package com.lisovitskiy.hw15;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.PreparedStatement;

public enum ScheduleDAO {
	INSTANCE;
	private static final String DB_USER = "root";
	private static final String DB_PASSWORD = "root";

	public static PreparedStatement getPreparedStatement(Connection connect, String sql, String... arg) {
		PreparedStatement ps = null;
		try {
			ps = (PreparedStatement) connect.prepareStatement(sql);
			if (arg.length > 0) {
				for (int i = 0, placeholder = 1; i < arg.length; i++, placeholder++) {
					ps.setString(placeholder, arg[i]);
				}
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return ps;
	}

	public String performQuery(String query, String... arg) {
		Connection connection = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String tableHtml = null;
		try {
			connection = SetupConnection.getConnection(DB_USER, DB_PASSWORD);
			ps = getPreparedStatement(connection, query, arg);
			rs = ps.executeQuery();
			tableHtml = tableToHtml(rs);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			SetupConnection.closeConnection(connection);
		}
		return tableHtml;
	}

	public static void showTable(ResultSet rs) throws SQLException {
		int numberOfColumns = rs.getMetaData().getColumnCount();
		while (rs.next()) {
			for (int i = 1; i <= numberOfColumns; i++) {
				System.out.print(rs.getString(i) + " ");
			}
			System.out.println();
		}
	}

	public static List<String> tableToList(ResultSet rs) throws SQLException {
		List<String> list = new ArrayList<>();
		int numberOfColumns;
		numberOfColumns = rs.getMetaData().getColumnCount();
		while (rs.next()) {
			for (int i = 1; i <= numberOfColumns; i++) {
				list.add(rs.getString(i));
			}
		}

		return list;
	}
	
	public static String tableToHtml(ResultSet rs) throws SQLException {
		StringBuilder table = new StringBuilder();
		table.append("<table border=2>");
		table.append("<tr>");
		int numberOfColumns;
		ResultSetMetaData meta = rs.getMetaData();
		numberOfColumns = meta.getColumnCount();
		for (int i = 1; i <= numberOfColumns; i++) {
			table.append("<th>");
			table.append(meta.getColumnName(i));
		}
		while (rs.next()) {
			table.append("<tr>");
			for (int i = 1; i <= numberOfColumns; i++) {
				table.append("<td>" + rs.getString(i).toString() + "</td>");
			}
			table.append("</tr>");
		}
		table.append("</table>");
		
		return table.toString();
	}

}
