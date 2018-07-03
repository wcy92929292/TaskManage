package com.htjy.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.jdt.internal.compiler.ast.DoubleLiteral;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.htjy.dao.StudentDao;
import com.htjy.entity.FeeModel;
import com.htjy.entity.FileModel;
import com.htjy.entity.ScoreModel;
import com.htjy.entity.StudentModel;
import com.htjy.entity.StudentSignModel;

@Controller
@RequestMapping("/student")
public class StudentController {
//
//	@Autowired StudentDao dao;
//	java.text.SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
//	/**
//	 * 新增个人基本信息
//	 * @return
//	 * @throws IOException
//	 * @throws ParseException
//	 */
//	@RequestMapping(value = "/add.do")
//    @ResponseBody
//    public JSONObject add(
//    		@RequestParam("registeredResidence") Integer registeredResidence,
//    		@RequestParam("birthday") String birthday,
//    		@RequestParam("registeredResidenceType") String registeredResidenceType,
//    		@RequestParam("address") String address,
//    		@RequestParam("education") String education,
//    		@RequestParam("entranceTime") String entranceTime,
//    		@RequestParam("graduationNo") String graduationNo,
//    		@RequestParam("graduation") String graduation,
//    		@RequestParam("graduationTime") String graduationTime,
//    		@RequestParam("cardId") String cardId,
//    		@RequestParam("cardIdType") String cardIdType,
//    		@RequestParam("technicalTitle") String technicalTitle,
//    		@RequestParam("email") String email,
//    		@RequestParam("marriage") String marriage,
//    		@RequestParam("nation") String nation,
//    		@RequestParam("phone") String phone,
//    		@RequestParam("political") String political,
//    		@RequestParam("major") String major,
//    		@RequestParam("remarks") String remarks,
//    		@RequestParam("sex") String sex,
//    		@RequestParam("anotherPhone") String anotherPhone,
//    		@RequestParam("wechat") String wechat,
//    		@RequestParam("area") String area,
//    		@RequestParam("city") String city,
//    		@RequestParam("province") String province,
//    		@RequestParam("name") String name,
//    		@RequestParam("photo") String photo,
//    		@RequestParam("teacherId") String teacherId
//          ) throws IOException, ParseException{
//		JSONObject obj = new JSONObject();
//		StudentModel stu = new StudentModel();
//		stu.setRegisteredResidence(registeredResidence);
//		stu.setBirthday(formatter.parse(birthday));
//		stu.setRegisteredResidenceType(Integer.parseInt(registeredResidenceType));
//		stu.setAddress(address);
//		stu.setEducation(Integer.parseInt(education));
//		stu.setEntranceTime(entranceTime.equals("")?null:formatter.parse(entranceTime));
//		stu.setGraduationNo(graduationNo);
//		stu.setGraduation(graduation);
//		stu.setGraduationTime(graduationTime.equals("")?null:formatter.parse(graduationTime));
//		stu.setCardId(cardId);
//		stu.setCardIdType(cardIdType.equals("")?null:Integer.parseInt(cardIdType));
//		stu.setTechnicalTitle(technicalTitle);
//		stu.setEmail(email);
//		stu.setMarriage(marriage.equals("")?null:Integer.parseInt(marriage));
//		stu.setNation(nation.equals("")?null:Integer.parseInt(nation));
//		stu.setPhone(phone);
//		stu.setPolitical(political.equals("")?null:Integer.parseInt(political));
//		stu.setMajor(major);
//		stu.setRemarks(remarks);
//		stu.setSex(Integer.parseInt(sex));
//		stu.setAnotherPhone(anotherPhone);
//		stu.setWechat(wechat);
//		stu.setArea(area.equals("")?null:Integer.parseInt(area));
//		stu.setCity(Integer.parseInt(city));
//		stu.setProvince(Integer.parseInt(province));
//		stu.setName(name);
//		stu.setPhoto(photo);
//		stu.setTeacherId(Integer.parseInt(teacherId));
//		try {
//			dao.addStudent(stu);
//			Integer id = stu.getId();
//			obj.put("code", "0");
//			obj.put("studentId", id);
//		} catch (Exception e) {
//			obj.put("code", "1");
//			// TODO: handle exception
//		}
//		return obj;
//	    }
//	/**
//	 * 更新个人信息
//	 * @return
//	 * @throws IOException
//	 * @throws ParseException
//	 */
//	@RequestMapping(value = "/update.do")
//    @ResponseBody
//    public JSONObject update(
//    		@RequestParam("registeredResidence") Integer registeredResidence,
//    		@RequestParam("birthday") String birthday,
//    		@RequestParam("registeredResidenceType") String registeredResidenceType,
//    		@RequestParam("address") String address,
//    		@RequestParam("education") String education,
//    		@RequestParam("entranceTime") String entranceTime,
//    		@RequestParam("graduationNo") String graduationNo,
//    		@RequestParam("graduation") String graduation,
//    		@RequestParam("graduationTime") String graduationTime,
//    		@RequestParam("cardId") String cardId,
//    		@RequestParam("cardIdType") String cardIdType,
//    		@RequestParam("technicalTitle") String technicalTitle,
//    		@RequestParam("email") String email,
//    		@RequestParam("marriage") String marriage,
//    		@RequestParam("nation") String nation,
//    		@RequestParam("phone") String phone,
//    		@RequestParam("political") String political,
//    		@RequestParam("major") String major,
//    		@RequestParam("remarks") String remarks,
//    		@RequestParam("sex") String sex,
//    		@RequestParam("anotherPhone") String anotherPhone,
//    		@RequestParam("wechat") String wechat,
//    		@RequestParam("area") String area,
//    		@RequestParam("city") String city,
//    		@RequestParam("province") String province,
//    		@RequestParam("name") String name,
//    		@RequestParam("photo") String photo,
//            @RequestParam("id1") String id
//          ) throws IOException, ParseException{
//		JSONObject obj = new JSONObject();
//		StudentModel stu = new StudentModel();
//		stu.setRegisteredResidence(registeredResidence);
//		stu.setBirthday(formatter.parse(birthday));
//		stu.setRegisteredResidenceType(Integer.parseInt(registeredResidenceType));
//		stu.setAddress(address);
//		stu.setEducation(Integer.parseInt(education));
//		stu.setEntranceTime(entranceTime.equals("")?null:formatter.parse(entranceTime));
//		stu.setGraduationNo(graduationNo);
//		stu.setGraduation(graduation);
//		stu.setGraduationTime(graduationTime.equals("")?null:formatter.parse(graduationTime));
//		stu.setCardId(cardId);
//		stu.setCardIdType(cardIdType.equals("")?null:Integer.parseInt(cardIdType));
//		stu.setTechnicalTitle(technicalTitle);
//		stu.setEmail(email);
//		stu.setMarriage(marriage.equals("")?null:Integer.parseInt(marriage));
//		stu.setNation(nation.equals("")?null:Integer.parseInt(nation));
//		stu.setPhone(phone);
//		stu.setPolitical(political.equals("")?null:Integer.parseInt(political));
//		stu.setMajor(major);
//		stu.setRemarks(remarks);
//		stu.setSex(Integer.parseInt(sex));
//		stu.setAnotherPhone(anotherPhone);
//		stu.setWechat(wechat);
//		stu.setArea(area.equals("")?null:Integer.parseInt(area));
//		stu.setCity(Integer.parseInt(city));
//		stu.setProvince(Integer.parseInt(province));
//		stu.setName(name);
//		stu.setPhoto(photo);
//		stu.setId(Integer.parseInt(id));
//		try {
//			dao.updateStudent(stu);
//			obj.put("code", "0");
//		} catch (Exception e) {
//			obj.put("code", "1");
//			// TODO: handle exception
//		}
//		return obj;
//	    }
//	/**
//	 * 查询个人基本信息
//	 * @param id
//	 * @return
//	 */
//	@ResponseBody
//	@RequestMapping("/queryDetail")
//	public JSONObject queryDetail(@RequestParam("id") String id){
//		JSONObject obj = new JSONObject();
//		try {
//			StudentModel stu = dao.queryDetail(id);
//			obj.put("code", "0");
//			obj.put("result", stu);
//		} catch (Exception e) {
//			// TODO: handle exception
//			obj.put("code", "1");
//		}
//		return obj;
//	}
//	/**
//	 * 新增报读信息
//	 * @return
//	 * @throws IOException
//	 * @throws ParseException
//	 */
//	@RequestMapping(value = "/addSign.do")
//    @ResponseBody
//    public JSONObject addSign(
//    		@RequestParam("charge") String charge,
//    		@RequestParam("city") String schoolId,
//    		@RequestParam("discount") String discount,
//    		@RequestParam("dream") String dream,
//    		@RequestParam("dreamType") String dreamType,
//    		@RequestParam("entranceGrade") String entranceGrade,
//    		@RequestParam("entranceType") String entranceType,
//    		@RequestParam("examinationAreaId") String examinationAreaId,
//    		@RequestParam("firstVolunteer") String firstVolunteer,
//    		@RequestParam("fullType") String fullType,
//    		@RequestParam("inputTime") String inputTime,
//    		@RequestParam("plus") String plus,
//    		@RequestParam("plusCondition") String plusCondition,
//    		@RequestParam("province") String arrangement,
//    		@RequestParam("recruitSchool") String recruitSchool,
//    		@RequestParam("recruitType") String recruitType,
//    		@RequestParam("remark") String remark,
//    		@RequestParam("scholarship") String scholarship,
//    		@RequestParam("secondVolunteer") String secondVolunteer,
//    		@RequestParam("teacherId") String teacherId,
//    		@RequestParam("studentId") String studentId
//          ) throws IOException, ParseException{
//		JSONObject obj = new JSONObject();
//		StudentSignModel sts = new StudentSignModel();
//		sts.setCharge(Double.parseDouble(charge));
//		sts.setSchoolId(Integer.parseInt(schoolId));
//		sts.setDiscount(discount);
//		sts.setDream(dream.equals("")?null:Integer.parseInt(dream));
//		sts.setDreamType(dreamType);
//		sts.setEntranceGrade(entranceGrade);
//		sts.setEntranceType(entranceType.equals("")?null:Integer.parseInt(entranceType));
//		sts.setExaminationAreaId(examinationAreaId.equals("")?null:Integer.parseInt(examinationAreaId));
//		sts.setFirstVolunteer(firstVolunteer.equals("")?null:Integer.parseInt(firstVolunteer));
//		sts.setFullType(fullType.equals("")?null:Integer.parseInt(fullType));
//		sts.setInputTime(inputTime.equals("")?null:formatter.parse(inputTime));
//		sts.setPlus(plus.equals("")?0:Integer.parseInt(plus));
//		sts.setPlusCondition(plusCondition.equals("")?null:Integer.parseInt(plusCondition));
//		sts.setArrangement(arrangement.equals("")?null:Integer.parseInt(arrangement));
//		sts.setRecruitSchool(recruitSchool.equals("")?null:Integer.parseInt(recruitSchool));
//		sts.setRecruitType(recruitType.equals("")?null:Integer.parseInt(recruitType));
//		sts.setRemark(remark);
//		sts.setScholarship(scholarship);
//		sts.setSecondVolunteer(secondVolunteer.equals("")?null:Integer.parseInt(secondVolunteer));
//		sts.setTeacherId(teacherId.equals("")?null:Integer.parseInt(teacherId));
//		sts.setStudentId(Integer.parseInt(studentId));
//		try{	
//			dao.addStudentSign(sts);
//			obj.put("code", "0");
//		} catch (Exception e) {
//			obj.put("code", "1");
//			// TODO: handle exception
//		}
//		return obj;
//		
//	}
//	/**
//	 * 查询报读信息
//	 * @param id
//	 * @return
//	 */
//	@ResponseBody
//	@RequestMapping("/querySignDetail")
//	public JSONObject querySignDetail(@RequestParam("id") String id){
//		JSONObject obj = new JSONObject();
//		try {
//			StudentSignModel stu = dao.querySignDetail(id);
//			obj.put("code", "0");
//			obj.put("result", stu);
//		} catch (Exception e) {
//			// TODO: handle exception
//			obj.put("code", "1");
//		}
//		return obj;
//	}
//	/**
//	 * 更新报读信息
//	 * @return
//	 * @throws IOException
//	 * @throws ParseException
//	 */
//	@RequestMapping(value = "/updateSign.do")
//    @ResponseBody
//    public JSONObject updateSign(
//    		@RequestParam("charge") String charge,
//    		@RequestParam("city") String schoolId,
//    		@RequestParam("discount") String discount,
//    		@RequestParam("dream") String dream,
//    		@RequestParam("dreamType") String dreamType,
//    		@RequestParam("entranceGrade") String entranceGrade,
//    		@RequestParam("entranceType") String entranceType,
//    		@RequestParam("examinationAreaId") String examinationAreaId,
//    		@RequestParam("firstVolunteer") String firstVolunteer,
//    		@RequestParam("fullType") String fullType,
//    		@RequestParam("inputTime") String inputTime,
//    		@RequestParam("plus") String plus,
//    		@RequestParam("plusCondition") String plusCondition,
//    		@RequestParam("province") String arrangement,
//    		@RequestParam("recruitSchool") String recruitSchool,
//    		@RequestParam("recruitType") String recruitType,
//    		@RequestParam("remark") String remark,
//    		@RequestParam("scholarship") String scholarship,
//    		@RequestParam("secondVolunteer") String secondVolunteer,
//    		@RequestParam("teacherId") String teacherId,
//    		@RequestParam("studentId") String studentId
//          ) throws IOException, ParseException{
//		JSONObject obj = new JSONObject();
//		StudentSignModel sts = new StudentSignModel();
//		sts.setCharge(Double.parseDouble(charge));
//		sts.setSchoolId(Integer.parseInt(schoolId));
//		sts.setDiscount(discount);
//		sts.setDream(dream.equals("")?null:Integer.parseInt(dream));
//		sts.setDreamType(dreamType);
//		sts.setEntranceGrade(entranceGrade);
//		sts.setEntranceType(entranceType.equals("")?null:Integer.parseInt(entranceType));
//		sts.setExaminationAreaId(examinationAreaId.equals("")?null:Integer.parseInt(examinationAreaId));
//		sts.setFirstVolunteer(firstVolunteer.equals("")?null:Integer.parseInt(firstVolunteer));
//		sts.setFullType(fullType.equals("")?null:Integer.parseInt(fullType));
//		sts.setInputTime(inputTime.equals("")?null:formatter.parse(inputTime));
//		sts.setPlus(plus.equals("")?0:Integer.parseInt(plus));
//		sts.setPlusCondition(plusCondition.equals("")?null:Integer.parseInt(plusCondition));
//		sts.setArrangement(arrangement.equals("")?null:Integer.parseInt(arrangement));
//		sts.setRecruitSchool(recruitSchool.equals("")?null:Integer.parseInt(recruitSchool));
//		sts.setRecruitType(recruitType.equals("")?null:Integer.parseInt(recruitType));
//		sts.setRemark(remark);
//		sts.setScholarship(scholarship);
//		sts.setSecondVolunteer(secondVolunteer.equals("")?null:Integer.parseInt(secondVolunteer));
//		sts.setTeacherId(teacherId.equals("")?null:Integer.parseInt(teacherId));
//		sts.setStudentId(Integer.parseInt(studentId));
//		try{	
//			dao.updateStudentSign(sts);
//			obj.put("code", "0");
//		} catch (Exception e) {
//			obj.put("code", "1");
//			// TODO: handle exception
//		}
//		return obj;
//		
//	}
//	/**
//	 * 上传材料
//	 * @param cardIdFile
//	 * @param cardIdBackFile
//	 * @param graduationCertificate
//	 * @param studentId
//	 * @return
//	 */
//	@RequestMapping(value = "/addFile.do")
//    @ResponseBody
//    public JSONObject addFile(
//    		@RequestParam("cardIdFile") String cardIdFile,
//    		@RequestParam("cardIdBackFile") String cardIdBackFile,
//    		@RequestParam("graduationCertificate") String graduationCertificate,
//    		@RequestParam("blueBackPhoto") String blueBackPhoto,
//    		@RequestParam("whiteBackPhoto") String whiteBackPhoto,
//    		@RequestParam("employCertificate") String employCertificate,
//    		@RequestParam("admission") String admission,
//    		@RequestParam("studentId") String studentId
//    		){
//		JSONObject obj = new JSONObject();
//		FileModel file = new FileModel();
//		file.setCardIdFile(cardIdFile);
//		file.setCardIdBackFile(cardIdBackFile);
//		file.setGraduationCertificate(graduationCertificate);
//		file.setBlueBackPhoto(blueBackPhoto);
//		file.setWhiteBackPhoto(whiteBackPhoto);
//		file.setEmployCertificate(employCertificate);
//		file.setAdmission(admission);
//		file.setStudentId(Integer.parseInt(studentId));
//		if(cardIdFile==null || cardIdBackFile==null || graduationCertificate==null || blueBackPhoto==null 
//				|| whiteBackPhoto==null ||employCertificate==null||admission==null ||cardIdFile.equals("") || 
//				cardIdBackFile.equals("") || graduationCertificate.equals("") || blueBackPhoto.equals("") 
//				|| whiteBackPhoto.equals("") ||employCertificate.equals("")||admission.equals("")){
//			file.setComplete(0);
//		}else{
//			file.setComplete(1);
//		}
//		try {
//			dao.addFile(file);
//			obj.put("code", "0");
//		} catch (Exception e) {
//			// TODO: handle exception
//			obj.put("code", "1");
//		}
//		return obj;
//	}
//	/**
//	 * 更新材料
//	 * @param cardIdFile
//	 * @param cardIdBackFile
//	 * @param graduationCertificate
//	 * @param studentId
//	 * @return
//	 */
//	@RequestMapping(value = "/updateFile.do")
//    @ResponseBody
//    public JSONObject updateFile(
//    		@RequestParam("cardIdFile") String cardIdFile,
//    		@RequestParam("cardIdBackFile") String cardIdBackFile,
//    		@RequestParam("graduationCertificate") String graduationCertificate,
//    		@RequestParam("blueBackPhoto") String blueBackPhoto,
//    		@RequestParam("whiteBackPhoto") String whiteBackPhoto,
//    		@RequestParam("employCertificate") String employCertificate,
//    		@RequestParam("admission") String admission,
//    		@RequestParam("studentId") String studentId
//    		){
//		JSONObject obj = new JSONObject();
//		FileModel file = new FileModel();
//		file.setCardIdFile(cardIdFile);
//		file.setCardIdBackFile(cardIdBackFile);
//		file.setGraduationCertificate(graduationCertificate);
//		file.setBlueBackPhoto(blueBackPhoto);
//		file.setWhiteBackPhoto(whiteBackPhoto);
//		file.setEmployCertificate(employCertificate);
//		file.setAdmission(admission);
//		file.setStudentId(Integer.parseInt(studentId));
//		if(cardIdFile==null || cardIdBackFile==null || graduationCertificate==null || blueBackPhoto==null 
//				|| whiteBackPhoto==null ||employCertificate==null||admission==null ||cardIdFile.equals("") || 
//						cardIdBackFile.equals("") || graduationCertificate.equals("") || blueBackPhoto.equals("") 
//						|| whiteBackPhoto.equals("") ||employCertificate.equals("")||admission.equals("")){
//			file.setComplete(0);
//		}else{
//			file.setComplete(1);
//		}
//		try {
//			dao.updateFile(file);
//			obj.put("code", "0");
//		} catch (Exception e) {
//			// TODO: handle exception
//			obj.put("code", "1");
//		}
//		return obj;
//	}
//	/**
//	 * 查询当前的材料
//	 * @param id
//	 * @return
//	 */
//	@ResponseBody
//	@RequestMapping("/queryFile")
//	public JSONObject queryFile(@RequestParam("id") String id){
//		JSONObject obj = new JSONObject();
//		try {
//			FileModel file = dao.queryFile(id);
//			obj.put("code", "0");
//			obj.put("result", file);
//		} catch (Exception e) {
//			// TODO: handle exception
//			obj.put("code", "1");
//		}
//		return obj;
//	}
//	/**
//	 * 学员列表
//	 * @param curr
//	 * @param limit
//	 * @param name
//	 * @param adminId
//	 * @param parentId
//	 * @param status
//	 * @param start
//	 * @param end
//	 * @param type
//	 * @param teacher
//	 * @param field
//	 * @return
//	 */
//	@ResponseBody
//	@RequestMapping("/list")
//	public JSONObject stuList(
//			@RequestParam("curr") String curr,
//			@RequestParam("limit") String limit,
//			@RequestParam(value="name",required=false) String name,
//			@RequestParam(value="adminId",required=false) String adminId,
//			@RequestParam(value="parentId",required=false) String parentId,
//			@RequestParam(value="status",required=false) String status,
//			@RequestParam(value="start",required=false) String start,
//			@RequestParam(value="end",required=false) String end,
//			@RequestParam(value="type",required=false) String type,
//			@RequestParam(value="teacher",required=false) String teacher,
//			@RequestParam(value="field",required=false) String field){
//		JSONObject obj = new JSONObject();
//		Map<String, Object> map = new HashMap<>();
//		try {
//			if(name==null){
//				map.put("name","");
//			}else{
//				map.put("name",name);
//			}
//			if(adminId==null || adminId.equals("")){
//				map.put("adminId","");
//			}else{
//				map.put("adminId",Integer.parseInt(adminId));
//			}
//			if(parentId==null || parentId.equals("")){
//				map.put("parentId","");
//			}else{
//				map.put("parentId",Integer.parseInt(parentId));
//			}
//			if(status==null || status.equals("")){
//				map.put("status","");
//			}else{
//				map.put("status",strToArr(status));
//			}
//			if(start==null || start.equals("")){
//				map.put("start",null);
//			}else{
//				map.put("start",formatter.parse(start));
//			}
//			if(end==null || end.equals("")){
//				map.put("end",null);
//			}else{
//				map.put("end",formatter.parse(end));
//			}
//			if(teacher==null || teacher.equals("")){
//				map.put("teacher","");
//			}else{
//				map.put("teacher",Integer.parseInt(teacher));
//			}
//			if(type==null || type.equals("")){
//				map.put("type","");
//			}else{
//				map.put("type",Integer.parseInt(type));
//			}
//			map.put("curr", Integer.parseInt(curr)*Integer.parseInt(limit));
//			map.put("limit",Integer.parseInt(limit));
//			map.put("name",name);
//			if(field!=null && !field.equals("")){//后期加的筛选条件
//				JSONObject Obj = JSONObject.parseObject(field);
//				StudentModel stu = Obj.toJavaObject(StudentModel.class);
//				map.put("xxname", stu.getName());
//				map.put("xxcardId", stu.getCardId());
//				map.put("xxphone", stu.getPhone());
//				map.put("xxgrade", stu.getEntranceGrade());
//				map.put("xxrecruitType", stu.getRecruitType());
//				map.put("xxfullType", stu.getFullType());
//				map.put("xxdream", stu.getDream());
//				map.put("xxarrangement", stu.getArrangement());
//				map.put("xxstart", stu.getStart());
//				map.put("xxend", stu.getEnd());
//				map.put("xxplusCondition", stu.getPlusCondition());
//				map.put("xxplus", stu.getPlus());
//				map.put("xxstatus", stu.getCheckStatus());
//			}else{
//				map.put("xxname", "");
//				map.put("xxcarlId", "");
//				map.put("xxphone", "");
//				map.put("xxgrade", "");
//				map.put("xxrecruitType", "");
//				map.put("xxfullType", "");
//				map.put("xxdream", "");
//				map.put("xxarrangement", "");
//				map.put("xxstart", null);
//				map.put("xxend", null);
//				map.put("xxplusCondition", "");
//				map.put("xxplus", "");
//				map.put("xxstatus", "");
//			}
//			List<StudentModel> list = dao.queryList(map);
//			obj.put("code", "0");
//			obj.put("result", list);
//		} catch (Exception e) {
//			// TODO: handle exception
//			obj.put("code", "1");
//		}
//		return obj;
//	}
//	/**
//	 * 用于分页的计数
//	 * @param name
//	 * @param adminId
//	 * @param parentId
//	 * @param status
//	 * @param field
//	 * @return
//	 */
//	@ResponseBody
//	@RequestMapping("/usersNum")
//	public Integer usersNum(
//			@RequestParam("name") String name,
//			@RequestParam(value="adminId",required=false) String adminId,
//			@RequestParam(value="parentId",required=false) String parentId,
//			@RequestParam(value="status",required=false) String status,
//			@RequestParam(value="field",required=false)String field){
//		Map<String, Object> map = new HashMap<>();
//		JSONObject obj = new JSONObject();
//		if(adminId==null || adminId.equals("")){
//			map.put("adminId","");
//		}else{
//			map.put("adminId",Integer.parseInt(adminId));
//		}
//		if(parentId==null || parentId.equals("")){
//			map.put("parentId","");
//		}else{
//			map.put("parentId",Integer.parseInt(parentId));
//		}
//		if(status==null || status.equals("")){
//			map.put("status","");
//		}else{
//			map.put("status",strToArr(status));
//		}
//		if(field!=null && !field.equals("")){
//			JSONObject Obj = JSONObject.parseObject(field);
//			StudentModel stu = Obj.toJavaObject(StudentModel.class);
//			map.put("xxname", stu.getName());
//			map.put("xxcardId", stu.getCardId());
//			map.put("xxphone", stu.getPhone());
//			map.put("xxgrade", stu.getEntranceGrade());
//			map.put("xxrecruitType", stu.getRecruitType());
//			map.put("xxfullType", stu.getFullType());
//			map.put("xxdream", stu.getDream());
//			map.put("xxarrangement", stu.getArrangement());
//			map.put("xxstart", stu.getStart());
//			map.put("xxend", stu.getEnd());
//			map.put("xxplusCondition", stu.getPlusCondition());
//			map.put("xxplus", stu.getPlus());
//			map.put("xxstatus", stu.getCheckStatus());
//		}else{
//			map.put("xxname", "");
//			map.put("xxcarlId", "");
//			map.put("xxphone", "");
//			map.put("xxgrade", "");
//			map.put("xxrecruitType", "");
//			map.put("xxfullType", "");
//			map.put("xxdream", "");
//			map.put("xxarrangement", "");
//			map.put("xxstart", null);
//			map.put("xxend", null);
//			map.put("xxplusCondition", "");
//			map.put("xxplus", "");
//			map.put("xxstatus", "");
//		}
//		map.put("name", name);
//		return dao.queryCount(map);
//	}
//	/**
//	 * 单用于下属的统计
//	 * @param name
//	 * @param adminId
//	 * @param parentId
//	 * @param status
//	 * @param start
//	 * @param end
//	 * @param teacher
//	 * @param type
//	 * @return
//	 * @throws ParseException
//	 */
//	@ResponseBody
//	@RequestMapping("/usersNumNext")
//	public Integer usersNum(
//			@RequestParam(value="name",required=false) String name,
//			@RequestParam(value="adminId",required=false) String adminId,
//			@RequestParam(value="parentId",required=false) String parentId,
//			@RequestParam(value="status",required=false) String status,
//			@RequestParam(value="start",required=false) String start,
//			@RequestParam(value="end",required=false) String end,
//			@RequestParam(value="teacher",required=false) String teacher,
//			@RequestParam(value="type",required=false) String type) throws ParseException{
//		Map<String, Object> map = new HashMap<>();
//		if(name==null){
//			map.put("name","");
//		}else{
//			map.put("name",name);
//		}
//		if(adminId==null || adminId.equals("")){
//			map.put("adminId","");
//		}else{
//			map.put("adminId",Integer.parseInt(adminId));
//		}
//		if(parentId==null || parentId.equals("")){
//			map.put("parentId","");
//		}else{
//			map.put("parentId",Integer.parseInt(parentId));
//		}
//		if(status==null || status.equals("")){
//			map.put("status","");
//		}else{
//			map.put("status",strToArr(status));
//		}
//		if(start==null || start.equals("")){
//			map.put("start",null);
//		}else{
//			map.put("start",formatter.parse(start));
//		}
//		if(end==null || end.equals("")){
//			map.put("end",null);
//		}else{
//			map.put("end",formatter.parse(end));
//		}
//		if(teacher==null || teacher.equals("")){
//			map.put("teacher","");
//		}else{
//			map.put("teacher",Integer.parseInt(teacher));
//		}
//		if(type==null || type.equals("")){
//			map.put("type","");
//		}else{
//			map.put("type",Integer.parseInt(type));
//		}
//		return dao.queryCountNext(map);
//	}
//	/**
//	 * 增加收费
//	 * @param data
//	 * @return
//	 * @throws ParseException
//	 */
//	@RequestMapping(value = "/addFee.do")
//    @ResponseBody
//    public JSONObject addFee(
//    		@RequestParam("data") String data
//    		) throws ParseException{
//		JSONObject obj = new JSONObject();
//		try {
//			JSONArray arr = JSONArray.parseArray(data);//字符串转arr
//			List<FeeModel> list = arr.toJavaList(FeeModel.class);//转list
//			List<FeeModel> copyList = arr.toJavaList(FeeModel.class);//用于更新的备份 一部分更新 一部分新增
//			List<FeeModel> oldFee = dao.queryFee(list.get(0).getStudentId());
//			if(oldFee==null || oldFee.size()==0){
//				dao.addFee(list);
//			}else{
//				if(oldFee.size()==list.size()){
//					dao.updateFeeList(list);
//				}else{
//					for (int i = 0; i < list.size()-oldFee.size(); i++) {
//						copyList.remove(oldFee.size()+i);
//						dao.addFeeSingle(list.get(oldFee.size()+i));
//					}
//					dao.updateFeeList(copyList);
//				}
//			}
//			obj.put("code", "0");
//		} catch (Exception e) {
//			// TODO: handle exception
//			obj.put("code", "1");
//		}
//		return obj;
//	}
//	/**
//	 * 查询fee
//	 * @param studentId
//	 * @return
//	 * @throws ParseException
//	 */
//	@RequestMapping(value = "/queryFee.do")
//    @ResponseBody
//    public JSONObject queryFee(
//    		@RequestParam("studentId") String studentId
//    		) throws ParseException{
//		JSONObject obj = new JSONObject();
//		try {
//			List<FeeModel> oldFee = dao.queryFee(Integer.parseInt(studentId));
//			obj.put("code", "0");
//			obj.put("data", oldFee);
//		} catch (Exception e) {
//			// TODO: handle exception
//			obj.put("code", "1");
//		}
//		return obj;
//	}
//	/**
//	 * 增加成绩
//	 * @param data
//	 * @return
//	 */
//	@RequestMapping(value = "/addScore.do")
//    @ResponseBody
//    public JSONObject addScore(
//    		@RequestParam("data")String data
//    		){
//		JSONObject obj = new JSONObject();
//		try {
//			JSONArray arr = JSONArray.parseArray(data);
//			List<ScoreModel> list = arr.toJavaList(ScoreModel.class);
//			dao.addScore(list);
//			obj.put("code", "0");
//		} catch (Exception e) {
//			// TODO: handle exception
//			obj.put("code", "1");
//		}
//		
//		return obj;
//	}
//	/**
//	 * 查询成绩
//	 * @param studentId
//	 * @return
//	 */
//	@RequestMapping(value = "/queryScore.do")
//    @ResponseBody
//    public JSONObject queryScore(
//    		@RequestParam("studentId") String studentId
//    		){
//		JSONObject obj = new JSONObject();
//		ScoreModel sc = new ScoreModel();
//		try {
//			sc.setStudentId(Integer.parseInt(studentId));
//			List<ScoreModel> scList = dao.queryScore(sc);
//			JSONArray jsonArray2 = getJSONArrayByList(scList);
//			obj.put("data", jsonArray2);
//			obj.put("code", "0");
//		} catch (Exception e) {
//			// TODO: handle exception
//			obj.put("code", "1");
//		}
//		
//		return obj;
//	}
//	/**
//	 * 审核资料和缴费，邮寄
//	 * @param studentId
//	 * @param checkStatus
//	 * @param post
//	 * @param complete
//	 * @return
//	 */
//	@RequestMapping(value = "/review.do")
//    @ResponseBody
//    public JSONObject review(
//    		Integer studentId,Integer checkStatus,Integer post,Integer complete,String status
//    		){
//		JSONObject obj = new JSONObject();
//		try {
//			if(checkStatus!=null){
//				dao.updateStatus(studentId,checkStatus);
//				dao.updateStatusSign(studentId,checkStatus);
//			}
//			if(post!=null){
//				dao.insertPost(studentId,post);
//			}
//			if(complete!=null){
////				dao.updateFee(studentId,complete);
//			}
//			if(status!=null && !status.equals("")){
//				dao.updateFee(studentId,"",0);
//				String[] split = status.split(",");
//				for (int i = 0; i < split.length; i++) {
//					dao.updateFee(studentId,split[i],1);
//				}
//			}
//			obj.put("code", "0");
//		} catch (Exception e) {
//			// TODO: handle exception
//			obj.put("code", "1");
//		}
//		
//		return obj;
//	}
//	/**
//	 * 更新资料的状态
//	 * @param studentId
//	 * @param checkStatus
//	 * @return
//	 */
//	@RequestMapping(value = "/updateStatus.do")
//    @ResponseBody
//    public JSONObject updateStatus(
//    		Integer studentId,Integer checkStatus
//    		){
//		JSONObject obj = new JSONObject();
//		try {
//			if(checkStatus!=null){
//				dao.updateStatus(studentId,checkStatus);
//				dao.updateStatusSign(studentId,checkStatus);
//			}
//			obj.put("code", "0");
//		} catch (Exception e) {
//			// TODO: handle exception
//			obj.put("code", "1");
//		}
//		
//		return obj;
//	}
//	/**
//	 * 删除学员（仅超级管理员）
//	 * @param stuId
//	 * @return
//	 */
//	@RequestMapping(value = "/delStudent.do")
//    @ResponseBody
//    public JSONObject delStudent(
//    		Integer stuId
//    		){
//		JSONObject obj = new JSONObject();
//		try {
//			if(stuId!=null){
//				dao.delStudent(stuId);
//			}
//			obj.put("code", "0");
//		} catch (Exception e) {
//			// TODO: handle exception
//			obj.put("code", "1");
//		}
//		
//		return obj;
//	}
//	
//	@RequestMapping(value = "/updateAssign.do")
//    @ResponseBody
//    public JSONObject updateAssign(
//    		Integer stuId,Integer teach,String name
//    		){
//		JSONObject obj = new JSONObject();
//		try {
//			if(stuId!=null){
//				dao.updateAssign(stuId,teach);
//				dao.updateAssignSign(stuId,teach);
//			}
//			obj.put("code", "0");
//		} catch (Exception e) {
//			// TODO: handle exception
//			obj.put("code", "1");
//		}
//		
//		return obj;
//	}
//	
//	/**
//     * List转JSONArray
//     * @param list
//     * @return
//     */
//    public static JSONArray getJSONArrayByList(List<?> list){
//        JSONArray jsonArray = new JSONArray();
//        if (list==null ||list.isEmpty()) {
//            return jsonArray;//nerver return null
//        }
//
//        for (Object object : list) {
//            jsonArray.add(object);
//        }
//        return jsonArray;
//    }
//    /**
//     * str转string[]
//     * @param str
//     * @return
//     */
//    public String[] strToArr(String str) {
//    	String[] arrayStr =new String[]{};
//    	String[] aa = new String[1];
//    	if(str.indexOf(",")!=-1){
//    		arrayStr =(String[])str.split(",");
//    	}else{
//    		aa[0]=str;
//    		arrayStr=aa;
//    	}
////        arrayStr =(String[]) (str.indexOf(",")!=-1? str.split(","):str+"");
//        return arrayStr;
//	}
}
