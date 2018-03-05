package com.lisovitskiy.hw15.dao;

import java.util.List;

import com.lisovitskiy.hw15.model.Student;

public interface StudentDAO {
	List<Student> selectAll();
}
