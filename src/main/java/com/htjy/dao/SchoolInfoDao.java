package com.htjy.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.htjy.dbo.SchoolInfo;

/**
 * 学校信息DAO
 */
public interface SchoolInfoDao {

	List<SchoolInfo> list(@Param("arrangement")Integer arrangement);

}
