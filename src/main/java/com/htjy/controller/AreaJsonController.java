package com.htjy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.htjy.dao.AreaDao;
import com.htjy.entity.AreaModel;
import com.htjy.entity.NationModel;
import com.htjy.entity.RegisterModel;
import com.htjy.entity.SchoolType;

@Controller
@RequestMapping("/area")
public class AreaJsonController {
	@Autowired
	private AreaDao dao;
	/**
	 * 省，市，县三级
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/area1.do", method = RequestMethod.GET)
	public JSONArray AreaJson(){
		List<AreaModel> queryAreaList = dao.queryAreaList();

		JSONArray jsonArray = new JSONArray();
		for(int i = 0;i<queryAreaList.size();i++){
			AreaModel sf = queryAreaList.get(i);
			JSONObject obj_1 = new JSONObject();
			
			
			obj_1.put("code", String.valueOf(sf.getPid()));
			obj_1.put("name", sf.getPname());
			
			JSONArray arr_2 = new JSONArray();
			
			for (int j = 0; j < sf.getCity().size() ; j ++) {

				JSONObject obj_2 = new JSONObject();
				obj_2.put("code", String.valueOf(sf.getCity().get(j).getCid()));
				obj_2.put("name", sf.getCity().get(j).getCname());
				
				
				JSONArray arr_3 = new JSONArray();
				for (int k = 0; k < sf.getCity().get(j).getAreaQus().size(); k++) {
					JSONObject obj_3 = new JSONObject();
					obj_3.put("code", String.valueOf(sf.getCity().get(j).getAreaQus().get(k).getAid()));
					obj_3.put("name", sf.getCity().get(j).getAreaQus().get(k).getAname());
					arr_3.add(obj_3);
				}
				
				obj_2.put("childs", arr_3);
				arr_2.add(obj_2);
			}
			obj_1.put("childs", arr_2);
			
//			System.out.println(obj_1 +"\r\n");
			
			jsonArray.add(obj_1);
		}
			
		return jsonArray;
	} 
	/**
	 * 学习类型，学校，专业三级
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/school.do", method = RequestMethod.GET)
	public JSONArray SchoolJson(){
		List<SchoolType> queryAreaList = dao.querySchoolList();

		JSONArray jsonArray = new JSONArray();
		for(int i = 0;i<queryAreaList.size();i++){
			SchoolType sf = queryAreaList.get(i);
			JSONObject obj_1 = new JSONObject();
			
			
			obj_1.put("code", String.valueOf(sf.getPid()));
			obj_1.put("name", sf.getPname());
			
			JSONArray arr_2 = new JSONArray();
			
			for (int j = 0; j < sf.getSchoolModel().size() ; j ++) {

				JSONObject obj_2 = new JSONObject();
				obj_2.put("code", String.valueOf(sf.getSchoolModel().get(j).getCid()));
				obj_2.put("name", sf.getSchoolModel().get(j).getCname());
				
				
				JSONArray arr_3 = new JSONArray();
				for (int k = 0; k < sf.getSchoolModel().get(j).getSchoolDream().size(); k++) {
					JSONObject obj_3 = new JSONObject();
					obj_3.put("code", String.valueOf(sf.getSchoolModel().get(j).getSchoolDream().get(k).getAid()));
					obj_3.put("name", sf.getSchoolModel().get(j).getSchoolDream().get(k).getAname());
					arr_3.add(obj_3);
				}
				
				obj_2.put("childs", arr_3);
				arr_2.add(obj_2);
			}
			obj_1.put("childs", arr_2);
			
			jsonArray.add(obj_1);
		}
			
		return jsonArray;
	} 
	/**
	 * 考试区县
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/examCounty.do", method = RequestMethod.GET)
	public List<NationModel> examCountyList(){
		return dao.queryExamList();
	}
	/**
	 * 报考的
	 */
	@ResponseBody
	@RequestMapping(value = "/recruit.do", method = RequestMethod.GET)
	public List<NationModel> recruitList(){
		return dao.queryRecruitList();
	}
	/**
	 * 民族
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/nation1.do", method = RequestMethod.GET)
	public List<NationModel> nationList(){
		return dao.queryNationList();
	}
	/**
	 * 户口
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/register.do", method = RequestMethod.GET)
	public List<RegisterModel> register(){
		return dao.queryRegisterList();
	}
}
