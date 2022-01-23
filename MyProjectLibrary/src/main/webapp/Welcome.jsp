<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<% String  content = (String)request.getAttribute("table");
 %>
 
<!DOCTYPE html>
<html>
<head>
<meta  http-equiv="Content-type" content="text/html; charset=US-ASCII">
<title>Welcome To My Library</title>
</head>
<body style="background-color:white;">

<h1>Welcome To My Library</h1> 

 <font color= 'red'>
   
<%= content%>
<a href= AddBook.jsp?operation=add> Add a Book </a>
</font>
</body>
</html>