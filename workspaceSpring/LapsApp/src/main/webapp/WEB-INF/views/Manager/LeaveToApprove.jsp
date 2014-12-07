<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Leave To Approve</title>
</head>
<body>
<c:forEach var="LeaveDetail" items="${manager.m_leaveToApprove}">
   <table style="width:600px;">
       <tr>
           <td valign="top" style="width: 120px;">
               <dl class="dl-horizontal">
                   <dt>EmployeeID</dt>
                   <dd><c:out value="${LeaveDetail.EmployeeID}"/></dd>
                   <dt>RoleID</dt>
                   <dd><c:out value="${LeaveDetail.RoleID}"/></dd>
                   <dt>LeaveTypeID</dt>
                   <dd><c:out value="${LeaveDetail.LeaveTypeID}"/></dd>
                   <dt>FromDate</dt>
                   <dd><c:out value="${LeaveDetail.FromDate}"/></dd>
                   <dt>ToDate</dt>
                   <dd><c:out value="${LeaveDetail.ToDate}"/></dd>
                   <dt>NumberOfDays</dt>
                   <dd><c:out value="${LeaveDetail.NumberOfDays}"/></dd>
               </dl>
           </td>
       </tr>
   </table>
</c:forEach>
</body>
</html>