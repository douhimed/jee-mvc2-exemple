package org.mql.biblio.dao;

import java.util.List;

import org.mql.biblio.models.Relation;

public interface IRelationDAO {

	List<Relation> getByDocument(String isbn);

	List<Relation> getByAuthor(int id);
	
}
