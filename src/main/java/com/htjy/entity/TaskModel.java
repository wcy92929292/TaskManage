package com.htjy.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 任务表
 * 
 */
public class TaskModel implements Serializable{
	private static final long serialVersionUID = 1220558996312231663L;
	 
	/** id */
	private Integer id;
	/** 标题*/
	private String title;
	private String type;
	private Integer lockTime;
	private Integer score;
	private String location;//大致地标
	private String address;//具体位置
	private String schedule;
	private String remark;
	private Integer setPerson;
	private Date setTime;
	private Integer updatePerson;
	private Date updateTime;
	
	public Integer getSetPerson() {
		return setPerson;
	}
	public void setSetPerson(Integer setPerson) {
		this.setPerson = setPerson;
	}
	public Date getSetTime() {
		return setTime;
	}
	public void setSetTime(Date setTime) {
		this.setTime = setTime;
	}
	public Integer getUpdatePerson() {
		return updatePerson;
	}
	public void setUpdatePerson(Integer updatePerson) {
		this.updatePerson = updatePerson;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Integer getLockTime() {
		return lockTime;
	}
	public void setLockTime(Integer lockTime) {
		this.lockTime = lockTime;
	}
	public Integer getScore() {
		return score;
	}
	public void setScore(Integer score) {
		this.score = score;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getSchedule() {
		return schedule;
	}
	public void setSchedule(String schedule) {
		this.schedule = schedule;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}


	
}
