package com.htjy.entity;

import java.util.List;

public class AreaCity {
	private Integer cid;
	private String cname;
	List<AreaQu> areaQus;

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

	public List<AreaQu> getAreaQus() {
		return areaQus;
	}

	public void setAreaQus(List<AreaQu> areaQus) {
		this.areaQus = areaQus;
	}

	@Override
	public String toString() {
		return "AreaCity [cid=" + cid + ", cname=" + cname + ", areaQus=" + areaQus + "]";
	}

}
