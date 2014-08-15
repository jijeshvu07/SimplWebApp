<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Department</title>
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
<script type="text/javascript">
	$(document).ready(function() {
		$(".edit").click(function() {
			$.ajax({
				type : 'POST',
				dataType : 'json',
				url : '/SimplWebApp/updatedepartment',
				data : ({
					id :  $(this).siblings("input").val()

				}),
				success : function(response) {

					alert(response);
					

				},
				error : function() {
					alert('Error while request..');
				}

			});

		});
	});
	
	
	/* 
	jQuery(document).ready(function(){
		jQuery("#userform").submit(function(e){
			jQuery(".formFieldError").remove();
			jQuery.ajax({
					url: jQuery(this).attr("action"),
					context: document.body,
					type: 'post',
					data:jQuery(this).serialize()
				}).done(function(res) {
					if(res.status==="ERROR"){
						for(var key in res.errorsMap){
							var err="<span class=\"formFieldError\" id=\""+key+"Id\">"+res.errorsMap[key]+"</span>";
							jQuery("[name^='"+key+"']").after(err);
						}
					}else{						
						jQuery("#msg").html("Form submitted");
					}
				}).fail(function(data){
					jQuery("#msg").html("<span class=\"formFieldError\">Server failed to process request</span>");
				});
			return false;
		});
	});
	
	 */
	
	
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
				<li><a href="${pageContext.request.contextPath}/home">Home</a></li>
				<li><a href="${pageContext.request.contextPath}/technologies">Technology</a></li>
				<li><a href="${pageContext.request.contextPath}/departments">Department</a></li>
				<li><a href="${pageContext.request.contextPath}/skill-factors">Skill-Factor</a></li>
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
	<br />
	<br />
	<br />
	<h1>Departments</h1>
	<fieldset>
		<h4>Add New Department</h4>
		<form:form method="post" action="/SimplWebApp/add-department" commandName="department" >

			<label>Department Name</label> <form:input path="name" />
				<form:errors path="name" class="error"></form:errors>
			<br /> <input type="submit" class="btn btn-primary" />

		</form:form>
		<div id="msg"></div>
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
			<c:forEach items="${departments}" var="dept" varStatus="i">
				<tr>

					<td nowrap="nowrap">${dept.id}&nbsp;</td>
					<td nowrap="nowrap">${dept.name}&nbsp;</td>
					<td nowrap="nowrap">${dept.createdDate}&nbsp;</td>
					<%-- 	<td nowrap="nowrap"><a title="Edit" href="#" class="edit"
						id="edit">Edit</a><input id="hiddenid" class="hiddenid"
						type="hidden" value="${dept.id}" /></td> --%>
					<td nowrap="nowrap"><a title="Delete"
						href="${pageContext.request.contextPath}/delete-department/${dept.id}"
						onclick="return confirm('Are you sure?')">Delete</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

	<a href="${pageContext.request.contextPath}/export.xls">Export</a><br/><br/>
	
	
	
	<form method="post" action="upload" enctype="multipart/form-data">
		<input type="file" name="file" /> <input type="submit" />
	</form>
</body>
</html>