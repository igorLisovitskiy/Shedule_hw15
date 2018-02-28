package com.lisovitskiy.hw15;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.*;

public class ReportServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException {
		String audiences = request.getParameter("audiences");
		String days = request.getParameter("days");
		String subjects = request.getParameter("subjects");
		String selectAll = request.getParameter("select");
		Report r = new Report();
		String table = "";
		if (selectAll != null) {
			table = r.selectAll();
		}
		
		if (audiences != null && days == null) {
			table = r.daysByOccupiedAudiences(audiences);
		}
		if(audiences != null && days != null){
			table = r.professorsWorkingOnDayAndAudience(audiences, days);
		} 
		if(days != null){
			table = r.professorsNotWorkingOnDay(days);
		}
		try {
			request.setAttribute("data", table);
			request.getRequestDispatcher("schedule.jsp").forward(request, response);

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
