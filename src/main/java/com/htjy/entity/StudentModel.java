package com.htjy.entity;

import java.util.Date;

/**
 * 
 * @version 2017年12月9日
 * @table t_admin_user_info
 */
public class StudentModel extends StudentSignModel{
	private Integer id;
	private Integer  registeredResidence;
	private Date  birthday;
	private Integer  registeredResidenceType;
	private String  address;
	private Integer  education;
	private Date  entranceTime;
	private String  graduationNo;
	private String  graduation;
	private Date  graduationTime;
	private String  cardId;
	private Integer  cardIdType;
	private String  technicalTitle;
	private String  email;
	private Integer  marriage;
	private Integer  nation;
	private String  phone;
	private Integer  political;
	private String  major;
	private String  remarks;
	private Integer  sex;
	private String  anotherPhone;
	private String  wechat;
	private Integer  area;
	private Integer  city;
	private Integer  province;
	private String  name;
	private String  photo;
	private Integer teacherId;
	private Integer checkStatus;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getRegisteredResidence() {
		return registeredResidence;
	}
	public void setRegisteredResidence(Integer registeredResidence) {
		this.registeredResidence = registeredResidence;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public Integer getRegisteredResidenceType() {
		return registeredResidenceType;
	}
	public void setRegisteredResidenceType(Integer registeredResidenceType) {
		this.registeredResidenceType = registeredResidenceType;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Integer getEducation() {
		return education;
	}
	public void setEducation(Integer education) {
		this.education = education;
	}
	public Date getEntranceTime() {
		return entranceTime;
	}
	public void setEntranceTime(Date entranceTime) {
		this.entranceTime = entranceTime;
	}
	public String getGraduationNo() {
		return graduationNo;
	}
	public void setGraduationNo(String graduationNo) {
		this.graduationNo = graduationNo;
	}
	public String getGraduation() {
		return graduation;
	}
	public void setGraduation(String graduation) {
		this.graduation = graduation;
	}
	public Date getGraduationTime() {
		return graduationTime;
	}
	public void setGraduationTime(Date graduationTime) {
		this.graduationTime = graduationTime;
	}
	public String getCardId() {
		return cardId;
	}
	public void setCardId(String cardId) {
		this.cardId = cardId;
	}
	public Integer getCardIdType() {
		return cardIdType;
	}
	public void setCardIdType(Integer cardIdType) {
		this.cardIdType = cardIdType;
	}
	public String getTechnicalTitle() {
		return technicalTitle;
	}
	public void setTechnicalTitle(String technicalTitle) {
		this.technicalTitle = technicalTitle;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Integer getMarriage() {
		return marriage;
	}
	public void setMarriage(Integer marriage) {
		this.marriage = marriage;
	}
	public Integer getNation() {
		return nation;
	}
	public void setNation(Integer nation) {
		this.nation = nation;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Integer getPolitical() {
		return political;
	}
	public void setPolitical(Integer political) {
		this.political = political;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public Integer getSex() {
		return sex;
	}
	public void setSex(Integer sex) {
		this.sex = sex;
	}
	public String getAnotherPhone() {
		return anotherPhone;
	}
	public void setAnotherPhone(String anotherPhone) {
		this.anotherPhone = anotherPhone;
	}
	public String getWechat() {
		return wechat;
	}
	public void setWechat(String wechat) {
		this.wechat = wechat;
	}
	public Integer getArea() {
		return area;
	}
	public void setArea(Integer area) {
		this.area = area;
	}
	public Integer getCity() {
		return city;
	}
	public void setCity(Integer city) {
		this.city = city;
	}
	public Integer getProvince() {
		return province;
	}
	public void setProvince(Integer province) {
		this.province = province;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public Integer getTeacherId() {
		return teacherId;
	}
	public void setTeacherId(Integer teacherId) {
		this.teacherId = teacherId;
	}
	public Integer getCheckStatus() {
		return checkStatus;
	}
	public void setCheckStatus(Integer checkStatus) {
		this.checkStatus = checkStatus;
	}
	@Override
	public String toString() {
		return "StudentModel [id=" + id + ", registeredResidence=" + registeredResidence + ", birthday=" + birthday
				+ ", registeredResidenceType=" + registeredResidenceType + ", address=" + address + ", education="
				+ education + ", entranceTime=" + entranceTime + ", graduationNo=" + graduationNo + ", graduation="
				+ graduation + ", graduationTime=" + graduationTime + ", cardId=" + cardId + ", cardIdType="
				+ cardIdType + ", technicalTitle=" + technicalTitle + ", email=" + email + ", marriage=" + marriage
				+ ", nation=" + nation + ", phone=" + phone + ", political=" + political + ", major=" + major
				+ ", remarks=" + remarks + ", sex=" + sex + ", anotherPhone=" + anotherPhone + ", wechat=" + wechat
				+ ", area=" + area + ", city=" + city + ", province=" + province + ", name=" + name + ", photo=" + photo
				+ ", teacherId=" + teacherId + ", checkStatus=" + checkStatus + "]";
	}
	

}
