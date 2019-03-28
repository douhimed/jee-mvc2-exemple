package org.mql.biblio.dao;

import java.util.List;
import java.util.List;
import java.util.Vector;

import org.mql.biblio.dao.jdbc.Database;
import org.mql.biblio.dao.mappers.BiblioMapper;
import org.mql.biblio.models.Document;

public class DocumentDAO implements IDocumentDAO {

	private Database db;
	private String tableName = "titles";
	private String keyName = "Title";

	public DocumentDAO() {
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

	public DocumentDAO(Database db) {
		super();
		this.db = db;
	}

	@Override
	public List<Document> getAll() {
		String[][] data = db.selectFromTable(tableName);
		List<Document> documents = mapData(data);
		return documents;
	}

	

	@Override
	public List<Document> getByPublisher(int id) {
		String[][] data = db.selectEqual(tableName, "Publisher_ID", id+"");
		return mapData(data);
	}

	private List<Document> mapData(String[][] data) {
		List<Document> documents = new Vector<>();
		for (int i = 1; i < data.length; i++) {
			documents.add(BiblioMapper.getDocument(data[i]));			
		}
		return documents;
	}

	@Override
	public List<Document> getLike(Object keyWord) {
		String[][] data = db.selectLike(tableName, keyName, keyWord.toString());
		return mapData(data);
	}

	@Override
	public Document getById(Object id) {
		String[][] data = db.selectEqual(tableName, "ISBN", id.toString());
		List<Document> documents = mapData(data);
		return documents.stream().findFirst().get();
	}

}
