package com.htjy.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.htjy.entity.TaskModel;
import com.htjy.entity.TaskScheduleModel;

public interface TaskDao {

	Integer addTask(TaskModel task);

	void addTaskSchedule(@Param("list")List<TaskScheduleModel> listSche);

	List<TaskModel> getTaskList(@Param("title")String title);


}
