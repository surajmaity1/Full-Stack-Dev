package com.surajmaity1.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.surajmaity1.web.dao.EmployeeInfoDao;
import com.surajmaity1.web.model.EmplyeeInfo;

public class GetEmployeeController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		
		EmployeeInfoDao employeeInfoDao = new EmployeeInfoDao();
		EmplyeeInfo emplyeeInfo = employeeInfoDao.getEmployeeInfo(id);
		
		
		HttpSession httpSession = request.getSession();
		httpSession.setAttribute("employee_info", emplyeeInfo);
		
		response.sendRedirect("showEmployeeInfo.jsp");
		/*
		request.setAttribute("employee_info", emplyeeInfo);
		
		RequestDispatcher requestDispatcher  = request.getRequestDispatcher("showEmployeeInfo.jsp");
		requestDispatcher.forward(request, response);
		*/
		
		
	}
}
