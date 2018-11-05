package com.seesawin.demo.ch10.date.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.seesawin.demo.ch10.date.dao.DateDAO;
import com.seesawin.demo.ch10.date.model.DateBean;
import com.seesawin.demo.util.ConnectionDB;

public class DateDAOImpl implements DateDAO {

	@Override
	public List<DateBean> selectAll() throws SQLException, Exception {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<DateBean> beans = null;

		try {
			conn = ConnectionDB.getConnection("frankDS");

			String SELECT_ALL = "select * from TB_DATE";
			ps = conn.prepareStatement(SELECT_ALL);
			rs = ps.executeQuery();

			beans = getBeans(rs);

		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			ConnectionDB.closeJDBCConnection(conn);
			ConnectionDB.closePreparedStatement(ps);
			ConnectionDB.closeResultSet(rs);
		}
		return beans;
	}

	@Override
	public DateBean selectByPrimaryKey(String dYear4) throws SQLException, Exception {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<DateBean> beans = null;

		try {
			conn = ConnectionDB.getConnection("frankDS");

			String SELECT_BY_PK = "select * from TB_DATE where d_year_4 = ?";
			ps = conn.prepareStatement(SELECT_BY_PK);
			if (dYear4 != null) {
				ps.setString(1, dYear4);
			} else {
				throw new Exception("must inupt dYear4!");
			}
			rs = ps.executeQuery();

			beans = getBeans(rs);

		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			ConnectionDB.closeJDBCConnection(conn);
			ConnectionDB.closePreparedStatement(ps);
			ConnectionDB.closeResultSet(rs);
		}
		return (beans != null && !beans.isEmpty()) ? beans.get(0) : null;
	}

	@Override
	public int insert(DateBean record) throws SQLException, Exception {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int count = 0;

		try {
			conn = ConnectionDB.getConnection("frankDS");

			String INSERT = "insert into TB_DATE values ( ?, ?, ?, ?, ?)";
			ps = conn.prepareStatement(INSERT);
			if (record.getdYear4() != null) {
				ps.setString(1, record.getdYear4());
			} else {
				throw new Exception("must inupt dYear4!");
			}
			ps.setDate(2, new java.sql.Date(record.getdDate().getTime()));
			ps.setTime(3, new java.sql.Time(record.getdTime().getTime()));
			ps.setTimestamp(4, new java.sql.Timestamp(record.getdDatetime().getTime()));
			ps.setTimestamp(5, new java.sql.Timestamp(record.getdTimestamp().getTime()));

			count = ps.executeUpdate();
			System.out.println("insert count : " + count);

		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			ConnectionDB.closeJDBCConnection(conn);
			ConnectionDB.closePreparedStatement(ps);
			ConnectionDB.closeResultSet(rs);
		}
		return count;
	}

	@Override
	public int insertSelective(DateBean record) throws SQLException, Exception {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int count = 0;

		try {
			conn = ConnectionDB.getConnection("frankDS");

			String INSERT = "insert into TB_DATE values ( ?, ?, ?, ?, ?)";
			ps = conn.prepareStatement(INSERT);
			if (record.getdYear4() != null) {
				ps.setString(1, record.getdYear4());
			} else {
				throw new Exception("must inupt dYear4!");
			}
			if (record.getdDate() != null) {
				ps.setDate(2, new java.sql.Date(record.getdDate().getTime()));
			}
			if (record.getdTime() != null) {
				ps.setTime(3, new java.sql.Time(record.getdTime().getTime()));
			}
			if (record.getdDatetime() != null) {
				ps.setTimestamp(4, new java.sql.Timestamp(record.getdDatetime().getTime()));
			}
			if (record.getdTimestamp() != null) {
				ps.setTimestamp(5, new java.sql.Timestamp(record.getdTimestamp().getTime()));
			}

			count = ps.executeUpdate();
			System.out.println("insert count : " + count);

		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			ConnectionDB.closeJDBCConnection(conn);
			ConnectionDB.closePreparedStatement(ps);
			ConnectionDB.closeResultSet(rs);
		}
		return count;
	}

