package com.htjy.entity;

import java.util.Date;

public class FeeModel {
	/**
	 * 2018年4月10日
	 * wcy
	 */
	private Integer id;
	private String project;
	private Double cost;
	private Date payTime;
	private Integer studentId;
	private Integer complete;
	private Integer refund;
	
	private Integer postStatus;
	private Integer checkStatus;
	
	
	public Integer getPostStatus() {
		return postStatus;
	}
	public void setPostStatus(Integer postStatus) {
		this.postStatus = postStatus;
	}
	public Integer getCheckStatus() {
		return checkStatus;
	}
	public void setCheckStatus(Integer checkStatus) {
		this.checkStatus = checkStatus;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getProject() {
		return project;
	}
	public void setProject(String project) {
		this.project = project;
	}
	public Double getCost() {
		return cost;
	}
	public void setCost(Double cost) {
		this.cost = cost;
	}
	public Date getPayTime() {
		return payTime;
	}
	public void setPayTime(Date payTime) {
		this.payTime = payTime;
	}
	public Integer getStudentId() {
		return studentId;
	}
	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}
	public Integer getComplete() {
		return complete;
	}
	public void setComplete(Integer complete) {
		this.complete = complete;
	}
	public Integer getRefund() {
		return refund;
	}
	public void setRefund(Integer refund) {
		this.refund = refund;
	}
	@Override
	public String toString() {
		return "FeeModel [id=" + id + ", project=" + project + ", cost=" + cost + ", payTime=" + payTime
				+ ", studentId=" + studentId + ", complete=" + complete + ", refund=" + refund + ", postStatus="
				+ postStatus + ", checkStatus=" + checkStatus + "]";
	}
	
}
