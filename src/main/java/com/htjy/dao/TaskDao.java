package com.htjy.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.scheduling.config.Task;

import com.htjy.entity.TaskApplyModel;
import com.htjy.entity.TaskModel;
import com.htjy.entity.TaskScheduleModel;

public interface TaskDao {

	Integer addTask(TaskModel task);

	void addTaskSchedule(@Param("list")List<TaskScheduleModel> listSche);

	List<TaskModel> getTaskList(@Param("title")String title);

	TaskModel getTaskDetail(@Param("tid")String tid);
	/**
	 * 获取某人未完成任务
	 * @param id
	 * @return
	 */
	Integer getUserNoCompleteNum(@Param("id")Integer id);
	/**
	 * 获取某人未审核任务
	 * @param id
	 * @return
	 */
	Integer getUserNoCheckNum(@Param("id")Integer id);
	/**
	 * 获取某人已完成任务
	 * @param id
	 * @return
	 */
	Integer getUserCompleteNum(@Param("id")Integer id);
	/**
	 * 获取某人已失败任务
	 * @param id
	 * @return
	 */
	Integer getUserFailNum(@Param("id")Integer id);
	/**
	 * 获取当天可用的任务（随机顺序）
	 * @param integer 
	 * @return
	 */
	List<TaskModel> getTodayTaskList(@Param("id")Integer integer);

	/**
	 * 获取当天可用的任务（赏金顺序）
	 * @param integer 
	 * @return
	 */
	List<TaskModel> getTodayTaskListScore(@Param("id")Integer id);

	TaskModel getTodayTaskDetail(@Param("id")String id);

	void acceptTask(TaskApplyModel apply);
	/**
	 * 根据taskid获取当天排期的id 
	 * @param id
	 * @return
	 */
	Integer getSidById(@Param("id")String id);

	List<TaskModel> getMyAcceptTaskList(@Param("id")Integer id, @Param("status")String status);
	/**
	 * 获取我接受过的任务
	 * @param id
	 * @param string 
	 * @return
	 */
	TaskModel getTaskingDetail(@Param("sid")String sid, @Param("uid")String string);
	/**
	 * 做任务 传图片 更新状态
	 * @param fileName
	 * @param aid
	 */
	void updateTaskingStatus(@Param("fileName")String fileName, @Param("aid")String aid);
	/**
	 * 取消任务
	 * @param aid
	 */
	void cancelMyAcceptTask(@Param("aid")String aid);
	/**
	 * 后台管理审核列表
	 * @return
	 */
	List<TaskModel> getCheckingTaskList();
	/**
	 * 审核任务 修改状态
	 * @param aid
	 * @return 
	 * @return
	 */
	void updateTaskingStatusNo(@Param("aid")String aid);
	void updateTaskingStatusOk(@Param("aid")String aid);


}
