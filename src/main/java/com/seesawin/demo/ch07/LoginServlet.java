package com.seesawin.demo.ch07;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/ch07/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}

	protected void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 取得HttpSession物件
		HttpSession session = request.getSession();

		// 驗證是否已經登入
		Object isLogin = session.getAttribute("isLogin");
		if (isLogin != null && (boolean) isLogin == true) {
			// 跳過登入畫面直接進入結果頁面
			RequestDispatcher rd = request.getRequestDispatcher("/jsp/ch07/ch07_login_result.jsp");
			rd.forward(request, response);
			return;
		}

		String action = request.getParameter("action");
		if ("init".equals(action)) {
			// 設置登入flag為false
			session.setAttribute("isLogin", false);

			// 登入畫面
			RequestDispatcher rd = request.getRequestDispatcher("/jsp/ch07/ch07_login.jsp");
			rd.forward(request, response);
			return;
		} else if ("check".equals(action)) {
			String acct = request.getParameter("acct");
			String pwd = request.getParameter("pwd");

			boolean isCorrect = false;

			// check acct and pwd
			if ("Frank".equals(acct) && "1234".equals(pwd)) {
				isCorrect = true;
			} else if ("Alec".equals(acct) && "4321".equals(pwd)) {
				isCorrect = true;
			} else {
				session.setAttribute("isLogin", false);
			}

			// 驗證是否登入過
			if (!isCorrect) {
				// 登入畫面
				RequestDispatcher rd = request.getRequestDispatcher("/jsp/ch07/ch07_login.jsp");
				// 設置requetScope變量
				request.setAttribute("acct", acct);
				request.setAttribute("pwd", pwd);
				request.setAttribute("errMsg", "帳號或密碼錯誤!");

				rd.forward(request, response);
			} else {
				// 結果畫面
				RequestDispatcher rd = request.getRequestDispatcher("/jsp/ch07/ch07_login_result.jsp");
				session.setAttribute("acct", request.getParameter("acct"));

				// 設置sessionScope變量，登入flag為true
				session.setAttribute("isLogin", true);
				rd.forward(request, response);
				return;
			}
		}
	}
}
