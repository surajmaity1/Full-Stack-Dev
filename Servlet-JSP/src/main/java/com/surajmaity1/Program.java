package com.surajmaity1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/app")
public class Program extends HttpServlet{
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		// JSTL - 
		String name = "Suraj";
		req.setAttribute("name", name);
		
		RequestDispatcher rd = req.getRequestDispatcher("File1.jsp");
		rd.forward(req, res);
		
		/*
		//  <!-- If diff servlet have diff value, this task will be performed by ServletConfig -->
		ServletConfig sc = getServletConfig();
		String str = sc.getInitParameter("name");
		
		PrintWriter pw = res.getWriter();
		pw.println("Hi: " + str);
		
		//<!-- If every servlet want to share same value, this task will be performed by ServletContext -->
		ServletContext sc = getServletContext();
		String str = sc.getInitParameter("name");
		
		PrintWriter pw = res.getWriter();
		pw.println("Hi: " + str);
		*/
		
		
		/*
		int val1 = Integer.parseInt(req.getParameter("num1"));
		
		int val2 = Integer.parseInt(req.getParameter("num2"));
		int total = val1 + val2;*/
		
		 //This technique called Session Management
		 //There are three concept to Transfer data from one Servlet to Another Servlet
		
		/*
		 * 1. Session
		 * 2. Cookie
		 * 3. URL rewriting
		 */
		
		
		// Here we have used Cookie technique	
		
		/* Cookie c = new Cookie("total", total+"");
		res.addCookie(c);
		res.sendRedirect("SquareNum");
		*/
		
		/*PrintWriter pw = res.getWriter();
		pw.println("<html><body bgcolor='black'>");
		pw.println("Square: " + total);
		pw.println("</body></html>");
		
		System.out.println("square num called");*/
		
		// Here we have used Session technique	
		// HttpSession session = req.getSession();
		// session.setAttribute("total", total);
		// res.sendRedirect("SquareNum");
		
		// Here we have used URL REWRITING technique	
		//res.sendRedirect("SquareNum?total="+total);
		
		
		/*
		req.setAttribute("total", total);
		
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("SquareNum");
		requestDispatcher.forward(req, res);
		
		PrintWriter pw = res.getWriter();
		pw.println("Result: " + total);
		
		*/
	}
}
