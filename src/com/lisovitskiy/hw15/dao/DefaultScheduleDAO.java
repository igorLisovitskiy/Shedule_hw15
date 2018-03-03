package com.lisovitskiy.hw15.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.lisovitskiy.hw15.model.Professor;
import com.mysql.jdbc.PreparedStatement;

public class DefaultScheduleDAO implements ScheduleDAO {

	@SuppressWarnings("unused")
	private Connection connection;

	public DefaultScheduleDAO(String user, String password) {
		this.connection = new ScheduleConnection().getConnection(user, password);
	}

	private final static String SELECT_PROFESSORS_WORKING_ON_DAY_IN_AUDIENCE = "SELECT p.id_professors, full_name, audience_id_audience AS auidience, name "
			+ "FROM professors p " + "INNER JOIN professors_have_subjects ps "
			+ "ON p.id_professors = ps.id_professors " + "INNER JOIN subjects subj "
			+ "ON ps.id_subjects = subj.id_subjects " + "INNER JOIN audience_has_subjects a_subj "
			+ "ON ps.id_subjects = a_subj.subjects_id_subjects " + "WHERE audience_id_audience = ? AND day = ?";

	private final static String SELECT_PROFESSORS_NOT_WORKING_ON_DAY = "SELECT * FROM professors_have_subjects "
			+ "LEFT JOIN audience_has_subjects ON professors_have_subjects.id_subjects = audience_has_subjects.subjects_id_subjects "
			+ "WHERE NOT day = ?";

	private final static String SELECT__DAYS_BY_NUMBER_OF_LESSONS = "SELECT day, COUNT(subjects_id_subjects) AS 'number of lessons' "
			+ "FROM audience_has_subjects GROUP BY day HAVING COUNT(subjects_id_subjects) = ?";

	private final static String SELECT_DAYS_BY_OCCUPIED_AUDIENCES = "SELECT day, COUNT(audience_id_audience) AS 'number of audiences' "
			+ "FROM audience_has_subjects GROUP BY day HAVING COUNT(audience_id_audience) = ?";

	private final static String SELECT_ALL = "SELECT p.id_professors, full_name, name, subj.id_subjects, audience_id_audience AS audience, day "
			+ "FROM professors p " + "INNER JOIN professors_have_subjects s " + "ON p.id_professors = s.id_professors "
			+ "INNER JOIN subjects subj " + "ON subj.id_subjects = s.id_subjects "
			+ "INNER JOIN audience_has_subjects a " + "ON subj.id_subjects = a.subjects_id_subjects";

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

	public ResultSet performQuery(String query, String... arg) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			Connection conn = DriverManager
					.getConnection("jdbc:mysql://localhost:3306/schedule?autoReconnect=true&useSSL=false&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "root");
			ps = (PreparedStatement) conn.prepareStatement(query);
			rs = ps.executeQuery();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// ScheduleConnection.closeConnection(connection);
		}
		return rs;
	}

	@Override
	public List<Professor> selectAll() {
		List<Professor> profList = new ArrayList<>();
		Professor prof;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			Connection conn = DriverManager
					.getConnection("jdbc:mysql://localhost:3306/schedule?autoReconnect=true&useSSL=false&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "root");
	
			ps = (PreparedStatement) conn.prepareStatement(SELECT_ALL);
			rs = ps.executeQuery();
			while (rs.next()) {
				profList.add(new Professor(rs.getInt("id_professors"), rs.getString("full_name")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return profList;
	}

	@Override
	public List<Professor> selectProfessorsNotWorkingOnDay(String day) {
		return null;
	}

	@Override
	public List<Professor> selectProfessorsWorkingOnDayInAudience(String day, int audience) {
		return null;
	}
}
