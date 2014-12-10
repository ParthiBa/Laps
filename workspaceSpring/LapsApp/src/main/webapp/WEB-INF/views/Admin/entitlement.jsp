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
	<form:form method="POST" commandName="entitlement"
		action="${pageContext.request.contextPath}/entitlement/create.html">
		<table>
			<tbody>
				<tr>
					<td><form:label path="roleId">
					RoleID
				</form:label><form:select path="roleId">
							<%-- 下拉选择菜单 --%>
							<form:option value="a">A</form:option>
							<form:option value="e">E</form:option>
							<form:option value="m">M</form:option>
						</form:select></td>
				</tr>

				<tr>
					<td><form:label path="leaveTypeId">
					LeaveTypeID
				</form:label><form:select path="leaveTypeId">
							<%-- 下拉选择菜单 --%>
							<form:option value="an">AN</form:option>
							<form:option value="med">MED</form:option>
						</form:select></td>
				</tr>
				<tr>
					<td>NumofDays</td>
					<td><form:input path="numOfDays" /></td>
					<td><form:errors path="numOfDays" cssStyle="color: red;" /></td>
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