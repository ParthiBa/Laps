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
<a href="${pageContext.request.contextPath}/manager/InitManagerWindow.html">Manager Home Page</a><br/>
<a href="${pageContext.request.contextPath}/employee/employeeForm.html">Login</a><br/>
<P>  The time on the server is ${serverTime}. </P>
</body>
</html>
