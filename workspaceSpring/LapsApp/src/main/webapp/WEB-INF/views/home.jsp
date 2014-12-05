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
<a href="${pageContext.request.contextPath}/employee/InitFindEmployee.html">List Max Leave List</a><br/>
<P>  The time on the server is ${serverTime}. </P>
</body>
</html>
