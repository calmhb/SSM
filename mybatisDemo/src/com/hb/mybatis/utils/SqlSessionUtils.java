/**
 * 
 */
package com.hb.mybatis.utils;

import java.io.InputStream;
import java.util.Properties;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * 
 * @author hb
 *
 * @date 2016年5月18日 上午11:05:23
 */
public class SqlSessionUtils {
	private static SqlSessionFactory sf;
	static {
		try {

			SqlSessionFactoryBuilder sqlBuilder = new SqlSessionFactoryBuilder();
			// 读取配置文件
			InputStream inputStream = Resources
					.getResourceAsStream("mybatis-config.xml");

			Properties pro = new Properties();
			pro.load(Resources.getResourceAsReader("db.properties"));

			sf = sqlBuilder.build(inputStream, pro);

		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public static SqlSession openSession() {
		return sf.openSession();
	}

}
