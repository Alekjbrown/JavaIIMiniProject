<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>New Lease</title>
</head>
<body>
	<form action="createNewLeaseServlet" method="post">
		Tenant Name: <input type="text" name="name"><br>
		Date of Birth:  
		<input type="text" name="month" placeholder="mm" size="4">
		<input type="text" name="day" placeholder="dd" size="4">, 
		<input type="text" name="year" placeholder="yyyy" size="4"><br>
		Phone: <input type="text" name="phone"><br>
		Available Units: <br>
		<select name="unitToAdd" size="6">
			<c:forEach items="${requestScope.allUnits}" var="currentunit">
				<option value="${currentunit.id}">${currentunit.beds} bed | ${currentunit.baths} | ${currentunit.floor} | ${currentitem.address}</option>
			</c:forEach> 
		</select>
		<br>
		Term in Months: <input type="number" name="term" required size="4"><br>
		<input type="submit" value="Create Lease and Add Unit">
	</form><br>
	<form action="index.html">
		<input type="submit" value="Home">
	</form>
</body>
</html>