package com.cl.easybuy.dao;

import com.cl.easybuy.pojo.User;

/**
 * ��������û���Ĺ���
 * 
 * @author calm
 * 
 */
public interface UserDao {
	/**
	 * �����û�������������ݿ��в�ѯ����
	 * 
	 * @param username
	 * @param pwd
	 * @return
	 */
	public User findUser(String username, String pwd);

	/**
	 * ��ʾ����û�(ע���û�).���浽���ݿ���
	 * 
	 * @param user
	 */
	public void addUser(User user);
}
