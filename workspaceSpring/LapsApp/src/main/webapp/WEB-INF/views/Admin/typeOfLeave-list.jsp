<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Entitlement List page</title>
</head>
<body>
<h1>Entitlement List page</h1>
<table style="text-align: center;" border="1px" cellpadding="0" cellspacing="0" >
<thead>
<tr>
<td>Role Id</td>
<td>LeaveType Id</td>
<td>Number of Days</td>
</thead>
<tbody>
<c:forEach var="Entitlement" items="${EntitlementList}">
<tr>
<td>${Entitlement.id.roleId}</td>
<td>${Entitlement.id.leaveTypeId}</td>
<td>${Entitlement.numOfDays}</td>
<td>${Entitlement.approvelRoleId}</td>
<td>
<a href="${pageContext.request.contextPath}/typeOfLeave/edit/${Entitlement.id.roleId}/${Entitlement.id.leaveTypeId}.html">Edit</a><br/>
<a href="${pageContext.request.contextPath}/typeOfLeave/delete/${Entitlement.id.roleId}/${Entitlement.id.leaveTypeId}.html">Delete</a><br/>
</td>
</tr>
</c:forEach>
</tbody>
</table>
<a href="${pageContext.request.contextPath}/">Home page</a>
</body>
</html>>