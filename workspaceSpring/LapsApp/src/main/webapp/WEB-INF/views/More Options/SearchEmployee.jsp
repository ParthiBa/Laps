<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title></title>
</head>
<body>
<div style="text-align:center">
<p><img src="https://fbcdn-sphotos-f-a.akamaihd.net/hphotos-ak-xpf1/t31.0-8/10749959_406574562839941_3539789211823270904_o.jpg" align="center"/></p>
</div>
<div>
<spring:url value="/admin/SearchEmployee.html" var="formUrl"/>
<form:form modelAttribute="employee" action="/admin/SearchEmployee" method="POST" >
 <label>EmployeeName</label>
 <form:input path="employeename" />
 <button type="submit">Find Employee</button>
 
 </form:form>
    </div>
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
				<td>${employee.SuperVisorID}</td>
				<td><a href="${pageContext.request.contextPath}/admin/edit/${employee.employeeID}.html">Edit</a></td>
<td><a href="${pageContext.request.contextPath}/admin/delete/${employee.employeeID}.html">Delete</a></td>
			</tr>
			</c:forEach>
			</tbody>
			</table>
	</c:if>
    <div style="position:absolute;margin-left:1000px;margin-top:140px;">
<img src="https://fbcdn-sphotos-d-a.akamaihd.net/hphotos-ak-xap1/v/t1.0-9/10363327_406579082839489_7985457610561998074_n.jpg?oh=70707f0d16562411b57e9828fc7eadd1&oe=5515D69E&__gda__=1425911874_4b407021bc4cbab27d5b4860bbe784d7"/>
</div>

</body>
</html>