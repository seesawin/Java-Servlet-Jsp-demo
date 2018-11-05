package com.seesawin.demo.ch99;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/ch99/01")
public class CH99Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}

	protected void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext application = getServletContext();
		application.setAttribute("proc", "Y");
		application.setAttribute("remarks", "\"專案\"全局變量，對每個用戶與頁面皆有效");
		
		HttpSession session = request.getSession();
		session.setAttribute("userName", "Stanely");
		session.setAttribute("remarks", "\"用戶\"全局變量，用戶不關閉瀏覽器或會話沒有過期皆有效");
		
		request.setAttribute("userName", "Luis");
		request.setAttribute("remarks", "\"在一次的請求的全部過程\"的變量，這個過程中forward的JSP頁面皆可使用");
		
		RequestDispatcher rd = request.getRequestDispatcher("/jsp/ch99/ch99_01.jsp");
		
		application.setAttribute("proc", "N");
		
		rd.forward(request, response);
	}
}
