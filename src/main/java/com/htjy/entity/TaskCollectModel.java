package com.htjy.entity;

import java.util.Date;

/**
 * 任务表
 * 
 */
public class TaskCollectModel extends UserModel{
	 
	private Integer cid;
	private Integer userId;//'用户id',
	private Integer collectScore;// '提现积分',
	private String collectStatus;//提现状态 0待审核 1审核通过 2审核失败',
	private Date applyTime;// '申请时间',
	private Date handleTime;//'处理时间',
	private String collectType;
	public Integer getCid() {
		return cid;
	}
	public void setCid(Integer cid) {
		this.cid = cid;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Integer getCollectScore() {
		return collectScore;
	}
	public void setCollectScore(Integer collectScore) {
		this.collectScore = collectScore;
	}
	public String getCollectStatus() {
		return collectStatus;
	}
	public void setCollectStatus(String collectStatus) {
		this.collectStatus = collectStatus;
	}
	public Date getApplyTime() {
		return applyTime;
	}
	public void setApplyTime(Date applyTime) {
		this.applyTime = applyTime;
	}
	public Date getHandleTime() {
		return handleTime;
	}
	public void setHandleTime(Date handleTime) {
		this.handleTime = handleTime;
	}
	public String getCollectType() {
		return collectType;
	}
	public void setCollectType(String collectType) {
		this.collectType = collectType;
	}
	
}
