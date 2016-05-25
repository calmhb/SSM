package com.cl.easybuy.dao;

import com.cl.easybuy.pojo.User;

/**
 * 定义操作用户表的规则
 * 
 * @author calm
 * 
 */
public interface UserDao {
	/**
	 * 根据用户名和密码从数据库中查询对象
	 * 
	 * @param username
	 * @param pwd
	 * @return
	 */
	public User findUser(String username, String pwd);

	/**
	 * 表示添加用户(注册用户).保存到数据库中
	 * 
	 * @param user
	 */
	public void addUser(User user);
}
