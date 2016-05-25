/**
 * 
 */
package com.hb.mybatis.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

/**
 * 
 * @author hb
 *
 * @date 2016年5月18日 上午10:29:12
 */
public class DbTest {

	@Test
	public void getSession() throws IOException {
		SqlSessionFactoryBuilder sqlBuilder = new SqlSessionFactoryBuilder();
		// 读取配置文件
		InputStream inputStream = Resources
				.getResourceAsStream("mybatis-config.xml");

		Properties pro = new Properties();
		pro.load(Resources.getResourceAsReader("db.properties"));

		SqlSessionFactory sf = sqlBuilder.build(inputStream, pro);

		SqlSession session = sf.openSession();
		System.out.println(session);

	}
}
