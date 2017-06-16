<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<?xml version="1.0" encoding="ISO-8859-1" ?>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Edit user page</title>
</head>
<body>
<h1>Edit user page</h1>
<p>Here you can edit the existing user.</p>
<p>${message}</p>
<form:form method="POST" commandName="user" action="${pageContext.request.contextPath}/user/edit/${user.id}.html">
<table>
<tbody>
	<tr>
		<td>Login:</td>
		<td><form:input path="login" /></td>
		<td><form:errors path="login" class="error-message" /></td>
	</tr>
		<tr>
		<td>Name:</td>
		<td><form:input path="name" /></td>
		<td><form:errors path="name" class="error-message" /></td>
	</tr>
		<tr>
		<td>Password:</td>
		<td><form:input path="password" /></td>
		<td><form:errors path="password" class="error-message" /></td>
	</tr>
		<tr>
		<td>Email:</td>
		<td><form:input path="email" /></td>
		<td><form:errors path="email" class="error-message" /></td>
	</tr>
	<tr>
		<td>Role:</td>
		<td><form:input path="role" /></td>
	</tr>
</tbody>
</table>
</form:form>

<p><a href="${pageContext.request.contextPath}/index.html">Home page</a></p>
</body>
</html>