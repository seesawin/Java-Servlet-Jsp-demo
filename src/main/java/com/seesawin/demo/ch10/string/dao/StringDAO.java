package com.seesawin.demo.ch10.string.dao;

import java.util.List;

import com.seesawin.demo.ch10.string.model.StringBean;

public interface StringDAO {
	/*
	 * select all StringBean
	 */
	List<StringBean> selectAll();

	/*
	 * select StringBean by PK
	 */
	StringBean selectByPrimaryKey(String sNbChar);

	/*
	 * insert StringBean
	 */
	int insert(StringBean record);

	/*
	 * insert StringBean selective
	 */
	int insertSelective(StringBean record);

	/*
	 * update StringBean selective by PK
	 */
	int updateByPrimaryKeySelective(StringBean record);

	/*
	 * update StringBean selective
	 */
	int updateByPrimaryKey(StringBean record);

	/*
	 * delete StringBean by PK
	 */
	int deleteByPrimaryKey(String sNbChar);
}
