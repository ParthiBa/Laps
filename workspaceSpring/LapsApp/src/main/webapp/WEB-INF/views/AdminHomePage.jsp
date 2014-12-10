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
<div style="text-align:center">
<p><img src="https://fbcdn-sphotos-f-a.akamaihd.net/hphotos-ak-xpf1/t31.0-8/10749959_406574562839941_3539789211823270904_o.jpg" align="center"/></p>
</div>
<div style="text-align:center;font-size:40px" >
<a href="${pageContext.request.contextPath}/admin/CreateEmployee.html">Create or Update Employee</a><br/>
<a href="${pageContext.request.contextPath}/admin/SearchEmployee.html">Search Employee</a><br/>
<a href="${pageContext.request.contextPath}/admin/AllEmployee.html">List of Employees</a><br/>

<a href="${pageContext.request.contextPath}/leavetype/AllLeaveType.html">Add Leave Type</a><br/>

<a href="${pageContext.request.contextPath}/leavetype/create.html">Add Leave Type</a><br/>
<a href="${pageContext.request.contextPath}/holiday/AllHoliday.html">List Of Holiday</a><br/>
<a href="${pageContext.request.contextPath}/holiday/create.html">Add Holiday</a><br/>
<a href="${pageContext.request.contextPath}/EProle/create.html">Add EmployeeRole</a>
<a href="${pageContext.request.contextPath}/EProle/All.html">List of EmployeeRoles</a>
<c:url var="c" value="/typeOfLeave/list.html" />
<a href="${c}">Entitlement List</a><br/>
<c:url var="ca" value="/typeOfLeave/create.html" />
<a href="${ca}">Create or Update Entitlement</a><br/>

</div>
<div style="position:absolute;margin-left:1000px;margin-top:140px;">
<img src="https://fbcdn-sphotos-d-a.akamaihd.net/hphotos-ak-xap1/v/t1.0-9/10363327_406579082839489_7985457610561998074_n.jpg?oh=70707f0d16562411b57e9828fc7eadd1&oe=5515D69E&__gda__=1425911874_4b407021bc4cbab27d5b4860bbe784d7"/>
</div>
</body>
</html>