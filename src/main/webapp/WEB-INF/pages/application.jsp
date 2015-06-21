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
         <li><a href="./news">News Feed</a></li>
         <li><a href="./details">My Info</a></li>
         <li><a href="./list">Employees</a></li>
         <c:if test="${manager == true}">
	         <li class="active"><a href="./applications">Applications</a></li>
        	 <li><a href="./reports.html">Reports</a></li>
         </c:if>
         <li><a href="./logout">Logout</a></li>
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
	<div class="col-sm-5">	
		<h1>${autUser.name} ${autUser.surname}</h1>
	</div>
	<div class="col-sm-4" style="margin-top:10px; text-align:right;">
		<button id="hire" type="button" class="btn btn-default btn-lg" style="width:40%"><span class="glyphicon glyphicon-ok"></span> Hire</button>
		<button id="decline" type="button" class="btn btn-default btn-lg" style="width:30%">Decline</button>
	</div>
</div>
<div class="row" style="margin-top:20px;">
	<div class="col-sm-3" style="text-align:center;">
		<div><span class="glyphicon glyphicon-earphone" aria-hidden="true"></span> ${autUser.phone}</div>
		<div><span class="glyphicon glyphicon-envelope" aria-hidden="true"></span> ${autUser.mail}</div>
		<div style="margin-top:10px;"><a href="/cv/${autUser.cv}">Get CV</a></div>
	</div>
	<div class="col-sm-9">
		<ul class="nav nav-tabs" style="">
		  <li role="presentation" class="active"><a id="tab-personal-info" href="#">Personal Info</a></li>
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
					<li class="list-group-item">Name: <span class="conv" en="true" at="name">${autUser.name}</span></li>
					<li class="list-group-item">Surname: <span class="conv" en="true" at="surname">${autUser.surname}</span></li>
					<li class="list-group-item">Born: <span class="conv" en="true" at="birthdate">${autUser.birth_date}</span></li>
				</ul>
			</div>
			<div class="panel panel-default">
				<div class="panel-heading">Contact Info</div>
				<ul class="list-group">
					<li class="list-group-item">Phone: <span class="conv" en="true" at="phone">${autUser.phone}</span></li>
					<li class="list-group-item">E-mail: <span class="conv" en="true" at="mail">${autUser.mail}</span></li>
					<li class="list-group-item">Address: <span class="conv" en="true" at="address">${autUser.address}</span></li>
				</ul>
			</div>
		</div>
	</div>
</div>
</div>

<script type="text/javascript">
	$('#hire').click(function() {
		obj = {};
		obj['id'] = ${autUser.user_id};
		obj['value'] = "true";
		$.post('./hire', obj, 
			    function(){
				window.location.href = "./applications";
			});
	});
	$('#decline').click(function() {
		obj = {};
		obj['id'] = ${autUser.user_id};
		obj['value'] = "false";
		$.post('./hire', obj, 
			    function(){
				window.location.href = "./applications";
			});
	});
</script>
</body>
</html>