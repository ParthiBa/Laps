<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Create Holiday</title>
<link rel="stylesheet" href="http://code.jquery.com/ui/1.10.2/themes/smoothness/jquery-ui.css" />
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
$(function() {
    $('.date-picker1').datepicker( {
        changeMonth: true,
        changeYear: true,
        showButtonPanel: true,
        yearRange: "-35:+0",
        dateFormat: 'dd/mm/yy',
        onSelect: (function(dateText, inst) { 
            $('.date-picker1').val(dateText);
        })
});
});
</script>
</head>
<body>
<form:form method="POST" commandName="holiday" action="${pageContext.request.contextPath}/holiday/create">    
<table>
<tbody>

<tr>
<td>Holiday Name:</td>
<td><form:input path="holidayName"/></td> 
<td></td>
</tr>

<tr>
<td>Start Date:</td>
<td><form:input path="startDate" class="date-picker" placeholder="dd/mm/yy"/></td>
<td></td>
</tr>

<tr>
<td>End Date:</td>
<td><form:input path="endDate" class="date-picker1" placeholder="dd/mm/yy"/></td>
<td></td>
</tr>

<tr>
<td><button type="submit">Apply Leave</button></td>
<td></td>
<td></td>
</tr>

</tbody>
</table>
</form:form>
</body>
</html>