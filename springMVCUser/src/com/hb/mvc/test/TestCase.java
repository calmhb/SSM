package com.hb.mvc.test;

import java.util.Arrays;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hb.mvc.pojo.User;
import com.hb.mvc.service.UserService;
import com.hb.mvc.service.impl.UserServiceImpl;
import com.hb.mvc.util.JdbcDataSource;

public class TestCase {

	@Ignore
	@Test
	public void testConnection() throws Exception {
		ApplicationContext ac = new ClassPathXmlApplicationContext(
				"spring-mvc.xml");
		System.out.println(Arrays.toString(ac.getBeanDefinitionNames()));
		JdbcDataSource ds = ac.getBean("jdbcDataSource", JdbcDataSource.class);
		// System.out.println(ds.getConnection());
		System.out.println(ds.getConnection());
	}

	@Test
	public void testService() throws Exception {
		ApplicationContext ac = new ClassPathXmlApplicationContext(
				"spring-mvc.xml");
		UserService service = ac.getBean("userService", UserServiceImpl.class);
		User u=service.login("haoren", "250");
		System.out.println(u);
	}
}
