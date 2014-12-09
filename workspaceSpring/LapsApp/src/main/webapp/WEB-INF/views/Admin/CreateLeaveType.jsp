<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Create Leave Type</title>
</head>
<body>

<form:form method="POST" commandName="leaveType" action="${pageContext.request.contextPath}/leavetype/create">    
<table>
<tbody>

<tr>
<td>LeaveTypeID:</td>
<td><form:input path="leaveTypeID"/></td> 
<td></td>
</tr>

<tr>
<td>LeaveTypeName:</td>
<td><form:input path="leaveTypeName"/></td>
<td></td>
</tr>

<tr>
<td><input type="submit" value="Submit" /></td>
<td></td>
<td></td>
</tr>

</tbody>
</table>
</form:form>
</body>
</html>