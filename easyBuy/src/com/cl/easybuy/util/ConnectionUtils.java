package com.cl.easybuy.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * ��������ݿ������
 * 
 * @author calm
 * 
 */
public class ConnectionUtils {
	// ����
	private static final String driverClass = "oracle.jdbc.OracleDriver";
	// �û���
	private static String username = "scott";
	// ����
	private static String pwd = "tiger";
	// url
	private static String url = "jdbc:oracle:thin:@localhost:1521:XE";
	/**
	 * ��̬�����,�������ʱִ��
	 */
	static {
		// ע������
		try {
			Class.forName(driverClass);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * ���߷���,��������ݿ������
	 * 
	 * @return java.sql.Connection
	 */
	public static Connection getConnection() {
		Connection conn = null;

		try {
			conn = DriverManager.getConnection(url, username, pwd);
		} catch (SQLException e) {
			// ��������쳣,���쳣�׸�������
			throw new RuntimeException(e);
		}

		return conn;
	}

	/**
	 * 
	 * �ṩ�ͷ�������Դ�Ĺ��߷���
	 * 
	 * @param conn
	 * @param pstm
	 * @param rs
	 */
	public static void close(Connection conn, Statement pstm, ResultSet rs) {
		try {

			if (conn != null) {
				conn.close();
			}
			if (pstm != null) {
				pstm.close();
			}
			if (rs != null) {
				rs.close();
			}

		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public static void main(String[] args) {
		System.out.println(getConnection());
	}
}
