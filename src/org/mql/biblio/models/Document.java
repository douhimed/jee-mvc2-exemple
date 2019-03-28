package org.mql.biblio.models;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;
import java.util.Vector;

public final class Document implements Serializable {

	private static final long serialVersionUID = 1L;

	private String isbn;
	private String title;
	private int yearPublished;
	private Publisher publisher;
	private List<Author> authors;

	{
		authors = new Vector<>();
	}

	public Document() {
	}

	public Document(String isbn) {
		super();
		this.isbn = isbn;
	}

	public Document(String isbn, String title, int yearPublished) {
		super();
		this.isbn = isbn;
		this.title = title;
		this.yearPublished = yearPublished;
	}

	public Document(String isbn, String title, int yearPublished, Publisher publisher) {
		super();
		this.isbn = isbn;
		this.title = title;
		this.yearPublished = yearPublished;
		this.publisher = publisher;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getYearPublished() {
		return yearPublished;
	}

	public void setYearPublished(int yearPublished) {
		this.yearPublished = yearPublished;
	}

	public Publisher getPublisher() {
		return publisher;
	}

	public void setPublisher(Publisher publisher) {
		this.publisher = publisher;
	}

	public void setAuthors(List<Author> authors) {
		this.authors = authors;
	}

	public List<Author> getAuthors() {
		return Collections.unmodifiableList(authors);
	}

	public void ListAuthors(List<Author> authors) {
		this.authors = authors;
	}

	public void addAuthor(Author author) {
		authors.add(author);
	}

	public boolean removeAuthor(Author author) {
		return authors.remove(author);
	}

	public void updateAUthor(Author author) {
		authors.add(author);
	}

	public int authorsNumber() {
		return authors.size();
	}

	@Override
	public String toString() {
		return "Document [isbn=" + isbn + ", title=" + title + ", yearPublished=" + yearPublished + ", publisher="
				+ publisher + ", authors=" + authors + "]";
	}

}
