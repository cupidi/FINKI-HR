<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<?xml version="1.0" encoding="UTF-8" ?>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false" %>
    
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
		<title>Home page</title>
	</head>
	<body>
		<h1>List of Students</h1>
		<p>Here you can see the list of the students, edit them, remove or update.</p>
		<table border="1px" cellpadding="0" cellspacing="0" >
			<thead>
				<tr>
					
					<th width="15%">name</th>
					<th width="10%">last name</th>
					
				</tr>
			</thead>
			<tbody>
				<c:forEach var="user" items="${allUsers}">
					<tr>
						
						<td>${user.name}</td>
						<td>${user.surname}</td>
						
					</tr>
				</c:forEach>
			</tbody>
		</table>
		
		
	</body>
</html>