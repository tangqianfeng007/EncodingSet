package com.encodingset.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;


/**
 *
 *@Author tangqianfeng 
 *@Version 1.0
 *
 */
public class DBTool {
	private static ThreadLocal<Connection> connectionLoacl = new ThreadLocal<Connection>();
	private static DBTool dbTool =null;
	private  DataSource dataSource =null;
	
	public static DBTool getInstance(){
		if(dbTool==null){
			dbTool = new DBTool(); 
		}
		return dbTool;
	}
	
	/**
	 * Jdbc
	 * 
	 * @return
	 */
	public Connection getJdbcConnection() throws Exception {
		Connection localConn = connectionLoacl.get();
		Connection con = null;
		if (localConn == null) {
			con = dataSource.getConnection();
			connectionLoacl.set(con);
		} else {
			con = localConn;
		}
		return con;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	public static void close(Connection conn, ResultSet rs, Statement st, PreparedStatement psmt) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		if (st != null) {
			try {
				st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (psmt != null) {
			try {
				psmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		try {
			if (conn != null && !conn.isClosed()) {
				try {
					connectionLoacl.remove();
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}

