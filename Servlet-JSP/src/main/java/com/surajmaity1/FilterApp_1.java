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
public class FilterApp_1 extends HttpFilter implements Filter {
	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		System.out.println("In FilterApp_1");
		
		int id = Integer.parseInt(request.getParameter("id"));
		PrintWriter pw = response.getWriter();
		if (id > 0) {
			chain.doFilter(request, response);
		}
		else {
			pw.println("Id should be greater than 0");
		}
		
		
	}
	public void init(FilterConfig fConfig) throws ServletException {
		
	}

}
