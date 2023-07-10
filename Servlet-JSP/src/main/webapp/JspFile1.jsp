<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ taglib prefix="fun" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	
	<c:set var="desc" value="Suraj is a SOFTWARE Dev" />
	
	
	 Length : ${fun:length(desc)}
	 
	 <br>
	 <c:forEach items="${fun:split(desc, 'a')}" var="s">
        <br>
        ${s}
        
     </c:forEach>
    <br>
    find index of SOFTWARE: ${fun:indexOf(desc,'SOFTWARE')}
    <br>
    is Present Dev: ${fun:contains(desc,'Dev') }
    <br>
    is Present Python: ${fun:contains(desc,"Python")}
    <br>
    <c:if test="${fun:contains(desc,'is')}">
    	There is present "is" in ${desc }
    </c:if>
    <br>
    <br>
    <br>
    <br>
    <br>
    <%/*
	<sql:setDataSource var="db" driver="com.mysql.cj.jdbc.Driver" url="jdbc:mysql://localhost:3306/student_1" user="root" password="1234"/>
    <sql:query var="rs" dataSource="${db}">select * from student_data</sql:query>
    
    
    <c:forEach items="${rs.rows}" var="stud">
        <c:out value="${stud.id }"></c:out> : <c:out value="${stud.name }"></c:out> : <c:out value="${stud.roll_no }"></c:out>
        <br>
    </c:forEach>
    <br>
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
    <br> 
    */ %>
</body>
</html>