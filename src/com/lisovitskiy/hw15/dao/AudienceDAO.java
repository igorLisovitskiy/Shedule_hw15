package com.lisovitskiy.hw15.dao;

import java.util.List;

import com.lisovitskiy.hw15.model.Subject;

public interface AudienceDAO {
	public interface SubjectDAO {
		List<Subject> selectAll();
	}

}
