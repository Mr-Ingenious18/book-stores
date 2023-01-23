<%@page import="com.js.dto.Books"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Your Book Store</title>
</head>
<body>
<h1>List of Books</h1>
<table border="2px solid black">
<tr>
<th>Book ID</th>
<th>Book Name</th>
<th>Price</th>
<th>Author Name</th>
<th>Delete</th>
<th>Update</th>
</tr>

<% ArrayList<Books> book = (ArrayList)request.getAttribute("data"); 
for(Books b: book){
%>
<tr>
<td><%=b.getId()%></td>
<td><%=b.getName()%></td>
<td><%=b.getPrice() %></td>
<td><%=b.getAuthor() %></td>
<td><a href="delete?id=<%=b.getId()%>">Delete</a></td>
<td><a href="update1?id=<%=b.getId()%>">Edit</a></td>
</tr>
<%} %>

</table>
<a href="welcome.html">Home</a>
</body>
</html>