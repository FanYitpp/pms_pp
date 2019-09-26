package cn.com.pms.service;

import java.util.ArrayList;
import java.util.List;

import cn.com.pms.model.House;

public interface HouseService {
	ArrayList<House> init(int id);
	House initEdit(int id);
	void initadd();
	void inserthouse(House hous, String name);
	void delecthouse(int id);
	void updatehouse(House hous);
	List<House> selectByUnitId(int houseUnitId);
}
