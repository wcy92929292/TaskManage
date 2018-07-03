package com.htjy.entity;

public class AreaQu {
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
		return "AreaQu [aid=" + aid + ", aname=" + aname + "]";
	}

}
