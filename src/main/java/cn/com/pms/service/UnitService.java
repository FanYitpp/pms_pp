package cn.com.pms.service;

import java.util.ArrayList;
import java.util.List;

import cn.com.pms.model.Unit;

public interface UnitService {
	
	//根据楼宇查询单元
	List<Unit> selectUnitByBuild(Integer buildId);

	
	
	ArrayList<Unit> init(int id);
	Unit initEdit(int id);
	void insertunit(Unit unit);
	void delectunit(int id);
	void updateunit(Unit unit);
	List<Unit> selectByBuildingId(int unitBuildingId);
	
}
