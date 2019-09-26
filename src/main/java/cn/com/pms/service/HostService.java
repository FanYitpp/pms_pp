package cn.com.pms.service;


import java.util.List;
import java.util.Map;

import javax.servlet.ServletOutputStream;

import cn.com.pms.model.Host;

public interface HostService {
	
	//查询单个信息
	public Host selectOne(int hostId);
	
	//查询所有信息
	public List<Host> selectHostInfo();
	
	//分页查询业主信息
	public List<Host> selectHostInfoPage(Integer currPageNo, Integer perPageSize);
	
	//查询总记录数
	public int selectHostCount();
	
	//根据小区，楼宇，单元 和业主姓名查询信息 
	public List<Map<String, Object>> selectHostByCond(Integer commId, Integer buildId, Integer unitId, String hostName, Integer page, Integer rows);
	
	//根据条件查询信息数量
	public Integer selectHostByCondPage(Integer commId, Integer buildId, Integer unitId, String hostName);
	
	//根据房间编号查询业主信息
	public List<Map<String,Object>> selectHostByHouseNumber(String houseNumber);
	
	//导出数据
	public void exportExcelInfo(List<Map<String, Object>> userList, ServletOutputStream outputStream);
	
	//查询所有户主信息
	public List<Map<String, Object>> selectAllHostInfo(Integer commId, Integer buildId, Integer unitId, String hostName);
	
	
	Host init(int id);
	void updatehost(Host host);
}
