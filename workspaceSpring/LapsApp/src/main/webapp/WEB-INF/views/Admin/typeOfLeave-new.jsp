<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<link rel="stylesheet"
	href="http://code.jquery.com/ui/1.10.2/themes/smoothness/jquery-ui.css" />
<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
<script src="http://code.jquery.com/ui/1.10.2/jquery-ui.js"></script>

<title>Entitlement</title>
</head>
<body>
	<h1>Manage Entitlement</h1>
	<form:form method="POST" commandName="Entitlement"
		action="${pageContext.request.contextPath}/typeOfLeave/create.html">
		<table>
			<tbody>
				<tr>
        		<td>Role ID:</td>
        		<td><form:select path="id.roleId">
           		<form:option value="-" label="Please Select"/>
            	<form:options items="${roleList}" itemValue="roleId" itemLabel="roleType" ></form:options>
            	</form:select> 
       			</td><td><form:errors path="roleId" cssStyle="color: red;"/></td>
        		<td><form:errors path="roleId" cssStyle="color: red;"/></td>
    			</tr>

				<tr>
        		<td>Leave Type Id:</td>
        		<td><form:select path="id.leaveTypeId">
           		<form:option value="-" label="Please Select"/>
            	<form:options items="${leaveTypeList}" itemValue="leaveTypeID" itemLabel="leaveTypeName" ></form:options>
            	</form:select> 
       			</td><td><form:errors path="id.leaveTypeId" cssStyle="color: red;"/></td>
        		<td><form:errors path="id.leaveTypeId" cssStyle="color: red;"/></td>
        		
				<tr>
					<td>Number of Days:</td>
					<td><form:input path="numOfDays" value="${days}" /></td>
					<td><form:errors path="numOfDays" cssStyle="color: red;" /></td>
				</tr>
				<tr>
					<td>Approve RoleID</td>
					<td><form:label path="approvelRoleId">
						</form:label><form:select path="approvelRoleId">
							<form:option value="M">Manager</form:option>
							<form:option value="null">None</form:option>
						</form:select>
						</td><td><form:errors path="approvelRoleId" cssStyle="color: red;"/></td>
        		<td><form:errors path="approvelRoleId" cssStyle="color: red;"/></td>
				</tr>
				<tr>
					<td><button type="submit">Submit</button></td>
					<td></td>
					<td></td>
				</tr>
			</tbody>
		</table>
	</form:form>
</body>
</html>