<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
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
<title>Apply Leave</title>
</head>
<body>
<h1>Apply Leave Information</h1>
<spring:url value="/employee/${employeelogedin.employeeID}/newLeave.html" var="formUrl"/>
<form:form method="POST" modelAttribute="leave" action="${fn:escapeXml(formUrl)}">
<table>
<tbody>
	<tr>
	  <td>Staff Name:</td>
	   <td><form:input path="employeeID"/></td> 
	</tr>
	<tr>
	   <td>Role ID:</td>
	   <td><form:input path="roleID"/></td>
	</tr>
	<tr>
	<td>Leave Type:</td>
	  <td><form:select path="LeaveTypeID">
	  <form:option value="-" label="select"/>
	  <form:options items="${LeaveTypeNameList}" itemValue="leaveTypeID" itemLabel="leaveTypeName"></form:options> 
	  </form:select>
	  </td>
	  <td><form:errors path="LeaveTypeID" cssStyle="color:red"></form:errors></td>	  
	</tr>
	<tr>
	   <td>FromDate:</td>
	   <td><form:input path="FromDate" class="date-picker" placeholder="dd/mm/yy"/></td>
	   <td><form:errors path="FromDate" cssStyle="color:red"></form:errors></td>
	</tr>
	<tr>
	   <td>ToDate:</td>
	   <td><form:input path="ToDate" class="date-picker1" placeholder="dd/mm/yy"/></td>
	   <td><form:errors path="ToDate" cssStyle="color:red"></form:errors></td>
    </tr>
    <!-- <tr>
       <td>NoOfDays:</td>
       <td><input type="text" readonly disabled/></td>      
    </tr> -->
    <tr>
        <td>Is Full Day:</td>
        <td><form:checkbox path="isFullDay"/>        
    </tr>
   <!--  <tr>
       <td>Reason:</td>
       <td><input type="text"/></td>       
    </tr> -->
    <tr>
    	<td>LeaveStatus:</td>
    	<td><form:select path="leaveStatus" items="${LeaveStatusList}" /></td>
    <tr>
      <td>WorkDissemination:</td>
      <td><form:input path="workDissemination"/></td>
     <!-- <td><form:errors path="workDissemination" cssStyle="color:red"></form:errors></td> -->
    </tr>	   
    <tr>
      <td>Contact Details:</td>
      <td><form:input path="contactDetail"/></td>     
    </tr>
    <tr>
    <td></td>
     <td><input type="submit" value="create"/><input type="button" value="Cancel"/></td>    
     
    </tr>
	
    
 </tbody>   
</table>
</form:form>
</body>
</html>