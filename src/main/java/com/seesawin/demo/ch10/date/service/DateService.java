package com.seesawin.demo.ch10.date.service;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import com.seesawin.demo.ch10.date.model.DateBean;

public interface DateService {
	/*
	 * select all DateBeam
	 */
	List<DateBean> selectAll() throws SQLException, Exception;

	/*
	 * select DateBeam by PK
	 */
	DateBean selectByPrimaryKey(String dYear4) throws SQLException, Exception;

	/*
	 * insert DateBeam
	 */
	int insert(DateBean record) throws SQLException, Exception;

	/*
	 * insert DateBeam selective
	 */
	int insertSelective(DateBean record) throws SQLException, Exception;

	/*
	 * update DateBeam selective by PK
	 */
	int updateByPrimaryKeySelective(DateBean record) throws SQLException, Exception;

	/*
	 * update DateBeam selective
	 */
	int updateByPrimaryKey(DateBean record) throws SQLException, Exception;

	/*
	 * delete DateBeam by PK
	 */
	int deleteByPrimaryKey(String dYear4) throws SQLException, Exception;
}
