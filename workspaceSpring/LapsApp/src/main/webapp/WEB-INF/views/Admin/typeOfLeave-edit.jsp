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
		action="${pageContext.request.contextPath}/typeOfLeave/edit/${Entitlement.id.roleId}/${Entitlement.id.leaveTypeId}.html">
		<table>
			<tbody>
				<tr>
					<td>RoleID</td>
					<td><form:input path="id.roleId" /></td>
					<td><form:errors path="id.roleId" cssStyle="color: red;" /></td>
				</tr>
				
				<tr>
					<td>leaveTypeId</td>
					<td><form:input path="id.leaveTypeId" /></td>
					<td><form:errors path="id.leaveTypeId" cssStyle="color: red;" /></td>
				</tr>
					
				<tr>
					<td>NumofDays</td>
					<td><form:input path="numOfDays" /></td>
					<td><form:errors path="numOfDays" cssStyle="color: red;" /></td>
				</tr>
				<tr>
					<td>Approve RoleID</td>
					<td><form:input path="approvelRoleId" /></td>
					<td><form:errors path="approvelRoleId" cssStyle="color: red;" /></td>
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