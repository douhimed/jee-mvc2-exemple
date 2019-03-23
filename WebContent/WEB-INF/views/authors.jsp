<%@page import="org.mql.biblio.models.Author"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>MQL : JEE</title>
</head>
<body>

	<h1><%=request.getAttribute("title")%></h1>

	<table border="1" style="width: 100%; border-collapse: collapse;">
	
		<%
			List<Author> authors = (List<Author>) request.getAttribute("authors");
			for (Author author : authors) {
		%>
		<tr>
			<td><%=author.getId()%></td>
			<td><%=author.getName()%></td>
			<td><%=author.getYearBorn()%></td>
		</tr>
		<%
			}
		%>

	</table>
</body>
</html>