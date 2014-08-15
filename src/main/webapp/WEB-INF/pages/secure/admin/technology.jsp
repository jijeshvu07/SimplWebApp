<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Technology</title>

<link rel="stylesheet" href="http://jqueryvalidation.org/files/demo/site-demos.css">
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
<script language="Javascript">
function fileUpload(form, action_url, div_id) {
    // Create the iframe...
    var iframe = document.createElement("iframe");
    iframe.setAttribute("id", "upload_iframe");
    iframe.setAttribute("name", "upload_iframe");
    iframe.setAttribute("width", "0");
    iframe.setAttribute("height", "0");
    iframe.setAttribute("border", "0");
    iframe.setAttribute("style", "width: 0; height: 0; border: none;");
 
    // Add to document...
    form.parentNode.appendChild(iframe);
    window.frames['upload_iframe'].name = "upload_iframe";
 
    iframeId = document.getElementById("upload_iframe");
 
    // Add event...
    var eventHandler = function () {
 
            if (iframeId.detachEvent) iframeId.detachEvent("onload", eventHandler);
            else iframeId.removeEventListener("load", eventHandler, false);
 
            // Message from server...
            if (iframeId.contentDocument) {
                content = iframeId.contentDocument.body.innerHTML;
            } else if (iframeId.contentWindow) {
                content = iframeId.contentWindow.document.body.innerHTML;
            } else if (iframeId.document) {
                content = iframeId.document.body.innerHTML;
            }
 
            document.getElementById(div_id).innerHTML = content;
 
            // Del the iframe...
            setTimeout('iframeId.parentNode.removeChild(iframeId)', 250);
        }
 
    if (iframeId.addEventListener) iframeId.addEventListener("load", eventHandler, true);
    if (iframeId.attachEvent) iframeId.attachEvent("onload", eventHandler);
 
    // Set properties of form...
    form.setAttribute("target", "upload_iframe");
    form.setAttribute("action", action_url);
   
    form.setAttribute("method", "post");
    form.setAttribute("enctype", "multipart/form-data");
    form.setAttribute("encoding", "multipart/form-data");
 
    // Submit the form...
    form.submit();
 
    document.getElementById(div_id).innerHTML = "checking data...";
    location.refesh();
}
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
	<br/><br/><br/><h1>Technologies</h1>
	<fieldset>
		<h4>Add New Technology</h4>
		<form:form method="post" action="add-technology"
			commandName="technology" id="technologyForm">

			<label>Technology Name</label>
			<form:input path="name" /><form:errors path="name" class="error"></form:errors>
			<br />
			<label>Department</label>
			<form:select path="department.id">

				<form:option value="0" label="Select" />

				<form:options items="${departments}" itemValue="id" itemLabel="name" />

			</form:select><form:errors path="department.id" class="error"></form:errors><br />
			<%-- 	<form:select path="department.id" items="${departments}" /> --%>
			<input type="submit" class="btn btn-primary"/>

		</form:form>
	</fieldset>
	<table id="listTable" class="table table-striped">
		<thead>
			<tr>
				<th>ID</th>
				<th>Name</th>
				<th>Department</th>
				<th>Created Date</th>
				<th>Action</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${technologies}" var="tech" varStatus="i">
				<tr>

					<td nowrap="nowrap">${tech.id}&nbsp;</td>
					<td nowrap="nowrap">${tech.name}&nbsp;</td>
					<td nowrap="nowrap">${tech.department.name}&nbsp;</td>
					<td nowrap="nowrap">${tech.createdDate}&nbsp;</td>
					<td nowrap="nowrap">
						<%-- <a title="Edit"
						href="${pageContext.request.contextPath}/home/editUser/${tech.id}">Update</a> --%>
						<a title="Delete"
						href="${pageContext.request.contextPath}/delete-technology/${tech.id}"
						onclick="return confirm('Are you sure?')">Delete</a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>


	<form enctype="multipart/form-data">
<input type="file" name="datafile" id="datafile"/>
<input type="button" value="upload"
        onClick="fileUpload(this.form,'/SimplWebApp/uploadtechnology','upload'); return false;" >
<div id="upload"></div>
</form>
	
</body>
</html>