
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Overtime Claim</title>
<link rel="stylesheet" href="//code.jquery.com/ui/1.11.2/themes/smoothness/jquery-ui.css">
</head>

<body>
<form:form method="POST" commandName="otdetail" action="${pageContext.request.contextPath}/otdetail/create">
   
    
<table>
<tbody>
<tr>
<td>EmployeeID:</td>
<td><form:input path="otdetailId.employeeID" /></td> 
<td></td>
</tr>

<tr>
<td>Date:</td>
<td><form:input path="otdetailId.otWorkedDate" /></td>
<td></td>
</tr>

<tr>
<td>During:</td>
<td>
<form:select path="isFullDay">
        	<form:option value="1" label="full day"/>
        	<form:option value="0" label="half day"/>
</form:select>
</td>
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
<a href="${pageContext.request.contextPath}/">Home page</a>
</body>
</html>