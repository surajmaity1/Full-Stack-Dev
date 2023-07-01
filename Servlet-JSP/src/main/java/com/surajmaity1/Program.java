package com.surajmaity1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Program extends HttpServlet{
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
		int val1 = Integer.parseInt(req.getParameter("num1"));
		int val2 = Integer.parseInt(req.getParameter("num2"));
		int total = val1 + val2;
		
		PrintWriter pw = res.getWriter();
		pw.println("Result: " + total);
	}
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
		int val1 = Integer.parseInt(req.getParameter("num1"));
		int val2 = Integer.parseInt(req.getParameter("num2"));
		int total = val1 + val2;
		
		PrintWriter pw = res.getWriter();
		pw.println("Result: " + total);
	}
}
