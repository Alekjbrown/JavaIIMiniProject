<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List of Units</title>
</head>
<body>
	<form method="post" action="unitNavigationServlet">
		<table>
		<tr>
			<td></td>
			<td>Address</td>
			<td>Floor</td>
			<td>Beds</td>
			<td>baths</td>
		</tr>
			<c:forEach items="${requestScope.allUnits }" var="currentunit">
				<tr>
					<td><input type="radio" name="id" value="${currentunit.id}"></td>
					<td>${currentunit.address}</td>
					<td>${currentUnit.floor}
					<td>${currentunit.beds}</td>
					<td>${currentunit.baths}</td>
				</tr>
			</c:forEach>
		</table>
		<input type="submit" value="edit" name="doThisToUnit">
		<input type="submit" value="delete" name="doThisToUnit"> 
		<input type="submit" value="add" name="doThisToUnit">
	</form>
	<br>
	<button onclick="window.location.href='index.html'">Home</button>
</body>
</html>