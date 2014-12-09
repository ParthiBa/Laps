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
</body>
</body>
</html>