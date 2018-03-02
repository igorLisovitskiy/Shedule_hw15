package com.lisovitskiy.hw15.controller;

import java.util.List;

import com.lisovitskiy.hw15.dao.DefaultScheduleDAO;
import com.lisovitskiy.hw15.dao.ScheduleDAO;
import com.lisovitskiy.hw15.model.Professor;

public class ScheduleFacade {
	private static final String DB_USER = "root";
	private static final String DB_PASSWORD = "root";
	DefaultScheduleDAO sDao = new DefaultScheduleDAO(DB_USER, DB_PASSWORD);
	

}
