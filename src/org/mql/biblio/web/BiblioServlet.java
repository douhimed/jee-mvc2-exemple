package org.mql.biblio.web;

import java.io.IOException;
import java.util.List;
import java.util.Vector;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.mql.biblio.business.BiblioBusiness;
import org.mql.biblio.business.IBiblioBusiness;
import org.mql.biblio.dao.AuthorDAO;
import org.mql.biblio.dao.DocumentDAO;
import org.mql.biblio.dao.IAuthorDAO;
import org.mql.biblio.dao.IDocumentDAO;
import org.mql.biblio.dao.IPublisherDAO;
import org.mql.biblio.dao.IRelationDAO;
import org.mql.biblio.dao.PublisherDAO;
import org.mql.biblio.dao.RelationDAO;
import org.mql.biblio.dao.jdbc.DataSource;
import org.mql.biblio.dao.jdbc.Database;
import org.mql.biblio.dao.jdbc.MySQLDataSource;
import org.mql.biblio.web.actions.BiblioAction;
import org.mql.biblio.web.actions.Context;
import org.mql.biblio.web.actions.WebContext;

//@WebServlet({ "/BiblioServlet", "/biblio/*", "*.biblio" })
public class BiblioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private BiblioAction biblioAction;

	private String preffix = "/WEB-INF/views/";
	private String suffix = ".jsp";

	private String classAction = "BiblioAction";
	private String methodAction = "index";
	private List<String> params;
	private String view = "home";


	public void init(ServletConfig config) throws ServletException {
		DataSource ds = new MySQLDataSource("Biblio");
		Database db = new Database(ds);
		IAuthorDAO authorDAO = new AuthorDAO(db);
		IDocumentDAO documentDAO = new DocumentDAO(db);
		IPublisherDAO publisherDAO = new PublisherDAO(db);
		IRelationDAO relationDAO = new RelationDAO(db);
		IBiblioBusiness service = new BiblioBusiness(authorDAO, publisherDAO, documentDAO, relationDAO);
		biblioAction = new BiblioAction(service);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		rootComponants(request.getRequestURI());
		try {
			view = biblioAction.getClass().getDeclaredMethod(methodAction, Context.class)
					.invoke(biblioAction, new WebContext(request)).toString();
		} catch (Exception e) {
			System.out.println("Error in view : " + e.getMessage());
			e.printStackTrace();
		}

		request.getRequestDispatcher(preffix + view + suffix).forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		doGet(request, response);
		
	}
	
	private void rootComponants(String uri) {
		String[] composants = uri.split("/");
		
		if(composants.length > 2) {
			params = new Vector<>();
			for (int i = 2; i < composants.length; i++) {
				if (i == 2) {
					char c = (char) (composants[2].charAt(0) - 32);
					classAction = c + composants[2].substring(1) + "Action";
				} else if (i == 3) {
					methodAction = composants[3];
				} else {
					params.add(composants[i]);
				}
			}
		}
	}

}
