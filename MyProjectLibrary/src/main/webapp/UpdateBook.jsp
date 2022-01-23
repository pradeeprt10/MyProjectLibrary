<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@ page import="java.util.*" %>
 <%@ page import = "java.lang.*" %>
 <%@ page isELIgnored="false" %>
 

 <%
 int Bookid_req = (Integer)(request.getAttribute("Bookid"));
 String Titel_req =(String) request.getAttribute((String)("Titel"));
 String Author_req =(String) request.getAttribute((String)("Author"));
 double Price_req = (Double)(request.getAttribute("Price"));
 int Page_req = (Integer)(request.getAttribute("Page"));
  %>   
<!DOCTYPE html>
<html>
<head>
<meta  http-equiv="Content-type" content="text/html; charset=US-ASCII">
<title>Update Book Record</title>
</head>
<body>
<br>
<h1>Add Book Screen</h1>
<br>
<form action="UpdateBookServlet" method="get">
&nbsp; &nbsp;Book Id &nbsp; &nbsp;<input type="text" name="Bookid_Name" value="<%=Bookid_req %>"/><br><br>
&nbsp; &nbsp;Titel &nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="Text"  name="Titel_Name" value="<%=Titel_req %>" /><br><br>
&nbsp; &nbsp;Author &nbsp; &nbsp;&nbsp;&nbsp;<input type="text" name="Author_Name"value="<%=Author_req %>" ><br><br>
&nbsp; &nbsp;Price &nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="Price_Name" value="<%=Price_req %>" ><br><br>
&nbsp; &nbsp;Page &nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="Page_Name"  value="<%=Page_req %>"><br><br>
&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;<button type="submit">Update</button>
</form>
</body>
</html>