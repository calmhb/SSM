package com.hb.mybatis.biz;

import java.util.List;

import com.hb.mybatis.entity.User;

/**
 * 用户业务层的实现
 * 
 * @author hb
 *
 * @date 2016年5月23日 上午11:21:17
 */
public interface UserBiz {
	public int addUser(User u);

	public int modifyUser(User u);

	public List<User> findUsers();

	public int countUser();

	public User findUserByName(String name);

	public User login(User u);

	public User findUserAndOrders(int uid);
}
