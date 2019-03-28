package org.mql.biblio.dao;

import java.util.List;
import java.util.List;
import java.util.Vector;

import org.mql.biblio.dao.jdbc.Database;
import org.mql.biblio.dao.mappers.BiblioMapper;
import org.mql.biblio.models.Author;

public class AuthorDAO implements IAuthorDAO {

	private Database db;
	private String tableName = "Authors";

	public AuthorDAO() {
	}

	public AuthorDAO(Database db) {
		super();
		this.db = db;
	}

	public void ListDataBase(Database db) {
		this.db = db;
	}

	public Database getDatabase() {
		return db;
	}

	public void ListTableName(String tableName) {
		this.tableName = tableName;
	}

	@Override
	public List<Author> getAll() {
		String[][] data = db.selectFromTable(tableName);
		List<Author> authors = mapData(data);
		return authors;
	}

	@Override
	public List<Author> getLike(Object like) {
		String[][] data = db.selectLike(tableName, "Author", like.toString());
		List<Author> authors = mapData(data);
		return authors;
	}

	@Override
	public Author getById(Object id) {
		String[][] data = db.selectEqual(tableName, "Au_id", id.toString());
		List<Author> authors = mapData(data);
		return authors.stream().findFirst().get();
	}

	private List<Author> mapData(String[][] data) {
		List<Author> authors = new Vector<Author>();
		for (int i = 1; i < data.length; i++) {
			authors.add(BiblioMapper.getAuthor(data[i]));			
		}
		//authors.sort((Author o1, Author o2) -> o1.getName().compareTo(o2.getName()));
		return authors;
	}

}
