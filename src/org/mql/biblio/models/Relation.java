package org.mql.biblio.models;

public class Relation {

	private String isbn;
	private int id_author;
	
	public Relation() {
		// TODO Auto-generated constructor stub
	}

	public Relation(String isbn, int id_author) {
		super();
		this.isbn = isbn;
		this.id_author = id_author;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public int getId_author() {
		return id_author;
	}

	public void setId_author(int id_author) {
		this.id_author = id_author;
	}

	@Override
	public String toString() {
		return "Relation [isbn=" + isbn + ", id_author=" + id_author + "]";
	}
	
	

}
