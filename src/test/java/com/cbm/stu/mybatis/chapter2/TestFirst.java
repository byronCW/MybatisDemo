/**
 * @Title: TestFirst.java
 * @Package com.cbm.stu.mybatis.chapter2
 * @Description: TODO(用一句话描述该文件做什么)
 * @author 34991
 * @date 2017年2月5日
 * @version V1.0
 */
package com.cbm.stu.mybatis.chapter2;

import org.apache.ibatis.session.SqlSession;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import com.cbm.stu.mybatis.entity.Role;
import com.cbm.stu.mybatis.mapper.RoleMapper;
import com.cbm.stu.mybatis.util.SqlSessionFactoryUtil;

/**
 * @ClassName: TestFirst
 * @Description: Mybatis Hello world
 * @author 34991
 * @date 2017年2月5日
 *
 */
public class TestFirst {

	private static SqlSession session = null;
	
	private static RoleMapper mapper = null;
	
	private long key;
	
	@BeforeClass
	public static void begin() {
		
		session = SqlSessionFactoryUtil.openSqlSession();
		
		mapper = session.getMapper(RoleMapper.class);
	}
	
	@AfterClass
	public static void end() {
		if ( session != null ) {
			session.close();
		}
	}
	
	@Test
	public void testInsert() {
		Role role = new Role();
		role.setRoleName("rna");
		role.setNote("rnna");
		
		key = mapper.insertRole(role);
		System.out.println(key);
	}
	
	@Test
	public void testGet() {
		Role r = mapper.getRole(1L);
		
//		Assert.assertSame("admin", r.getRoleName());
		Assert.assertEquals("admin", r.getRoleName());
	}
	
	@Test
	public void testDelete() {
		Assert.assertSame(1, mapper.deleteRole(5L));
		Assert.assertSame(0, mapper.deleteRole(10000L));
	}
}
