<!-- Directive -->
<%@page import="java.util.Scanner"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
	<%@ include file="File1.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor="red">


	<!-- Note: check directive above  -->
	
	<!-- Declaration -->
	<%!
	int val = 23;
	Scanner sc = new Scanner(System.in);
	%>


	<!-- Scriplet Tag -->
	<%
	int val1 = Integer.parseInt(request.getParameter("num1"));
	int val2 = Integer.parseInt(request.getParameter("num2"));
	
	int total = val1 + val2;
	out.println("Total: " + total);
	%>
	<br>
	<!-- Expression -->
	<%=val %>
	<br>
	<%out.println(val); %>
	
	<br>
	<%
	pageContext.setAttribute("name", "Suraj");
	%>
</body>
</html>