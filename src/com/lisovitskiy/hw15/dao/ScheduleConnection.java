package com.lisovitskiy.hw15.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ScheduleConnection{
	private static final String DB_DRIVER = "com.mysql.jdbc.Driver";
	private static final String DB_CONNECTION_URL = "jdbc:mysql://localhost:3306/schedule?autoReconnect=true&useSSL=false&useLegacyDatetimeCode=false&serverTimezone=UTC";

	public Connection getConnection(String user, String password) {
		Connection connection = null;
		try {
			Class.forName(DB_DRIVER);
			connection = DriverManager.getConnection(DB_CONNECTION_URL, user, password);

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}

	public static void closeConnection(Connection connection) {
		System.out.println("Closing connection");
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