	@Override
	public int updateByPrimaryKeySelective(DateBean record) throws SQLException, Exception {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int count = 0;

		try {
			conn = ConnectionDB.getConnection("frankDS");

			String UPDATE = "update TB_DATE set d_date = ?, d_time = ?, d_datetime = ?, d_timestamp = ?" + "where d_year_4 = ?";
			ps = conn.prepareStatement(UPDATE);
			if (record.getdYear4() != null) {
				ps.setString(5, record.getdYear4());
			} else {
				throw new Exception("must inupt dYear4!");
			}
			if (record.getdDate() != null) {
				ps.setDate(1, new java.sql.Date(record.getdDate().getTime()));
			}
			if (record.getdTime() != null) {
				ps.setTime(2, new java.sql.Time(record.getdTime().getTime()));
			}
			if (record.getdDatetime() != null) {
				ps.setTimestamp(3, new java.sql.Timestamp(record.getdDatetime().getTime()));
			}
			if (record.getdTimestamp() != null) {
				ps.setTimestamp(4, new java.sql.Timestamp(record.getdTimestamp().getTime()));
			}

			count = ps.executeUpdate();
			System.out.println("update count : " + count);

		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			ConnectionDB.closeJDBCConnection(conn);
			ConnectionDB.closePreparedStatement(ps);
			ConnectionDB.closeResultSet(rs);
		}
		return count;
	}

	@Override
	public int updateByPrimaryKey(DateBean record) throws SQLException, Exception {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int count = 0;

		try {
			conn = ConnectionDB.getConnection("frankDS");

			String UPDATE = "update TB_DATE set d_date = ?, d_time = ?, d_datetime = ?, d_timestamp = ?" + "where d_year_4 = ?";
			ps = conn.prepareStatement(UPDATE);
			if (record.getdYear4() != null) {
				ps.setString(5, record.getdYear4());
			} else {
				throw new Exception("must inupt dYear4!");
			}
			ps.setDate(1, new java.sql.Date(record.getdDate().getTime()));
			ps.setTime(2, new java.sql.Time(record.getdTime().getTime()));
			ps.setTimestamp(3, new java.sql.Timestamp(record.getdDatetime().getTime()));
			ps.setTimestamp(4, new java.sql.Timestamp(record.getdTimestamp().getTime()));

			count = ps.executeUpdate();
			System.out.println("update count : " + count);

		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			ConnectionDB.closeJDBCConnection(conn);
			ConnectionDB.closePreparedStatement(ps);
			ConnectionDB.closeResultSet(rs);
		}
		return count;
	}

	@Override
	public int deleteByPrimaryKey(String dYear4) throws SQLException, Exception {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int count = 0;

		try {
			conn = ConnectionDB.getConnection("frankDS");

			String DELETE = "delete from TB_DATE where d_year_4 = ?";
			ps = conn.prepareStatement(DELETE);
			if (dYear4 != null) {
				ps.setString(1, dYear4);
			} else {
				throw new Exception("must inupt dYear4!");
			}

			count = ps.executeUpdate();
			System.out.println("delete count : " + count);

		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			ConnectionDB.closeJDBCConnection(conn);
			ConnectionDB.closePreparedStatement(ps);
			ConnectionDB.closeResultSet(rs);
		}
		return count;
	}

	public static List<DateBean> getBeans(ResultSet rs) throws SQLException {
		int count = 0;
		List<DateBean> resultList = new ArrayList<DateBean>();
		while (rs.next()) {
			DateBean beam = new DateBean();
			beam.setdYear4(rs.getString("d_year_4"));
			beam.setdDate(rs.getDate("d_date"));
			beam.setdTime(rs.getTime("d_time"));
			beam.setdTimestamp(rs.getTimestamp("d_datetime"));
			beam.setdDatetime(rs.getTimestamp("d_timestamp"));

			System.out.println((++count) + ". " + beam.toString());

			resultList.add(beam);
		}
		return resultList;
	}
}
