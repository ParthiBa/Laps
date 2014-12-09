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
        <td>
	        EmployeeID
	        <c:out value="${LeaveDetail.id.employeeID}"/>
        </td>
        <td>
	        Status
	        <form name="form" action="${pageContext.request.contextPath}/manager/approveorreject" method="post">
				<textarea name="comment" placeholder="Leave a comment here" cols="7" rows="2" ></textarea>
				<br/>
				<input type="hidden" name="Approved"/>
				<input type="hidden" name="Rejected"/>
				<input type="hidden" name="empid" value="${LeaveDetail.id.employeeID}"/>
				<input type="hidden" name="date" value="${LeaveDetail.id.fromDate}"/>
				<input name="btn" type="submit" value="Approve" onclick="{document.form.Approved.value=this.value;}"/>&nbsp;&nbsp;
				<input name="btn" type ="submit" value="Reject" onclick="{document.form.Rejected.value=this.value;}"/>
			</form>
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
  </c:when>
 </c:choose>
</c:forEach>
</body>
</html>