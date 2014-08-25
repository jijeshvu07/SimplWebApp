<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet"
	href="<c:url value="/resources/css/bootstrap.min.css" />" />
<link rel="stylesheet"
	href="<c:url value="/resources/css/bootstrap-theme.min.css" />" />
<script src="<c:url value="/resources/js/jquery.min.js" />"></script>
<script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>UserRating</title>
<link rel="stylesheet" type="text/css"
	href="//cdn.datatables.net/1.10.0/css/jquery.dataTables.css">
<!-- <script type="text/javascript"
	src="//code.jquery.com/jquery-1.10.2.min.js"></script> -->
<script type="text/javascript"
	src="//cdn.datatables.net/1.10.0/js/jquery.dataTables.js"></script>
<script type="text/javascript">
	$(document).ready(function() {

		$("#example").dataTable({
			"bProcessing" : false,
			"bServerSide" : false,
			"sort" : "position",
			"sAjaxSource" : "springPaginationDataTables",
			"aoColumns" : [ {"mData" : "id"}, 
			                {"mData" : "userId.name"},
			                {"mData" : "technologyId.department.name"},
			                {"mData" : "technologyId.name"},
			                {"mData" : "skillFactorId.factorName"},
			                {"mData" : "ratingId.name"},
			                {"mData" : "attendDate"}
			]
		});

	});
</script>
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
<br/><br/><br/><h1>User Rating</h1>
	<table width="70%" style="border: 3px; background: rgb(243, 244, 248);" class="table table-striped">
		<tr>
			<td>
				<table id="example" class="display" cellspacing="0" width="100%" class="table table-striped">
					<thead>
						<tr>
							<th>ID</th>
							<th>User Name</th>
							<th>Department</th>
							<th>Technology</th>
							<th>Skill Factor</th>
							<th>Rating</th>
                             <th>Attend Date</th>

						</tr>
					</thead>
				</table>
			</td>
		</tr>
	</table>
</body>
</html>