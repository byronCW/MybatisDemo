package com.cbm.stu.mybatis;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.cbm.stu.mybatis.entity.Role;
import com.cbm.stu.mybatis.mapper.RoleMapper;

/**
 * @ClassName: App
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author byron
 * @date 2017年2月15日
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	InputStream inputStream = null;
    	SqlSession session = null;
		try {
			inputStream = Resources.getResourceAsStream("mybatis.xml");
			SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
			System.out.println( factory );
			session = factory.openSession();
			
			// 以下两种方式推荐使用 mapper 方式
			
			// 通过session 获取 mapper 的方式执行 sql，优点：代码意义明确，面向对象；IDE可以检查语法错误
			RoleMapper mapper = session.getMapper(RoleMapper.class);
			Role role = mapper.getRole(2L);
			System.out.println(role);
			
			// ibatis方式，通过“命名空间 + sql id”,去获取sql并执行
			role = session.selectOne("com.cbm.stu.mybatis.mapper.RoleMapper.getRole", 1L);
			System.out.println(role);
			
			// sql id是唯一的，可省略命名空间
			role = session.selectOne("getRole", 2L);
			System.out.println(role);
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
			if (inputStream != null) {
				try {
					inputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
    }
}
