package cn.com.pms.service.impl;

import java.math.BigDecimal;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import cn.com.pms.dao.BuildingMapper;
import cn.com.pms.dao.CommunityMapper;
import cn.com.pms.dao.HostMapper;
import cn.com.pms.dao.HouseMapper;
import cn.com.pms.dao.UnitMapper;
import cn.com.pms.model.Building;
import cn.com.pms.model.Community;
import cn.com.pms.model.Host;
import cn.com.pms.model.House;
import cn.com.pms.model.Unit;
import cn.com.pms.service.AddModelService;

@Service
public class AddModelServiceImpl implements AddModelService {
	
	@Autowired
	CommunityMapper communityMapper;
	
	@Autowired
	BuildingMapper buildingMapper;
	
	@Autowired
	UnitMapper unitMapper;
	
	@Autowired
	HouseMapper houseMapper;
	
	@Autowired
	HostMapper hostMapper;
	
	@Autowired  
	private  HttpServletRequest request;  //获取request
	
	@Transactional
	@Override
	public void insertModel(Community comm, Building buil, Unit unit) {
		
		communityMapper.insertSelective(comm);
		
		for (int b = 1; b <= comm.getCommunityBuildingingnum(); b++) {
			
			Building nbuil=new Building();
			nbuil.setBuildingName("第"+b+"栋");
			nbuil.setBuildingUnitnum(buil.getBuildingUnitnum());
			nbuil.setBuildingFloornum(buil.getBuildingFloornum());
			nbuil.setBuildingCommunityId(comm.getCommunityId());
			nbuil.setBuildingCreatetime(comm.getCommunityCreatetime());
			buildingMapper.insertSelective(nbuil);
			
			for (int bd = 1; bd <= buil.getBuildingUnitnum(); bd++) {
				
				Unit nunit=new Unit();
				nunit.setUnitName("第"+bd+"单元");
				nunit.setUnitFloorNum(unit.getUnitFloorNum());
				nunit.setUnitBuildingId(nbuil.getBuildingId());
				unitMapper.insertSelective(nunit);
				
				for (int bc = 1; bc <= buil.getBuildingFloornum(); bc++) {
					for (int h = 1; h <= unit.getUnitFloorNum(); h++) {
						House house=new House();
						house.setHouseName(Integer.parseInt(bc+"0"+h));
						house.setHouseNumber(comm.getCommunityId()+"0"+nbuil.getBuildingId()+"0"+nunit.getUnitId()+"0"+bc+"0"+h);
						
						Host host=new Host();
						host.setHostName("新户主");
						host.setHostLink("未填写");
						host.setHostCard("未填写");
						hostMapper.insertSelective(host);
						
						house.setHouseHostId(host.getHostId());
						house.setHouseStyleId(1);
						house.setHouseType(1);
						house.setHouseUnitId(nunit.getUnitId());
						house.setHouseBalance(new BigDecimal(0));
						house.setHouseCreatetime(comm.getCommunityCreatetime());
						houseMapper.insertSelective(house);
					}
				}
				
			}
				
		}

	}

}
