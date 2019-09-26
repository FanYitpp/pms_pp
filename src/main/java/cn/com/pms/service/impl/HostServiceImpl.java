package cn.com.pms.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import cn.com.pms.dao.HostMapper;
import cn.com.pms.model.Host;
import cn.com.pms.service.HostService;
import cn.com.pms.util.ExcelUtil;

@Service("hostService")
public class HostServiceImpl implements HostService{

	
	@Autowired
	private HostMapper hostMapper;

	@Override
	public Host selectOne(int hostId) {
		return hostMapper.selectByPrimaryKey(hostId);
	}

	@Override
	public List<Host> selectHostInfo() {
		return hostMapper.selectHostInfo();
	}

	@Override
	public List<Host> selectHostInfoPage(Integer currPageNo, Integer perPageSize) {
		return hostMapper.selectHostInfoPage(currPageNo, perPageSize);
	}

	@Override
	public int selectHostCount() {
		return hostMapper.selectHostCount();
	}

	@Override
	public List<Map<String, Object>> selectHostByCond(Integer commId,Integer buildId,Integer unitId,String hostName,Integer page,Integer rows) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("currPageNo", page-1);
		map.put("perPageSize", rows);
		if(commId != 0) {
			map.put("commId", commId);
		}
		if(buildId != 0) {
			map.put("buildId", buildId);
		}
		if(unitId != 0) {
			map.put("unitId", unitId);
		}
		if(!StringUtils.isEmpty(hostName)) {
			map.put("hostName", hostName);
		}
		return hostMapper.selectHostByCond(map);
	}

	@Override
	public Integer selectHostByCondPage(Integer commId, Integer buildId, Integer unitId,String hostName) {
		Map<String, Object> map = new HashMap<String, Object>();
		if(commId != 0) {
			map.put("commId", commId);
		}
		if(buildId != 0) {
			map.put("buildId", buildId);
		}
		if(unitId != 0) {
			map.put("unitId", unitId);
		}
		if(!StringUtils.isEmpty(hostName)) {
			map.put("hostName", hostName);
		}
		return hostMapper.selectHostByCondPage(map);
	}

	@Override
	public List<Map<String, Object>> selectHostByHouseNumber(String houseNumber) {
		return hostMapper.selectHostByHouseNumber(houseNumber);
	}

	@Override
	public void exportExcelInfo(List<Map<String, Object>> hostList, ServletOutputStream outputStream) {
		ExcelUtil.exportHostExcel(hostList, outputStream);
	}

	@Override
	public List<Map<String, Object>> selectAllHostInfo(Integer commId, Integer buildId, Integer unitId, String hostName) {
		Map<String, Object> map = new HashMap<String, Object>();
		if(commId != 0) {
			map.put("commId", commId);
		}
		if(buildId != 0) {
			map.put("buildId", buildId);
		}
		if(unitId != 0) {
			map.put("unitId", unitId);
		}
		if(!StringUtils.isEmpty(hostName)) {
			map.put("hostName", hostName);
		}
		return hostMapper.selectAllHostInfo(map);
	}
	
	
	
	@Autowired  
	private  HttpServletRequest request;  //获取request
	


	@Transactional
	@Override
	public Host init(int id) {
		Host host=hostMapper.selectByPrimaryKey(id);
		request.setAttribute("host", host);
		return host;
	}

	
	@Transactional
	@Override
	public void updatehost(Host host) {
		hostMapper.updateByPrimaryKeySelective(host);
	}
	

}
