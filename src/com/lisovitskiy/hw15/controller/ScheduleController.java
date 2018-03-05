package com.lisovitskiy.hw15.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.*;

import com.lisovitskiy.hw15.facade.ScheduleFacade;
import com.lisovitskiy.hw15.model.Professor;

public class ScheduleController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException {
		ScheduleFacade sf = new ScheduleFacade();
		List<Professor> list = sf.getProfessors();
		request.setAttribute("list", list);
		try {
			request.getRequestDispatcher("schedule.jsp").forward(request, response);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
