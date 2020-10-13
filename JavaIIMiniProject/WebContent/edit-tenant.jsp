<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit a tenant</title>
</head>
<body>
<form action = "editTenantServlet" method="post">
<input type ="hidden" name = "id" value= "${TenantToEdit.id}">
Name: <input type ="text" name = "name" value="${TenantToEdit.tenantName}">
Date of Birth: <input type ="text" name = "month" placeholder="mm" size="4" value= "${month}"> <input type ="text" name = "day"
placeholder="dd" size="4" value= "${date}">, <input type ="text" name= "year" placeholder="yyyy" size="4" value= "${year}">
Phone number: <input type = "text" name = "phone" value="${TenantToEdit.phone}"><br />
<input type = "submit" value="Save Edited Item">
</form>
</body>
</html>
