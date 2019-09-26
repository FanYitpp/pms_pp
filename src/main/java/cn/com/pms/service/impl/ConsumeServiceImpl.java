package cn.com.pms.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletOutputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.pms.dao.ConsumeMapper;
import cn.com.pms.model.Consume;
import cn.com.pms.service.ConsumeService;
import cn.com.pms.util.ExcelUtil;

@Service("consumeService")
public class ConsumeServiceImpl implements ConsumeService{
	
	@Autowired
	private ConsumeMapper consumeMapper;

	//根据房间编号查询用户消费信息
	@Override
	public List<Map<String, Object>> queryConsumeInfoByHouseNumber(String houseNumber,String beginTime,String endTime,Integer currPageNo,Integer perPageSize) {
		Map<String , Object> map = new HashMap<String, Object>();
		map.put("houseNumber", houseNumber);
		map.put("currPageNo", currPageNo);
		map.put("perPageSize", perPageSize);
		map.put("beginTime", beginTime);
		map.put("endTime", endTime);
		return consumeMapper.queryConsumeInfoByHouseNumber(map);
	}
	
	// 根据房间编号查询用户费用明细==用户折线图显示
	@Override
	public List<Map<String, Object>> displayChartByConsumeInfo(String houseNumber, Integer costitemId,String beginTime, String endTime) {
		Map<String , Object> map = new HashMap<String, Object>();
		map.put("houseNumber", houseNumber);
		map.put("costitemId", costitemId);
		map.put("beginTime", beginTime);
		map.put("endTime", endTime);
		return consumeMapper.displayChartByConsumeInfo(map);
	}

	//根据房间编号查询用户消费信息数量
	@Override
	public int queryConsumeInfoByHouseNumberCount(String houseNumber,String beginTime,String endTime) {
		Map<String , Object> map = new HashMap<String, Object>();
		map.put("houseNumber", houseNumber);
		map.put("beginTime", beginTime);
		map.put("endTime", endTime);
		return consumeMapper.queryConsumeInfoByHouseNumberCount(map);
	}

	//常规费用查询
	@Override
	public List<Map<String, Object>> queryStatisticsConsume(Integer commId, Integer buildId, Integer unitId,String beginTime, String endTime,Integer page,Integer rows) {
		Map<String , Object> map = new HashMap<String, Object>();
		map.put("commId", commId);
		map.put("buildId", buildId);
		map.put("unitId", unitId);
		map.put("beginTime", beginTime);
		map.put("endTime", endTime);
		map.put("page", page-1);
		map.put("rows", rows);
		return consumeMapper.queryStatisticsConsume(map);
	}

	//查询统计数量
	@Override
	public int queryStatisticsConsumeCount(Integer commId, Integer buildId, Integer unitId, String beginTime,String endTime) {
		Map<String , Object> map = new HashMap<String, Object>();
		map.put("commId", commId);
		map.put("buildId", buildId);
		map.put("unitId", unitId);
		map.put("beginTime", beginTime);
		map.put("endTime", endTime);
		return consumeMapper.queryStatisticsConsumeCount(map);
	}
	
	//导出数据
	@Override
	public void exportExcelInfo(List<Map<String, Object>> consumeList, ServletOutputStream outputStream) {
		ExcelUtil.exportConsumeExcel(consumeList, outputStream);
	}

	//常规费用查询--用于导出数据
	@Override
	public List<Map<String, Object>> selectAllConsumeInfo(Integer commId, Integer buildId, Integer unitId,
			String beginTime, String endTime) {
		Map<String , Object> map = new HashMap<String, Object>();
		map.put("commId", commId);
		map.put("buildId", buildId);
		map.put("unitId", unitId);
		map.put("beginTime", beginTime);
		map.put("endTime", endTime);
		return consumeMapper.selectAllConsumeInfo(map);
	}
	
	
	
	@Transactional
	@Override
	public void insert(Consume record) {
		consumeMapper.insert(record);
	}
	@Transactional
	@Override
	public Consume selectByPrimaryKey(Integer consumeId) {
		return consumeMapper.selectByPrimaryKey(consumeId);
	}
	@Transactional
	@Override
	public int updateByPrimaryKeySelective(Consume record) {
		return consumeMapper.updateByPrimaryKeySelective(record);
	}
	@Transactional
	@Override
	public int updateByPrimaryKey(Consume record) {
		return consumeMapper.updateByPrimaryKey(record);
	}
	@Transactional
	@Override
	public void deleteByPrimaryKey(Integer consumeId) {
		consumeMapper.deleteByPrimaryKey(consumeId);
	}
	

}
