package com.htjy.service;

import java.util.List;

import com.htjy.entity.AdminUserInfo;

/**
 * 绠＄悊鍛樼浉鍏充俊鎭疭ervice
 *
 * @author fuqin.li@ling9527.com
 * @version 2017骞�12鏈�13鏃�
 */
public interface AdminUserService {

	AdminUserInfo login(String username, String password);

	List<AdminUserInfo> queryManager();

	void add(AdminUserInfo ad);

	List<AdminUserInfo> queryAll();

	AdminUserInfo queryById(String adminId);

	void update(AdminUserInfo ad);

	List<AdminUserInfo> queryNextTeacher(int i);

	void delAdmin(Integer adminId);

	List<AdminUserInfo> queryTeacherList();
}
