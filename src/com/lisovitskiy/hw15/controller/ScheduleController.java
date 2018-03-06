package com.lisovitskiy.hw15.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.*;

import com.lisovitskiy.hw15.facade.ScheduleFacade;
import com.lisovitskiy.hw15.model.Day;
import com.lisovitskiy.hw15.model.Professor;

public class ScheduleController extends HttpServlet {

	private static final long serialVersionUID = 1L;


	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException {
		ScheduleFacade sf = new ScheduleFacade();
		Integer action = null;
		try {
			action = Integer.parseInt(request.getParameter("action"));
		}catch(NumberFormatException e) {
			if(action == null) {
				action = 1;
			}
		}
	
		switch (action) {
		case 1:
			List<Professor> profListAll = sf.getProfessors();
			request.setAttribute("profListAll", profListAll);
			break;
		case 2:
			List<Professor> profListNotworkingOn = sf.getProfessorsNotWorkingOn(request.getParameter("day-2"));
			request.setAttribute("profListNotworkingOn", profListNotworkingOn);
			break;
		case 3:
			List<Professor> profListOnDayInAudience = sf.getProfessorsWorkingOnDayInAudience(request.getParameter("day-3"),Integer.parseInt(request.getParameter("audience-3")));
			request.setAttribute("profListOnDayInAudience", profListOnDayInAudience);
			break;
		case 4:
			List<Day> daysByAudiences = sf.getDaysByAudiences(Integer.parseInt(request.getParameter("audience-4")));
			request.setAttribute("daysByAudiences", daysByAudiences);
			break;
		case 5:
			List<Day> daysByLessons = sf.getDaysByLessons(Integer.parseInt(request.getParameter("lessons-5")));
			request.setAttribute("daysByLessons", daysByLessons);
			break;

		default:
			break;
		}

		try {
			request.getRequestDispatcher("schedule.jsp").forward(request, response);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
