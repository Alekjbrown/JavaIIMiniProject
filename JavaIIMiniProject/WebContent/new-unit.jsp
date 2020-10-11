<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="C" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add New Unit</title>
</head>
<body>
	<h1>Add New Unit</h1>
	<form action="addUnitServlet" method="post">
		<label for="beds">Beds: </label>
		<input type="number" id="beds" name="beds" size="4" required><br>
		<label for="baths">Baths: </label>
		<input type="number" id="baths" name="baths" size="4" required><br>
		<label for="floor">Floor: </label>
		<input type="number" id="floor" name="floor" size="4" required><br>
		<label for="address">Address: </label>
		<input type="text" id="address" name="address" required placeholder="123 abc st, UNIT, City, ST, Zip"><br>
		<input type="submit" name="Add New Unit">
	</form>
	<br>
	<form action="index.html">
		<input type="submit" value="Home">
	</form>
</body>
</html>