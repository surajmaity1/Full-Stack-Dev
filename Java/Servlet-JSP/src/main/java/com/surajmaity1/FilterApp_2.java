package com.surajmaity1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;

@WebFilter("/app")
public class FilterApp_2 extends HttpFilter implements Filter {
	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("In FilterApp_2");
		
		String name = request.getParameter("name");
		PrintWriter pw = response.getWriter();
		if (name.length() > 2) {
			chain.doFilter(request, response);
		}
		else {
			pw.println("Name's length should be greater than 2");
		}
		
	}
	public void init(FilterConfig fConfig) throws ServletException {
		
	}

}
