<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<?xml version="1.0" encoding="UTF-8" ?>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>

<html>
<head>
<!-- JQuery -->
<script src="https://code.jquery.com/jquery-1.11.3.min.js"></script>
<script src="https://code.jquery.com/jquery-migrate-1.2.1.min.js"></script>

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">

<!-- Optional theme -->
<!-- <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap-theme.min.css"> -->
<link rel="stylesheet" href="./css/theme.css" type="text/css">

<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>

<link rel="stylesheet" href="./css/global.css" type="text/css">
</head>
<body>

<nav class="navbar navbar-default navbar-fixed-top bar-logo" role="navigation">
   <div class="navbar-header">
      <a class="navbar-brand" href="./news.html"><span class="glyphicon glyphicon-tree-deciduous" aria-hidden="true"></span> PhinkeyHR</a>
   </div>
</nav>
<nav class="navbar navbar-default navbar-fixed-top bar-nav" role="navigation">
   <div>
      <ul class="nav navbar-nav">
         <li><a href="./news.html">News Feed</a></li>
         <li <c:if test="${autUser.user_id == logedUser.user_id}"> class="active" </c:if>><a href="./details">My Info</a></li>
         <li <c:if test="${autUser.user_id != logedUser.user_id}"> class="active" </c:if>><a href="./list">Employees</a></li>
         <li><a href="./applications.html">Applications</a></li>
         <li><a href="./reports.html">Reports</a></li>
      </ul>
   </div>
</nav>

<div class="container">
<div class="row">
	<div class="col-sm-3" style="text-align:center;">
		<!-- <span class="glyphicon glyphicon-picture" aria-hidden="true" style="font-size:80pt;"></span>  -->
		<img width="150" height="150"
							src="<c:url value="/images/${autUser.picture}"/>" />
	</div>
	<div class="col-sm-9">	
		<h1>${autUser.name} ${autUser.surname}</h1>
	</div>
</div>
<div class="row" style="margin-top:20px;">
	<div class="col-sm-3" style="text-align:center;">
		<div><span class="glyphicon glyphicon-earphone" aria-hidden="true"></span> ${autUser.phone}</div>
		<div><span class="glyphicon glyphicon-envelope" aria-hidden="true"></span> ${autUser.mail}</div>
		<div style="margin-top:10px;">Hire Date: ${autUser.hire_date}</div>
	</div>
	<div class="col-sm-9">
		<ul class="nav nav-tabs" style="">
		  <li role="presentation" class="active"><a id="tab-personal-info" href="#">Personal Info</a></li>
		  <li role="presentation"><a id="tab-job-info" href="#">Job Info</a></li>
		</ul>
	</div>
</div>
<div class="row" style="margin-top:20px;">
	<div class="col-sm-3"></div>
	<div class="col-sm-9">
		<div id="content-personal-info">
			<div class="panel panel-default">
				<div class="panel-heading">Basic Info</div>
				<ul class="list-group">
					<li class="list-group-item">Name: ${autUser.name}</li>
					<li class="list-group-item">Surname: ${autUser.surname}</li>
					<li class="list-group-item">Born: ${autUser.birth_date}</li>
				</ul>
			</div>
			<div class="panel panel-default">
				<div class="panel-heading">Contact Info</div>
				<ul class="list-group">
					<li class="list-group-item">Phone: ${autUser.phone}</li>
					<li class="list-group-item">E-mail: ${autUser.mail}</li>
					<li class="list-group-item">Address: ${autUser.address}</li>
				</ul>
			</div>
		</div>
		<div id="content-job-info" style="display:none;">
			<div class="panel panel-default">
				<div class="panel-heading">Basic Info</div>
				<ul class="list-group">
					<li class="list-group-item">Hire Date: ${autUser.hire_date}</li>
					<li class="list-group-item">Position: ${jobTitles[0]}</li>
				</ul>
			</div>
			<div class="panel panel-default">
				<div class="panel-heading">Job History</div>
				<table class="table">
					<col width="80%">
		  			<col width="10%">
		  			<col width="10%">
					<tr>
						<th>Position</th>
						<th>Salary</th>
						<th>Start</th>
					</tr>
					<c:forEach var="userJobPosition" items="${userJobPositions}" varStatus="status">
						<tr>
							<td>${jobTitles[status.index]}</td>
							<td>${salaries[status.index]}</td>
							<td>${userJobPosition.date}</td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</div>
	</div>
</div>
</div>

<script type="text/javascript">
$('#tab-personal-info').click(function() {
	$('#content-personal-info').css('display', 'block');
	$('#content-job-info').css('display', 'none');
	$(this).parent().addClass('active');
	$('#tab-job-info').parent().removeClass('active');
});
$('#tab-job-info').click(function() {
	$('#content-job-info').css('display', 'block');
	$('#content-personal-info').css('display', 'none');
	$(this).parent().addClass('active');
	$('#tab-personal-info').parent().removeClass('active');
});
</script>

</body>
</html>