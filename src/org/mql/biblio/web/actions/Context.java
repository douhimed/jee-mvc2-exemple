package org.mql.biblio.web.actions;

public interface Context {

	String getParameter(String nom);

	void setModel(String name, Object model);

	Object getModel(String name);
}
