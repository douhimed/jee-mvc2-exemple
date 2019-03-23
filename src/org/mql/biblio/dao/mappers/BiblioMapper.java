package org.mql.biblio.dao.mappers;

import org.mql.biblio.models.Author;
import org.mql.biblio.models.Document;
import org.mql.biblio.models.Publisher;
import org.mql.biblio.models.Relation;

public class BiblioMapper {

	public BiblioMapper() {
	}

	public static Author getAuthor(String... row) {
		Author author = new Author();
		author.setName(row[1]);
		try {
			author.setId(Integer.parseInt(row[0]));
			author.setYearBorn(Integer.parseInt(row[2]));
		} catch (Exception e) {
			System.out.println("Error : " + e.getMessage());
		}

		return author;
	}

	public static Document getDocument(String... row) {
		Document document = new Document();
		document.setTitle(row[1]);
		try {
			document.setIsbn(row[0]);
			document.setYearPublished(Integer.parseInt(row[2]));
			document.setPublisher(new Publisher(Integer.parseInt(row[3])));
		} catch (Exception e) {
			System.out.println("Error : " + e.getMessage());
		}

		return document;
	}

	public static Publisher getPublisher(String[] row) {
		Publisher publisher = new Publisher();
		publisher.setName(row[1]);
		publisher.setCompany(row[2]);
		try {
			publisher.setId(Integer.parseInt(row[0]));
		} catch (Exception e) {
			System.out.println("Error : " + e.getMessage());
		}

		return publisher;
	}

	public static Relation getRelation(String[] row) {
		Relation relation = new Relation();
		relation.setIsbn(row[0]);
		try {
			relation.setId_author(Integer.parseInt(row[1]));;
		} catch (Exception e) {
			System.out.println("Error : " + e.getMessage());
		}
		return relation;
	}

}
