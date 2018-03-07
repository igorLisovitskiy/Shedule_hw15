package com.lisovitskiy.hw15.filters;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class HitCounterFilter implements Filter {
	private int hits;
	private FilterConfig filterConfig;

	@Override
	public void init(FilterConfig filterConfig) {
		this.filterConfig = filterConfig;
		this.hits = 0;
	}
	
	@Override
	public void destroy() {
		this.hits = 0;
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
			
			StringWriter sw = new StringWriter();
			PrintWriter writer = new PrintWriter(sw);
			writer.println();
			writer.println("===============");
			writer.println("The number of hits is: " + hits++);
			writer.println("===============");
			writer.flush();
			filterConfig.getServletContext().log(sw.getBuffer().toString());
			chain.doFilter(request, response);
	}

}
