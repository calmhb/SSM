package com.hb.mvc.test;

import java.util.Properties;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.ViewResolver;

public class TestCase {

	@Test
	public void testViewResolver() {
		ApplicationContext ac = new ClassPathXmlApplicationContext(
				"spring-mvc.xml");
		ViewResolver viewRes = ac.getBean("viewResolver", ViewResolver.class);
		System.out.println(viewRes);

	}
}
