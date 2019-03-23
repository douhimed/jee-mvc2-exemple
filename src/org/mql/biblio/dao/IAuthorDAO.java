package org.mql.biblio.dao;

import java.util.List;

import org.mql.biblio.models.Author;

public interface IAuthorDAO extends IObjectDAO<Author>{

	List<Author> getLike(Object keyWord);

}
