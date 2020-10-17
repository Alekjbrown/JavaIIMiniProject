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

<!-- Unit Address: <input type ="text" name = "unit" value="${LeaseToEdit.unit.address}">
Tenant Name: <input type ="text" name = "tenant" value="${LeaseToEdit.tenant.tenantName}">
Term: <input type ="text" name = "term" value="${LeaseToEdit.term}">
End Date:<input type ="text" name = "month" placeholder="mm" size="4" value= "${month}"> <input type ="text" name = "day"
placeholder="dd" size="4" value= "${date}">, <input type ="text" name= "year" placeholder="yyyy" size="4" value= "${year}">
<input type = "submit" value="Save Edited Item">

	<form action="createNewLeaseServlet" method="post"> -->
		Tenant Name: <input type="text" name="name" value="${LeaseToEdit.tenant.tenantName}"><br>
		Date of Birth:  
		<input type="text" name="month" placeholder="mm" size="4" value="${month}">
		<input type="text" name="day" placeholder="dd" size="4" value="${date}">, 
		<input type="text" name="year" placeholder="yyyy" size="4" value="${year}"><br>
		Phone: <input type="text" name="phone" value="${LeaseToEdit.tenant.phone}"><br>
		Available Units: <br>
		Current Unit Address: <input type="text" name="unit" value="${LeaseToEdit.unit.address}" readonly="readonly"><br>
		<select name="unitToAdd" size="6" required>
			<c:forEach items="${requestScope.allUnits}" var="currentunit">
				<option value="${currentunit.id}">${currentunit.beds} bed | ${currentunit.baths} | ${currentunit.floor} | ${currentitem.address}</option>
			</c:forEach> 
		</select>
		<br>
		Term in Months: <input type="number" name="term" required size="4" value="${LeaseToEdit.term}"><br>
		<input type="submit" value="Save Edited Item">
	</form><br>
	<form action="index.html">
		<input type="submit" value="Home">
	</form>
</form>
</body>
</html>