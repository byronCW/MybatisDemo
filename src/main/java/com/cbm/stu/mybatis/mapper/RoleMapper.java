/**
 * @Title: RoleMapper.java
 * @Package com.cbm.stu.mybatis.mapper
 * @Description: TODO(用一句话描述该文件做什么)
 * @author 34991
 * @date 2017年2月5日
 * @version V1.0
 */
package com.cbm.stu.mybatis.mapper;

import com.cbm.stu.mybatis.entity.Role;

/**
 * @ClassName: RoleMapper
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author 34991
 * @date 2017年2月5日
 *
 */
public interface RoleMapper {

	public Role getRole(Long id);
	
	public int insertRole(Role role);
	
	public int deleteRole(Long id);
}
