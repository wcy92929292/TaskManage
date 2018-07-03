package com.htjy.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.htjy.entity.FeeModel;
import com.htjy.entity.FileModel;
import com.htjy.entity.ScoreModel;
import com.htjy.entity.StudentModel;
import com.htjy.entity.StudentSignModel;

public interface StudentDao {

	Integer addStudent(StudentModel stu);

	StudentModel queryDetail(String id);

	void updateStudent(StudentModel stu);

	void addStudentSign(StudentSignModel sts);

	StudentSignModel querySignDetail(String id);

	void updateStudentSign(StudentSignModel sts);

	void addFile(FileModel file);

	void updateFile(FileModel file);

	FileModel queryFile(String id);

	Integer queryCount(Map<String, Object> map);

	void addFee(@Param("list") List<FeeModel> list);

	List<StudentModel> queryList(Map<String, Object> map);

	void addScore(@Param("list") List<ScoreModel> list);

	List<ScoreModel> queryScore(ScoreModel sc);

	List<FeeModel> queryFee(Integer studentId);

	void delFee(Integer studentId);

	void updateStatus(Integer studentId, Integer checkStatus);

	void updateFee(@Param("studentId")Integer studentId, @Param("split")String split, @Param("complete")Integer complete);

	void insertPost(Integer studentId, Integer post);

	Integer queryCountNext(Map<String, Object> map);

	void delStudent(Integer stuId);

	void updateFeeList(@Param("list")List<FeeModel> list);

	void addFeeSingle(FeeModel feeModel);

	void updateStatusSign(Integer studentId, Integer checkStatus);

	void updateAssign(Integer stuId, Integer teach);

	void updateAssignSign(Integer stuId, Integer teach);

}
