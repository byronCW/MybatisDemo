/**
 * @Title: entity.java
 * @Package com.cbm.stu.mybatis
 * @Description: TODO(用一句话描述该文件做什么)
 * @author 34991
 * @date 2017年2月5日
 * @version V1.0
 */
package com.cbm.stu.mybatis.entity;

/**
 * @ClassName: entity
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author 34991
 * @date 2017年2月5日
 *
 */
public class Role {

	private Long id;

	private String roleName;

	private String note;

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the roleName
	 */
	public String getRoleName() {
		return roleName;
	}

	/**
	 * @param roleName
	 *            the roleName to set
	 */
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	/**
	 * @return the note
	 */
	public String getNote() {
		return note;
	}

	/**
	 * @param note
	 *            the note to set
	 */
	public void setNote(String note) {
		this.note = note;
	}

	/* (非 Javadoc)
	 * <p>Title: toString</p>
	 * <p>Description: </p>
	 * @return
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return String.format("Role [id=%s, roleName=%s, note=%s]", id, roleName, note);
	}

}
