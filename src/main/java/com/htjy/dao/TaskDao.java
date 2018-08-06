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
	 * 做任务 传图片,传位置 更新状态
	 * @param fileName
	 * @param aid
	 * @param ad 
	 */
	void updateTaskingStatus(@Param("fileName")String fileName, @Param("aid")String aid, @Param("ad")String ad);
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
	/**
	 * 是否有完全相同的任务已经录入
	 * @param model
	 * @return
	 */
	int queryRepeat(TaskModel model);
	/**
	 * 任务预告（即未上线任务）
	 * @param integer
	 * @return
	 */
	List<TaskModel> getPreTaskList(@Param("id")Integer integer);

	List<TaskModel> getPreTaskListScore(@Param("id")Integer integer);
	/**
	 * 预告按时间顺序
	 * @param object
	 * @return
	 */
	List<TaskModel> getPreTaskListDay(Object object);
	/**
	 * 根据aid查询任务id再查询所有接收任务的人的id
	 * @param aid
	 * @return
	 */
	List<Integer> queryMsgPeopleByAid(@Param("aid")Integer aid);
	/**
	 * 别人完成后，其他人自动过期失败
	 * @param integer
	 * @param alist
	 */
	void updateOtherScheduleStatus(@Param("userId")Integer integer, @Param("sid")List<Integer> alist);
	/**
	 * 预告按热度顺序
	 * @param object
	 * @return
	 */
	List<TaskModel> getPreTaskListFocus(Object object);
	/**
	 * 今日任务按热度顺序
	 * @param object
	 * @return
	 */
	List<TaskModel> getTodayTaskListFocus(@Param("id")Integer integer);
	/**
	 * 后面四个为关注相关
	 * @param tid
	 * @param id
	 */
	void focusSbPlus(@Param("tid")Integer tid, @Param("userId")Integer id);//某人添加关注
	void focusTaskPlus(@Param("tid")Integer tid);//任务增加关注数
	void focusSbDiv(@Param("tid")Integer tid, @Param("userId")Integer id);//某人取消关注
	void focusTaskDiv(@Param("tid")Integer tid);//任务减少关注数
	/**
	 * 获取登录用户下 关注的任务
	 * @param id
	 * @return
	 */
	List<Integer> getUserFocusList(@Param("userId")Integer id);

	List<Integer> selectMsgSid(@Param("aid")int parseInt);
	/**
	 * 根据接收aid获取sid再获取tid
	 * @param aid
	 * @return
	 */
	Integer queryTaskIdByAid(@Param("aid")Integer aid);
	/**
	 * 关闭一个阶段的任务
	 * @param taskId
	 */
	void updateTaskAble(@Param("tid")Integer taskId);
	/**
	 * 查询这个人是否接受了这个任务
	 * @param parseInt
	 * @param id
	 * @return
	 */
	Integer queryTaskIdAndPerson(@Param("tid")Integer parseInt, @Param("userId")Integer id);
	/**
	 * 查询拍照数量和标题
	 * @param aid
	 * @return
	 */
	TaskModel getPhotoNumEtc(@Param("aid")Integer aid);

}
