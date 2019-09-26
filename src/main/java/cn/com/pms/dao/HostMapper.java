package cn.com.pms.dao;

import java.util.List;
import java.util.Map;

import cn.com.pms.model.Host;

public interface HostMapper {
	
	//根据主键查询信息
	Host selectByPrimaryKey(Integer hostId);
	
	//查询所有信息
	List<Host> selectHostInfo();
	
	//分页查询业主信息
	List<Host> selectHostInfoPage(Integer currPageNo, Integer perPageSize);
	
	//查询总记录数
	int selectHostCount();
	
	//根据小区，楼宇，单元 和业主姓名查询信息 
	List<Map<String, Object>> selectHostByCond(Map<String, Object> map);
	
	//根据条件查询信息数量
	Integer selectHostByCondPage(Map<String, Object> map);
	
	//根据房间编号查询户主信息
	List<Map<String,Object>> selectHostByHouseNumber(String houseNumber);
	
	//查询所有户主信息
	List<Map<String, Object>> selectAllHostInfo(Map<String, Object> map);
	
    int deleteByPrimaryKey(Integer hostId);

    int insert(Host record);

    int insertSelective(Host record);


    int updateByPrimaryKeySelective(Host record);

    int updateByPrimaryKey(Host record);
    
    

}