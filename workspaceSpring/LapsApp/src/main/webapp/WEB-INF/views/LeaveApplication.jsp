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
<title>Leave Application</title>
</head>
<body>
<script>
    $(function () {
        $("#Date").datepicker({ dateFormat: 'yy/mm/dd'});
    });
</script>
<spring:url value="/employee/${employeelogedin.employeeID}/newLeave.html" var="formUrl"/>
    <form:form modelAttribute="leave" action="${fn:escapeXml(formUrl)}" method="post" class="form-horizontal"
               id="search-owner-form">
        <fieldset>
            <div>
                <label class="control-label">RoleID </label>
                <form:input path="roleID" size="30" maxlength="80" value="E"/>
            </div>
            <div>
                <label class="control-label">LeaveType </label>
                <form:input path="leaveTypeID" size="30" maxlength="80" value="AN"/>
            </div>
            <div>
                <label class="control-label">Number Of Day(s) </label>
                <form:input path="NUmberOfDays" size="30" maxlength="80"/>
            </div>
            <div>
                <label class="control-label">From date</label>
                <form:input path="fromDate"  name = "date" size="30" maxlength="80" value="14/12/07"/>
            </div>
            <div>
                <label class="control-label">Approver ID</label>
                <form:input path="m_manager.employeeID" size="30" maxlength="80" value="M01"/>
            </div>
            <div class="form-actions">
                <button type="submit">Apply Leave</button>
            </div>
        </fieldset>
    </form:form>
</body>
</html>