package com.surajmaity1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.surajmaity1.dao.LogInDao;

/**
 * Servlet implementation class LogIn
 */
@WebServlet("/LogIn")
public class LogIn extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String usr_name = request.getParameter("usr_nam");
		String pwd = request.getParameter("pwd");
		LogInDao logInDao = new LogInDao();
		if (logInDao.checkCredentials(usr_name, pwd)) {
			HttpSession httpSession = request.getSession();
			httpSession.setAttribute("usr_nam", usr_name);
			response.sendRedirect("Greeting.jsp");
		}
		else {
			response.sendRedirect("LogIn.jsp");
		}
		
	}

}
