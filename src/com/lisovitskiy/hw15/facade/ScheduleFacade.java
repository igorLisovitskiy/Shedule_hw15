package com.lisovitskiy.hw15.facade;

import java.util.List;

import com.lisovitskiy.hw15.dao.ProfessorDAO;
import com.lisovitskiy.hw15.dao.impl.DayDAOImpl;
import com.lisovitskiy.hw15.dao.impl.ProfessorDAOImpl;
import com.lisovitskiy.hw15.model.Day;
import com.lisovitskiy.hw15.model.Professor;

public class ScheduleFacade {
	private ProfessorDAOImpl profDao = new ProfessorDAOImpl();
	private DayDAOImpl dayDAO = new DayDAOImpl();

	public List<Professor> getProfessors() {
		List<Professor> list = profDao.selectAll();
		return list;
	}

	public List<Professor> getProfessorsNotWorkingOn(String day) {
		List<Professor> list = profDao.selectProfessorsNotWorkingOnDay(day);
		return list;
	}

	public List<Professor> getProfessorsWorkingOnDayInAudience(String day, int audienceId) {
		List<Professor> list = profDao.selectProfessorsWorkingOnDayInAudience(day, audienceId);
		return list;
	}

	public List<Day> getDays() {
		List<Day> list = dayDAO.selectAll();
		return list;
	}

	public List<Day> getDaysByAudiences(int a) {
		List<Day> list = dayDAO.daysByOccupiedAudiences(a);
		return list;
	}

	public List<Day> getDaysByLessons(int l) {
		List<Day> list = dayDAO.daysByNumberOfLessons(l);
		return list;
	}

}
