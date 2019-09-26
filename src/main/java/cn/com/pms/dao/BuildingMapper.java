package cn.com.pms.dao;

import java.util.ArrayList;
import java.util.List;

import cn.com.pms.model.Building;

public interface BuildingMapper {
	
	//根据小区查询楼房信息
	List<Building> selectBuildByComm(Integer commId);
	
    int deleteByPrimaryKey(Integer buildingId);

    int insert(Building record);

    int insertSelective(Building record);

    Building selectByPrimaryKey(Integer buildingId);

    int updateByPrimaryKeySelective(Building record);

    int updateByPrimaryKey(Building record);
    
    
    
    
    ArrayList<Building> selectAllByComm(Integer commid);
    List<Building> selectByCommunityId(Integer buildingCommunityId);
}