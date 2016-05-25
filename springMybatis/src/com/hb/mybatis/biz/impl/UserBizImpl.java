package com.hb.mybatis.biz.impl;

import java.util.List;

import com.hb.mybatis.biz.UserBiz;
import com.hb.mybatis.dao.UserMapper;
import com.hb.mybatis.entity.User;

/**
 * 业务实现类
 * 
 * @author hb
 *
 * @date 2016年5月23日 上午11:26:19
 */
public class UserBizImpl implements UserBiz {
	private UserMapper userMapper;

	@Override
	public int addUser(User u) {
		return userMapper.inserUser(u);
	}

	@Override
	public int modifyUser(User u) {

		return userMapper.updateUser(u);
	}

	@Override
	public List<User> findUsers() {
		return userMapper.findAll();
	}

	@Override
	public int countUser() {

		return userMapper.count();
	}

	@Override
	public User findUserByName(String name) {

		return userMapper.findByName(name);
	}

	@Override
	public User login(User u) {

		return userMapper.findByNameAndPwd(u);
	}

	@Override
	public User findUserAndOrders(int uid) {

		return userMapper.cascadeByUid(uid);
	}

	public UserMapper getUserMapper() {
		return userMapper;
	}

	public void setUserMapper(UserMapper userMapper) {
		this.userMapper = userMapper;
	}

}
