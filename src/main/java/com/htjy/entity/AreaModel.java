package com.htjy.entity;

import java.util.List;

public class AreaModel {
	private Integer pid;
	private String pname;
	private List<AreaCity> city;

	public Integer getPid() {
		return pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public List<AreaCity> getCity() {
		return city;
	}

	public void setCity(List<AreaCity> city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "AreaModel [pid=" + pid + ", pname=" + pname + ", city=" + city + "]";
	}

}
