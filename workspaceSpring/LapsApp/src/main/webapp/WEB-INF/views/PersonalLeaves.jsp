<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Personal Leaves History</title>
</head>
<body>
<div style="text-align:center">
<p><img src="https://fbcdn-sphotos-f-a.akamaihd.net/hphotos-ak-xpf1/t31.0-8/10749959_406574562839941_3539789211823270904_o.jpg" align="center"/></p>
</div>
<label>Welcome ${employeelogedin.employeename} </label>
<c:forEach var="LeaveDetail" items="${employeelogedin.m_personalLeaveHistory}">
    <table style="width:600px;">
      <tr>
        <td>
	        EmployeeID
	        <c:out value="${LeaveDetail.id.employeeID}"/>
        </td>
        <td>
	        Status
	        <c:out value="${LeaveDetail.leaveStatus}"/>
        </td>
        <td>
	        RoleID
	        <c:out value="${LeaveDetail.roleID}"/>
        </td>
        <td>
	        LeaveTypeID
	        <c:out value="${LeaveDetail.leaveTypeID}"/>
        </td>
        <td>
	        FromDate
	        <c:out value="${LeaveDetail.id.fromDate}"/>
        </td>
        <td>
	        ToDate
	        <c:out value="${LeaveDetail.toDate}"/>
        </td>
        <td>
	        NumberOfDays
	        <c:out value="${LeaveDetail.NUmberOfDays}"/>
        </td>
      </tr>
  </table>
  </c:forEach>
  <div style="position:absolute;margin-left:1000px;margin-top:140px;">
<img src="https://fbcdn-sphotos-d-a.akamaihd.net/hphotos-ak-xap1/v/t1.0-9/10363327_406579082839489_7985457610561998074_n.jpg?oh=70707f0d16562411b57e9828fc7eadd1&oe=5515D69E&__gda__=1425911874_4b407021bc4cbab27d5b4860bbe784d7"/>
</div>
</body>
</body>
</html>