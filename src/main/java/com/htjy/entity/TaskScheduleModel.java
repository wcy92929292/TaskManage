package com.htjy.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 任务表
 * 
 */
public class TaskScheduleModel implements Serializable{
	private static final long serialVersionUID = 1220558996312231663L;
	 
	private Integer id;
	private Integer tid;
	private Date daytime;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getTid() {
		return tid;
	}
	public void setTid(Integer tid) {
		this.tid = tid;
	}
	public Date getDaytime() {
		return daytime;
	}
	public void setDaytime(Date daytime) {
		this.daytime = daytime;
	}

	
}
