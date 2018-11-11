package com.seesawin.demo.ch08.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.seesawin.demo.ch08.model.UserBean;

@WebFilter(filterName = "AuthenticationFilter", urlPatterns = { "/ch08/product" })
public class AuthenticationFilter implements Filter {
	@Override
	public void init(FilterConfig fConfig) throws ServletException {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		if (request instanceof ServletRequest && response instanceof ServletResponse) {
			HttpServletRequest req = (HttpServletRequest) request;
			HttpServletResponse resp = (HttpServletResponse) response;
			
			// create a new Session or get the old Session
			HttpSession session = req.getSession();
			
			// get user info
			UserBean ub = (UserBean) session.getAttribute("user");
			
			if (ub == null) {
				// login page
				String redirect = resp.encodeRedirectURL(req.getContextPath() + "/ch08/login?action=init");
				resp.sendRedirect(redirect);
				return;
			} else {
				System.out.println("do something before servlet...");

				chain.doFilter(request, response);

				System.out.println("do something after servlet...");

			}
		}
	}

	@Override
	public void destroy() {
	}
}
