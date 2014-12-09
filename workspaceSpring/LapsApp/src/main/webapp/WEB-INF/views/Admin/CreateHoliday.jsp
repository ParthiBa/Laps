<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Create Holiday</title>
</head>
<body>
<form:form method="POST" commandName="holiday" action="${pageContext.request.contextPath}/holiday/create">    
<table>
<tbody>

<tr>
<td>Holiday Name:</td>
<td><form:input path="holidayName"/></td> 
<td></td>
</tr>

<tr>
<td>Start Date:</td>
<td><form:input path="startDate"/></td>
<td></td>
</tr>

<tr>
<td>End Date:</td>
<td><form:input path="endDate"/></td>
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