package org.mql.biblio.dao;

import java.util.List;
import java.util.List;
import java.util.Vector;

import org.mql.biblio.dao.jdbc.Database;
import org.mql.biblio.dao.mappers.BiblioMapper;
import org.mql.biblio.models.Publisher;

public class PublisherDAO implements IPublisherDAO {

	private Database db;
	private String tableName = "publishers";

	
	public PublisherDAO() {
		// TODO Auto-generated constructor stub
	}
	
	public PublisherDAO(Database db) {
		super();
		this.db = db;
	}


	public Database getDb() {
		return db;
	}

	public void ListDb(Database db) {
		this.db = db;
	}
	
	@Override
	public List<Publisher> getAll() {
		String[][] data = db.selectFromTable(tableName);
		List<Publisher> publishers = mapPublisher(data);
		return publishers;
	}

	@Override
	public Publisher getById(Object id) {
		String[][] data = db.selectEqual(tableName, "publisher_ID", id.toString());
		List<Publisher> publishers = mapPublisher(data);
		return publishers.stream().findFirst().get();
	}

	private List<Publisher> mapPublisher(String[][] data) {
		List<Publisher> publishers = new Vector<>();
		for (int i = 1; i < data.length; i++) {
			publishers.add(BiblioMapper.getPublisher(data[i]));			
		}
		//publishers.sort((Publisher o1, Publisher o2) -> o1.getName().compareTo(o2.getName()));
		return publishers;
	}

}
