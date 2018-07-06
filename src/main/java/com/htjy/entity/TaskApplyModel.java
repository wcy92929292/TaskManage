package com.htjy.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 任务申请，审核，状态表
 * 
 */
public class TaskApplyModel extends UserModel{
	/** id */
	private Integer aid;
	private Integer sid;
	private Integer userId;
	private String picture;//图片
	private Integer status;
	private Date startTime;
	private Date endTime;
	private Date finishTime;
	private Date checkTime;
	private Integer checkPerson;

	public Integer getAid() {
		return aid;
	}
	public void setAid(Integer aid) {
		this.aid = aid;
	}
	public Integer getSid() {
		return sid;
	}
	public void setSid(Integer sid) {
		this.sid = sid;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Date getStartTime() {
		return startTime;
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	public Date getCheckTime() {
		return checkTime;
	}
	public void setCheckTime(Date checkTime) {
		this.checkTime = checkTime;
	}
	public Integer getCheckPerson() {
		return checkPerson;
	}
	public void setCheckPerson(Integer checkPerson) {
		this.checkPerson = checkPerson;
	}
	public Date getFinishTime() {
		return finishTime;
	}
	public void setFinishTime(Date finishTime) {
		this.finishTime = finishTime;
	}
	
}
