<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<link rel="stylesheet"
	href="<c:url value="/resources/css/bootstrap.min.css" />" />
<link rel="stylesheet"
	href="<c:url value="/resources/css/bootstrap-theme.min.css" />" />
<script src="<c:url value="/resources/js/jquery.min.js" />"></script>
<script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>

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

	<h2>Admin View</h2>
	<br />

	
	

	<table id="listTable" class="table table-striped">
		<thead>
			<tr>
				<th>ID</th>
				<th>Name</th>
				<th>Password</th>
				<th>Email</th>
				<th>Authority</th>
				<th>Department</th>
				<th>Operations</th>
			</tr>
		</thead>
		<tbody>

			<c:forEach items="${users}" var="current" varStatus="i">
				<tr>
					
							<td nowrap="nowrap">${current.id}&nbsp;</td>
							<td nowrap="nowrap">${current.name}&nbsp;</td>
							<td nowrap="nowrap">${current.password}&nbsp;</td>
							<td nowrap="nowrap">${current.email}&nbsp;</td>
							<td nowrap="nowrap">${current.authority}&nbsp;</td>
							<td nowrap="nowrap">${current.department.name}&nbsp;</td>
							<td nowrap="nowrap">
								<%-- <a title="Create"
						href="${pageContext.request.contextPath}/home/admin/userPage">Create</a> <a
						title="Edit"
						href="${pageContext.request.contextPath}/home/editUser/${current.id}">Update</a> --%>
								<a title="Delete"
								href="${pageContext.request.contextPath}/home/deleteUser/${current.id}"
								onclick="return confirm('Are you sure?')">Delete</a>
							</td>
					
				</tr>
			</c:forEach>

		</tbody>
	</table>
</body>
</html>