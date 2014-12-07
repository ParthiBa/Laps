<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Claims To Approve</title>
</head>
<body>
<c:forEach var="OTDetail" items="${manager.m_claimsToApprove}">
   <table style="width:600px;">
       <tr>
           <td valign="top" style="width: 120px;">
               <dl class="dl-horizontal">
                   <dt>EmployeeID</dt>
                   <dd><c:out value="${OTDetail.EmployeeID}"/></dd>
                   <dt>OTWorkedDate</dt>
                   <dd><c:out value="${OTDetail.OTWorkedDate}"/></dd>
                   <dt>IsFullDay</dt>
                   <dd><c:out value="${OTDetail.IsFullDay}"/></dd>
                   <dt>ISApproved</dt>
                   <dd><c:out value="${OTDetail.ISApproved}"/></dd>
               </dl>
           </td>
       </tr>
   </table>
</c:forEach>
</body>
</html>