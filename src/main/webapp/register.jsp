<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Your Book Store</title>
</head>
<body>
		<h1>Enter the Book details</h1>
		<form action="insert">
		Book ID: <input type="text" name="id"><br><br> 
		Book Name: <input type="text" name="bookname"><br><br> 
		Book Price: <input type="text" name="price"><br><br> 
		Book Author: <input type="text" name="author"><br><br> 
		<input type="submit" name="Save">
	</form>
</body>
</html>