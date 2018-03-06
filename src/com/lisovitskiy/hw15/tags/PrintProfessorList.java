package com.lisovitskiy.hw15.tags;

import javax.servlet.jsp.tagext.*;

import com.lisovitskiy.hw15.model.Professor;

import javax.servlet.jsp.*;
import java.io.*;
import java.util.List;

public class PrintProfessorList extends BodyTagSupport  {
	private static final long serialVersionUID = 1L;
	private List<Professor> list;

	public void setList(List<Professor> list) {
		this.list = list;
	}
	  @Override
	    public int doStartTag() throws JspException {
		  	JspWriter out = pageContext.getOut();
		  	try {
			out.write("<thead><th>ID</th><th>Name</th></thead>");
		  	for(Professor p: list) {
			  	out.write("<tr>");
			  	out.write( "<td>" + p.getId() + "</td>");
				out.write( "<td>" + p.getName() + "</td>");
				out.write("</tr>");
				}
		  	}catch (IOException e) {
				e.printStackTrace();
			}
		  	
	        return EVAL_BODY_INCLUDE;
	    }

}
