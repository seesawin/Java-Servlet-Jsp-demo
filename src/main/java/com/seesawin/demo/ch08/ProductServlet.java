package com.seesawin.demo.ch08;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.seesawin.demo.ch03.model.ProductBeam;
import com.seesawin.demo.ch03.service.ProductService;
import com.seesawin.demo.ch03.service.impl.ProductServiceImpl;

@WebServlet("/ch08/product")
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}

	protected void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		System.out.println("name : " + name);
		
		ProductService service = new ProductServiceImpl();
		
		List<ProductBeam> products = null;
		if(name == null || name.isEmpty()) {
			products = service.selectProducts();
		} else {
			products = service.searchProducts(name);
		}
		request.setAttribute("products",products);
		request.setAttribute("name",name);
		
		RequestDispatcher rd = request.getRequestDispatcher("/jsp/ch08/product.jsp");
		rd.forward(request, response);
		return;
	}
}
