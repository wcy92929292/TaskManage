package com.htjy.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.config.Task;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.htjy.dao.TaskDao;
import com.htjy.entity.TaskModel;
import com.htjy.entity.TaskScheduleModel;
import com.htjy.util.DateUtils;

@Controller
@RequestMapping("/task")
public class TaskController {
	
	@Autowired TaskDao taskDao;
	/**
	 * 添加任务
	 * @param address
	 * @param location
	 * @param lockTime
	 * @param remark
	 * @param schedule
	 * @param score
	 * @param title
	 * @param type
	 * @return
	 * @throws IOException
	 * @throws ParseException
	 */
	@RequestMapping(value = "/addTask.do")
    @ResponseBody
    public JSONObject add(
    		@RequestParam("address") String address,
    		@RequestParam("location") String location,
    		@RequestParam("lockTime") String lockTime,
    		@RequestParam("remark") String remark,
    		@RequestParam("schedule") String schedule,//"2018-07-05 - 2018-07-13"
    		@RequestParam("score") String score,
    		@RequestParam("title") String title,
    		@RequestParam("type") String type
          ) throws IOException, ParseException{
		TaskModel task = new TaskModel();
		List<TaskScheduleModel> listSche = new ArrayList<TaskScheduleModel>();
		JSONObject obj = new JSONObject();
		task.setAddress(address);
		task.setLocation(location);
		task.setLockTime(Integer.parseInt(lockTime));
		task.setRemark(remark!=null?remark:"");
		task.setScore(score!=null?Integer.parseInt(score):0);
		task.setTitle(title);
		task.setType(type);
		task.setSchedule(schedule);
		task.setSetPerson(1);
		taskDao.addTask(task);//增加任务
		Integer tid = task.getId();
		//组装一个数组时间数组，准备录入排期
		String[] dateBet = schedule.split(" - ");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date dBegin = sdf.parse(dateBet[0]);
		Date dEnd = sdf.parse(dateBet[1]);
		List<Date> listDate = DateUtils.getDatesBetweenTwoDate(dBegin, dEnd);//生成时间集合
		for(int i=0;i<listDate.size();i++){
			System.out.println(sdf.format(listDate.get(i)));
			TaskScheduleModel taskSche = new TaskScheduleModel();
			taskSche.setTid(tid);
			taskSche.setDaytime(listDate.get(i));
			listSche.add(taskSche);
		}
		taskDao.addTaskSchedule(listSche);
		try {
			obj.put("code", "0");
			return obj;
		} catch (Exception e) {
			// TODO: handle exception
			obj.put("code", "1");
			return obj;
		}
		
		
	}
	
	@RequestMapping(value = "/getManageTaskList.do")
    @ResponseBody
    public JSONObject getTaskList(@RequestParam("title") String title) throws IOException, ParseException{
		JSONObject obj = new JSONObject();
		List<TaskModel> listModel = taskDao.getTaskList(title);
		obj.put("code", 0);
		obj.put("result", listModel);
		return obj;
	}
}
