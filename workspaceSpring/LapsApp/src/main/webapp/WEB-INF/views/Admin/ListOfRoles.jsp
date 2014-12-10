<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>List of Employee role</title>
</head>
<body>
<c:if test="${not empty EmpolyeeRoleList}">
    		<h1>Leave Type List Page</h1>
			<table  border="1px" cellpadding="1px" cellspacing="2px" >
			<thead>
					<td>RoleTypeID</td>
					<td>RoleType</td>
					<td>Delete</td>
			</thead>
			<tbody>
			<c:forEach var="EmployeeRole" items="${EmpolyeeRoleList}">
			<tr>
				<td>${EmployeeRole.roleId}</td>
				<td>${EmployeeRole.roleType}</td>
				<td><a href="${pageContext.request.contextPath}/EProle/Delete/${EmployeeRole.roleId}.html">Delete</a></td>
			</tr>
			</c:forEach>
			</tbody>
			</table>
	</c:if>
</body>
</html>