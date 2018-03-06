package com.lisovitskiy.hw15.db.utils;

import org.apache.tomcat.jdbc.pool.*;
import java.sql.Connection;
import java.sql.SQLException;

public enum ConnectionPool {
	INSTANCE;
	private static final String DB_DRIVER = "com.mysql.jdbc.Driver";
	private static final String DB_CONNECTION_URL = "jdbc:mysql://localhost:3306/schedule?autoReconnect=true&useSSL=false&useLegacyDatetimeCode=false&serverTimezone=UTC";
	private static final String DB_USER = "root";
	private static final String DB_PASSWORD = "root";
	
	public Connection getConnection() {
		PoolProperties p = new PoolProperties();
		p.setDriverClassName(DB_DRIVER);
		p.setUrl(DB_CONNECTION_URL);
		p.setUsername(DB_USER);
		p.setPassword(DB_PASSWORD);
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
