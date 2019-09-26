package cn.com.pms.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.pms.dao.BuildingMapper;
import cn.com.pms.model.Building;
import cn.com.pms.service.BuildingService;

@Service("buildingService")
public class BuildingServiceImpl implements BuildingService{
	
	@Autowired
	private BuildingMapper buildingMapper;


	@Autowired  
	private  HttpServletRequest request;  //获取request
	
	@Override
	public List<Building> selectBuildByComm(Integer commId) {
		return buildingMapper.selectBuildByComm(commId);
	}
	
	
	
	
	
	
	@Transactional
	@Override
	public void delectbuil(int id) {
		buildingMapper.deleteByPrimaryKey(id);
	}

	@Transactional
	@Override
	public ArrayList<Building> init(int id) {
		ArrayList<Building> ALbuil=buildingMapper.selectAllByComm(id);
		request.setAttribute("ALbuil", ALbuil);
		request.setAttribute("commid", id);
		return ALbuil;
	}

	@Transactional
	@Override
	public Building initEdit(int id) {
		Building buil=buildingMapper.selectByPrimaryKey(id);
		request.setAttribute("buil", buil);
		return buil;
	}

	@Transactional
	@Override
	public void insertbuil(Building buil) {
		buildingMapper.insertSelective(buil);

	}

	@Transactional
	@Override
	public void updatebuil(Building buil) {
		buildingMapper.updateByPrimaryKeySelective(buil);
	}
	
	@Transactional
	@Override
	public List<Building> selectByCommunityId(Integer buildingCommunityId) {
		return buildingMapper.selectByCommunityId(buildingCommunityId);
	}

}
