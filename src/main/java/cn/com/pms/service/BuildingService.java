package cn.com.pms.service;

import java.util.ArrayList;
import java.util.List;

import cn.com.pms.model.Building;

public interface BuildingService {

	//根据小区查询楼房信息
	List<Building> selectBuildByComm(Integer commId);
	
	
	
	ArrayList<Building> init(int id);
	Building initEdit(int id);
	void insertbuil(Building buil);
	void delectbuil(int id);
	void updatebuil(Building buil);
	List<Building> selectByCommunityId(Integer buildingCommunityId);
	
}
