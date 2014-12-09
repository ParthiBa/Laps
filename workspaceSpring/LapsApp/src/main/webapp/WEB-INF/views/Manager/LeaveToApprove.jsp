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
<script src="jquery-2.1.1.js" type="text/javascript" charset="utf-8"></script> 
</head>
<body>
<label>Welcome ${manager.employeename} </label>
<c:forEach var="LeaveDetail" items="${manager.m_leaveToApprove}">
 <c:choose>
   <c:when test="${(LeaveDetail.leaveStatus == 'APPLIED')}">
   <table style="width:600px;">
      <tr>
        <td>
	        EmployeeID
	        <c:out value="${LeaveDetail.id.employeeID}"/>
        </td>
        <td>
	        Status
	        <form name="form" action="${pageContext.request.contextPath}/manager/approveorreject" method="post">
				<input type="hidden" name="empid" value="${LeaveDetail.id.employeeID}"/>
				<input type="hidden" name="date" value="<fmt:formatDate value="${LeaveDetail.id.fromDate}" pattern="MM-dd-yyyy" />"/> 
				<INPUT TYPE="HIDDEN" NAME="buttonName">
            	<button id="approve "type="submit" name="buttonName">APPROVE</button>
            	<button id="reject" TYPE="submit" name="buttonName">REJECT</button>
            	<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js">
            	</script>
            	<script>
            	$(document).ready(function(){
            		$("#approve").click(function(){
            			$("#approve").val('1');
            		});
            		$("#reject").click(function(){
            			$("#reject").val('0');
            		});
            	});
            	</script>
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