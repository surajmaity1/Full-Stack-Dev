package com.surajmaity1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SquareNumber extends HttpServlet{
	public void service(HttpServletRequest req, HttpServletResponse res) throws IOException {
		HttpSession session = req.getSession();
				
		int num = (int)session.getAttribute("total");
		num *= num;
		
		// get from URL REWRITING
		// int num = Integer.parseInt(req.getParameter("total"));
		
		PrintWriter pw = res.getWriter();
		pw.println("Square: " + num);
		
		System.out.println("square num called");
	}
}
