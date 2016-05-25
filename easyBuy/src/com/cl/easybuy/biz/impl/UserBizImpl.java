package com.cl.easybuy.biz.impl;

import com.cl.easybuy.biz.UserBiz;
import com.cl.easybuy.dao.UserDao;
import com.cl.easybuy.dao.impl.UserDaoImpl;
import com.cl.easybuy.pojo.User;

/**
 * 业务逻辑具体的实现
 * 
 * @author hb
 * 
 * @date 2015年9月8日 上午8:52:57
 */
public class UserBizImpl implements UserBiz {
	/**
	 * 使用简单工厂
	 */
	private UserDao userDao = new UserDaoImpl();

	@Override
	public User login(String username, String pwd) {
		User u = userDao.findUser(username, pwd);
		if (u == null) {// 如果用户为空,说明用户名和密码错误
			throw new RuntimeException("用户名或者密码错误!");
		}
		return u;
	}

	@Override
	public void regist(User user) {
		try {
			userDao.addUser(user);
		} catch (Exception e) {
			throw new RuntimeException("服务器异常!");
		}

	}

}
