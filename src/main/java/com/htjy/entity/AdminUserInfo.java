package com.htjy.entity;

import java.io.Serializable;

/**
 * 管理员信息表
 * 
 * @version 2017年12月9日
 * @table t_admin_user_info
 */
public class AdminUserInfo implements Serializable{
	private static final long serialVersionUID = 1220558996312231663L;
	 
	/** 管理员id */
	private Integer id;
	/** 名称 */
	private String loginName;
	/** 密码 */
	private String password;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}


	
}
