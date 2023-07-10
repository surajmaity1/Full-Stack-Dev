<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	
	<c:forEach items="${sudentInfo}" var="sdata">
		${sdata.name }
		<br>
	</c:forEach>
	<br>
	${sudentInfo}
	<br>
	<!-- ${sun}  
	<br>
	<c:out value="${sun } said ->Hi Everyone ... "></c:out>
    <br>
    <c:import url="https://surajmyt.hashnode.dev"></c:import>
    <br> -->
    
</body>
</html>