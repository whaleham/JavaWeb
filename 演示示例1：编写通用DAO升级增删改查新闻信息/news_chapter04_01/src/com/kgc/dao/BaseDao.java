package com.kgc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BaseDao {
	protected Connection conn;
	protected PreparedStatement ps;
	protected Statement stmt;
	protected ResultSet rs;

	public boolean getConnection() {
		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://127.0.0.1:3306/kgcnews";
		String username = "root";
		String password = "bdqn";
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, username, password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return false;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public int executeUpdate(String sql, Object[] params) {
		int updateRows = 0;
		if(getConnection()){
			try {
				ps=conn.prepareStatement(sql);
				for(int i=0;i<params.length;i++){
					ps.setObject(i+1, params[i]);
				}
				updateRows=ps.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return updateRows;
	}

	// ��ѯ
	public ResultSet executeSQL(String sql,Object[] params) {
		if(getConnection()){
			try {
				ps=conn.prepareStatement(sql);
				//���ռλ��
				for(int i=0;i<params.length;i++){
					ps.setObject(i+1, params[i]);
				}
				rs=ps.executeQuery();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return rs;
	}

	// �ر���Դ
	public boolean closeResource() {
		if(rs!=null){
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
				return false;
			}
		}
		if(ps!=null){
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
				return false;
			}
		}
		if(stmt!=null){
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
				return false;
			}
		}
		if(conn!=null){
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
				return false;
			}
		}
		return true;
	}

}
