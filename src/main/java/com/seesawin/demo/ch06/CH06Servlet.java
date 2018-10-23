package com.seesawin.demo.ch06;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.seesawin.demo.ch05.model.OrderBean;

@WebServlet("/ch06/01")
public class CH06Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}

	protected void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Date orderDate1 = Date.valueOf("2012-03-13");
		Date orderDate2 = Date.valueOf("2030-11-06");
		Date orderDate3 = Date.valueOf("2001-01-21");
		Date orderDate4 = Date.valueOf("2002-06-08");
		Date orderDate5 = Date.valueOf("2003-02-01");
		Date orderDate6 = Date.valueOf("2004-09-23");
		Date orderDate7 = Date.valueOf("2005-03-01");
		Date orderDate8 = Date.valueOf("2006-05-25");
		Date orderDate9 = Date.valueOf("2007-04-11");
		OrderBean ob1 = new OrderBean(15426, orderDate1, "AA001", 107.12355);
		OrderBean ob2 = new OrderBean(25030, orderDate2, "AA002", 9742305.11);
		OrderBean ob3 = new OrderBean(12341, orderDate3, "AA003", 825434.012);
		OrderBean ob4 = new OrderBean(34656, orderDate4, "AA004", 9706435.666);
		OrderBean ob5 = new OrderBean(14325, orderDate5, "AA005", 842324.1);
		OrderBean ob6 = new OrderBean(23465, orderDate6, "AA006", 82524.23);
		OrderBean ob7 = new OrderBean(75674, orderDate7, "AA007", 102357.5435);
		OrderBean ob8 = new OrderBean(34543, orderDate8, "AA008", 9702545);
		OrderBean ob9 = new OrderBean(25674, orderDate9, "AA009", 823454.3);

		List<OrderBean> obList = new ArrayList<OrderBean>();
		obList.add(ob1);
		obList.add(ob2);
		obList.add(ob3);
		obList.add(ob4);
		obList.add(ob5);
		obList.add(ob6);
		obList.add(ob7);
		obList.add(ob8);
		obList.add(ob9);
		
		int i = (int)(Math.random()*10);
		if(i % 2 == 0) {
			request.setAttribute("obList", obList);
		} else {
			request.setAttribute("obList", null);
		}

		RequestDispatcher rd = request.getRequestDispatcher("/jsp/ch06/JSTL.jsp");
		rd.forward(request, response);
		return;
	}
}
