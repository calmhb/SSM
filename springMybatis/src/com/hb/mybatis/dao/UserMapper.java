/**
 * 
 */
package com.hb.mybatis.dao;

import java.util.List;

import com.hb.mybatis.entity.User;

/**
 * 
 * @author hb
 *
 * @date 2016年5月18日 上午11:09:28
 */
public interface UserMapper {

	public int inserUser(User u);

	public int updateUser(User u);

	public List<User> findAll();

	public int count();

	public User findByName(String name);

	public User findByNameAndPwd(User u);

	public User cascadeByUid(int uid);

}
