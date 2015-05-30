<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>


<html>
<head>
<!-- JQuery -->
<script src="https://code.jquery.com/jquery-1.11.3.min.js"></script>
<script src="https://code.jquery.com/jquery-migrate-1.2.1.min.js"></script>

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">

<!-- Optional theme -->
<!-- <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap-theme.min.css"> -->
<link rel="stylesheet" href="./css/theme.css">

<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>

<link rel="stylesheet" href="./css/global.css">

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
		<div class="col-sm-12" style="height:100%; width:100%;">
			<div class="panel panel-default bubble" style="width:400px; height:260px;">
			  <div class="panel-heading">
			    <h3 class="panel-title">Welcome!</h3>
			  </div>
			  <div class="panel-body">
			  <form action="checkEmployees" method="post">
			  	<div style="margin-bottom:20px;">Please enter your credentials to start.</div>
			    <div class="input-group">
				  <span class="input-group-addon"><span class="glyphicon glyphicon-envelope"></span></span>
				  <input type="text" class="form-control" placeholder="E-mail" name="email" id="email">
				</div>
				<div class="input-group" style="margin-top:10px;">
				  <span class="input-group-addon"><span class="glyphicon glyphicon-lock"></span></span>
				  <input type="password" class="form-control" placeholder="Password" name="password" id="password">
				</div>
				<div style="margin-top:20px;">
					<a href="./register.html" style="">Apply for a job</a>
					<button id="login" type="submit" class="btn btn-default" style="width:125px; margin-left:144px;">Log In</button>
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
</script>
</body>
</html>