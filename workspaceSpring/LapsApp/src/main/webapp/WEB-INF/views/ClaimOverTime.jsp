
<%@ page session="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Overtime Claim</title>
<link rel="stylesheet" href="//code.jquery.com/ui/1.11.2/themes/smoothness/jquery-ui.css">
<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
<script src="http://code.jquery.com/ui/1.10.2/jquery-ui.js"></script>
<script>
$(function() {
    $('.date-picker').datepicker( {
        changeMonth: true,
        changeYear: true,
        showButtonPanel: true,
        yearRange: "-35:+0",
        dateFormat: 'dd/mm/yy',
        onSelect: (function(dateText, inst) { 
            $('.date-picker').val(dateText);
        })
});
});
</script>
</head>

<body>
<spring:url value="/employee/${employeelogedin.employeeID}/newClaim.html" var="formUrl"/>
<form:form modelAttribute="claim" action="${fn:escapeXml(formUrl)}" method="post" class="form-horizontal"
										               id="search-owner-form">
<table>
<tbody>
<tr>
<td>EmployeeID:</td>
<td><form:input path="m_itID.employeeID" /></td> 
<td></td>
</tr>

<tr>
<td>Date:</td>
<td><form:input path="m_itID.m_otWorkedDate" class="date-picker" placeholder="dd/mm/yy"/></td>
<td></td>
</tr>
<tr>
<td>Manager ID</td>
<td><form:input path="m_manager.employeeID" size="30" maxlength="80" value="M01"/></td>
</tr>
<tr>
<td>During:</td>
<td>
<form:select path="isFullDay">
        	<form:option value="1" label="full day"/>
        	<form:option value="0" label="half day"/>
</form:select>
</td>
<td></td>
</tr>

<tr>
<td><input type="submit" value="Submit" /></td>
<td></td>
<td></td>
</tr>


</tbody>
</table>
</form:form>
<a href="${pageContext.request.contextPath}/">Home page</a>
</body>
</html>