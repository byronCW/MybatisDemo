/**
 * @Title: SqlSessionFactoryUtil.java
 * @Package com.cbm.stu.mybatis.util
 * @Description: TODO(用一句话描述该文件做什么)
 * @author 34991
 * @date 2017年2月5日
 * @version V1.0
 */
package com.cbm.stu.mybatis.util;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;

/**
 * @ClassName: SqlSessionFactoryUtil
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author 34991
 * @date 2017年2月5日
 *
 */
public class SqlSessionFactoryUtil {

	private static SqlSessionFactory factory = null;
	
	// 类线程锁
	private static final Class<SqlSessionFactoryUtil> CLASS_LOCK = SqlSessionFactoryUtil.class;
	
	private SqlSessionFactoryUtil() {}
	
	public static SqlSessionFactory init() {
		InputStream inputStream = null;
		
		try {
			inputStream = Resources.getResourceAsStream("mybatis.xml");
		} catch (IOException e) {
//			Logger.getLogger(SqlSessionFactoryUtil.class).log(Level.SEVERE, null, e);
			Logger.getLogger(SqlSessionFactoryUtil.class).error(e);
		}
		
		synchronized (CLASS_LOCK) {
			if (factory == null) {
				factory = new SqlSessionFactoryBuilder().build(inputStream);
			}
		}
		
		return factory;
	}
	
	public static SqlSession openSqlSession() {
		if ( factory == null ) {
			init();
		}
		return factory.openSession();
	}
}
