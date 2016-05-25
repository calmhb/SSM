package com.cl.easybuy.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.cl.easybuy.dao.UserDao;
import com.cl.easybuy.pojo.User;
import com.cl.easybuy.util.ConnectionUtils;

/**
 * 实现操作用户表的规则
 * 
 * @author hb
 * 
 * @date 2015年9月7日 下午2:39:57
 */
public class UserDaoImpl implements UserDao {

	@Override
	public User findUser(String username, String pwd) {
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;

		User u = null;

		try {
			conn = ConnectionUtils.getConnection();
			final String sql = "select id,username,pwd,pro from cl_user where username=? and pwd=?";
			pstm = conn.prepareStatement(sql);
			// 绑定数据
			pstm.setString(1, username);
			pstm.setString(2, pwd);
			// 执行SQL语句
			rs = pstm.executeQuery();
			if (rs.next()) {// 判断结果集中是否有数据
				u = new User();
				// 从结果集中获得数据
				u.setId(rs.getInt("id"));
				u.setUsername(rs.getString("username"));
				u.setPwd(rs.getString("pwd"));
				u.setPro(rs.getInt("pro"));
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			// 释放功能
			ConnectionUtils.close(conn, pstm, null);
		}
		return u;
	}

	@Override
	public void addUser(User user) {
		// 1.获得Connection对象
		Connection conn = null;
		// 2.预处理对象
		PreparedStatement pstm = null;
		try {

			conn = ConnectionUtils.getConnection();
			// 3.封装SQL语句
			final String sql = "insert into cl_user(id,username,pwd,pro) values(cl_user_seq.nextval,?,?,?)";
			// 4.获得pstm
			pstm = conn.prepareStatement(sql);
			// 为占位符?绑定数据
			pstm.setString(1, user.getUsername());
			pstm.setString(2, user.getPwd());
			pstm.setInt(3, user.getPro());
			// 执行SQL语句
			pstm.executeUpdate();
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			// 释放功能
			ConnectionUtils.close(conn, pstm, null);
		}
	}

}
