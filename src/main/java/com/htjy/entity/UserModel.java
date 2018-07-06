package com.htjy.entity;
/**
 * 2018年7月4日
 * wcy
 */
public class UserModel {
	
	private Integer id;
	/** 名称 */
	private String loginName;
	/** 密码 */
	private String password;
	
	private String phone;
	private String address;
	private String nameStatus;
	private String collectType;
	private String collectAccount;
	private String daytime;
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
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getNameStatus() {
		return nameStatus;
	}
	public void setNameStatus(String nameStatus) {
		this.nameStatus = nameStatus;
	}
	public String getCollectType() {
		return collectType;
	}
	public void setCollectType(String collectType) {
		this.collectType = collectType;
	}
	public String getCollectAccount() {
		return collectAccount;
	}
	public void setCollectAccount(String collectAccount) {
		this.collectAccount = collectAccount;
	}
	public String getDaytime() {
		return daytime;
	}
	public void setDaytime(String daytime) {
		this.daytime = daytime;
	}
	
	
}
