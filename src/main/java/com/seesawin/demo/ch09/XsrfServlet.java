package com.seesawin.demo.ch09;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.owasp.esapi.ESAPI;
import org.owasp.esapi.ValidationErrorList;
import org.owasp.esapi.errors.ValidationException;

@WebServlet("/ch09/xsrf")
public class XsrfServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}

	protected void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ValidationErrorList errList = new ValidationErrorList();
		String acct = request.getParameter("acct");
		String esapiAcct = ESAPI.validator().getValidInput("acct", request.getParameter("acct"), "HTTPParameterValue", 100, true, errList);
		String pwd = request.getParameter("pwd");
		String esapiPwd = ESAPI.validator().getValidInput("pwd", request.getParameter("pwd"), "HTTPParameterValue", 100, true, errList);
		String errCde = "00";
		String errMsg = "No problem!";
		
		System.out.println("ori acct : " + acct + ", esapi acct : " + esapiAcct);
		System.out.println("ori pwd : " + pwd + ", esapi pwd : " + esapiPwd);
		
		List<ValidationException> errors = errList.errors();
		if (errors.size() > 0) {
			System.out.println("ESAPI Error");
			for (ValidationException ex : errors) {
				System.out.println(ex.getMessage() + ";" + ex.getLogMessage());
			}

			errCde = "01";
			errMsg = "ESAPI Error!";
			request.setAttribute("errors", errors);
		}

		request.setAttribute("acct", acct);
		request.setAttribute("pwd", pwd);
		request.setAttribute("errCde", errCde);
		request.setAttribute("errMsg", errMsg);
		
		HttpSession session = request.getSession();
		String sessionId = session.getId();
		System.out.println("in servlet sessionId : " + sessionId);

		RequestDispatcher rd = request.getRequestDispatcher("/jsp/ch09/ch09_xsrf.jsp");
		rd.forward(request, response);
		return;
	}
}
