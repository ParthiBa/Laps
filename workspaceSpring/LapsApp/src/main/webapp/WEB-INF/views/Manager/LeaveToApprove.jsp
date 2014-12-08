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
<title>Leave To Approve</title>
</head>
<body>
<label>Welcome ${manager.employeename} </label>
<c:forEach var="LeaveDetail" items="${manager.m_leaveToApprove}">
 <c:choose>
   <c:when test="${(LeaveDetail.leaveStatus == 'Applied')}">
   <table style="width:600px;">
       <tr>
           <td valign="top" style="width: 120px;">
               <dl class="dl-horizontal">
                   <dt>EmployeeID</dt>
                   <dd><c:out value="${LeaveDetail.id.employeeID}"/></dd>
                   <dt>RoleID</dt>
                   <dd><c:out value="${LeaveDetail.roleID}"/></dd>
                   <dt>LeaveTypeID</dt>
                   <dd><c:out value="${LeaveDetail.leaveTypeID}"/></dd>
                   <dt>FromDate</dt>
                   <dd><c:out value="${LeaveDetail.id.fromDate}"/></dd>
                   <dt>ToDate</dt>
                   <dd><c:out value="${LeaveDetail.toDate}"/></dd>
                   <dt>NumberOfDays</dt>
                   <dd><c:out value="${LeaveDetail.NUmberOfDays}"/></dd>
               </dl>
           </td>
       </tr>
   </table>
   </c:when>
 </c:choose>
</c:forEach>
</body>
</html>