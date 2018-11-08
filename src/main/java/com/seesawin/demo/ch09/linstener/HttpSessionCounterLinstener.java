package com.seesawin.demo.ch09.linstener;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class HttpSessionCounterLinstener implements HttpSessionListener {

	/*
	 * Create session
	 * 1.invoke request.getSession()
	 * 2.go to a JSP page
	 * 
	 * */
	@Override
	public void sessionCreated(HttpSessionEvent se) {
		HttpSession session = se.getSession();
		String sessionId = session.getId();
		System.out.println("create sessionId : " + sessionId);
		
		ServletContext ctx = session.getServletContext();
		Integer numSessions = (Integer) ctx.getAttribute("numSessions");
		if (numSessions == null) {
			numSessions = new Integer(1);
		} else {
			int count = numSessions.intValue();
			numSessions = new Integer(count + 1);
		}
		ctx.setAttribute("numSessions", numSessions);

		System.out.println("session Created..., numSessions : " + numSessions);
	}

	/*
	 * Destroy session
	 * 1.session.invalidate()
	 * 2.session timeout
	 * 3.server shutdown
	 * 
	 * */
	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		HttpSession session = se.getSession();
		String sessionId = session.getId();
		System.out.println("delete sessionId : " + sessionId);
		
		ServletContext ctx = session.getServletContext();
		Integer numSessions = (Integer) ctx.getAttribute("numSessions");
		if (numSessions == null) {
			numSessions = new Integer(0);
		} else {
			int count = numSessions.intValue();
			numSessions = new Integer(count - 1);
		}
		ctx.setAttribute("numSessions", numSessions);
		
		System.out.println("session  Destroyed..., numSessions : " + numSessions);
	}
}
