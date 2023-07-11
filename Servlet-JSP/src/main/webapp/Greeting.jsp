<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Greeting Page</title>
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
	Welcome, ${usr_nam}
	<br>
	<a href="PurchaseHistory.jsp">Buy Pizza</a>
	<br>
	<iframe width="560" height="315" src="https://www.youtube.com/embed/iONm3BnLe70" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share" allowfullscreen></iframe>
	<br>
	
	<form action="LogOut">
		<input type="submit" value="LogOut">
	</form>
</body>
</html>