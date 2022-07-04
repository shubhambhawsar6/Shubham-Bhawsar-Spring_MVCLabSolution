<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home page</title>
</head>
<body>

    <h2 align="center"> Registration Table </h2>
	<table align="center">
		<tr>
			<td><a href="addStudent?id=-1"><input type="button" value="Register New Student"/></a></td>
			
		</tr>
	</table>
	<form action="search" method="post"> 
	<table align="center" weight="70%" height="70%">
	<tr> 
	<td><input type="text" name="firstName" placeholder="Search By firstName" /></td></tr>
	<tr>
	
	 <td colspan="2"><input type="submit" value="search">  </td>
	
	</table> 
	</form>
	
	<h2 align="center"> Display Table </h2>
	
	
	
	<table border="1" align="center" bgcolor="lightblue"  weight="70%" height="70%">
		<thead>
			<tr>
				<th>id</th>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Country</th>
				<th>Department</th>
				<th>Action</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${student}" var="student">
				<tr>
					<td>${student.id}</td>
					<td>${student.firstName}</td>
					<td>${student.lastName}</td>
					<td>${student.country}</td>
					<td>${student.department}</td>
					<td><a href="addStudent?id=${student.id}">Update</a> 
					<a href="deleteStudent?id=${student.id}">/ Delete</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>
