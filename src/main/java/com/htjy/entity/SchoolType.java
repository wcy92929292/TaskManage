package com.htjy.entity;

import java.util.List;

public class SchoolType {
	private Integer pid;
	private String pname;
	private List<SchoolModel> schoolModel;

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


	public List<SchoolModel> getSchoolModel() {
		return schoolModel;
	}

	public void setSchoolModel(List<SchoolModel> schoolModel) {
		this.schoolModel = schoolModel;
	}

	@Override
	public String toString() {
		return "SchoolType [pid=" + pid + ", pname=" + pname + ", schoolModel=" + schoolModel + "]";
	}
	
}
