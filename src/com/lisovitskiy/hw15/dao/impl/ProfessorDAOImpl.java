package com.lisovitskiy.hw15.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.lisovitskiy.hw15.dao.ProfessorDAO;
import com.lisovitskiy.hw15.db.utils.ConnectionPool;
import com.lisovitskiy.hw15.model.Professor;
import java.sql.PreparedStatement;

public class ProfessorDAOImpl implements ProfessorDAO {

	public ProfessorDAOImpl(String user, String password) {
		// this.connection = new ScheduleConnection().getConnection(user, password);
	}

	private static final String DB_DRIVER = "com.mysql.jdbc.Driver";
	private final static String SELECT_PROFESSORS_WORKING_ON_DAY_IN_AUDIENCE = "SELECT p.id_professors, full_name, audience_id_audience AS auidience, name "
			+ "FROM professors p " + "INNER JOIN professors_have_subjects ps "
			+ "ON p.id_professors = ps.id_professors " + "INNER JOIN subjects subj "
			+ "ON ps.id_subjects = subj.id_subjects " + "INNER JOIN audience_has_subjects a_subj "
			+ "ON ps.id_subjects = a_subj.subjects_id_subjects " + "WHERE audience_id_audience = ? AND day = ?";

	private final static String SELECT_PROFESSORS_NOT_WORKING_ON_DAY = "SELECT * FROM professors_have_subjects "
			+ "LEFT JOIN audience_has_subjects ON professors_have_subjects.id_subjects = audience_has_subjects.subjects_id_subjects "
			+ "WHERE NOT day = ?";

	private final static String SELECT_ALL = "SELECT p.id_professors, full_name, name, subj.id_subjects, audience_id_audience AS audience, day "
			+ "FROM professors p " + "INNER JOIN professors_have_subjects s " + "ON p.id_professors = s.id_professors "
			+ "INNER JOIN subjects subj " + "ON subj.id_subjects = s.id_subjects "
			+ "INNER JOIN audience_has_subjects a " + "ON subj.id_subjects = a.subjects_id_subjects";
	
	private final static String SELECT_ALL_PROFESSORS = "SELECT * FROM professors";
	@Override
	public List<Professor> selectAll() {
		List<Professor> profList = new ArrayList<>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try (Connection conn = ConnectionPool.INSTANCE.getConnection()) {
			ps = conn.prepareStatement(SELECT_ALL_PROFESSORS);
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

	public static void main(String[] args) {
		ProfessorDAOImpl p = new ProfessorDAOImpl("root", "root");
		List<Professor> l = p.selectAll();
		System.out.println(l.size());
	}
}
