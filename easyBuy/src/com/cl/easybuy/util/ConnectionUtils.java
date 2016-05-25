package com.cl.easybuy.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 获得与数据库的连接
 * 
 * @author calm
 * 
 */
public class ConnectionUtils {
	// 驱动
	private static final String driverClass = "oracle.jdbc.OracleDriver";
	// 用户名
	private static String username = "scott";
	// 密码
	private static String pwd = "tiger";
	// url
	private static String url = "jdbc:oracle:thin:@localhost:1521:XE";
	/**
	 * 静态代码库,在类加载时执行
	 */
	static {
		// 注册驱动
		try {
			Class.forName(driverClass);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 工具方法,获得与数据库的连接
	 * 
	 * @return java.sql.Connection
	 */
	public static Connection getConnection() {
		Connection conn = null;

		try {
			conn = DriverManager.getConnection(url, username, pwd);
		} catch (SQLException e) {
			// 如果出现异常,将异常抛给调用者
			throw new RuntimeException(e);
		}

		return conn;
	}

	/**
	 * 
	 * 提供释放物理资源的工具方法
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
