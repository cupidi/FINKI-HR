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

	<h1>Detail View</h1>

	<table border="0px" cellpadding="0" cellspacing="0">

		<tbody>

			<tr>
				<td width="200px"><figure>
						<img width="150" height="150"
							src="<c:url value="/images/${autUser.picture}"/>" />
					</figure></td>
				<td>${autUser.name}&nbsp;&nbsp;&nbsp;${autUser.surname}</td>
			</tr>


			<tr>
				<td>
					<p name="phone1">${autUser.phone}</p>
					<p name="email1">${autUser.mail}</p> </br> Hire Date:
					<p name="phone1">${autUser.hire_date}</p>
				</td>

				<td>
					<h3>Personal Info</h3>
				</td>
			</tr>


			<tr>
				<td></td>
<h5>Basic information</h5>
				
					<form action="edit" method="post">
					 Name <input type="text" name="name"
					value="${autUser.name}" /> </br> Surname <input type="text"
					name="surname" value="${autUser.surname}" /></br> Born <input
					type="date" name="birthdate" value="${autUser.birth_date}" /></br> SSN
					<input type="text" name="ssn" value="${autUser.ssn}" /></br> Gender <input
					type="text" name="gender" value="${autUser.gender}" /></br> </br> </br>
				
			
					<h5>Contact</h5> Phone <input type="text" name="phone"
					value="${autUser.phone}" /> </br> Email <input type="text" name="mail"
					value="${autUser.mail}" /> </br> Address <input type="text"
					name="address" value="${autUser.address}" />
					
					<input type="submit" value="Edit" />
					</form>
				
			</tr>
		</tbody>
	</table>

	</br>
	</br>
	</br>
	</br>
	</br>

	<table border="0px" cellpadding="0" cellspacing="0">

		<tbody>
			<tr>
				<td width="230px"></td>
				<td><h3>Job Info</h3></td>
			</tr>
			<tr>
				<td></td>
				<td><h5>Basic Info</h5> Hire Date: ${autUser.hire_date} </br>
					Position: ${jobTitles[0]} </br>
				</br>
				</br></td>
			</tr>
			<tr>
				<td></td>
				<td>
					<h5>Job History</h5>


					<table border="0px" cellpadding="0" cellspacing="0">
						<thead>
							<tr>

								<th width="15%">Position</th>
								<th width="10%">Salary</th>
								<th width="15%">Start</th>



							</tr>
						</thead>
						<tbody>
							<c:forEach var="userJobPosition" items="${userJobPositions}"
								varStatus="status">
								<tr>

									<td>${jobTitles[status.index]} </br>
									</td>
									<td>${salaries[status.index]}</td>
									<td>${userJobPosition.date}</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</td>
			</tr>
		</tbody>
	</table>



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