package com.seesawin.demo.ch10.date.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.seesawin.demo.ch10.date.dao.DateDAO;
import com.seesawin.demo.ch10.date.dao.impl.DateDAOImpl;
import com.seesawin.demo.ch10.date.model.DateBean;
import com.seesawin.demo.ch10.date.service.DateService;

public class DateServiceImpl implements DateService {

	@Override
	public List<DateBean> selectAll() throws SQLException, Exception {
		DateDAO dao = new DateDAOImpl();
		return dao.selectAll();
	}

	@Override
	public DateBean selectByPrimaryKey(String dYear4) throws SQLException, Exception {
		DateDAO dao = new DateDAOImpl();
		return dao.selectByPrimaryKey(dYear4);
	}

	@Override
	public int insert(DateBean record) throws SQLException, Exception {
		DateDAO dao = new DateDAOImpl();
		return dao.insert(record);
	}

	@Override
	public int insertSelective(DateBean record) throws SQLException, Exception {
		DateDAO dao = new DateDAOImpl();
		return dao.insertSelective(record);
	}

	@Override
	public int updateByPrimaryKeySelective(DateBean record) throws SQLException, Exception {
		DateDAO dao = new DateDAOImpl();
		return dao.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(DateBean record) throws SQLException, Exception {
		DateDAO dao = new DateDAOImpl();
		return dao.updateByPrimaryKey(record);
	}

	@Override
	public int deleteByPrimaryKey(String dYear4) throws SQLException, Exception {
		DateDAO dao = new DateDAOImpl();
		return dao.deleteByPrimaryKey(dYear4);
	}

}
