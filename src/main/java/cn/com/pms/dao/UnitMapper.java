package cn.com.pms.dao;

import java.util.ArrayList;
import java.util.List;

import cn.com.pms.model.Unit;

public interface UnitMapper {
	
	//根据楼宇查询单元
	List<Unit> selectUnitByBuild(Integer buildId);
	
    int deleteByPrimaryKey(Integer unitId);

    int insert(Unit record);

    int insertSelective(Unit record);

    Unit selectByPrimaryKey(Integer unitId);

    int updateByPrimaryKeySelective(Unit record);

    int updateByPrimaryKey(Unit record);
    
    
    
    ArrayList<Unit> selectAllByBuil(Integer builid);
    List<Unit> selectByBuildingId(Integer unitBuildingId);
    
}