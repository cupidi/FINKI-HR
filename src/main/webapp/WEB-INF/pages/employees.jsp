<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<?xml version="1.0" encoding="UTF-8" ?>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Insert title here</title>
</head>
<body>

	


	<!-- Employees                   -->
	
	<h1>List of Employees</h1>
	<p>Employees (${numEmployees})</p>
	<table border="1px" cellpadding="0" cellspacing="0">
		<thead>
			<tr>

				<th width="15%">Picture</th>
				<th width="10%">Name Surname</th>
				<th width="15%">Job title</th>
				<th width="10%">Hire datee</th>


			</tr>
		</thead>
		<tbody>
			<c:forEach var="employee" items="${employees}" varStatus="status">
				<tr>

					<td><figure>
							<img width="100" height="100"
								src="<c:url value="/images/${employee.picture}"/>" />
						</figure></td>
					<td>${employee.name}&nbsp;&nbsp;&nbsp;${employee.surname}</td>
					<td>${job[status.index][0]}</td>
					<td>${employee.hire_date}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>




	<!-- News feed                    -->
	
	<h1>News Feed</h1>
<form action="addAnnouncement" >
<input type="submit" value="Add Announcement" />
</form>
	<table border="0px" cellpadding="0" cellspacing="0">

		<tbody>
			<c:forEach var="announcement" items="${announcements}"
				varStatus="status">
				<tr>

					<td></br> Title: ${announcement.announcement_title} </br>
					</br> ${announcement.announcement}
						<h6>posted by:${userNames[status.index]}
							${announcement.datum}</h6></td>

				</tr>
			</c:forEach>
		</tbody>
	</table>



</body>
</html>