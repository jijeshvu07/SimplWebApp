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



	<br>
	<c:choose>
		<c:when test="${isAdmin}">
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
						<a href="" class="navbar-brand">Skill Test</a>
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

			<br/><br/><br/><h2>${message}</h2>


		</c:when>
		<c:otherwise>
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
						<a href="${pageContext.request.contextPath}/SkillRate" class="navbar-brand">Skill Test</a>
					</div>
					<!-- Collection of nav links and other content for toggling -->
					<div id="navbarCollapse" class="collapse navbar-collapse">
						<ul class="nav navbar-nav">
							<li class="active"><a
								href="${pageContext.request.contextPath}/home">Home</a></li>
							<li><a href="${pageContext.request.contextPath}/SkillRate">Skill Test</a></li>
							</ul>
						<ul class="nav navbar-nav navbar-right">
							<li><a href="<c:url value="/j_spring_security_logout" />">
									Logout</a></li>
						</ul>
					</div>
				</div>
			</nav>

			<br/><br/><br/><h2>${message}</h2>
		</c:otherwise>
	</c:choose>

</body>
</html>