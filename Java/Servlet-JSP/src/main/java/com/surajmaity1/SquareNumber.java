package com.surajmaity1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/SquareNum")
public class SquareNumber extends HttpServlet{
	public void service(HttpServletRequest req, HttpServletResponse res) throws IOException {
		/*
		 int num = 0;
		
		// using Cookie 
		Cookie c[] = req.getCookies();
		for(Cookie cookie: c) {
			if (cookie.getName().equals("total")) {
				num = Integer.parseInt(cookie.getValue());
			}
		}
		
		num *= num;
		
		
		// HttpSession session = req.getSession();	
		// int num = (int)session.getAttribute("total");
		
		
		
		// get from URL REWRITING
		// int num = Integer.parseInt(req.getParameter("total"));
		
		
		
		PrintWriter pw = res.getWriter();
		pw.println("<html><body bgcolor='blue'>");
		pw.println("Square: " + num);
		pw.println("</body></html>");
		
		System.out.println("square num called");
		*/
	}
}
