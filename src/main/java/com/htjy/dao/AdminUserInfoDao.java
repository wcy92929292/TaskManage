package com.htjy.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.htjy.entity.AdminUserInfo;

/**
 * 管理员DAO
 * 
 * @TABLE t_admin_user_info
 * @author fuqin.li@ling9527.com
 * @version 2018年3月6日
 */
public interface AdminUserInfoDao {

	AdminUserInfo login(@Param("username") String username, @Param("password")String password);

	List<AdminUserInfo> queryManager();

	void add(AdminUserInfo ad);

	List<AdminUserInfo> queryAll();

	AdminUserInfo queryById(String adminId);

	void update(AdminUserInfo ad);

	List<AdminUserInfo> queryNextTeacher(int i);

	void delAdmin(Integer adminId);

	AdminUserInfo selectAdminIdById(@Param("adminId") Integer id);

	List<AdminUserInfo> queryTeacherList();
}

