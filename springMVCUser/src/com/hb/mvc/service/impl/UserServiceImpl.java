package com.hb.mvc.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hb.mvc.dao.UserDao;
import com.hb.mvc.exception.NameOrPwdException;
import com.hb.mvc.exception.NullParamException;
import com.hb.mvc.pojo.User;
import com.hb.mvc.service.UserService;

/** ҵ���ע�� */
@Service("userService")
public class UserServiceImpl implements UserService {
	private UserDao userDao;// �ṩgetter��setter����

	public UserDao getUserDao() {
		return userDao;
	}

	// �Զ�ƥ��userDao����ע��
	@Resource(name = "userDao")
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public User login(String name, String pwd) throws NameOrPwdException,
			NullParamException {
		if (name == null || name.equals("") || pwd == null || pwd.equals("")) {
			throw new NullParamException("��¼��������Ϊ��!");
		}
		User user = userDao.findByName(name);
		if (user != null && pwd.equals(user.getPwd())) {
			return user;
		}
		throw new NameOrPwdException("�û��������������!");
	}

}
