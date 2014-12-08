<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>
<a href="${pageContext.request.contextPath}/employee/InitFindEmployee.html">List Max Leave List</a><br/>
<P>  The time on the server is ${serverTime}. </P>
<c:url var="c" value="/admin/CreateEmployee.html" />
<c:url var="ca" value="/admin/SearchEmployee.html"/>
<c:url var="cb" value="/admin/AllEmployee.html" />
<c:url var="login" value="/Login/loginEmp.html"/>
<i>${message}</i>
<a href="${c}">Create a new Employee</a>
<a href="${ca}">Search Employee</a>
<a href="${cb}">List of Employees</a>
<a href="${login}">login</a>
</body>
</html>
