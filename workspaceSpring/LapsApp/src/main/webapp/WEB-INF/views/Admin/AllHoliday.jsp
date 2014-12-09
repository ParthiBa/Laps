<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<c:if test="${not empty HolidayList}">
    		<h1>Holiday List Page</h1>
			<table style="text-align: center;" border="1px" cellpadding="0" cellspacing="0" >
			<thead>
					<td>Holiday Name:</td>
					<td>Start Date:</td>
					<td>End Date:</td>
					<td>Delete</td>
			</thead>
			<tbody>
			<c:forEach var="holiday" items="${HolidayList}">
			<tr>
				<td>${holiday.holidayName}</td>
				<td>${holiday.startDate}</td>
				<td>${holiday.endDate}</td>
				<td><a href="${pageContext.request.contextPath}/holiday/delete/${holiday.holidayName}.html">Delete</a></td>
			</tr>
			</c:forEach>
			</tbody>
			</table>
</c:if>
</body>
</html>