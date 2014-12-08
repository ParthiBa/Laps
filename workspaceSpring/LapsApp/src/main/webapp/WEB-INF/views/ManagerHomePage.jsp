<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<div style="width: 601px;">

<spring:url value="/manager/InitManagerWindow.html" var="formUrl"/>
<form:form action="${fn:escapeXml(formUrl)}" method="post" class="form-horizontal" id="form">
    <ul class="nav">
        <li style="width: 120px;"><a href="<spring:url value="/" htmlEscape="true" />"><i class="icon-home"></i>
            Home</a></li>
        <li style="width: 150px;"><a href="<spring:url value="/manager/InitManagerLeaveApproveWindow.html" htmlEscape="true" />"><i
            class="icon-search"></i> Find Leave to Approve</a></li>
        <li style="width: 160px;"><a href="<spring:url value="/manager/InitManagerClaimApproveWindow.html" htmlEscape="true" />"><i
             class="icon-th-list"></i> Find Claims To Approve</a></li>
    </ul>
</form:form>
</div>