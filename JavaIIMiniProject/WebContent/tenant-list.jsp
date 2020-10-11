<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List of Tenants</title>
</head>
<body>
	<form method="post" action="tenantNavigationServlet">
		<table>
		<tr>
			<td></td>
			<td>Name</td>
			<td>DOB</td>
			<td>Phone</td>
		</tr>
			<c:forEach items="${requestScope.allTenants }" var="currenttenant">
				<tr>
					<td><input type="radio" name="id" value="${currenttenant.id}"></td>
					<td>${currenttenant.tenantName}</td>
					<td>${currenttenant.dob}
					<td>${currenttenant.phone}</td>
				</tr>
			</c:forEach>
		</table>
		<input type="submit" value="edit" name="doThisToTenant">
		<input type="submit" value="delete" name="doThisToTenant"> 
		<input type="submit" value="add" name="doThisToTenant">
	</form>
	<br>
	<button onclick="window.location.href='index.html'">Home</button>
</body>
</html>