package org.mql.biblio.dao;

import java.util.List;

import org.mql.biblio.models.Document;

public interface IDocumentDAO extends IObjectDAO<Document>{
	
	List<Document> getByPublisher(int id);
	List<Document> getLike(Object keyWord);

}
