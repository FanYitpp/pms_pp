package cn.com.pms.service;

import java.util.ArrayList;
import java.util.List;

import cn.com.pms.model.Community;

public interface CommunityService {

	//查询所有小区信息
	List<Community> selectCommList();
	
	
	ArrayList<Community> init();
	Community initEdit(int id);
	void insertComm(Community comm);
	void delectComm(int id);
	void updateComm(Community comm);
	List<Community> getAll();
	
}
