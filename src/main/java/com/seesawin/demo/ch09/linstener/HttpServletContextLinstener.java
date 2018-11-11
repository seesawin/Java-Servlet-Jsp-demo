package com.seesawin.demo.ch09.linstener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class HttpServletContextLinstener implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("context Initialized...");
		ServletContext context = sce.getServletContext();
		String projectName = context.getInitParameter("projectName");
		System.out.println("projectName : " + projectName);
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("context Destroyed...");
	}

}
