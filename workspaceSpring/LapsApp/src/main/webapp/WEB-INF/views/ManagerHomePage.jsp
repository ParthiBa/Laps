<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<div style="text-align:center">
<p><img src="https://fbcdn-sphotos-f-a.akamaihd.net/hphotos-ak-xpf1/t31.0-8/10749959_406574562839941_3539789211823270904_o.jpg" align="center"/></p>
</div>
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
<div style="position:absolute;margin-left:1000px;margin-top:140px;">
<img src="https://fbcdn-sphotos-d-a.akamaihd.net/hphotos-ak-xap1/v/t1.0-9/10363327_406579082839489_7985457610561998074_n.jpg?oh=70707f0d16562411b57e9828fc7eadd1&oe=5515D69E&__gda__=1425911874_4b407021bc4cbab27d5b4860bbe784d7"/>
</div>