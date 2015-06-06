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
<link rel="stylesheet" href="theme.css">

<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>

<link rel="stylesheet" href="global.css">

<style>
body {
	padding-top:0px;
}
</style>
</head>
<body>

<nav class="navbar navbar-default navbar-fixed-top bar-logo" role="navigation">
   <div class="navbar-header">
      <a class="navbar-brand" href="./login.html"><span class="glyphicon glyphicon-tree-deciduous" aria-hidden="true"></span> PhinkeyHR</a>
   </div>
</nav>
<div class="jumbotron" style="height:100%; width:100%;">
  <div class="container">
    <div class="row">
    	<div class="col-sm-6">
    		<div class="page-header">
			  <h1>The leading HRM system. <small>Used by over 16% of medium-sized businesses in the United States.</small></h1>
			</div>
			<div class="well" style="width:80%;">I've tired tons of different human resources management systems. I assure you that this is the best one out there! - Mark</div>
			<div class="well" style="width:80%">I am so dependant on the PhinkeyHR that I have the feeling that my business would fail without it... - Jenny</div>
    	</div>
		<div class="col-sm-6" style="height:100%;">
			<div class="panel panel-default bubble" style="width:400px">
			  <div class="panel-heading">
			    <h3 class="panel-title">Apply for a job</h3>
			  </div>
			  <div class="panel-body">
			  <form action="registerUser" method="post" enctype="multipart/form-data">
			  	<div style="margin-bottom:20px;">Please provide the required information.</div>
			  	<div class="input-group" style="margin-top:10px;">
				  <span class="input-group-addon"><span class="glyphicon glyphicon-user"></span></span>
				  <input name="name" type="text" class="form-control" placeholder="Name">
				</div>
				<div class="input-group" style="margin-top:10px;">
				  <span class="input-group-addon"><span class="glyphicon glyphicon-user"></span></span>
				  <input name="surname" type="text" class="form-control" placeholder="Surename">
				</div>
				<div class="input-group" style="margin-top:10px;">
				  <span class="input-group-addon"><span class="glyphicon glyphicon-calendar"></span></span>
				  <input name="birthdate" type="date" class="form-control" placeholder="Date of birth">
				</div>
				<div class="input-group" style="margin-top:10px;">
				  <span class="input-group-addon"><span class="glyphicon glyphicon-earphone"></span></span>
				  <input name="phone" type="text" class="form-control" placeholder="Phone">
				</div>
				<div class="input-group" style="margin-top:10px;">
				  <span class="input-group-addon"><span class="glyphicon glyphicon-home"></span></span>
				  <input name="address" type="text" class="form-control" placeholder="Address">
				</div>
			    <div class="input-group" style="margin-top:30px;">
				  <span class="input-group-addon"><span class="glyphicon glyphicon-envelope"></span></span>
				  <input name="mail" type="text" class="form-control" placeholder="E-mail">
				</div>
				<div class="input-group" style="margin-top:10px;">
				  <span class="input-group-addon"><span class="glyphicon glyphicon-lock"></span></span>
				  <input name="password" type="text" class="form-control" placeholder="Password">
				</div>
				<div class="input-group" style="margin-top:10px;">
				  <span class="input-group-addon"><span class="glyphicon glyphicon-picture"></span></span>
				  <input name="picture" type="file" class="form-control" placeholder="Picture">
				</div>
				<div class="input-group" style="margin-top:10px;">
				  <span class="input-group-addon"><span class="glyphicon glyphicon-list-alt"></span></span>
				  <input name="cv" type="file" class="form-control" placeholder="CV">
				</div>
				<div style="margin-top:20px; text-align:right;">
					<button id="register" type="submit" class="btn btn-default" style="width:125px;">Register</button>
				</div>
			  </form>
			  </div>
			</div>
		</div>
	</div>
  </div>
</div>

<script type="text/javascript">
document.body.style.overflow = 'hidden';

// $('#register').click(function() { 
// 	window.location.href = "./details.html";
// })
</script>
</body>
</html>