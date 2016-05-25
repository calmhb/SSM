/**
 * 
 */
package com.hb.mybatis.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.hb.mybatis.dao.UserDao;
import com.hb.mybatis.entity.Order;
import com.hb.mybatis.entity.User;
import com.hb.mybatis.utils.SqlSessionUtils;

/**
 * 
 * @author hb
 *
 * @date 2016年5月18日 上午11:28:35
 */
public class UserDaoImpl implements UserDao {

	public int inserUser(User u) {
		// session的事务默认是手动提交
		SqlSession session = SqlSessionUtils.openSession();
		int id = -1;
		try {
			UserDao userDao = session.getMapper(UserDao.class);
			userDao.inserUser(u);// 将游离状态的数据转成持久状态
			id = u.getId();// 获得返回的主键值
			session.commit();
		} catch (Exception e) {
			session.rollback();
			throw new RuntimeException(e);
		} finally {
			session.close();
		}

		return id;

	}

	@Override
	public int updateUser(User u) {
		SqlSession session = SqlSessionUtils.openSession();
		int change = -1;
		try {
			UserDao userDao = session.getMapper(UserDao.class);
			change = userDao.updateUser(u);
			session.commit();
		} catch (Exception e) {
			session.rollback();
			throw new RuntimeException(e);
		} finally {
			session.close();
		}
		return change;
	}

	@Override
	public List<User> findAll() {
		SqlSession session = SqlSessionUtils.openSession();
		List<User> users = null;
		try {
			UserDao userDao = session.getMapper(UserDao.class);
			users = userDao.findAll();
		} finally {
			session.close();
		}
		return users;
	}

	public int count() {

		SqlSession session = SqlSessionUtils.openSession();
		int count = -1;
		try {
			UserDao userDao = session.getMapper(UserDao.class);
			System.out.println(userDao);
			count = userDao.count();
		} finally {
			session.close();
		}

		return count;
	}

	public User findByName(String name) {
		SqlSession session = SqlSessionUtils.openSession();
		User user = null;
		try {
			UserDao userDao = session.getMapper(UserDao.class);
			user = userDao.findByName(name);
		} finally {
			session.close();
		}

		return user;
	}

	@Override
	public User findByNameAndPwd(User u) {
		SqlSession session = SqlSessionUtils.openSession();
		User user = null;
		try {
			UserDao userDao = session.getMapper(UserDao.class);
			user = userDao.findByNameAndPwd(u);
		} finally {
			session.close();
		}

		return user;
	}

 	public User cascadeByUid(int uid) {
		SqlSession session = SqlSessionUtils.openSession();
		User u = null;
		try {
			UserDao userDao = session.getMapper(UserDao.class);
			u = userDao.cascadeByUid(uid);
		} finally {
			session.close();
		}

		return u;
	}
 }
