package com.lisovitskiy.hw15.db.utils;

import org.apache.tomcat.jdbc.pool.*;
import java.sql.Connection;
import java.sql.SQLException;

public final class ConnectionManager {
	private final static String DB_DRIVER = "com.mysql.jdbc.Driver";
	private final static DataSource dSource = new DataSource();

	private ConnectionManager() {
		
	}
	public static void setUpConnection(String url, String user, String password) {
		PoolProperties p = new PoolProperties();
		p.setDriverClassName(DB_DRIVER);
		p.setMaxActive(100);
		p.setMaxAge(50000);
		p.setUrl(url);
		p.setUsername(user);
		p.setPassword(password);
		dSource.setPoolProperties(p);
	}
	
	public static Connection getConnection() throws SQLException {
		return dSource.getConnection();
	}

	
	
	

	

	
		


}
