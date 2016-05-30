package com.hb.mvc.service;

import com.hb.mvc.exception.NameOrPwdException;
import com.hb.mvc.exception.NullParamException;
import com.hb.mvc.pojo.User;

/** ҵ���߼� */
public interface UserService {

	public User login(String name, String pwd) throws NameOrPwdException,
			NullParamException;

}
