package com.lisovitskiy.hw15.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;

import com.lisovitskiy.hw15.dao.DayDAO;
import com.lisovitskiy.hw15.db.utils.ConnectionPool;
import com.lisovitskiy.hw15.model.Day;

public class DayDAOImpl implements DayDAO {
	ServletContext servletContext;
	
	private final static String SELECT__DAYS_BY_NUMBER_OF_LESSONS = "SELECT day, COUNT(subjects_id_subjects) AS 'number of lessons' "
			+ "FROM audience_has_subjects GROUP BY day HAVING COUNT(subjects_id_subjects) = ?";

	private final static String SELECT_DAYS_BY_OCCUPIED_AUDIENCES = "SELECT day, COUNT(audience_id_audience) AS 'number of audiences' "
			+ "FROM audience_has_subjects GROUP BY day HAVING COUNT(audience_id_audience) = ?";

	private final static String SELECT_ALL_DAYS = "SELECT * FROM audience_has_subjects";

	public List<Day> selectAll() {
		List<Day> dayList = new ArrayList<>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try (Connection conn = (Connection) servletContext.getAttribute("connectionPool")) {
			ps = conn.prepareStatement(SELECT_ALL_DAYS);
			rs = ps.executeQuery();
			while (rs.next()) {
				String dbDay = rs.getString("day");
				dayList.add(Day.dayToDay(dbDay));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dayList;
	}

	public List<Day> daysByOccupiedAudiences(int audiences) {
		List<Day> dayList = new ArrayList<>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try (Connection conn = (Connection) servletContext.getAttribute("connectionPool")) {
			ps = conn.prepareStatement(SELECT_DAYS_BY_OCCUPIED_AUDIENCES);
			ps.setInt(1, audiences);
			rs = ps.executeQuery();
			while (rs.next()) {
				dayList.add(Day.dayToDay(rs.getString("day")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dayList;
	}

	public List<Day> daysByNumberOfLessons(int numberOfLessons) {
		List<Day> dayList = new ArrayList<>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try (Connection conn = (Connection) servletContext.getAttribute("connectionPool")) {
			ps = conn.prepareStatement(SELECT__DAYS_BY_NUMBER_OF_LESSONS);
			ps.setInt(1, numberOfLessons);
			rs = ps.executeQuery();
			while (rs.next()) {
				dayList.add(Day.dayToDay(rs.getString("day")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dayList;
	}

}
