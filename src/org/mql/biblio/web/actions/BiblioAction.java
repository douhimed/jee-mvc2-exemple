package org.mql.biblio.web.actions;

import java.util.List;
import java.util.Vector;

import org.mql.biblio.business.IBiblioBusiness;
import org.mql.biblio.models.Author;
import org.mql.biblio.models.Document;
import org.mql.biblio.models.Publisher;

public class BiblioAction {

	private IBiblioBusiness service;

	public BiblioAction() {
	}

	public BiblioAction(IBiblioBusiness service) {
		super();
		this.service = service;
	}

	public String index(Context context) {
		List<Author> authors = service.authors();
		System.out.println("taille : " + authors.size());
		context.setModel("authors", authors);
		context.setModel("publishers", service.publishers());
		return "home";
	}

	public String authors(Context context) {
		List<Author> authors = service.authors();
		context.setModel("authors", authors);
		context.setModel("title", "Liste de tous les auteurs");
		return "authors";
	}

	public String documents(Context context) {
		List<Document> documents = service.documents();
		context.setModel("documents", documents);
		context.setModel("title", "Liste de tous les documents");
		return "documents";
	}

	public String findAuthors(Context context) {
		String keyWord = context.getParameter("keyWord");
		List<Author> authors = service.authors(keyWord);
		context.setModel("authors", authors);
		context.setModel("title", "Liste de tous les authors ayant : " + keyWord);
		return "authors";
	}

	public String findDocument(Context context) {
		List<Document> documents = new Vector<Document>();
		String keyWord = context.getParameter("keyWord");
		documents = service.documents(keyWord);
		context.setModel("title", "Liste de tous les documents ayant : " + keyWord);
		context.setModel("documents", documents);
		return "documents";
	}

	public String byAuthor(Context context) {
		int auth_id = Integer.parseInt(context.getParameter("authorID"));
		Author author = service.getAuthor(auth_id);
		List<Document> documents = service.getDocumentsByAuthor(auth_id);
		context.setModel("documents", documents);
		context.setModel("title", "Liste de tous les documents ecrit par : " + author.getName());
		return "documents";

	}

	public String byPublisher(Context context) {
		int id = Integer.parseInt(context.getParameter("publisherID"));
		Publisher publisher = service.getPublisher(id);
		List<Document> documents = service.getDocumentsByPublisher(publisher);
		context.setModel("documents", documents);
		context.setModel("title", "Liste de tous les documents publié par : " + publisher.getName());
		return "documents";

	}

	public String authorsByPublisher(Context context) {
		int id = Integer.parseInt(context.getParameter("publisherID"));
		Publisher publisher = service.getPublisher(id);
		List<Document> documents = service.getDocumentsByAuthor(id);
		List<Author> authors = new Vector<>();
		for (Document document : documents)
			authors.addAll(document.getAuthors());
		context.setModel("authors", authors);
		context.setModel("title", "Liste des auteurs ayant ecrit un document avec editeur : " + publisher.getName());
		return "authors";
	}

	public String themeByPublisher(Context context) {
		String keyWord = context.getParameter("keyWord");
		List<Document> documents = service.documents(keyWord);
		List<Publisher> publishers = new Vector<Publisher>();
		for (Document document : documents) {
			publishers.add(document.getPublisher());
		}
		context.setModel("publishers", publishers);
		context.setModel("title", "Liste des editeurs ayant ecrit un document sur la thematique : " + keyWord);
		return "editeurs";
	}

}
