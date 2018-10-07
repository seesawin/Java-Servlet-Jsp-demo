package com.seesawin.demo.ch3.ctrl;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.seesawin.demo.ch3.model.ProductBeam;
import com.seesawin.demo.ch3.service.ProductService;
import com.seesawin.demo.ch3.service.impl.ProductServiceImpl;

/**
 * Servlet implementation class FUNC001Servlet
 */
@WebServlet("/ch03/01")
public class CH003Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CH003Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
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
		
		RequestDispatcher rd = request.getRequestDispatcher("/jsp/ch03/product.jsp");
		rd.forward(request, response);
	}

}
