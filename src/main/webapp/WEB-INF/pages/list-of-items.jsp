<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<?xml version="1.0" encoding="ISO-8859-1" ?>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>List of items</title>
</head>
<body>
<h1>List of items</h1>
<p>Here you can see the list of the items, edit them, remove or update.</p>
<table border="1px" cellpadding="0" cellspacing="0" >
<thead>
<tr>
<th width="10%">item_id</th><th width="10%">name</th><th width="10%">photo</th><th width="10%">description</th><th width="10%">price</th>
</tr>
</thead>
<tbody>
<c:forEach var="item" items="${items}">
<tr>
	<td>${item.item_id}</td>
	<td>${item.name}</td>
	<td>${item.photo}</td>
	<td>${item.description}</td>
	<td>${item.price}</td>
	<td>
	<a href="${pageContext.request.contextPath}/item/edit/${item.item_id}.html">Edit</a><br/>
	<a href="${pageContext.request.contextPath}/item/delete/${item.item_id}.html">Delete</a><br/>
	</td>
</tr>
</c:forEach>
</tbody>
</table>

<p><a href="${pageContext.request.contextPath}/index.html">Home page</a></p>

</body>
</html>