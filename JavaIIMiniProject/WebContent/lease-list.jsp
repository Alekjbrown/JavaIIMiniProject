<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List of Leases</title>
</head>
<body>
	<form method="post" action="leaseNavigationServlet">
		<table>
			<c:forEach items="${requestScope.allLeases}" var="currentlease">
				<tr>
					<td><input type="radio" name="id" value="${currentlease.id}"></td>
					<td><h2>${currentlease.tenant.tenantName}</h2></td>
				</tr>
				<tr>
					<td colspan="3">DOB: ${currentlease.tenant.dob}</td>
				</tr>
				<tr>
					<td colspan="3">Phone: ${currentlease.tenant.phone}</td>
				</tr>
				<tr>
					<td colspan="3">Unit: ${currentlease.unit.address}</td>
				</tr>
				<tr>
					<td colspan="3">Floor: ${currentlease.unit.floor}</td>
				</tr>
				<tr>
					<td colspan="3">Beds: ${currentlease.unit.beds}</td>
				</tr>
				<tr>
					<td colspan="3">Baths: ${currentlease.unit.baths}</td>
				</tr>
			</c:forEach>
		</table>
		<input type="submit" value="edit" name="doThisToLease">
		<input type="submit" value="delete" name="doThisToLease">
		<input type="submit" value="add" name="doThisToLease">
	</form>
	<br>
	<button onclick="window.location.href='index.html'">Home</button>
</body>
</html>