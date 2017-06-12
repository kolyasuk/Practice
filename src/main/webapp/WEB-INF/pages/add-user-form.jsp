<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Add user page</h1>
<p>Here you can add a new user.</p>
<form:form method="POST" commandName="user" action="${pageContext.request.contextPath}/user/add/process.html">
<table>
<tbody>
    <tr>
        <td>Name:</td>
        <td><form:input path="firstName" /></td>
    </tr>
        <tr>
        <td>Name:</td>
        <td><form:input path="lastName" /></td>
    </tr>
    <tr>
        <td>Role:</td>
        <td><form:input path="role" /></td>
    </tr>
    <tr>
        <td><input type="submit" value="Add" /></td>
        <td></td>
    </tr>
</tbody>
</table>
</form:form>
 
<p><a href="${pageContext.request.contextPath}/index.html">Home page</a></p>
</body>
</html>