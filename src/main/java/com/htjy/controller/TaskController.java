package com.htjy.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.config.Task;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.htjy.dao.TaskDao;
import com.htjy.entity.TaskApplyModel;
import com.htjy.entity.TaskModel;
import com.htjy.entity.TaskScheduleModel;
import com.htjy.entity.UserModel;
import com.htjy.service.impl.ComparatorImpl;
import com.htjy.util.DateUtils;
import com.htjy.util.ReadUrlUtil;

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
	/**
	 * 任务列表
	 * @param title
	 * @return
	 * @throws IOException
	 * @throws ParseException
	 */
	@RequestMapping(value = "/getManageTaskList.do")
    @ResponseBody
    public JSONObject getTaskList(@RequestParam("title") String title) throws IOException, ParseException{
		JSONObject obj = new JSONObject();
		List<TaskModel> listModel = taskDao.getTaskList(title);
		obj.put("code", 0);
		obj.put("result", listModel);
		return obj;
	}
	/**
	 * 这是编辑任务的详细
	 * @param tid
	 * @return
	 */
	@RequestMapping(value="/getTaskDetail.do")
	@ResponseBody
	public JSONObject getTaskDetail(@RequestParam("tid") String tid){
		JSONObject obj = new JSONObject();
		TaskModel taskModel = taskDao.getTaskDetail(tid);
		obj.put("code", 0);
		obj.put("result", taskModel);
		return obj;
	}
	/**
	 * 获取个人中心页面的四种状态的数字
	 * @param request
	 * @param response
	 * @param session
	 * @return
	 */
	@RequestMapping("/getUserTaskStatus.do")
	@ResponseBody
	public JSONObject getUserTaskStatus(HttpServletRequest request, HttpServletResponse response, HttpSession session){
		UserModel u = (UserModel) session.getAttribute("user");
		JSONObject obj = new JSONObject();
		if(u!=null){
			Integer id = u.getId();
			Integer noCom = taskDao.getUserNoCompleteNum(id);
			Integer noCheck = taskDao.getUserNoCheckNum(id);
			Integer com = taskDao.getUserCompleteNum(id);
			Integer fail = taskDao.getUserFailNum(id);
			obj.put("code", "0");
			obj.put("noCom", noCom);
			obj.put("noCheck", noCheck);
			obj.put("com", com);
			obj.put("fail", fail);
		}else{
			obj.put("code", "1");
		}
		return obj;
	}
	/**
	 * 获取首页三个标签的不同tasklist
	 * @param myAddress
	 * @param flag
	 * @param request
	 * @param response
	 * @param session
	 * @return
	 * @throws JSONException
	 * @throws IOException
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping("/getTodayTaskList.do")
	@ResponseBody
	public JSONObject getTodayTaskList(
			@RequestParam("myAddress") String myAddress,
			@RequestParam("flag") String flag,
			HttpServletRequest request, HttpServletResponse response, HttpSession session) throws JSONException, IOException{
		UserModel u = (UserModel) session.getAttribute("user");
		JSONObject obj = new JSONObject();
		if(u!=null){
			List<TaskModel> listTodayList = new ArrayList<TaskModel>();
			if(flag.equals("1")){
				listTodayList= taskDao.getTodayTaskList(u.getId());//这里是随机的顺序的任务列表
			}else{
				listTodayList= taskDao.getTodayTaskListScore(u.getId());//这里是赏金的顺序的任务列表
			}
			if(listTodayList.size()==0){
				obj.put("code", "2");
				return obj;
			}
			String strLocation = "";
			for (TaskModel task : listTodayList) {
				strLocation = strLocation + task.getLocation()+"|";
			}
			//strLocation类似 天安门|北京西站|上海滩 这种格式
			strLocation = strLocation.equals("")? "":strLocation.substring(0, strLocation.length()-1);
			//调用百度地图的距离接口
			JSONObject o = ReadUrlUtil.readJsonFromUrl("http://api.map.baidu.com/direction/v1/routematrix?output=json&origins="+strLocation+"&destinations="+myAddress+"&ak=z1mGbIzrx8mkXmBl8Ik1Epyp"); 
			JSONObject result = (JSONObject) o.get("result");
			JSONArray element = (JSONArray) result.get("elements");
			for (int i = 0; i < element.size(); i++) {
				JSONObject ele = element.getJSONObject(i);
				JSONObject distance = (JSONObject) ele.get("distance");
				Integer dis = (int) distance.get("value");
				listTodayList.get(i).setDistance(dis);
			}
			if(flag.equals("2")){//按distance排序
				Comparator comp = new ComparatorImpl();
				Collections.sort(listTodayList, comp);
			}
			obj.put("code", "0");
			obj.put("result", listTodayList);
		}
		return obj;
	}
	/**
	 * 获取可用任务的点击详细
	 * @param id
	 * @return
	 */
	@RequestMapping("/getTodayTaskDetail.do")
	@ResponseBody
	public JSONObject getTodayTaskDetail(@RequestParam("id")String id){
		TaskModel t = taskDao.getTodayTaskDetail(id);
		JSONObject o = new JSONObject();
		o.put("code", "0");
		o.put("result", t);
		return o;
	}
	/**
	 * 接收任务
	 * @param id
	 * @param period
	 * @param request
	 * @param response
	 * @param session
	 * @return
	 */
	@RequestMapping("/acceptTask.do")
	@ResponseBody
	public JSONObject acceptTask(
			@RequestParam("id")String id,
			@RequestParam("period")String period,
			HttpServletRequest request, HttpServletResponse response, HttpSession session
			){
		TaskApplyModel apply = new TaskApplyModel();
		UserModel u = (UserModel) session.getAttribute("user");
		Integer sid = taskDao.getSidById(id);
		long currentTime = System.currentTimeMillis() ;
		if(period.equals("30分钟")){//计算结束时间
			apply.setStartTime(new Date(currentTime));
			currentTime +=30*60*1000;
			apply.setEndTime(new Date(currentTime));
		}else if(period.equals("1小时")){
			apply.setStartTime(new Date(currentTime));
			currentTime +=60*60*1000;
			apply.setEndTime(new Date(currentTime));
		}else if(period.equals("2小时")){
			apply.setStartTime(new Date(currentTime));
			currentTime +=120*60*1000;
			apply.setEndTime(new Date(currentTime));
		}
		apply.setSid(sid);
		apply.setUserId(u.getId());
		apply.setStatus(0);
		taskDao.acceptTask(apply);
		Integer tid = apply.getAid();//获取记录的id
		JSONObject o = new JSONObject();
		o.put("code", "0");
		o.put("result", tid);
		return o;
	}
	/**
	 * 获取我接受的任务列表（四个状态）
	 * @param status
	 * @param request
	 * @param response
	 * @param session
	 * @return
	 */
	@RequestMapping("/getMyAcceptTaskList.do")
	@ResponseBody
	public JSONObject getMyAcceptTaskList(
			@RequestParam("status")String status,
			HttpServletRequest request, HttpServletResponse response, HttpSession session){
		
		JSONObject o = new JSONObject();
		UserModel u= (UserModel)session.getAttribute("user");
		if(u!=null){
			Integer id= u.getId();
			List<TaskModel>list = taskDao.getMyAcceptTaskList(id,status);
			o.put("code", "0");
			o.put("result", list);
		}
		return o;
	}
	/**
	 * 获取进行中的任务的详细
	 * @param sid
	 * @param request
	 * @param response
	 * @param session
	 * @return
	 */
	@RequestMapping("/getTaskingDetail.do")
	@ResponseBody
	public JSONObject getTaskingDetail(
			@RequestParam("sid")String sid,
			HttpServletRequest request, HttpServletResponse response, HttpSession session){
		JSONObject o = new JSONObject();
		UserModel u = (UserModel)session.getAttribute("user");
		TaskModel t = taskDao.getTaskingDetail(sid,u.getId()+"");
		o.put("code", "0");
		o.put("result", t);
		return o;
	}
	/**
	 * 取消任务
	 * @param aid
	 * @param request
	 * @param response
	 * @param session
	 * @return
	 */
	@RequestMapping("/cancelMyAcceptTask.do")
	@ResponseBody
	public JSONObject cancelMyAcceptTask(
			@RequestParam("aid") String aid,
			HttpServletRequest request, HttpServletResponse response, HttpSession session)
	{
		JSONObject o = new JSONObject();
		taskDao.cancelMyAcceptTask(aid);
		o.put("code", "0");
		return o;
	}
	/**
	 * 审核任务列表  （完成任务写在上传图片那里了）
	 * @return
	 */
	@RequestMapping("/checkingTaskList.do")
	@ResponseBody
	public JSONObject checkingTaskList(){
		JSONObject obj = new JSONObject();
		List<TaskModel> listModel = taskDao.getCheckingTaskList();
		obj.put("code", 0);
		obj.put("result", listModel);
		return obj;
	}
	
	/**
	 * 审核任务成功  （完成任务写在上传图片那里了）
	 * @return
	 */
	@RequestMapping("/updateTaskingStatusOk.do")
	@ResponseBody
	public JSONObject updateTaskingStatusOk(@RequestParam("aid")String aid){
		JSONObject obj = new JSONObject();
		taskDao.updateTaskingStatusOk(aid);
		obj.put("code", 0);
		return obj;
	}
	
	/**
	 * 审核任务失败  （完成任务写在上传图片那里了）
	 * @return
	 */
	@RequestMapping("/updateTaskingStatusNo.do")
	@ResponseBody
	public JSONObject updateTaskingStatusNo(@RequestParam("aid")String aid){
		JSONObject obj = new JSONObject();
		taskDao.updateTaskingStatusNo(aid);
		obj.put("code", 0);
		return obj;
	}
}
