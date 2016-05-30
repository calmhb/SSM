package com.hb.mvc.dao.impl;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.hb.mvc.dao.UserDao;
import com.hb.mvc.pojo.User;
import com.hb.mvc.util.JdbcDataSource;
//�־ò�ע��
@Repository("userDao") //ָ���ض���bean id ����setUserDaoע��
public class UserDaoImpl implements UserDao, Serializable {
	private JdbcDataSource dataSource;

	public JdbcDataSource getDataSource() {
		return dataSource;
	}

	@Autowired // ���������Զ�װ��
	public void setDataSource(
			@Qualifier("jdbcDataSource") JdbcDataSource dataSource) {
		this.dataSource = dataSource;
	}

	public UserDaoImpl() {
	}

	/** ���� UserDaoImpl �������������JDBCDataSourceʵ�� */
	public UserDaoImpl(JdbcDataSource dataSource) {
		this.dataSource = dataSource;
	}

	/** ����Ψһ�û�����ѯϵͳ�û�, ���û���ҵ��û���Ϣ����null */
	public User findByName(String name) {
		System.out.println("����JDBC��������User��Ϣ");
		String sql = "select id, name, pwd, phone  from t_user where name=?";
		Connection conn = null;
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			ResultSet rs = ps.executeQuery();
			User user = null;
			while (rs.next()) {
				user = new User();
				user.setId(rs.getInt("id"));
				user.setName(rs.getString("name"));
				user.setPwd(rs.getString("pwd"));
				user.setPhone(rs.getString("phone"));
			}
			rs.close();
			ps.close();
			return user;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			dataSource.close(conn);
		}
	}

}
