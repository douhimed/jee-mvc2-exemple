package org.mql.biblio.web.actions;

import javax.servlet.http.HttpServletRequest;

// webContext or SwingContext ...
public class WebContext implements Context {

	private HttpServletRequest request;

	public WebContext() {
	}

	public WebContext(HttpServletRequest request) {
		this.request = request;
	}

	public HttpServletRequest getRequest() {
		return request;
	}

	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

	@Override
	public String getParameter(String name) {
		return request.getParameter(name);
	}

	@Override
	public void setModel(String name, Object model) {
		request.setAttribute(name, model);
	}

	@Override
	public Object getModel(String name) {
		return request.getAttribute(name);
	}

}
