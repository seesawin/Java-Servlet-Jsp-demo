package com.seesawin.demo.ch10.nubmer.dao;

import java.util.List;

import com.seesawin.demo.ch10.nubmer.model.NumberBean;

public interface NumberDAO {
	/*
	 * select all NumberBean
	 * 
	 * */
	List<NumberBean> selectAll();

	/*
	 * select NumberBean by PK
	 * 
	 * */
	NumberBean selectByPrimaryKey(Byte nTiny);

	/*
	 * insert NumberBean
	 * 
	 * */
	int insert(NumberBean record);

	/*
	 * insert NumberBean selective
	 * 
	 * */
	int insertSelective(NumberBean record);

	/*
	 * update NumberBean selective by PK
	 * 
	 * */
	int updateByPrimaryKeySelective(NumberBean record);

	/*
	 * update NumberBean selective
	 * 
	 * */
	int updateByPrimaryKey(NumberBean record);

	/*
	 * delete NumberBean by PK
	 * 
	 * */
	int deleteByPrimaryKey(Byte nTiny);
}
