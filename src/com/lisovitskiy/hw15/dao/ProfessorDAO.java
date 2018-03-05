package com.lisovitskiy.hw15.dao;

import java.util.List;
import com.lisovitskiy.hw15.model.Professor;

public interface ProfessorDAO {
	List<Professor> selectAll();
	List<Professor> selectProfessorsNotWorkingOnDay(String day);
	List<Professor> selectProfessorsWorkingOnDayInAudience(String day, int audience);
}
