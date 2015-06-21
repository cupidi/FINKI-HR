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
         <li <c:if test="${autUser.user_id == logedUser.user_id}"> class="active" </c:if>><a href="./details">My Info</a></li>
         <li <c:if test="${autUser.user_id != logedUser.user_id}"> class="active" </c:if>><a href="./list">Employees</a></li>
         <c:if test="${manager == true}">
	         <li><a href="./applications">Applications</a></li>
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
		<div id="content-job-info" style="display:none;">
			<div class="panel panel-default">
				<div class="panel-heading">Basic Info</div>
				<ul class="list-group">
					<li class="list-group-item">Hire Date: ${autUser.hire_date}</li>
					<li class="list-group-item">Current Position: ${userJobPositions[0].position_name}</li>
				</ul>
			</div>
			<c:if test="${autUser.user_id == logedUser.user_id || manager == true}">
				<div class="panel panel-default">
					<div class="panel-heading">Job History</div>
					<table class="table">
						<col width="60%">
			  			<col width="20%">
			  			<col width="20%">
						<tr>
							<th>Position</th>
							<th>Salary</th>
							<th>Start</th>
						</tr>
						<c:forEach var="userJobPosition" items="${userJobPositions}" varStatus="status">
							<tr>
								<td style="text-align:center">${userJobPosition.position_name}</td>
								<td style="text-align:center">${userJobPosition.salary}</td>
								<td style="text-align:center">${userJobPosition.starting_date}</td>
							</tr>
						</c:forEach>
					</table>
					<c:if test="${manager == true}">
						<div class="update-button-div"><button type="button" class="btn btn-default" data-toggle="modal" data-target="#modal-update"><span class="glyphicon glyphicon-briefcase"></span> Update Job</button></div>
					</c:if>
				</div>
			</c:if>
		</div>
	</div>
</div>
</div>

<div class="modal fade" id="modal-update" role="dialog">
  <div class="modal-dialog">
    <div class="modal-content">
    <form action="addJob" method="post">
      <div class="modal-body">
      	<input type="hidden" name="id" value="${autUser.user_id}">
      	<div class="input-group">
		  <span class="input-group-addon">Position</span>
		  <input name="position" type="text" class="form-control" placeholder="Position Title">
		</div>
		<div class="input-group" style="margin-top:10px">
		  <span class="input-group-addon">Salary</span>
		  <input name="salary" type="text" class="form-control" placeholder="Salary in dollars">
		</div>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
        <button type="submit" value="Add" class="btn btn-default">Update</button>
      </div>
      </form>
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
<c:if test="${autUser.user_id == logedUser.user_id || manager == true}">
	<script type="text/javascript">
		$('.conv').click(function() {
		
			if ($(this).attr("en") === "false")
				return;
			
			var val = $(this).html();
			$(this).html('<input type="text" value="'+val+'" />');
			var $newE = $(this).find('input');
			$newE.focus();
			$(this).attr("en", "false");
			
			$newE.on('blur', function() {
				at = $(this).parent().attr("at");
				val = $(this).val();
				obj = {};
				obj['id'] = ${autUser.user_id};
				obj[at] = val;
				$.post('./edit', obj, 
					    function(){
						location.reload();
					});
				$(this).parent().attr("en", "true");
				$(this).parent().html($(this).val());
				
			});
		});
	</script>
</c:if>
</body>
</html>