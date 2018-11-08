package com.seesawin.demo.ch09.linstener;

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

	}
}
