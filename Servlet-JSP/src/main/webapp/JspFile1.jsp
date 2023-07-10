<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<sql:setDataSource var="db" driver="com.mysql.cj.jdbc.Driver" url="jdbc:mysql://localhost:3306/student_1" user="root" password="1234"/>
	<sql:query var="rs" dataSource="${db}">select * from student_data</sql:query>
	
	
	<c:forEach items="${rs.rows}" var="stud">
		<c:out value="${stud.id }"></c:out> : <c:out value="${stud.name }"></c:out> : <c:out value="${stud.roll_no }"></c:out>
		<br>
	</c:forEach>
	<br>
	
	
	
	
	
	
	
	
	
	
	
	<!--
	<c:forEach items="${sudentInfo}" var="sdata">
		${sdata.name }
		<br>
	</c:forEach>
	<br>
	${sudentInfo}
	<br>
	${sun}  
	<br>
	<c:out value="${sun } said ->Hi Everyone ... "></c:out>
    <br>
    <c:import url="https://surajmyt.hashnode.dev"></c:import>
    <br> -->
    
</body>
</html>