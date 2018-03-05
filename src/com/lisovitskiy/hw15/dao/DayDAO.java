package com.lisovitskiy.hw15.dao;

import java.util.List;

import com.lisovitskiy.hw15.model.Day;

public interface DayDAO {
	List<Day> selectAll();
	List<Day> daysByNumberOfLessons(int numberOfLessons);
	List<Day> daysByOccupiedAudiences(int audience);
}
