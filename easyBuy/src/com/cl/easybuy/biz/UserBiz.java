package com.cl.easybuy.biz;

import com.cl.easybuy.pojo.User;

/**
 * ʵ���û���ҵ���߼�
 * 
 * @author hb
 * 
 * @date 2015��9��8�� ����8:51:09
 */
public interface UserBiz {
	/**
	 * ʵ�ֵ�¼���߼�
	 * 
	 * @param username
	 * @param pwd
	 * @return
	 */
	public User login(String username, String pwd);

	/**
	 * ʵ��ע����߼�
	 * 
	 * @param user
	 */
	public void regist(User user);
}
