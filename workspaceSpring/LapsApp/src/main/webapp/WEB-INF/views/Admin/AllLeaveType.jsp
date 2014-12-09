<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>List of All Leave Type</title>
</head>
<body>
<c:if test="${not empty LeaveTypeList}">
    		<h1>Leave Type List Page</h1>
			<table style="text-align: center;" border="1px" cellpadding="0" cellspacing="0" >
			<thead>
					<td>LeaveTypeID</td>
					<td>LeaveTypeName</td>
					<td>Delete</td>
			</thead>
			<tbody>
			<c:forEach var="leaveType" items="${LeaveTypeList}">
			<tr>
				<td>${leaveType.leaveTypeID}</td>
				<td>${leaveType.leaveTypeName}</td>
				<td><a href="${pageContext.request.contextPath}/leavetype/delete/${leaveType.leaveTypeID}.html">Delete</a></td>
			</tr>
			</c:forEach>
			</tbody>
			</table>
	</c:if>
</body>
</html>