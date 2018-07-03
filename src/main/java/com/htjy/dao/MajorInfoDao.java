package com.htjy.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.htjy.dbo.MajorInfo;

/**
 * 专业DAO
 */
public interface MajorInfoDao {

	List<MajorInfo> list(@Param("schoolId") Integer schoolId);

}
