package com.lisovitskiy.hw15.listeners;

import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.lisovitskiy.hw15.db.utils.ConnectionPool;

/**
 * Application Lifecycle Listener implementation class ConnectionPoolListener
 *
 */
@WebListener
public class ConnectionPoolListener implements ServletContextListener {
	private static final String DB_CONNECTION_URL = "jdbc:mysql://localhost:3306/schedule?autoReconnect=true&useSSL=false&useLegacyDatetimeCode=false&serverTimezone=UTC";
	private static final String DB_USER = "root";
	private static final String DB_PASSWORD = "root";
	
	ServletContext servletContext;
	
    public ConnectionPoolListener() {

    }

    public void contextDestroyed(ServletContextEvent sce)  { 
    	Connection con = (Connection) servletContext.getAttribute("connectionPool");
    	System.out.println("destroyed");
    	try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }

    public void contextInitialized(ServletContextEvent sce)  { 
    	servletContext = sce.getServletContext();
    	//db initialization
//    	String url = servletContext.getInitParameter("url");
//    	String user = servletContext.getInitParameter("user");
//    	String password = servletContext.getInitParameter("password");
    	System.out.println("listen");
    	Connection connection =  ConnectionPool.INSTANCE.getConnection(DB_CONNECTION_URL, DB_USER, DB_PASSWORD);
    	servletContext.setAttribute("connectionPool", connection);
    }
	
}
