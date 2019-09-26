package cn.com.pms.service;

import cn.com.pms.model.Building;
import cn.com.pms.model.Community;
import cn.com.pms.model.Unit;

public interface AddModelService {
	void insertModel(Community comm, Building buil, Unit unit);
}
