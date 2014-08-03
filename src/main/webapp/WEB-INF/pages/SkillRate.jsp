<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
<link rel="stylesheet"
	href="<c:url value="/resources/css/bootstrap.min.css" />" />
<link rel="stylesheet"
	href="<c:url value="/resources/css/bootstrap-theme.min.css" />" />
<script
	src="http://cdnjs.cloudflare.com/ajax/libs/jquery/1.8.0/jquery-1.8.0.min.js "></script>
<script src="<c:url value="/resources/js/jquery.min.js" />"></script>
<script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
<script src="<c:url value="/resources/js/underscore-min.js" />"></script>

<script type="text/javascript">
	var arr = [];
	var index;
	
	$(document).ready(function() {
		$(".rating").click(function() {
			var idx = $(this).closest('td').index();
			
			var userskill = {
				tech : $(this).closest('td').siblings('td.techId').text(),
				skill : $('#listTable thead th').eq(idx).text(),
				rValue : $(this).val()

			}

		var result=	containsObject(userskill,arr);
		if(result==false){
			arr.push(userskill);

		}else{
			arr.splice(index, 1);
			arr.push(userskill);
		}

	});
	});
	
	function containsObject(obj, list) {
		    var i;
		    for (i = 0; i < list.length; i++) {
		        if ((list[i].tech === obj.tech) && (list[i].skill==obj.skill)) {
		        	index=i;
		            return true;
		        }
		    }

		    return false;
		}
	$(document).ready(function() {
		$("#btn").click(function() {
			if($('input.rating:checked').length<=0)
			{
			 alert("No radio checked")
			}else{
				$.ajax({
					type : 'POST',
					dataType : 'json',
					url : '/SimplWebApp/saveUserRating',
					data : ({
						id : JSON.stringify(arr)
					}),
					success : function(responseData) {
						if (responseData != null) {

							alert(responseData);
						} else {
							alert("no data");
						}
					}

				});
			}
			
	 
		});
	});
</script>
</head>
<body>
	<br>
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
				<a href="${pageContext.request.contextPath}/SkillRate"
					class="navbar-brand">Skill Test</a>
			</div>
			<!-- Collection of nav links and other content for toggling -->
			<div id="navbarCollapse" class="collapse navbar-collapse">
				<ul class="nav navbar-nav">
					<li><a href="${pageContext.request.contextPath}/home">Home</a></li>
					<li><a class="active"
						href="${pageContext.request.contextPath}/SkillRate">Skill Test</a></li>
				</ul>
				<ul class="nav navbar-nav navbar-right">
					<li><a href="<c:url value="/j_spring_security_logout" />">
							Logout</a></li>
				</ul>
			</div>
		</div>
	</nav>

	<br />
	<br />
	<br />
	<h2>${message}</h2>





	<table id="listTable" class="table table-striped">
		<thead>
			<tr>
				<th>#</th>
				<th>Technology</th>
				<c:forEach items="${skillfactors}" var="skillfact" varStatus="j">
					<th>${skillfact.factorName}</th>
				</c:forEach>

			</tr>
		</thead>
		<tbody>
			<c:forEach items="${technologies}" var="tech" varStatus="i">
				<tr>

					<td nowrap="nowrap" class="techId">${tech.id}</td>
					<td nowrap="nowrap" class="tech">${tech.name}</td>


					<c:forEach items="${skillfactors}" var="skillfact" varStatus="l">
						<td nowrap="nowrap"><c:forEach items="${ratingList}"
								var="ratings" varStatus="k">

								<!-- working code -->
								<input type="radio"  name="${tech.id}+${skillfact.id}"
									value="${ratings.id}" class="rating" />${ratings.name}
					           
					<br>

							</c:forEach></td>
					</c:forEach>

				</tr>
			</c:forEach>

		</tbody>
	</table>
	<p align="center">
		<input type="button" value="Submit" id="btn" class="btn btn-primary" />
	</p>


</body>
</html>