package org.mql.biblio.business;

import java.util.List;
import java.util.List;
import java.util.Vector;

import org.mql.biblio.dao.IAuthorDAO;
import org.mql.biblio.dao.IDocumentDAO;
import org.mql.biblio.dao.IPublisherDAO;
import org.mql.biblio.dao.IRelationDAO;
import org.mql.biblio.models.Author;
import org.mql.biblio.models.Document;
import org.mql.biblio.models.Publisher;
import org.mql.biblio.models.Relation;

public class BiblioBusiness implements IBiblioBusiness {

	private IAuthorDAO authorDAO;
	private IPublisherDAO publisherDAO;
	private IDocumentDAO documentDAO;
	private IRelationDAO relationDAO;

	public BiblioBusiness() {

	}

	public BiblioBusiness(IAuthorDAO authorDAO, IPublisherDAO publisherDAO, IDocumentDAO documentDAO) {
		super();
		this.authorDAO = authorDAO;
		this.publisherDAO = publisherDAO;
		this.documentDAO = documentDAO;
	}

	public BiblioBusiness(IAuthorDAO authorDAO2, IPublisherDAO publisherDAO2, IDocumentDAO documentDAO2,
			IRelationDAO relationDAO) {
		this(authorDAO2, publisherDAO2, documentDAO2);
		this.relationDAO = relationDAO;
	}

	public IAuthorDAO getAuthorDAO() {
		return authorDAO;
	}

	public void ListAuthorDAO(IAuthorDAO authorDAO) {
		this.authorDAO = authorDAO;
	}

	public IPublisherDAO getPublisherDAO() {
		return publisherDAO;
	}

	public void ListPublisherDAO(IPublisherDAO publisherDAO) {
		this.publisherDAO = publisherDAO;
	}

	public IDocumentDAO getDocumentDAO() {
		return documentDAO;
	}

	public void ListDocumentDAO(IDocumentDAO documentDAO) {
		this.documentDAO = documentDAO;
	}

	@Override
	public List<Author> authors() {
		return authorDAO.getAll();
	}

	@Override
	public List<Author> authors(Object like) {
		return authorDAO.getLike(like);
	}

	@Override
	public List<Document> documents() {
		List<Document> documents = documentDAO.getAll();
		return documentInfos(documents, null);
	}

	@Override
	public Publisher getPublisher(int id) {
		return publisherDAO.getById(id);
	}

	@Override
	public List<Publisher> publishers() {
		return publisherDAO.getAll();
	}
	
	@Override
	public List<Document> documents(String keyWord) {
		List<Document> documents = documentDAO.getLike(keyWord);
		return documentInfos(documents, null);
	}

	@Override
	public List<Document> getDocumentsByAuthor(int id) {
		List<Relation> relations = relationDAO.getByAuthor(id);
		List<Document> documents = new Vector<Document>();
		for (Relation relation : relations) {
			Document document = documentDAO.getById(relation.getIsbn());
			int id_p = document.getPublisher().getId();
			document.setPublisher(publisherDAO.getById(id_p));
			Author author = authorDAO.getById(relation.getId_author());
			document.addAuthor(author);
			documents.add(document);
		}
		return documents;
	}

	@Override
	public Author getAuthor(int auth_id) {
		return authorDAO.getById(auth_id);
	}
	
	@Override
	public List<Document> getDocumentsByPublisher(Publisher publisher) {
		List<Document> documents = documentDAO.getByPublisher(publisher.getId());
		return documentInfos(documents, publisher);
	}

	private List<Document> documentInfos(List<Document> documents, Publisher publisher) {
		
		for (Document document : documents) {
			if(publisher == null) {
				int id_p = document.getPublisher().getId();
				publisher = publisherDAO.getById(id_p);
			}
			document.setPublisher(publisher);
			List<Relation> ralations = relationDAO.getByDocument(document.getIsbn()); 
			for (Relation relation : ralations) {
				Author author = authorDAO.getById(relation.getId_author());
				document.addAuthor(author);
			}
		}

		return documents;
	}
}