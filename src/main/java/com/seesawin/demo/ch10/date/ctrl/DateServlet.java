package com.seesawin.demo.ch10.date.ctrl;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.seesawin.demo.ch10.date.model.DateBean;
import com.seesawin.demo.ch10.date.service.DateService;
import com.seesawin.demo.ch10.date.service.impl.DateServiceImpl;
import com.seesawin.demo.util.DateUtil;

@WebServlet("/ch10/date")
public class DateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}

	protected void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String action = request.getParameter("action");

		if ("init".equals(action)) {
			RequestDispatcher rd = request.getRequestDispatcher("/jsp/ch10/ch10_date_index.jsp");
			rd.forward(request, response);
			return;
		}
		if ("selectAll".equals(action)) {
			this.selectAll(request, response);
		}
		if ("selectOne".equals(action)) {
			this.selectOne(request, response);
		}
		if ("insert".equals(action)) {
			this.insert(request, response);
		}
		if ("update".equals(action)) {
			this.update(request, response);
		}
		if ("delete".equals(action)) {
			this.delete(request, response);
		}

		// other method depending on you business logic...
	}

	private void selectAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DateService service = new DateServiceImpl();
		List<DateBean> beans = null;
		String errCde = "00";
		String errMsg = "";

		try {
			beans = service.selectAll();

			if (beans == null || beans.isEmpty()) {
				errCde = "01";
				errMsg = "No data!";
			}

			// set query result to requesetScope
			request.setAttribute("beans", beans);
		} catch (Exception e) {
			e.printStackTrace();

			// error handling...
			errCde = "01";
			errMsg = "Error : " + e.getMessage();
		}

		request.setAttribute("errCde", errCde);
		request.setAttribute("errMsg", errMsg);

		RequestDispatcher rd = request.getRequestDispatcher("/jsp/ch10/ch10_date_selectAll.jsp");
		rd.forward(request, response);
		return;
	}

	private void selectOne(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DateService service = new DateServiceImpl();
		DateBean bean = null;
		String errCde = "00";
		String errMsg = "";
		String dYear4 = request.getParameter("dYear4");

		try {
			if (dYear4 == null || dYear4.isEmpty()) {
				throw new Exception("must inupt dYear4!");
			}
			bean = service.selectByPrimaryKey(dYear4);

			if (bean == null) {
				errCde = "01";
				errMsg = "No data!";
			}

			// set query result to requesetScope
			request.setAttribute("bean", bean);
		} catch (Exception e) {
			e.printStackTrace();

			// error handling...
			errCde = "01";
			errMsg = "Error : " + e.getMessage();
		}

		request.setAttribute("errCde", errCde);
		request.setAttribute("errMsg", errMsg);
		request.setAttribute("dYear4", dYear4);

		RequestDispatcher rd = request.getRequestDispatcher("/jsp/ch10/ch10_date_selectOne.jsp");
		rd.forward(request, response);
	}

	private void insert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DateService service = new DateServiceImpl();
		int count = 0;
		String errCde = "00";
		String errMsg = "";
		String dYear4 = request.getParameter("dYear4");
		String dDate = request.getParameter("dDate");
		Date sysDate = new Date();
		DateBean bean = null;
		String view = "/jsp/ch10/ch10_date_selectOne.jsp";

		try {
			DateBean record = new DateBean();
			if (dYear4 != null && !dYear4.isEmpty()) {
				record.setdYear4(dYear4.substring(0, 4));
			} else {
				throw new Exception("must inupt dYear4!");
			}
			if (dDate != null && !dDate.isEmpty()) {
				record.setdDate(DateUtil.getUtilDateFromString(dDate, "yyyy-MM-dd"));
			}
			record.setdTime(new java.sql.Time(sysDate.getTime()));
			record.setdTimestamp(new java.sql.Timestamp(sysDate.getTime()));
			record.setdDatetime(new java.sql.Timestamp(sysDate.getTime()));

			count = service.insertSelective(record);
			if (count != 1) {
				throw new Exception("error count : " + count + " when inserting!");
			} else {
				errCde = "00";
				errMsg = "insert success!";
			}

			bean = service.selectByPrimaryKey(dYear4);

			// set query result to requesetScope
			request.setAttribute("bean", bean);

		} catch (Exception e) {
			e.printStackTrace();

			// error handling...
			errCde = "01";
			errMsg = "Error : " + e.getMessage();
			view = "/jsp/ch10/ch10_date_insert.jsp";
		}

		request.setAttribute("errCde", errCde);
		request.setAttribute("errMsg", errMsg);
		request.setAttribute("dYear4", dYear4);

		RequestDispatcher rd = request.getRequestDispatcher(view);
		rd.forward(request, response);
	}

	private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DateService service = new DateServiceImpl();
		int count = 0;
		String errCde = "00";
		String errMsg = "";
		String dYear4 = request.getParameter("dYear4");
		String dDate = request.getParameter("dDate");
		String updateAction = request.getParameter("updateAction");
		Date sysDate = new Date();
		DateBean bean = null;
		String view = null;
		DateBean record = new DateBean();
		
		try {
			if ("updateInit".equals(updateAction)) {
				view = "/jsp/ch10/ch10_date_update.jsp";

				if (dYear4 == null || dYear4.isEmpty()) {
					throw new Exception("must inupt dYear4!");
				}

				bean = service.selectByPrimaryKey(dYear4);

				if (bean == null) {
					errCde = "01";
					errMsg = "No data!";
				}
				
				// set query result to requesetScope
				request.setAttribute("bean", bean);

			} else if ("updateData".equals(updateAction)) {
				view = "/jsp/ch10/ch10_date_selectOne.jsp";

				if (dYear4 != null && !dYear4.isEmpty()) {
					record.setdYear4(dYear4.substring(0, 4));
				} else {
					throw new Exception("must inupt dYear4!");
				}
				if (dDate != null && !dDate.isEmpty()) {
					record.setdDate(DateUtil.getUtilDateFromString(dDate, "yyyy-MM-dd"));
				}
				record.setdTime(new java.sql.Time(sysDate.getTime()));
				record.setdTimestamp(new java.sql.Timestamp(sysDate.getTime()));
				record.setdDatetime(new java.sql.Timestamp(sysDate.getTime()));

				count = service.updateByPrimaryKey(record);
				if (count != 1) {
					throw new Exception("error count : " + count + " when updating!");
				} else {
					errCde = "00";
					errMsg = "update success!";
				}

				bean = service.selectByPrimaryKey(dYear4);
				
				// set query result to requesetScope
				request.setAttribute("bean", bean);
			}
		} catch (Exception e) {
			System.out.println(">>>>>>>>>>>>>>>> error!!!");
			e.printStackTrace();

			// error handling...
			errCde = "01";
			errMsg = "Error : " + e.getMessage();
			view = "/jsp/ch10/ch10_date_update.jsp";
			
			// set original result to requesetScope
			request.setAttribute("bean", record);
		}

		request.setAttribute("errCde", errCde);
		request.setAttribute("errMsg", errMsg);
		request.setAttribute("dYear4", dYear4);

		RequestDispatcher rd = request.getRequestDispatcher(view);
		rd.forward(request, response);
	}

	private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DateService service = new DateServiceImpl();
		int count = 0;
		String errCde = "00";
		String errMsg = "";
		List<DateBean> beans = null;

		try {
			String dYear4 = request.getParameter("dYear4");
			if (dYear4 == null || dYear4.isEmpty()) {
				throw new Exception("must inupt dYear4!");
			}

			count = service.deleteByPrimaryKey(dYear4);
			if (count != 1) {
				throw new Exception("error count : " + count + " when deleting!");
			}

			beans = service.selectAll();

			if (beans == null || beans.isEmpty()) {
				errCde = "01";
				errMsg = "No data!";
			}

			// set query result to requesetScope
			request.setAttribute("beans", beans);
		} catch (Exception e) {
			e.printStackTrace();

			// error handling...
			errCde = "01";
			errMsg = "Error : " + e.getMessage();
		}

		request.setAttribute("errCde", errCde);
		request.setAttribute("errMsg", errMsg);

		RequestDispatcher rd = request.getRequestDispatcher("/jsp/ch10/ch10_date_selectAll.jsp");
		rd.forward(request, response);
	}
}
