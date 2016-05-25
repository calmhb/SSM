package com.cl.easybuy.biz;

import com.cl.easybuy.pojo.User;

/**
 * 实现用户的业务逻辑
 * 
 * @author hb
 * 
 * @date 2015年9月8日 上午8:51:09
 */
public interface UserBiz {
	/**
	 * 实现登录的逻辑
	 * 
	 * @param username
	 * @param pwd
	 * @return
	 */
	public User login(String username, String pwd);

	/**
	 * 实现注册的逻辑
	 * 
	 * @param user
	 */
	public void regist(User user);
}
