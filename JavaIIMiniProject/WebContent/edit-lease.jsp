<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit a lease</title>
</head>
<body>
<form action = "editLeaseServlet" method="post">
<input type ="hidden" name = "id" value= "${LeaseToEdit.id}">
Unit Address: <input type ="text" name = "unit" value="${LeaseToEdit.unit}">
Tenant Name: <input type ="text" name = "tenant" value="${LeaseToEdit.tenant}">
Term: <input type ="text" name = "term" value="${LeaseToEdit.term}">
End Date:<input type ="text" name = "month" placeholder="mm" size="4" value= "${month}"> <input type ="text" name = "day"
placeholder="dd" size="4" value= "${date}">, <input type ="text" name= "year" placeholder="yyyy" size="4" value= "${year}">
<input type = "submit" value="Save Edited Item">
</form>
</body>
</html>