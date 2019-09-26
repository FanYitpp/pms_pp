package cn.com.pms.service.impl;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.pms.dao.HostMapper;
import cn.com.pms.dao.HouseMapper;
import cn.com.pms.dao.StyleMapper;
import cn.com.pms.model.Host;
import cn.com.pms.model.House;
import cn.com.pms.model.Style;
import cn.com.pms.service.HouseService;
import cn.com.pms.vo.HouseVo;

@Service
public class HouseServiceImpl implements HouseService {

	@Autowired
	HouseMapper Mapper;
	
	@Autowired
	HostMapper hostMapper;
	
	@Autowired
	StyleMapper styleMapper;
	
	@Autowired  
	private  HttpServletRequest request;  //获取request
	
	@Transactional
	@Override
	public void delecthouse(int id) {
		House hous=Mapper.selectByPrimaryKey(id);
		Mapper.deleteByPrimaryKey(id);
		hostMapper.deleteByPrimaryKey(hous.getHouseHostId());
	}

	@Transactional
	@Override
	public ArrayList<House> init(int id) {
		ArrayList<House> ALhouse=Mapper.selectAllByUnit(id);
		ArrayList<HouseVo> ALhouseVo=new ArrayList<HouseVo>();
		for (House house : ALhouse) {
			HouseVo hv=new HouseVo();
			hv.setHouse(house);
			hv.setHostName(hostMapper.selectByPrimaryKey(house.getHouseHostId()).getHostName());
			hv.setStyleName(styleMapper.selectByPrimaryKey(house.getHouseStyleId()).getStyleName());
			hv.setStyleArea(styleMapper.selectByPrimaryKey(house.getHouseStyleId()).getStyleArea().toString());
			ALhouseVo.add(hv);
		}
		request.setAttribute("ALhouse", ALhouseVo);
		request.setAttribute("unitid", id);
		return ALhouse;
	}

	@Transactional
	@Override
	public House initEdit(int id) {
		House house=Mapper.selectByPrimaryKey(id);
		request.setAttribute("house", house);
		ArrayList<Style> ALstyle=styleMapper.selectAll();
		request.setAttribute("ALstyle", ALstyle);
		return house;
	}

	@Transactional
	@Override
	public void inserthouse(House hous,String name) {
		Host host=new Host();
		host.setHostName(name);
		host.setHostLink("未填写");
		host.setHostCard("未填写");
		hostMapper.insertSelective(host);
		hous.setHouseHostId(host.getHostId());
		Mapper.insertSelective(hous);

	}

	@Transactional
	@Override
	public void updatehouse(House hous) {
		Mapper.updateByPrimaryKeySelective(hous);
	}

	@Transactional
	@Override
	public void initadd(){
		ArrayList<Style> ALstyle=styleMapper.selectAll();
		request.setAttribute("ALstyle", ALstyle);
	};
	@Transactional
	@Override
	public List<House> selectByUnitId(int houseUnitId) {
		return Mapper.selectByUnitId(houseUnitId);
	}
}
