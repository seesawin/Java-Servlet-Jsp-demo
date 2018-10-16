package com.seesawin.demo.ch02;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ch02/requestInfo")
public class RequestInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("<head>");
		out.println("<title>CH02-Request Information Example</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h2>Request Information Example</h2>");
		out.println("<P>Request URL: " + request.getRequestURL());
		out.println("<P>Request URI: " + request.getRequestURI());
		out.println("<P>QueryString: " + request.getQueryString());
		out.println("<P>Context Path: " + request.getContextPath());
		out.println("<P>Servlet Path: " + request.getServletPath());
		out.println("<P>Server Name: " + request.getServerName());
		out.println("<P>SessionId: " + request.getRequestedSessionId());
		out.println("<P>Method: " + request.getMethod());
		out.println("<P>Protocol: " + request.getProtocol());
		out.println("<P>Remote Address: " + request.getRemoteAddr());

		out.println("</body>");
		out.println("</html>");
	}
}
