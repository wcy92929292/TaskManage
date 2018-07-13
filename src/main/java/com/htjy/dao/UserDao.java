package com.htjy.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.htjy.entity.UserModel;

public interface UserDao {

	void addUser(UserModel user);

	UserModel getUserByPhone(@Param("phone")String phone);

	UserModel login(@Param("phone")String phone, @Param("password")String password);

	void addUserScore(@Param("id")String string);

	List<UserModel> getUserList();

}
