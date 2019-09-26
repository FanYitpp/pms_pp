package cn.com.pms.dao;

import java.util.ArrayList;
import java.util.List;

import cn.com.pms.model.Community;

public interface CommunityMapper {
	
	
	//查询所有小区信息
	List<Community> selectCommList();
	
    int deleteByPrimaryKey(Integer communityId);

    int insert(Community record);

    int insertSelective(Community record);

    Community selectByPrimaryKey(Integer communityId);

    int updateByPrimaryKeySelective(Community record);

    int updateByPrimaryKey(Community record);
    
    
    
    
    ArrayList<Community> selectAll();
    
    List<Community> getAll();
    
    
    
}