package com.lisovitskiy.hw15.db.utils;

import org.apache.tomcat.jdbc.pool.*;
import java.sql.Connection;
import java.sql.SQLException;

public enum ConnectionPool {
	INSTANCE;
	private static final String DB_DRIVER = "com.mysql.jdbc.Driver";
	
	public Connection getConnection (String url, String user, String password) {
		PoolProperties p = new PoolProperties();
		p.setDriverClassName(DB_DRIVER);
		p.setUrl(url);
		p.setUsername(user);
		p.setPassword(password);
		p.setMaxActive(100);
		p.setMaxAge(50000);
		DataSource dSource = new DataSource();
		dSource.setPoolProperties(p);
		Connection con = null;
		try{
			con = dSource.getConnection();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return con;
	}

}
