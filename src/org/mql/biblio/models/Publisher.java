package org.mql.biblio.models;

import java.io.Serializable;

public final class Publisher implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private int id;
	private String name;
	private String company;

	public Publisher() {
	}

	public Publisher(int id) {
		this.id = id;
	}

	public Publisher(String name, String company) {
		this.name = name;
		this.company = company;
	}
	
	public Publisher(int id, String name, String company) {
		this(name, company);
		this.id = id;
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

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	@Override
	public String toString() {
		return "Publisher [id=" + id + ", name=" + name + ", company=" + company + "]";
	}

}
