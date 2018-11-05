package com.seesawin.demo.util;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class ConnectionDB {

	/**
	 * get DataSource from JNDI
	 */
	public static Connection getConnection(String dsName) {
		DataSource ds = null;
		Connection conn = null;
		try {
			Context initContext;
			Context ctx;
			try {
				initContext = new InitialContext();
			} catch (NamingException ne) {
				throw new RuntimeException("naming Exception");
			}
			try {
				ctx = (Context) initContext.lookup("java:/comp/env");
			} catch (NamingException ne) {
				throw new RuntimeException("naming Exception");
			}
			if (ctx == null) {
				throw new RuntimeException("JNDI Context could not be found");
			} else {
				System.out.println("JNDI Context succss");
			}
			try {
				ds = (DataSource) ctx.lookup(dsName);
			} catch (NamingException ne) {
				throw new RuntimeException("get datasorce naming exception");
			}
			if (ds == null) {
				throw new RuntimeException("Datasource could not be found");
			} else {
				System.out.println("Datasource succss");
			}
			conn = ds.getConnection();

			return conn;
		} catch (SQLException se) {
			System.out.println("connection failure " + se.getMessage());
			throw new RuntimeException(se.getMessage());
		}
	}

	/**
	 * get DataSource from JDBC
	 */
	public static Connection getConnection(String dbURL, String dbUid, String dbPwd) {
		Connection conn = null;

		try {
			try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (Exception ex) {
				System.out.println("Load JDBC driver failure");
			}
			conn = DriverManager.getConnection(dbURL, dbUid, dbPwd);
		} catch (Exception e) {
			System.out.println("JDBC URL error " + e.getMessage());
		}
		return conn;
	}

	/**
	 * close Connection
	 */
	public static void closeJDBCConnection(final Connection conn) {
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException ex) {
				// logger.error(ex) ;
			}
		}
	}

	/**
	 * close Statement
	 */
	public static void closeStatement(final Statement stmt) {
		if (stmt != null) {
			try {
				stmt.close();
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
	}

	/**
	 * close PreparedStatement
	 */
	public static void closePreparedStatement(final PreparedStatement stmt) {
		if (stmt != null) {
			try {
				stmt.close();
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
	}

	/**
	 * close CallableStatement
	 */
	public static void closeCallableStatement(final CallableStatement stmt) {
		if (stmt != null) {
			try {
				stmt.close();
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
	}

	/**
	 * close ResultSet
	 */
	public static void closeResultSet(final ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
	}

}
