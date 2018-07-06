package com.htjy.service.impl;

import java.util.Comparator;

import com.htjy.entity.TaskModel;

public class ComparatorImpl implements Comparator<TaskModel> {
	
	public int compare(TaskModel s1,TaskModel s2) {
		int age1 = s1.getDistance();
		int age2 = s2.getDistance();
		if(age1>age2){
			return 1;
		}else if(age1<age2){
			return -1;
		}else{
			return 0;
		}
	}
}
