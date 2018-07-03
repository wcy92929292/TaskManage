package com.htjy.entity;

public class FileModel {
	private String cardIdFile;
	private String cardIdBackFile;
	private String graduationCertificate;
	private String blueBackPhoto;
	private String whiteBackPhoto;
	private String employCertificate;
	private String admission;
	private Integer studentId;
	private Integer complete;
	public String getCardIdFile() {
		return cardIdFile;
	}
	public void setCardIdFile(String cardIdFile) {
		this.cardIdFile = cardIdFile;
	}
	public String getCardIdBackFile() {
		return cardIdBackFile;
	}
	public void setCardIdBackFile(String cardIdBackFile) {
		this.cardIdBackFile = cardIdBackFile;
	}
	public String getGraduationCertificate() {
		return graduationCertificate;
	}
	public void setGraduationCertificate(String graduationCertificate) {
		this.graduationCertificate = graduationCertificate;
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
	
	public String getBlueBackPhoto() {
		return blueBackPhoto;
	}
	public void setBlueBackPhoto(String blueBackPhoto) {
		this.blueBackPhoto = blueBackPhoto;
	}
	public String getWhiteBackPhoto() {
		return whiteBackPhoto;
	}
	public void setWhiteBackPhoto(String whiteBackPhoto) {
		this.whiteBackPhoto = whiteBackPhoto;
	}
	public String getEmployCertificate() {
		return employCertificate;
	}
	public void setEmployCertificate(String employCertificate) {
		this.employCertificate = employCertificate;
	}
	public String getAdmission() {
		return admission;
	}
	public void setAdmission(String admission) {
		this.admission = admission;
	}
	@Override
	public String toString() {
		return "FileModel [cardIdFile=" + cardIdFile + ", cardIdBackFile=" + cardIdBackFile + ", graduationCertificate="
				+ graduationCertificate + ", blueBackPhoto=" + blueBackPhoto + ", whiteBackPhoto=" + whiteBackPhoto
				+ ", employCertificate=" + employCertificate + ", admission=" + admission + ", studentId=" + studentId
				+ ", complete=" + complete + "]";
	}

}
