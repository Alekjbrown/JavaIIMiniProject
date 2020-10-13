<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit a unit</title>
</head>
<body>
<form action = "editUnitServlet" method="post">
<input type ="hidden" name = "id" value= "${UnitToEdit.id}">
Beds: <input type ="text" name = "beds" value="${UnitToEdit.beds}">
Baths: <input type ="text" name = "baths" value="${UnitToEdit.baths}">
Floor: <input type = "text" name = "floor" value="${UnitToEdit.floor}">
Address: <input type ="text" name = "address" value="${UnitToEdit.address}"><br />
<input type = "submit" value="Save Edited Item">
</form>
</body>
</html>