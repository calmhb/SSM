package com.cl.easybuy.biz.impl;

import com.cl.easybuy.biz.UserBiz;
import com.cl.easybuy.dao.UserDao;
import com.cl.easybuy.dao.impl.UserDaoImpl;
import com.cl.easybuy.pojo.User;

/**
 * ҵ���߼������ʵ��
 * 
 * @author hb
 * 
 * @date 2015��9��8�� ����8:52:57
 */
public class UserBizImpl implements UserBiz {
	/**
	 * ʹ�ü򵥹���
	 */
	private UserDao userDao = new UserDaoImpl();

	@Override
	public User login(String username, String pwd) {
		User u = userDao.findUser(username, pwd);
		if (u == null) {// ����û�Ϊ��,˵���û������������
			throw new RuntimeException("�û��������������!");
		}
		return u;
	}

	@Override
	public void regist(User user) {
		try {
			userDao.addUser(user);
		} catch (Exception e) {
			throw new RuntimeException("�������쳣!");
		}

	}

}
