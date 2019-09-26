package cn.com.pms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.pms.dao.CostitemMapper;
import cn.com.pms.model.Costitem;
import cn.com.pms.service.CostitemService;

@Service("costitemService")
public class CostitemServiceImpl implements CostitemService{
	
	@Autowired
	private CostitemMapper costitemMapper;

	@Override
	public List<Costitem> selectCostitemList() {
		return costitemMapper.selectCostitemList();
	}

	@Override
	public void addCostitem(Costitem costitem) {
		try {
			costitemMapper.addCostitem(costitem);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	

	@Override
	public List<Costitem> getAll(){
		return costitemMapper.getAll();
	}

}
