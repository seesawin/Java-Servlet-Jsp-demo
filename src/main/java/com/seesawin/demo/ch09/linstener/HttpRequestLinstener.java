package com.seesawin.demo.ch09.linstener;

import java.util.Enumeration;

import javax.servlet.ServletRequest;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

public class HttpRequestLinstener implements ServletRequestListener {

	@Override
	public void requestDestroyed(ServletRequestEvent sre) {
		System.out.println("request Destroyed...");
	}

	@Override
	public void requestInitialized(ServletRequestEvent sre) {
		System.out.println("request Initialized...");
		ServletRequest request = sre.getServletRequest();
		Enumeration<String> parameterNames = request.getParameterNames();

		int count = 0;
		while (parameterNames.hasMoreElements()) {
			String paramName = parameterNames.nextElement();
			String[] paramValues = request.getParameterValues(paramName);
			for (int i = 0; i < paramValues.length; i++) {
				String paramValue = paramValues[i];
				System.out.println((++count) + ". name : " + paramName + ", value : " + paramValue);
			}
		}
	}
}
