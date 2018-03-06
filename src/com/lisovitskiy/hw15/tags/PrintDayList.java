package com.lisovitskiy.hw15.tags;

import java.io.IOException;
import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.BodyTagSupport;

import com.lisovitskiy.hw15.model.Day;

public class PrintDayList extends BodyTagSupport {
	private static final long serialVersionUID = 1L;
	
	private List<Day> list;

	public void setList(List<Day> list) {
		this.list = list;
	}
	  @Override
	    public int doStartTag() throws JspException {
		  	JspWriter out = pageContext.getOut();
		  	try {
			out.write("<thead><th>Weekday</th></thead>");
		  	for(Day d: list) {
			  	out.write("<tr>");
			  	out.write( "<td>" + d.getDay() + "</td>");
				out.write("</tr>");
				}
		  	}catch (IOException e) {
				e.printStackTrace();
			}
		  	
	        return EVAL_BODY_INCLUDE;
	    }

}
