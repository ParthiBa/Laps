<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>
<c:url var="loginEmp" value="/Login/loginEmp.html"/>
<c:url var="logout" value="/Login/loginEmp.html"/>
<c:url var="loginMrg" value="/Login/loginMngr.html"/>
<a href="${loginEmp}">login as Staff</a>
<a href="${loginMrg}">login as Manager</a>
<a href="${logout}">logout</a>
</body>
</html>
