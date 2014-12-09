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
<fieldset>
            <div>
                <label class="control-label">Staff Name: </label>
                <form:input path="employeeID" size="30" maxlength="80" value="E01"/>
            </div>
            <div>
                <form:select path="LeaveTypeID">
	  				<form:options items="${LeaveTypeNameList}" itemValue="leaveTypeID" itemLabel="leaveTypeName"></form:options> 
			  		</form:select>
            </div>
            <div>
                <label class="control-label">FromDate</label>
                <form:input path="FromDate" class="date-picker" placeholder="dd/mm/yy"/>
			    <form:errors path="FromDate" cssStyle="color:red"></form:errors>
            </div>
            <div>
                <label class="control-label">ToDate</label>
                <form:input path="ToDate" class="date-picker1" placeholder="dd/mm/yy"/>
			    <form:errors path="ToDate" cssStyle="color:red"></form:errors>
            </div>
            <div>
                <label class="control-label">Number Of Day(s):</label>
                <form:input path="NUmberOfDays" size="30" maxlength="80" value="1.0"/>
            </div>
            <div>
                <label class="control-label">Approver ID</label>
                <form:input path="m_manager.employeeID" size="30" maxlength="80" value="M01"/>
            </div>
            <div>
		    	<label class="control-label">LeaveStatus:</label>
		    	<form:select path="LeaveTypeID">
	  				<form:options items="${LeaveStatusList}"></form:options> 
		  		</form:select>
           </div>
		   <div>
		    	<label class="control-label">workDissemination"/></label>
		     	<form:input path="workDissemination" size="30" maxlength="80" value="E01"/>
		   </div>	   
		   <div>
                <label class="control-label">Contact Details:</label>
                <form:input path="contactDetail" size="30" maxlength="80"/>
           </div>
           <div class="form-actions">
                <button type="submit">Apply Leave</button>
           </div>
    </fieldset>
  </form:form>
</body>
</html>