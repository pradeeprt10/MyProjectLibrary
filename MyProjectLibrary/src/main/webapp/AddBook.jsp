<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta  http-equiv="Content-type" content="text/html; charset=US-ASCII">
<title>Add Book</title>
</head>
<body>
<br>
<h1>Add Book Screen</h1>
<br>
<form action="AddBookServlet" method="get">
&nbsp; &nbsp;Book Id &nbsp; &nbsp;<input type="text" placeholder="Bookid" name="Bookid" required><br><br>
&nbsp; &nbsp;Titel &nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="Text" placeholder="Titel" name="Titel" ><br><br>
&nbsp; &nbsp;Author &nbsp; &nbsp;&nbsp;&nbsp;<input type="text" placeholder="Author" name="Author" ><br><br>
&nbsp; &nbsp;Price &nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" placeholder="Price" name="Price" ><br><br>
&nbsp; &nbsp;Page &nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" placeholder="Page" name="Page" ><br><br>
&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;<button type="submit">Add</button>
</form>
</body>
</html>