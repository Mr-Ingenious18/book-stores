<%@page import="com.js.dto.Books"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Your Book Store</title>
</head>
<body>
<h1>Enter details to update</h1>
<% Books b = (Books)request.getAttribute("book"); %>
    <form action="update2">
		Book ID: <input type="text" name="id" value="<%=b.getId()%>" readonly="readonly" ><br><br> 
		Book Name: <input type="text" name="bookname" value="<%=b.getName()%>"><br><br> 
		Book Price: <input type="text" name="price" value="<%=b.getPrice() %>"><br><br> 
		Book Author: <input type="text" name="author" value="<%=b.getAuthor()%>"><br><br> 
		<input type="submit" name="Update">
	</form>
</body>
</html>