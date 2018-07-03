package com.htjy.entity;

public class ScoreModel {
	/**
	 * 2018年4月11日
	 * wcy
	 */
	private Integer studentId;
	private String studentName;
	private String semester;
	private String entranceGrade;
	private String subject;
	private Double score;
	public Integer getStudentId() {
		return studentId;
	}
	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getSemester() {
		return semester;
	}
	public void setSemester(String semester) {
		this.semester = semester;
	}
	public String getEntranceGrade() {
		return entranceGrade;
	}
	public void setEntranceGrade(String entranceGrade) {
		this.entranceGrade = entranceGrade;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public Double getScore() {
		return score;
	}
	public void setScore(Double score) {
		this.score = score;
	}
	@Override
	public String toString() {
		return "ScoreModel [studentId=" + studentId + ", studentName=" + studentName + ", semester=" + semester
				+ ", entranceGrade=" + entranceGrade + ", subject=" + subject + ", score=" + score + "]";
	}
	
}
