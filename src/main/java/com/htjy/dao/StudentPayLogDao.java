package com.htjy.dao;

import com.htjy.dbo.StudentPayLog;


public interface StudentPayLogDao {
	
	StudentPayLog find(StudentPayLog studentPayLog);

	void insert(StudentPayLog studentPayLog);
	
	void update(StudentPayLog studentPayLog);
}
