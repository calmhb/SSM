/**
 * 
 */
package com.hb.mybatis.test;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import com.hb.mybatis.dao.UserDao;
import com.hb.mybatis.dao.impl.UserDaoImpl;
import com.hb.mybatis.entity.Order;
import com.hb.mybatis.entity.User;

/**
 * 
 * @author hb
 *
 * @date 2016年5月18日 上午11:30:38
 */
public class UserDaoTest {
	@Ignore
	@Test
	public void testCount() {
		UserDao userDao = new UserDaoImpl();
		int count = userDao.count();
		System.out.println(count);

	}

	@Ignore
	@Test
	public void findAll() {
		UserDao userDao = new UserDaoImpl();
		List<User> users = userDao.findAll();
		for (User user : users) {
			System.out.println(user.getName());
		}
		System.out.println(users.size());

	}

	@Ignore
	@Test
	public void updateUser() {
		User u = new User();
		u.setId(1016);
		u.setName("lily");

		UserDao userDao = new UserDaoImpl();
		userDao.updateUser(u);
	}

	@Ignore
	@Test
	public void findByName() {
		UserDao userDao = new UserDaoImpl();
		User u = userDao.findByName("haoren");
		System.out.println(u.getPwd());
	}

	@Ignore
	@Test
	public void findByUser() {
		UserDao userDao = new UserDaoImpl();
		User u = new User();
		u.setName("haoren");
		u.setPwd("250");
		User user = userDao.findByNameAndPwd(u);
		System.out.println(user.getPower());

	}

	@Ignore
	@Test
	public void addUser() {
		User u = new User();
		u.setName("betterMan7");
		u.setPwd("250");
		u.setPower("普通用户");

		UserDao userDao = new UserDaoImpl();
		int d = userDao.inserUser(u);
		System.out.println(d);

	}

	@Test
	public void findList() {
		UserDao userDao = new UserDaoImpl();
		User u = userDao.cascadeByUid(1001);
		System.out.println(u.getOrders());
		System.out.println(u.getName());
		System.out.println(u.getId());
		List<Order> orders = u.getOrders();

		for (Order o : orders) {
			System.out.println(o.getId());
			System.out.println(o.getUser());
		}

	}
}
