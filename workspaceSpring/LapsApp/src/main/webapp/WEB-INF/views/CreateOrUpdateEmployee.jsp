<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>   
  <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
// $(function() {
//     $( "#datepicker" ).datepicker();
//   });
</script>
<title>Employee</title>

</head>
<body>
<div align="center">
<c:choose>
        <c:when test="${actiont== 'create'}"><c:set var="method" value="post"/><c:set var="button" value="create Employee"/><h1>Please fill up the new EmployeeForm</h1></c:when>
        <c:otherwise><c:set var="method" value="put"/><c:set var="button" value="Update Employee"/><h1>edit the EmployeeForm</h1></c:otherwise>
    </c:choose>
<form:form action="/admin/CreateEmployee" method="${method}" commandName="employee">
<table border="0">
<tr><td colspan="3" align="center">    </tr>
<tr><td>EmployeeId:</td>
  <td><form:input path="employeeID"/></td>
  <td><form:errors path="employeeID" cssStyle="color: red;"/></td>
  
 </tr>
 <tr><td>EmployeeName:</td>
   <td><form:input path="employeename" /></td><form:errors path="employeename" cssStyle="color: red;"/></tr>
    <tr><td>DateOfBirth</td>
        <td><form:input path="dob" class="date-picker" placeholder="dd/mm/yy" /></td>
        <td><form:errors path="dob" cssStyle="color: red;"/></td>
    </tr>
    <tr><td>Password:</td>
    <td><form:password path="password" />
				</td>
				<td><form:errors path="password" cssClass="error" />
				</td>
				</tr>
    <tr>
        <td>Role ID:</td>
        <td><form:select path="roleID">
            <form:option value="-" label="Please Select"/>
            <form:options items="${roleList}" itemValue="roleId" itemLabel="roleType" ></form:options>
            

            </form:select> 
        </td><td><form:errors path="roleID" cssStyle="color: red;"/></td>
        <td><form:errors path="roleID" cssStyle="color: red;"/></td>
    </tr>
    <tr>
       
       <td>SuperVisor</td>
           <td> <form:select path="supervisorID">
            <form:option value="-" label="Select" />
            <form:options items="${SupervisorList}" itemValue="employeeID" itemLabel="employeename" />
            </form:select> </td><td><form:errors path="supervisorID" cssStyle="color: red;"/></td>
    </tr>
   <tr>
   <td><input type="submit" value=${button}>

              
<%--                     <button type="submit">${button}</button> --%>
   
         
   </tr>
   
    </table>
    </form:form>
    </div>
</body>
</html>