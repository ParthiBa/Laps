<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>List of All Employees</title>
</head>
<body>
    <c:if test="${not empty employeeList}">
    		<h1>Employee List Page</h1>
			<table style="text-align: center;" border="1px" cellpadding="0" cellspacing="0" >
			<thead>
					<td>employeeID</td>
					<td>employeeName</td>
					<td>DateOfBirth</td>
					<td>RoleID</td>
					<td>SupervisorID</td>
					<td>Edit</td>
					<td>Delete</td>
			</thead>
			<tbody>
			<c:forEach var="employee" items="${employeeList}">
			<tr>
				<td>${employee.employeeID}</td>
				<td>${employee.employeename}</td>
				<td>${employee.dob}</td>
				<td>${employee.roleID}</td>
				<td>${employee.supervisorID}</td>
				<td><a href="${pageContext.request.contextPath}/admin/edit/${employee.employeeID}.html">Edit</a></td>
<td><a href="${pageContext.request.contextPath}/admin/delete/${employee.employeeID}.html">Delete</a></td>
			</tr>
			</c:forEach>
			</tbody>
			</table>
	</c:if>
</body>
</html>