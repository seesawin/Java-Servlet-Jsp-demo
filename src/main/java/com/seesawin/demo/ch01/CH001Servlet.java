package com.seesawin.demo.ch01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FUNC001Servlet
 */
@WebServlet("/ch01/01")
public class CH001Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CH001Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 讀取使用者在request URL附帶的參數
		String action = request.getParameter("action");
		System.out.println("action : " + action);
		
		// init: 初始畫面
		if("init".equals(action)) {
			// 將程式導入下個畫面(JSP)或是下一隻程式(JAVA)
			RequestDispatcher rd = request.getRequestDispatcher("/jsp/ch01/ch01_index.jsp");
			rd.forward(request, response);
			return;
		} else if ("byServlet".equals(action)) {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<html><head>");
			out.println("<title>FUNC001</title>");
			out.println("</head>");
			out.println("<body>");
			out.write("<pre>回傳HTML字串給瀏覽器，瀏覽器將字串內容編譯成網頁畫面,\r\n");
			out.write("這種方式會造成前後端職責不清楚，除非是舊專案，現在已經很少人使用</pre>");
			out.println("</body>");
			out.println("</html>");
			return;
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
