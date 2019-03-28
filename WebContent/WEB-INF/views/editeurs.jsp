<%@page import="org.mql.biblio.models.Publisher"%>
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
		List<Publisher> publishers = (List<Publisher>) request.getAttribute("publishers");
			for (Publisher publisher : publishers) {
		%>
		<tr>
			<td><%=publisher.getName()%></td>
			<td><%=publisher.getCompany()%></td>
		</tr>
		<%
			}
		%>

	</table>
</body>
</html>