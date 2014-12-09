
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
<div style="text-align:center">
<p><img src="https://fbcdn-sphotos-f-a.akamaihd.net/hphotos-ak-xpf1/t31.0-8/10749959_406574562839941_3539789211823270904_o.jpg" align="center"/></p>
</div>
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
<div style="position:absolute;margin-left:1000px;margin-top:140px;">
<img src="https://fbcdn-sphotos-d-a.akamaihd.net/hphotos-ak-xap1/v/t1.0-9/10363327_406579082839489_7985457610561998074_n.jpg?oh=70707f0d16562411b57e9828fc7eadd1&oe=5515D69E&__gda__=1425911874_4b407021bc4cbab27d5b4860bbe784d7"/>
</div>
</body>
</html>