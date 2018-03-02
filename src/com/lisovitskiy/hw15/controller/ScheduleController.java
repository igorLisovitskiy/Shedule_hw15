package com.lisovitskiy.hw15.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.*;

public class ScheduleController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException {
		ScheduleFacade sf = new ScheduleFacade();
		String audiences = request.getParameter("audiences");
		String days = request.getParameter("days");
		String subjects = request.getParameter("subjects");
		String selectAll = request.getParameter("select");
		request.setAttribute("data", sf.sDao.selectAll());
		try {
			request.getRequestDispatcher("schedule.jsp").forward(request, response);
		} catch (IOException e) {
			e.printStackTrace();
		}
		


	}

}
