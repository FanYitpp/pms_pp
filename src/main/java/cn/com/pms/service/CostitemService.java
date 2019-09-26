package cn.com.pms.service;

import java.util.List;
import cn.com.pms.model.Costitem;

public interface CostitemService {
	
	//查询费项列表
	public List<Costitem> selectCostitemList();
	
	//田间费项
	public void addCostitem(Costitem costitem);
	
	
	
	List<Costitem> getAll();
	
}
