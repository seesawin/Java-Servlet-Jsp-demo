package com.seesawin.demo.ch02;

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
@WebServlet("/ch02/01")
public class CH002Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CH002Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet...");
		// 說明瀏覽器送來之文字資料的編碼
		request.setCharacterEncoding("UTF-8");
		
		// 讀取使用者在request URL附帶的參數
		String action = request.getParameter("action");
		String mName = request.getParameter("mName");
		String mAge = request.getParameter("mAge");
		String sex = request.getParameter("sex");
		String location = request.getParameter("location");
		System.out.println("action : " + action);
		System.out.println("mName : " + mName);
		System.out.println("mAge : " + mAge);
		System.out.println("sex : " + sex);
		System.out.println("location : " + location);
		
		request.setAttribute("mName",mName);
		request.setAttribute("mAge",mAge);
		request.setAttribute("sex",sex);
		request.setAttribute("location",location);
		
		RequestDispatcher rd = request.getRequestDispatcher("/jsp/ch02/result.jsp");
		rd.forward(request, response);
		return;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost...");
		
		// 說明瀏覽器送來之文字資料的編碼
		request.setCharacterEncoding("UTF-8");
		
		// TODO Auto-generated method stub
		// 讀取使用者在request URL附帶的參數
		String action = request.getParameter("action");
		String mName = request.getParameter("mName");
		String mAge = request.getParameter("mAge");
		String sex = request.getParameter("sex");
		String location = request.getParameter("location");
		System.out.println("action : " + action);
		System.out.println("mName : " + mName);
		System.out.println("mAge : " + mAge);
		System.out.println("sex : " + sex);
		System.out.println("location : " + location);
		
		request.setAttribute("mName",mName);
		request.setAttribute("mAge",mAge);
		request.setAttribute("sex",sex);
		request.setAttribute("location",location);
		
		RequestDispatcher rd = request.getRequestDispatcher("/jsp/ch02/result.jsp");
		rd.forward(request, response);
		return;
	}

}
