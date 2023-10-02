<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="com.surajmaity1.web.model.EmplyeeInfo" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Show EmployeeInfo</title>
</head>
<body>
	<%
		//EmplyeeInfo  einfo = (EmplyeeInfo) request.getAttribute("employee_info");
		
		EmplyeeInfo  einfo = (EmplyeeInfo) session.getAttribute("employee_info");
	
		out.println(einfo);
	%>
</body>
</html>