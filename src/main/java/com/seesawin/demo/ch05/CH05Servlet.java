package com.seesawin.demo.ch05;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.seesawin.demo.ch03.model.ProductBeam;
import com.seesawin.demo.ch03.service.ProductService;
import com.seesawin.demo.ch03.service.impl.ProductServiceImpl;
import com.seesawin.demo.ch05.model.OrderBean;

@WebServlet("/ch05/01")
public class CH05Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}

	protected void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// Case1 屬性物件是字串物件==>透過EL來取用，${識別字串}
		request.setAttribute("Case1", "第一種情況，屬性物件是字串物件，也就是本字串");

		// Case2 屬性物件是JavaBean物件==>透過 EL 來取用，${識別字串.JavaBean的性質}
		Date orderDate = Date.valueOf("2011-01-12");
		// Java beam 利用建構子封裝資料
		OrderBean ob = new OrderBean(65851, orderDate, "kitty968", 2587);
		request.setAttribute("Case2", ob);

		// Case3 屬性物件是Map物件==>透過EL來取用，${識別字串.鍵值}就可取得對應的value
		// 泛型語法:key值為String，value可以為任何型態的物件
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("mapkey1", "Hello, World字串"); // 存放字串
		map.put("mapkey2", ob); // 存放物件
		request.setAttribute("Case3", map);

		// Case4 屬性物件是元素是JavaBean物件的陣列==>搭配JSTL的<c:forEach>與EL 來取用
		Date orderDate1 = Date.valueOf("2011-01-01");
		Date orderDate2 = Date.valueOf("2011-01-11");
		Date orderDate3 = Date.valueOf("2011-01-21");
		OrderBean ob1 = new OrderBean(65824, orderDate1, "array123", 1507);
		OrderBean ob2 = new OrderBean(42301, orderDate2, "array456", 2507);
		OrderBean ob3 = new OrderBean(94337, orderDate3, "array789", 3507);
		
		// 物件陣列，此處的物件必須為OrderBean
		OrderBean oba[] = { ob1, ob2, ob3 };
		request.setAttribute("Case4", oba);

		// Case5 屬性物件是元素是JavaBean物件的Collection==>搭配JSTL的<c:forEach>與EL 來取用
		Date orderDate41 = Date.valueOf("2010-10-06");
		Date orderDate42 = Date.valueOf("2010-10-16");
		Date orderDate43 = Date.valueOf("2010-10-26");
		OrderBean ob4 = new OrderBean(15426, orderDate41, "collection123", 107);
		OrderBean ob5 = new OrderBean(25030, orderDate42, "collection456", 9705);
		OrderBean ob6 = new OrderBean(35231, orderDate43, "collection789", 824);
		Collection<OrderBean> obc1 = new ArrayList<OrderBean>();
		obc1.add(ob4);
		obc1.add(ob5);
		obc1.add(ob6);
		request.setAttribute("Case5_1", obc1);

		List<OrderBean> obc2 = new ArrayList<OrderBean>();
		obc2.add(ob4);
		obc2.add(ob5);
		obc2.add(ob6);
		request.setAttribute("Case5_2", obc2);

		// Case6 Key或Value是JavaBean物件的Map==>搭配JSTL的<c:forEach>與EL 來取用
		Date orderDate51 = Date.valueOf("2001-01-05");
		Date orderDate52 = Date.valueOf("2001-01-15");
		Date orderDate53 = Date.valueOf("2001-01-25");
		OrderBean ob7 = new OrderBean(52841, orderDate51, "map123", 1007);
		OrderBean ob8 = new OrderBean(90461, orderDate52, "map456", 9005);
		OrderBean ob9 = new OrderBean(24750, orderDate53, "map789", 6824);
		Map<String, OrderBean> obm = new HashMap<String, OrderBean>();
		obm.put("obmKey1", ob7);
		obm.put("obmKey2", ob8);
		obm.put("obmKey3", ob9);
		request.setAttribute("Case6", obm);
		RequestDispatcher rd = request.getRequestDispatcher("/jsp/ch05/ELDemo.jsp");
		rd.forward(request, response);
		return;
	}
}
