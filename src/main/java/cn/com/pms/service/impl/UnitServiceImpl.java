package cn.com.pms.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.pms.dao.UnitMapper;
import cn.com.pms.model.Unit;
import cn.com.pms.service.UnitService;

@Service("unitService")
public class UnitServiceImpl implements UnitService{
	
	@Autowired
	private UnitMapper unitMapper;

	@Override
	public List<Unit> selectUnitByBuild(Integer buildId) {
		return unitMapper.selectUnitByBuild(buildId);
	}

	
	
	@Autowired  
	private  HttpServletRequest request;  //获取request
	
	@Transactional
	@Override
	public void delectunit(int id) {
		unitMapper.deleteByPrimaryKey(id);
	}

	@Transactional
	@Override
	public ArrayList<Unit> init(int id) {
		ArrayList<Unit> ALunit=unitMapper.selectAllByBuil(id);
		request.setAttribute("ALunit", ALunit);
		request.setAttribute("builid", id);
		return ALunit;
	}

	@Transactional
	@Override
	public Unit initEdit(int id) {
		Unit unit=unitMapper.selectByPrimaryKey(id);
		request.setAttribute("unit", unit);
		return unit;
	}

	@Transactional
	@Override
	public void insertunit(Unit unit) {
		unitMapper.insertSelective(unit);

	}

	@Transactional
	@Override
	public void updateunit(Unit unit) {
		unitMapper.updateByPrimaryKeySelective(unit);
	}
	@Transactional
	@Override
	public List<Unit> selectByBuildingId(int unitBuildingId) {
		return unitMapper.selectByBuildingId(unitBuildingId);
	}
	
}
