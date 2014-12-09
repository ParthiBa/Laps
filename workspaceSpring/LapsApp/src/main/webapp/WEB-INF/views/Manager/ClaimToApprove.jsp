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
<title>Claims To Approve</title>
</head>
<body>
<label>Welcome ${manager.employeename} </label>
<c:forEach var="OTDetail" items="${manager.m_claimsToApprove}">
 <c:choose>
   <c:when test="${(OTDetail.isApproved == '0')}">
   <table style="width:600px;">
      <tr>
        <td>
	        EmployeeID
	        <c:out value="${OTDetail.m_itID.employeeID}"/>
        </td>
        <td>
	        OTWorkedDate
	        <c:out value="${OTDetail.m_itID.m_otWorkedDate}"/>
        </td>
        <td>
	        IsFullDay
	        <c:out value="${OTDetail.isFullDay}"/>
        </td>
        <td>
	        ISApproved
	        <c:out value="${OTDetail.isApproved}"/>
        </td>
      </tr>
  </table>
  </c:when>
 </c:choose>
</c:forEach>
</body>
</html>