package com.htjy.entity;

import java.util.List;

public class SchoolModel {
	private Integer cid;
	private String cname;
	List<SchoolDream> schoolDream;

	public Integer getCid() {
		return cid;
	}

	public void setCid(Integer cid) {
		this.cid = cid;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public List<SchoolDream> getSchoolDream() {
		return schoolDream;
	}

	public void setSchoolDream(List<SchoolDream> schoolDream) {
		this.schoolDream = schoolDream;
	}

	@Override
	public String toString() {
		return "SchoolModel [cid=" + cid + ", cname=" + cname + ", schoolDream=" + schoolDream + "]";
	}

}
