<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<?xml version="1.0" encoding="ISO-8859-1" ?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<script src="//code.jquery.com/jquery-1.11.0.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/css/bootstrap.min.css"></script>
<link href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" rel="stylesheet" />
<link href="${pageContext.request.contextPath}/resources/css/bootstrap-theme.min.css" rel="stylesheet" />



<script src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Register New-User</title>
<script type="text/javascript">
		
	$(document)	.ready(	function(){
	$("#username").change(function() {	
		$.ajax({
		type : 'POST',
		dataType : 'json',
		url : '/SimplWebApp/checkusername',
		data : ({
			name : $("#username").val()
			
			
		}),
		success : function(response) {
			
			

						if (response == '0')//if ajax_check_username.php return value "0"
						{
							
							$("#availability_status").html('<font color="Green"> Available </font>');
							
							//add this image to the span with id "availability_status"
						} else if (response == '1')//if it returns "1"
						{
							
							$("#availability_status").html('<font color="Red">Not Available </font>');
							
						}

					

		},
		error : function() {
			alert('Error while request..');
		}

});
		
	});
	});
</script>

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
				<li><a href="${pageContext.request.contextPath}/home">Home</a></li>
				<li><a href="#">Our Services</a></li>
				<li><a href="#">About Us</a></li>
				<li><a href="#">Contact Us</a></li>
			</ul>

		</div>
	</div>
	</nav>
	<br/><br/>
	<div align="center">
		<fieldset>
			<h1>Create New User-Account</h1>
			<form:form method="POST" commandName="user"
				action="${pageContext.request.contextPath}/do-register">
				
					<table>
						<tbody>
							<tr>
								<td>Name:</td>
								<td><form:input path="name" 
										id="username" /><span id="availability_status"></span></td>
								<td><form:errors path="name" class="error" /></td>
								
							</tr>
							<tr>
								<td>Email:</td>
								<td><form:input path="email"  /></td>
								<td><form:errors path="email" class="error" /></td>
							</tr>
							<tr>
								<td>Password:</td>
								<td><form:password path="password"  /></td>
								<td><form:errors path="password" class="error" /></td>
							</tr>
							<tr>
								<td>Department:</td>
								<td><form:select path="department.id">

										<form:option value="0" label="Select" />

										<form:options items="${departments}" itemValue="id"
											itemLabel="name" />

									</form:select></td>
									<td><form:errors path="department.id" class="error" /></td>
							</tr>
							<tr>
								<td><input type="submit" value="Create"
									class="btn btn-primary" /></td>
								<td></td>
							</tr>
						</tbody>
					</table>
				
			</form:form>
			
		</fieldset>
	</div>
</body>
</html>






















