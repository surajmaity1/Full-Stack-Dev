package com.surajmaity1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SquareNumber extends HttpServlet{
	public void service(HttpServletRequest req, HttpServletResponse res) throws IOException {
		int num = Integer.parseInt(req.getParameter("total"));
		num *= num;
		
		PrintWriter pw = res.getWriter();
		pw.println("Square: " + num);
		
		System.out.println("square num called");
	}
}
