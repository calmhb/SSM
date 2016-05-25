package com.cl.easybuy.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.cl.easybuy.dao.UserDao;
import com.cl.easybuy.pojo.User;
import com.cl.easybuy.util.ConnectionUtils;

/**
 * ʵ�ֲ����û���Ĺ���
 * 
 * @author hb
 * 
 * @date 2015��9��7�� ����2:39:57
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
			// ������
			pstm.setString(1, username);
			pstm.setString(2, pwd);
			// ִ��SQL���
			rs = pstm.executeQuery();
			if (rs.next()) {// �жϽ�������Ƿ�������
				u = new User();
				// �ӽ�����л������
				u.setId(rs.getInt("id"));
				u.setUsername(rs.getString("username"));
				u.setPwd(rs.getString("pwd"));
				u.setPro(rs.getInt("pro"));
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			// �ͷŹ���
			ConnectionUtils.close(conn, pstm, null);
		}
		return u;
	}

	@Override
	public void addUser(User user) {
		// 1.���Connection����
		Connection conn = null;
		// 2.Ԥ�������
		PreparedStatement pstm = null;
		try {

			conn = ConnectionUtils.getConnection();
			// 3.��װSQL���
			final String sql = "insert into cl_user(id,username,pwd,pro) values(cl_user_seq.nextval,?,?,?)";
			// 4.���pstm
			pstm = conn.prepareStatement(sql);
			// Ϊռλ��?������
			pstm.setString(1, user.getUsername());
			pstm.setString(2, user.getPwd());
			pstm.setInt(3, user.getPro());
			// ִ��SQL���
			pstm.executeUpdate();
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			// �ͷŹ���
			ConnectionUtils.close(conn, pstm, null);
		}
	}

}
