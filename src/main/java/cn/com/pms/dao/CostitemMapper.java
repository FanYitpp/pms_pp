package cn.com.pms.dao;

import java.util.List;

import cn.com.pms.model.Costitem;

public interface CostitemMapper {
   
	//查询费项列表
	List<Costitem> selectCostitemList();
	
	//添加费项
	void addCostitem(Costitem costitem);
	
	List<Costitem> getAll();
	
}