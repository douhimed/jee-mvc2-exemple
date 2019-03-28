<%@page import="org.mql.biblio.models.Author"%>
<%@page import="org.mql.biblio.models.Document"%>
<%@page import="org.mql.biblio.models.Publisher"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>



<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>MQL : JEE</title>
</head>
<body>
	<h2>Page d'accueil</h2>
	<ul>
		<li><a href="biblio/authors">Liste des auteurs</a></li>
		<li><a href="biblio/documents">Liste des documents</a></li>
	</ul>
	<hr />
	<form method="POST" action="biblio/findAuthors">
		Auteur par nom : <input type="text" name="keyWord" /> <input type="submit"
			name="OK" value="OK" />
	</form>
	<hr />
	<form method="POST" action="biblio/findDocument">
		Documents par mot cl� : <input type="text" name="keyWord" /> <input type="submit"
			name="OK" value="OK" />
	</form>
	
	<hr />

	<form method="POST" action="biblio/byAuthor">
	document par autheur : 
		<select name="authorID">
			<%
			List<Author> authors = (List<Author>) request.getAttribute("authors");
				for (Author author : authors) {
			%>
			<option value="<%=author.getId()%>"><%=author.getName()%></option>
			<%
				}
			%>
			
		</select>
		<input type="submit"
			name="OK" value="OK" />
	</form>
	
	<hr />

	<form method="POST" action="biblio/byPublisher">
	documents par editeur : 
		<select name="publisherID">
			<%
			List<Publisher> publishers = (List<Publisher>) request.getAttribute("publishers");
				for (Publisher publisher : publishers) {
			%>
			<option value="<%=publisher.getId()%>"><%=publisher.getName()%></option>
			<%
				}
			%>
			
		</select>
		<input type="submit"
			name="OK" value="OK" />
	</form>
	
	<hr />

	<form method="POST" action="biblio/authorsByPublisher">
	auteurs d'un editeur : 
		<select name="publisherID">
			<%
				for (Publisher publisher : publishers) {
			%>
			<option value="<%=publisher.getId()%>"><%=publisher.getName()%></option>
			<%
				}
			%>
			
		</select>
		<input type="submit"
			name="OK" value="OK" />
	</form>
	
		<hr />

	<form method="POST" action="biblio/themeByPublisher">
	editeur par thematique : <input type="text" name="keyWord" /> <input type="submit"
			name="OK" value="OK" />
	</form>
	
</body>
</html>