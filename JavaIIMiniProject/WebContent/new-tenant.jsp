<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Create New Tenant</title>
</head>
<body>
	<h1>Add new tenant</h1>
	<form action="addTenantServlet" method="post">
		<label for="name">Name: </label>
		<input type="text" id="name" name="name" required><br>
		
		<label for="month">Date of Birth:</label>
		<input type="text" id="name" name="month" placeholder="mm" size="4">
		<input type="text" name="day" placeholder="dd" size="4">, 
		<input type="text" name="year" placeholder="yyyy" size="4"><br>
		
		<label for="phone">Phone: </label>
		<input type="text" id="phone" name="text" placeholder="555-555-5555"><br>
		
		<input type="submit" value="Create Tenant">
	</form>
</body>
</html>