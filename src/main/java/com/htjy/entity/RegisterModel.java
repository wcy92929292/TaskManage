package com.htjy.entity;

public class RegisterModel {
	private Integer id;
	private String name;
	private String area;
	private String code;
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "RegisterModel [id=" + id + ", name=" + name + ", area=" + area + ", code=" + code + "]";
	}

	
}
