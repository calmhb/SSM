package com.hb.mvc.dao;

import com.hb.mvc.pojo.User;

public interface UserDao {

	/** 根据唯一用户名查询系统用户, 如果没有找到用户信息返回null */
	public User findByName(String name);
	// public User add(String name, String pwd, String phone);
	// public User find(int id);
	// public User delete(int id);
	// public void update(User user);
}
