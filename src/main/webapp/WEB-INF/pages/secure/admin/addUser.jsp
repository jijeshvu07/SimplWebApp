<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<?xml version="1.0" encoding="ISO-8859-1" ?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Add User</title>
<script type="text/javascript" src="<c:url value="/resources/js/jquery-latest.min.js" />"></script>
<link rel="stylesheet" href="<c:url value="/resources/css/navstyle.css" />"></link>
<link rel="stylesheet" href="<c:url value="/resources/css/bootstrap.min.css" />"></link>
<style>
.error {
	color: #ff0000;
}
</style>
</head>
<body>
	<br/><br/><br/><h1>Add User</h1>
	<p>Here you can add a new user.</p>
	<form:form method="POST" commandName="user"
		action="${pageContext.request.contextPath}/home/admin/addUser">
		<table>
			<tbody>
				<tr>
					<td>Name:</td>
					<td><form:input path="name" />
					</td>
					<td><form:errors path="name" class="error"/>
					</td>
				</tr>
				<tr>
					<td>Email:</td>
					<td><form:input path="email" />
					</td>
					<td><form:errors path="email" class="error"/>
					</td>
				</tr>
				<tr>
					<td>Password:</td>
					<td><form:password path="password" />
					</td>
					<td><form:errors path="password" class="error"/>
					</td>
				</tr>
				<tr>
					<td>Authority:</td>
					<td><form:input path="authority" />
					</td>
					<td><form:errors path="authority" class="error"/>
					</td>
				</tr>
				<tr>
					<td><input type="submit" value="Add" />
					</td>
					<td></td>
				</tr>
			</tbody>
		</table>
	</form:form>

	<p>
		<a href="${pageContext.request.contextPath}">Home page</a>
	</p>
</body>
</html>