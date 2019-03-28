<%@page import="org.mql.biblio.models.Author"%>
<%@page import="org.mql.biblio.models.Document"%>
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


	<hr />

	<%
	List<Document> documents = (List<Document>) request.getAttribute("documents");
		for (Document document : documents) {
	%>
	ISBN :<%=document.getIsbn()%><br /> Titre :
	<%=document.getTitle()%><br /> Année de piblication :
	<%=document.getYearPublished()%><br /> Editeur :
	<%=document.getPublisher().getName()%><br /> Entreprise :
	<%=document.getPublisher().getCompany()%><br />

	<table border="1" style="width: 100%; border-collapse: collapse;">
		<tr>
			<th>Nom</th>
			<th>date de naissance</th>
		</tr>

		<%
		List<Author> authors = document.getAuthors();
				for (Author author : authors) {
		%>
		<tr>
			<td><%=author.getName()%></td>
			<td><%=author.getYearBorn()%></td>
		</tr>
		<%
			}
		%>

	</table>
	<hr />
	<%
		}
	%>

</body>
</html>