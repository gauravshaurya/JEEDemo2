package com.iris.filters;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter("/register")
public class TimeFilter implements Filter {

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
			response.setContentType("text/html");
			PrintWriter out=response.getWriter();
			
			LocalDateTime obj=LocalDateTime.now();
			int hour=obj.getHour();
			
			if((hour>=16)&&(hour<=18)){
				out.println("You can't register between 16 to 17");
			}
			else {
				chain.doFilter(request, response);
			}
	}

	public void init(FilterConfig fConfig) throws ServletException {
	
	}

}
