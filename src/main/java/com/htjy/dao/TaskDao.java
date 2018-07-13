package com.htjy.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.scheduling.config.Task;

import com.htjy.entity.ScoreDetailModel;
import com.htjy.entity.TaskApplyModel;
import com.htjy.entity.TaskCollectModel;
import com.htjy.entity.TaskModel;
import com.htjy.entity.TaskScheduleModel;
import com.htjy.entity.UserModel;

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
	TaskModel getTaskingDetail(@Param("aid")String aid, @Param("uid")String string);
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
	/**
	 * 任务总数
	 * @return
	 */
	Integer getTaskNum();
	/**
	 * 待审核的任务数
	 * @return
	 */
	Integer getCheckingTaskNum();
	/**
	 * 今日的任务总数
	 * @param strDate
	 * @return
	 */
	Integer getTodayTaskNum(@Param("strDate")String strDate);
	/**
	 * 自动执行更新时间过期的任务
	 */
	void updateScheduleStatus();
	/**
	 * 更新任务的可用状态
	 * @param tid
	 */
	void updateAvail(@Param("aid")Integer tid);
	/**
	 * 获取用户id 用以加分 更新分
	 * @param aid
	 * @return
	 */
	Integer getUserIdByAid(@Param("aid")String aid);
	/**
	 * 加分
	 * @param userId
	 * @param score
	 * @param integer 
	 * @param integer2 
	 * @param cid 
	 */
	void addSbScore(@Param("userId")Integer userId,@Param("score") Integer score, @Param("type")Integer integer, @Param("status")Integer integer2, @Param("cid")Integer cid);
	/**
	 * 该任务的分数
	 * @param string
	 * @param aid
	 * @return
	 */
	Integer getTaskScore(@Param("userId")String string, @Param("aid")String aid);

	/**
	 * 更新分
	 * @param userId
	 * @param score
	 */
	void updateSbScore(@Param("userId")Integer userId, @Param("score")Integer score);

	List<ScoreDetailModel> getScoreDetails(@Param("userId")Integer id);

	Integer getUserScore(@Param("userId")Integer id);

	void updateBank(@Param("userId")String string, @Param("bank")String bank, @Param("number")String number);

	void updateQrc(@Param("fileName")String fileName,@Param("flag") String flag, @Param("userId")String string);

	UserModel getMyBank(@Param("userId")Integer id);

	int insertCollectScore(TaskCollectModel model);

	List<TaskCollectModel> getApplyCollectionList();
	/**
	 * 提现审核成功
	 * @param cid
	 */
	void updateCollectingStatusOk(@Param("cid")String cid);
	/**
	 * 更新流水状态
	 * @param cid
	 */
	void updateScoreDetailOk(@Param("cid")String cid);
	/**
	 * 提现审核失败
	 * @param cid
	 */
	void updateCollectingStatusNo(@Param("cid")String cid);
	/**
	 * 根据cid找到整个collect提现
	 * @param cid
	 * @return
	 */
	TaskCollectModel getCollectByCid(@Param("cid")String cid);
	/**
	 * 更新流水状态失败
	 * @param cid
	 */
	void updateScoreDetailNo(@Param("cid")String cid);


}
