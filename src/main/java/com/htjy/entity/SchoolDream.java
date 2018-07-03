package com.htjy.entity;

public class SchoolDream {
	private Integer aid;
	private String aname;

	public Integer getAid() {
		return aid;
	}

	public void setAid(Integer aid) {
		this.aid = aid;
	}

	public String getAname() {
		return aname;
	}

	public void setAname(String aname) {
		this.aname = aname;
	}

	@Override
	public String toString() {
		return "SchoolDream [aid=" + aid + ", aname=" + aname + "]";
	}

}
