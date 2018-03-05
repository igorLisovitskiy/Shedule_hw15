package com.lisovitskiy.hw15.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.lisovitskiy.hw15.db.utils.ConnectionPool;
import com.lisovitskiy.hw15.model.Day;
import com.lisovitskiy.hw15.model.Professor;

public class DayDAOImpl {
	private final static String SELECT__DAYS_BY_NUMBER_OF_LESSONS = "SELECT day, COUNT(subjects_id_subjects) AS 'number of lessons' "
			+ "FROM audience_has_subjects GROUP BY day HAVING COUNT(subjects_id_subjects) = ?";

	private final static String SELECT_DAYS_BY_OCCUPIED_AUDIENCES = "SELECT day, COUNT(audience_id_audience) AS 'number of audiences' "
			+ "FROM audience_has_subjects GROUP BY day HAVING COUNT(audience_id_audience) = ?";
	
	private final static String SELECT_DAYS_PER_AUDIENCE = "SELECT * FROM audience_has_subjects";
	
	public List<Day> selectAll() {
		List<Day> dayList = new ArrayList<>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try (Connection conn = ConnectionPool.INSTANCE.getConnection()) {
			ps = conn.prepareStatement(SELECT_DAYS_PER_AUDIENCE);
			rs = ps.executeQuery();
			Day[] days = Day.values();
			while (rs.next()) {
				String dbDay = rs.getString("day");
				//select day if equals
				for(Day d: days) {
					if(d.equals(dbDay)) {
					//add day to the list
					}
				}
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dayList;
	}
}
