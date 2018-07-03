package com.htjy.dao;

import java.util.List;

import com.htjy.entity.AreaModel;
import com.htjy.entity.NationModel;
import com.htjy.entity.RegisterModel;
import com.htjy.entity.SchoolType;

public interface AreaDao {

	public List<AreaModel> queryAreaList();

	public List<NationModel> queryNationList();

	public List<RegisterModel> queryRegisterList();

	public List<NationModel> queryExamList();

	public List<NationModel> queryRecruitList();

	public List<SchoolType> querySchoolList();

}
