package com.lisovitskiy.hw15.facade;

import java.util.List;

import com.lisovitskiy.hw15.dao.ProfessorDAO;
import com.lisovitskiy.hw15.dao.impl.ProfessorDAOImpl;
import com.lisovitskiy.hw15.model.Professor;

public class ScheduleFacade {
	private static final String DB_USER = "root";
	private static final String DB_PASSWORD = "root";
	
	public List<Professor> getProfessors(){
		 ProfessorDAOImpl sDao = new ProfessorDAOImpl(DB_USER, DB_PASSWORD);
		 List<Professor> list =  sDao.selectAll();
		return list;
	}
}
