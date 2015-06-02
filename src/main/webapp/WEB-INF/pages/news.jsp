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
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">

	<!-- Optional theme -->
	<!-- <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap-theme.min.css"> -->
<link rel="stylesheet" href="./css/theme.css">

	<!-- Latest compiled and minified JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>

<link rel="stylesheet" href="./css/global.css">
<style>
textarea {
	resize: none;
}
</style>
</head>
<body>

	<nav class="navbar navbar-default navbar-fixed-top bar-logo"
		role="navigation">
		<div class="navbar-header">
			<a class="navbar-brand" href="./news.html"><span
				class="glyphicon glyphicon-tree-deciduous" aria-hidden="true"></span>
				PhinkeyHR</a>
		</div>
	</nav>
	<nav class="navbar navbar-default navbar-fixed-top bar-nav"
		role="navigation">
		<div>
			<ul class="nav navbar-nav">
				<li class="active"><a href="./news.html">News Feed</a></li>
				<li><a href="./details">My Info</a></li>
				<li><a href="./list">Employees</a></li>
				<li><a href="./applications.html">Applications</a></li>
				<li><a href="./reports.html">Reports</a></li>
			</ul>
		</div>
	</nav>

	<div class="container">
		<c:if test="${autUser.type == 'admin'}">
			<div class="row">
				<div class="col-sm-12"
					style="text-align: right; margin-bottom: 20px;">
					<button type="button" class="btn btn-default" data-toggle="modal"
						data-target="#modal-add">+ Add an Announcement</button>
				</div>
			</div>
		</c:if>
		<div class="row">
			<div class="col-sm-12">
				<c:forEach var="announcement" items="${announcements}"
					varStatus="status">
					<div class="panel panel-default">
						<div class="panel-heading">
							<h3 class="panel-title">${announcement.announcement_title}</h3>
						</div>
						<div class="panel-body">${announcement.announcement}</div>
					</div>
				</c:forEach>

			</div>
		</div>
	</div>

	<div class="modal fade" id="modal-add" role="dialog">
		<div class="modal-dialog">
			<div class="modal-content">
				<form action="addedAnnouncement" method="post">
					<div class="modal-body">
						<div class="input-group">
							<span class="input-group-addon">Title</span> 
							<input type="text" name="title" class="form-control" placeholder="Announcement Title">
						</div>
						<div style="margin-top: 10px;">
							<textarea class="form-control" name="announcement" rows="15"
								placeholder="Announcement Content"></textarea>
						</div>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
						<button type="submit" value="Add" class="btn btn-default">Add</button>
					</div>
				</form>
			</div>
		</div>
	</div>

</body>
</html>