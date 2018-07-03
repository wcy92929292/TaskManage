package com.htjy.entity;

import java.util.Date;
import java.util.List;

public class StudentSignModel{
	private Double charge;
	private Integer schoolId;
	private String discount;
	private Integer dream;
	private String dreamType;
	private String entranceGrade;
	private Integer entranceType;
	private Integer examinationAreaId;
	private Integer firstVolunteer;
	private Integer fullType;
	private Date inputTime;
	private Integer plus;
	private Integer plusCondition;
	private Integer arrangement;
	private Integer recruitSchool;
	private Integer recruitType;
	private String remark;
	private String scholarship;
	private Integer secondVolunteer;
	private Integer teacherId;
	private Integer studentId;
	private Integer checkStatus;
	
	private String schoolName;
	private String firstName;
	private String secondName;
	private String teacherName;
	private String recName;
	private String examName;
	private Integer complete;
	
	private String project1;
	private String project2;
	private String cost1;
	private String cost2;
	private String payTime1;
	private String payTime2;
	private String complete1;
	private String complete2;
	private String refund1;
	private String refund2;
	
	private String scoreId; 
	private Integer post;
	
	private Date start;
	private Date end;
	private List<FeeModel> feeDetail;
	public List<FeeModel> getFeeDetail() {
		return feeDetail;
	}
	public void setFeeDetail(List<FeeModel> feeDetail) {
		this.feeDetail = feeDetail;
	}
	public Date getStart() {
		return start;
	}
	public void setStart(Date start) {
		this.start = start;
	}
	public Date getEnd() {
		return end;
	}
	public void setEnd(Date end) {
		this.end = end;
	}
	public String getScoreId() {
		return scoreId;
	}
	public void setScoreId(String scoreId) {
		this.scoreId = scoreId;
	}
	public String getProject1() {
		return project1;
	}
	public void setProject1(String project1) {
		this.project1 = project1;
	}
	public String getProject2() {
		return project2;
	}
	public void setProject2(String project2) {
		this.project2 = project2;
	}
	public String getCost1() {
		return cost1;
	}
	public void setCost1(String cost1) {
		this.cost1 = cost1;
	}
	public String getCost2() {
		return cost2;
	}
	public void setCost2(String cost2) {
		this.cost2 = cost2;
	}
	public String getPayTime1() {
		return payTime1;
	}
	public void setPayTime1(String payTime1) {
		this.payTime1 = payTime1;
	}
	public String getPayTime2() {
		return payTime2;
	}
	public void setPayTime2(String payTime2) {
		this.payTime2 = payTime2;
	}
	public String getComplete1() {
		return complete1;
	}
	public void setComplete1(String complete1) {
		this.complete1 = complete1;
	}
	public String getComplete2() {
		return complete2;
	}
	public void setComplete2(String complete2) {
		this.complete2 = complete2;
	}
	public String getRefund1() {
		return refund1;
	}
	public void setRefund1(String refund1) {
		this.refund1 = refund1;
	}
	public String getRefund2() {
		return refund2;
	}
	public void setRefund2(String refund2) {
		this.refund2 = refund2;
	}
	public String getTeacherName() {
		return teacherName;
	}
	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}
	public Double getCharge() {
		return charge;
	}
	public void setCharge(Double charge) {
		this.charge = charge;
	}
	public Integer getSchoolId() {
		return schoolId;
	}
	public void setSchoolId(Integer schoolId) {
		this.schoolId = schoolId;
	}
	public String getDiscount() {
		return discount;
	}
	public void setDiscount(String discount) {
		this.discount = discount;
	}
	public Integer getDream() {
		return dream;
	}
	public void setDream(Integer dream) {
		this.dream = dream;
	}
	public String getDreamType() {
		return dreamType;
	}
	public void setDreamType(String dreamType) {
		this.dreamType = dreamType;
	}
	public String getEntranceGrade() {
		return entranceGrade;
	}
	public void setEntranceGrade(String entranceGrade) {
		this.entranceGrade = entranceGrade;
	}
	public Integer getEntranceType() {
		return entranceType;
	}
	public void setEntranceType(Integer entranceType) {
		this.entranceType = entranceType;
	}
	public Integer getExaminationAreaId() {
		return examinationAreaId;
	}
	public void setExaminationAreaId(Integer examinationAreaId) {
		this.examinationAreaId = examinationAreaId;
	}
	public Integer getFirstVolunteer() {
		return firstVolunteer;
	}
	public void setFirstVolunteer(Integer firstVolunteer) {
		this.firstVolunteer = firstVolunteer;
	}
	public Integer getFullType() {
		return fullType;
	}
	public void setFullType(Integer fullType) {
		this.fullType = fullType;
	}
	public Date getInputTime() {
		return inputTime;
	}
	public void setInputTime(Date inputTime) {
		this.inputTime = inputTime;
	}
	public Integer getPlus() {
		return plus;
	}
	public void setPlus(Integer plus) {
		this.plus = plus;
	}
	public Integer getPlusCondition() {
		return plusCondition;
	}
	public void setPlusCondition(Integer plusCondition) {
		this.plusCondition = plusCondition;
	}
	public Integer getArrangement() {
		return arrangement;
	}
	public void setArrangement(Integer arrangement) {
		this.arrangement = arrangement;
	}
	public Integer getRecruitSchool() {
		return recruitSchool;
	}
	public void setRecruitSchool(Integer recruitSchool) {
		this.recruitSchool = recruitSchool;
	}
	public Integer getRecruitType() {
		return recruitType;
	}
	public void setRecruitType(Integer recruitType) {
		this.recruitType = recruitType;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getScholarship() {
		return scholarship;
	}
	public void setScholarship(String scholarship) {
		this.scholarship = scholarship;
	}
	public Integer getSecondVolunteer() {
		return secondVolunteer;
	}
	public void setSecondVolunteer(Integer secondVolunteer) {
		this.secondVolunteer = secondVolunteer;
	}
	public Integer getTeacherId() {
		return teacherId;
	}
	public void setTeacherId(Integer teacherId) {
		this.teacherId = teacherId;
	}
	public Integer getStudentId() {
		return studentId;
	}
	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}
	public Integer getCheckStatus() {
		return checkStatus;
	}
	public void setCheckStatus(Integer checkStatus) {
		this.checkStatus = checkStatus;
	}
	
	public String getSchoolName() {
		return schoolName;
	}
	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getSecondName() {
		return secondName;
	}
	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}
	public String getRecName() {
		return recName;
	}
	public void setRecName(String recName) {
		this.recName = recName;
	}
	public String getExamName() {
		return examName;
	}
	public void setExamName(String examName) {
		this.examName = examName;
	}
	public Integer getComplete() {
		return complete;
	}
	public void setComplete(Integer complete) {
		this.complete = complete;
	}
	public Integer getPost() {
		return post;
	}
	public void setPost(Integer post) {
		this.post = post;
	}
	@Override
	public String toString() {
		return "StudentSignModel [charge=" + charge + ", schoolId=" + schoolId + ", discount=" + discount + ", dream="
				+ dream + ", dreamType=" + dreamType + ", entranceGrade=" + entranceGrade + ", entranceType="
				+ entranceType + ", examinationAreaId=" + examinationAreaId + ", firstVolunteer=" + firstVolunteer
				+ ", fullType=" + fullType + ", inputTime=" + inputTime + ", plus=" + plus + ", plusCondition="
				+ plusCondition + ", arrangement=" + arrangement + ", recruitSchool=" + recruitSchool + ", recruitType="
				+ recruitType + ", remark=" + remark + ", scholarship=" + scholarship + ", secondVolunteer="
				+ secondVolunteer + ", teacherId=" + teacherId + ", studentId=" + studentId + ", checkStatus="
				+ checkStatus + ", schoolName=" + schoolName + ", firstName=" + firstName + ", secondName=" + secondName
				+ ", teacherName=" + teacherName + ", recName=" + recName + ", examName=" + examName + ", complete="
				+ complete + ", project1=" + project1 + ", project2=" + project2 + ", cost1=" + cost1 + ", cost2="
				+ cost2 + ", payTime1=" + payTime1 + ", payTime2=" + payTime2 + ", complete1=" + complete1
				+ ", complete2=" + complete2 + ", refund1=" + refund1 + ", refund2=" + refund2 + ", scoreId=" + scoreId
				+ ", post=" + post + ", start=" + start + ", end=" + end + ", feeDetail=" + feeDetail + "]";
	}
	
}
