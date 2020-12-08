package com.lisovitskiy.hw15.db.utils;

import java.sql.Connection;

import javax.servlet.ServletContext;

public class AppUtil {
	
	private static ServletContext context;
	public static void setServletContext(ServletContext context) {
		AppUtil.context = context;
	}
	public static ServletContext getServletContext() {
		return AppUtil.context;
	}
}
