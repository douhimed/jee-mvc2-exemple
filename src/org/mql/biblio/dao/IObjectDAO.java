package org.mql.biblio.dao;

import java.util.List;

public interface IObjectDAO<T> {

	List<T> getAll();
	T getById(Object id);
	
}
