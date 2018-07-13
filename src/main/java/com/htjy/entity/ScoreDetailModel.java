package com.htjy.entity;

import java.util.Date;

public class ScoreDetailModel extends TaskCollectModel{
	private Integer id;
	private Integer userId;
	private Integer scoreChange;
	private Date changeTime;
	private Integer changeType;
	private Integer changeStatus;
	private Integer cid;
	public Integer getCid() {
		return cid;
	}
	public void setCid(Integer cid) {
		this.cid = cid;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Integer getScoreChange() {
		return scoreChange;
	}
	public void setScoreChange(Integer scoreChange) {
		this.scoreChange = scoreChange;
	}
	public Date getChangeTime() {
		return changeTime;
	}
	public void setChangeTime(Date changeTime) {
		this.changeTime = changeTime;
	}
	public Integer getChangeType() {
		return changeType;
	}
	public void setChangeType(Integer changeType) {
		this.changeType = changeType;
	}
	public Integer getChangeStatus() {
		return changeStatus;
	}
	public void setChangeStatus(Integer changeStatus) {
		this.changeStatus = changeStatus;
	}
	
}
