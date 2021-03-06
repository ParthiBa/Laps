<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Student List page</title>
</head>
<body>
<%-- <c:forEach var="Employee" items="${Employee}"> --%>
<%-- </c:forEach> --%>
<spring:url value="/employee/process.html" var="formUrl"/>
    <form:form modelAttribute="employee" action="${fn:escapeXml(formUrl)}" method="get" class="form-horizontal"
               id="search-owner-form">
        <fieldset>
            <div>
                <label class="control-label">Last name </label>
                <form:input path="employeeID" size="30" maxlength="80"/>
            </div>
            <div class="form-actions">
                <button type="submit">Find Owner</button>
            </div>
            <c:forEach var="LeaveDetail" items="${LeaveDetailList}">
            ${LeaveDetail.employeeID}
            </c:forEach>
        </fieldset>
    </form:form>
</body>
</html>