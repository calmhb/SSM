package com.hb.mvc.dao;

import com.hb.mvc.pojo.User;

public interface UserDao {

	/** ����Ψһ�û�����ѯϵͳ�û�, ���û���ҵ��û���Ϣ����null */
	public User findByName(String name);
	// public User add(String name, String pwd, String phone);
	// public User find(int id);
	// public User delete(int id);
	// public void update(User user);
}
