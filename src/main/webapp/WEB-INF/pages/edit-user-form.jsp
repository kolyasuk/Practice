<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Edit user page</h1>
<p>Here you can edit the existing user.</p>
<p>${message}</p>
<form:form method="POST" commandName="user" action="${pageContext.request.contextPath}/user/edit/${user.id}.html">
<table>
<tbody>
    <tr>
        <td>First Name:</td>
        <td><form:input path="firstName" /></td>
    </tr>
        <tr>
        <td>Last Name:</td>
        <td><form:input path="lastName" /></td>
    </tr>
    <tr>
        <td>Role:</td>
        <td><form:input path="role" /></td>
    </tr>
    <tr>
        <td><input type="submit" value="Edit" /></td>
        <td></td>
    </tr>
</tbody>
</table>
</form:form>
 
<p><a href="${pageContext.request.contextPath}/index.html">Home page</a></p>
</body>
</html>