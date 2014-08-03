<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"/>
<title>Rating</title>
<link rel="stylesheet"
	href="<c:url value="/resources/css/bootstrap.min.css" />" />
<link rel="stylesheet"
	href="<c:url value="/resources/css/bootstrap-theme.min.css" />" />
<script src="<c:url value="/resources/js/jquery.min.js" />"></script>
<script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
<style>
.error {
	color: #ff0000;
}
</style>
</head>
<body>
<nav role="navigation" class="navbar navbar-default navbar-fixed-top">
				<div class="container-fluid">
					<!-- Brand and toggle get grouped for better mobile display -->
					<div class="navbar-header">
						<button type="button" data-target="#navbarCollapse"
							data-toggle="collapse" class="navbar-toggle">
							<span class="sr-only">Toggle navigation</span> <span
								class="icon-bar"></span> <span class="icon-bar"></span> <span
								class="icon-bar"></span>
						</button>
						<a href="#" class="navbar-brand">Skill Test</a>
					</div>
					<!-- Collection of nav links and other content for toggling -->
					<div id="navbarCollapse" class="collapse navbar-collapse">
						<ul class="nav navbar-nav">
							<li ><a
								href="${pageContext.request.contextPath}/home">Home</a></li>
							<li><a
								href="${pageContext.request.contextPath}/technologies">Technology</a></li>
							<li><a href="${pageContext.request.contextPath}/departments">Department</a></li>
							<li><a
								href="${pageContext.request.contextPath}/skill-factors">Skill-Factor</a></li>
							<li><a href="${pageContext.request.contextPath}/rating">Rating</a></li>
							<li><a href="${pageContext.request.contextPath}/user-rating">Users-Rating</a></li>
							<li><a href="${pageContext.request.contextPath}/users">Users</a></li>
							
						</ul>
						<ul class="nav navbar-nav navbar-right">
							<li><a href="<c:url value="/j_spring_security_logout" />">
									Logout</a></li>
						</ul>
					</div>
				</div>
			</nav>
<br/><br/><br/><h1>Rating</h1>
	<fieldset>
		<h4>Add New Rating</h4>
		<form:form method="post" action="add-rating"
			commandName="rating">

			<label>Rating Name</label>
			<form:input path="name" /><form:errors path="name" class="error"></form:errors>
			<br />
			
			<input type="submit" class="btn btn-primary"/>

		</form:form>
	</fieldset>
	<table id="listTable" class="table table-striped">
		<thead>
			<tr>
				<th>ID</th>
				<th>Name</th>
				<th>Created Date</th>
				<th>Action</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${ratings}" var="rate" varStatus="i">
				<tr>

					<td nowrap="nowrap">${rate.id}&nbsp;</td>
					<td nowrap="nowrap">${rate.name}&nbsp;</td>
					<td nowrap="nowrap">${rate.createdDate}&nbsp;</td>
					<td nowrap="nowrap"><%-- <a title="Edit"
						href="${pageContext.request.contextPath}/home/editUser/${tech.id}">Update</a> --%>
						<a title="Delete"
						href="${pageContext.request.contextPath}/delete-rating/${rate.id}" onclick="return confirm('Are you sure?')">Delete</a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>