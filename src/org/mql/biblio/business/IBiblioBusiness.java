package org.mql.biblio.business;

import java.util.List;

import org.mql.biblio.models.Author;
import org.mql.biblio.models.Document;
import org.mql.biblio.models.Publisher;

public interface IBiblioBusiness {
	
	List<Author> authors();
	List<Author> authors(Object like);
	List<Document> documents();
	List<Document> documents(String keyWord);
//	List<Object> getLike(String tableName, String keyWord);
	List<Document> getDocumentsByAuthor(int id);
	Author getAuthor(int auth_id);
	Publisher getPublisher(int id);
	List<Document> getDocumentsByPublisher(Publisher publisher);
	List<Publisher> publishers();

}
