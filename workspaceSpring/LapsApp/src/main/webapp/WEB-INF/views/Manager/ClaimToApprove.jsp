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
   <table style="width:600px;">
       <tr>
           <td valign="top" style="width: 120px;">
               <dl class="dl-horizontal">
                   <dt>EmployeeID</dt>
                   <dd><c:out value="${OTDetail.m_itID.employeeID}"/></dd>
                   <dt>OTWorkedDate</dt>
                   <dd><c:out value="${OTDetail.m_itID.m_otWorkedDate}"/></dd>
                   <dt>IsFullDay</dt>
                   <dd><c:out value="${OTDetail.isFullDay}"/></dd>
                   <dt>ISApproved</dt>
                   <dd><c:out value="${OTDetail.isApproved}"/></dd>
               </dl>
           </td>
       </tr>
   </table>
</c:forEach>
</body>
</html>