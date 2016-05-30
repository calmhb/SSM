package com.hb.mvc.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hb.mvc.dao.UserDao;
import com.hb.mvc.exception.NameOrPwdException;
import com.hb.mvc.exception.NullParamException;
import com.hb.mvc.pojo.User;
import com.hb.mvc.service.UserService;

/** 业务层注解 */
@Service("userService")
public class UserServiceImpl implements UserService {
	private UserDao userDao;// 提供getter和setter方法

	public UserDao getUserDao() {
		return userDao;
	}

	// 自动匹配userDao对象并注入
	@Resource(name = "userDao")
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public User login(String name, String pwd) throws NameOrPwdException,
			NullParamException {
		if (name == null || name.equals("") || pwd == null || pwd.equals("")) {
			throw new NullParamException("登录参数不能为空!");
		}
		User user = userDao.findByName(name);
		if (user != null && pwd.equals(user.getPwd())) {
			return user;
		}
		throw new NameOrPwdException("用户名或者密码错误!");
	}

}
