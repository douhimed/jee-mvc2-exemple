package org.mql.biblio.models;

import java.io.Serializable;
import java.util.Objects;

public final class Author implements Serializable {

	private static final long serialVersionUID = 1L;

	private int id;
	private String name;
	private int yearBorn;

	public Author() {
	}

	public Author(int id, String name, int yearBorn) {
		super();
		this.id = id;
		this.name = name;
		this.yearBorn = yearBorn;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getYearBorn() {
		return yearBorn;
	}

	public void setYearBorn(int yearBorn) {
		this.yearBorn = yearBorn;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Author [id=" + id + ", name=" + name + ", yearBorn=" + yearBorn + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name, yearBorn);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		
		if(!(obj instanceof Author))
			return false;
		
		if(obj != this )
			return false;
		
		Author author = (Author)obj;
		return Integer.compare(this.id, author.getId()) == 0
				&& this.name.equals(author.getName())
				&& Integer.compare(this.yearBorn, author.getYearBorn()) == 0;
	}

}
