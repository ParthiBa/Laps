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
<title>Claim Application</title>
</head>
<body>
<div style="text-align:center">
<p><img src="https://fbcdn-sphotos-f-a.akamaihd.net/hphotos-ak-xpf1/t31.0-8/10749959_406574562839941_3539789211823270904_o.jpg" align="center"/></p>
</div>
<spring:url value="/employee/${employeelogedin.employeeID}/newClaim.html" var="formUrl"/>
    <form:form modelAttribute="claim" action="${fn:escapeXml(formUrl)}" method="post" class="form-horizontal"
               id="search-owner-form">
        <fieldset>
            <div>
                <label class="control-label">OTWorked Date </label>
                <form:input path="m_itID.m_otWorkedDate" size="30" maxlength="80" value="E"/>
            </div>
            <div>
                <label class="control-label">IsFullDay </label>
                <form:input path="isFullDay" size="30" maxlength="80" value="AN"/>
            </div>
            <div>
                <label class="control-label">Manager ID</label>
                <form:input path="m_manager.employeeID" size="30" maxlength="80" value="M01"/>
            </div>
            <div class="form-actions">
                <button type="submit">Apply Leave</button>
            </div>
        </fieldset>
    </form:form>
    <div style="position:absolute;margin-left:1000px;margin-top:140px;">
<img src="https://fbcdn-sphotos-d-a.akamaihd.net/hphotos-ak-xap1/v/t1.0-9/10363327_406579082839489_7985457610561998074_n.jpg?oh=70707f0d16562411b57e9828fc7eadd1&oe=5515D69E&__gda__=1425911874_4b407021bc4cbab27d5b4860bbe784d7"/>
</div>
</body>
</html>