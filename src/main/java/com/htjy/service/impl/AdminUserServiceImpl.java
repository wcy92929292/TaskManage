package com.htjy.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.htjy.dao.AdminUserInfoDao;
import com.htjy.entity.AdminUserInfo;
import com.htjy.service.AdminUserService;

@Service
public class AdminUserServiceImpl implements AdminUserService{

	@Autowired
	private AdminUserInfoDao adminUserInfoDao; 
	
	@Override
	public AdminUserInfo login(String username, String password) {
		return adminUserInfoDao.login(username, password);
	}

	@Override
	public List<AdminUserInfo> queryManager() {
		// TODO Auto-generated method stub
		return adminUserInfoDao.queryManager();
	}

	@Override
	public void add(AdminUserInfo ad) {
		// TODO Auto-generated method stub
		adminUserInfoDao.add(ad);
	}

	@Override
	public List<AdminUserInfo> queryAll() {
		// TODO Auto-generated method stub
		return adminUserInfoDao.queryAll();
	}

	@Override
	public AdminUserInfo queryById(String adminId) {
		// TODO Auto-generated method stub
		return adminUserInfoDao.queryById(adminId);
	}

	@Override
	public void update(AdminUserInfo ad) {
		// TODO Auto-generated method stub
		adminUserInfoDao.update(ad);
	}

	@Override
	public List<AdminUserInfo> queryNextTeacher(int i) {
		// TODO Auto-generated method stub
		return adminUserInfoDao.queryNextTeacher(i);
	}

	@Override
	public void delAdmin(Integer adminId) {
		// TODO Auto-generated method stub
		adminUserInfoDao.delAdmin(adminId);
	}

	@Override
	public List<AdminUserInfo> queryTeacherList() {
		// TODO Auto-generated method stub
		return adminUserInfoDao.queryTeacherList();
	}

}
