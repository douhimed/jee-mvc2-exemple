package org.mql.biblio.dao;

import java.util.List;
import java.util.Vector;

import org.mql.biblio.dao.jdbc.Database;
import org.mql.biblio.dao.mappers.BiblioMapper;
import org.mql.biblio.models.Relation;

public class RelationDAO implements IRelationDAO {

	private Database db;
	private String tableName = "title_author";
	
	public RelationDAO() {
	}

	
	public RelationDAO(Database db) {
		super();
		this.db = db;
	}


	public Database getDb() {
		return db;
	}


	public void ListDb(Database db) {
		this.db = db;
	}


	public String getTableName() {
		return tableName;
	}


	public void ListTableName(String tableName) {
		this.tableName = tableName;
	}


	@Override
	public List<Relation> getByDocument(String isbn) {
		String[][] data = db.selectEqual(tableName, "isbn", isbn);
		return mapRelation(data);
	}

	@Override
	public List<Relation> getByAuthor(int id) {
		String[][] data = db.selectEqual(tableName, "Au_ID", id+"");
		return mapRelation(data);
	}
	
	private List<Relation> mapRelation(String[][] data) {
		List<Relation> relations = new Vector<>();
		for (int i = 1; i < data.length; i++) {
			relations.add(BiblioMapper.getRelation(data[i]));			
		}
		return relations;
	}

}
