package org.mql.biblio.test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

import org.mql.biblio.models.Author;

// Just for testing serialization
public class Main {

	public Main() {
		exp02();
	}

	// deserialisation
	private void exp02() {
		Author author;
		try {
			InputStream is = new FileInputStream("ressources/Authors.dat");
			ObjectInputStream in = new ObjectInputStream(is);
			author = (Author) in.readObject();
			System.out.println(author);
		} catch (Exception e) {
			System.out.println("Error : " + e.getMessage());
			e.printStackTrace();
		}
	}

	// Serialisation
	private void exp01() {

		Author author = new Author(1, "DOUHI", 1994);
		try {
			OutputStream os = new FileOutputStream("ressources/Authors.dat");
			ObjectOutputStream out = new ObjectOutputStream(os);
			out.writeObject(author);
			out.close();
		} catch (Exception e) {
			System.out.println("Error : " + e.getMessage());
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new Main();
	}

}
