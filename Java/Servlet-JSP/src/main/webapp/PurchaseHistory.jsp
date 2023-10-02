<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>History Page</title>
</head>
<body>
	<%
	
	response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.0
	response.setHeader("Pragma", "no-cache"); // HTTP 1.0
	response.setHeader("Expires", "0"); // Proxies
		if(session.getAttribute("usr_nam") == null){
			response.sendRedirect("LogIn.jsp");
		}
	%>
	<br>
	You ordered some pizza...
	<br>
	And now, it's time to buy pizza ...
</body>
</html>