package cn.com.pms.service;

import java.util.List;
import java.util.Map;

import javax.servlet.ServletOutputStream;

import cn.com.pms.model.Consume;

public interface ConsumeService {
	
	//根据房间编号查询用户消费信息
	public List<Map<String,Object>> queryConsumeInfoByHouseNumber(String houseNumber, String beginTime, String endTime, Integer currPageNo, Integer perPageSize);
	
	// 根据房间编号查询用户费用明细==用户折线图显示
    public List<Map<String, Object>> displayChartByConsumeInfo(String houseNumber, Integer costitemId, String beginTime, String endTime);
	
	//根据房间编号查询用户消费信息数量
    public int queryConsumeInfoByHouseNumberCount(String houseNumber, String beginTime, String endTime);
    
    //常规费用查询
    public List<Map<String, Object>> queryStatisticsConsume(Integer commId, Integer buildId, Integer unitId, String beginTime, String endTime, Integer page, Integer rows);

    //查询统计数量
    public int queryStatisticsConsumeCount(Integer commId, Integer buildId, Integer unitId, String beginTime, String endTime);
    
    //导出数据
  	public void exportExcelInfo(List<Map<String, Object>> consumeList, ServletOutputStream outputStream);
    
    //常规费用查询--用于导出数据
    public List<Map<String,Object>> selectAllConsumeInfo(Integer commId, Integer buildId, Integer unitId, String beginTime, String endTime);



    void insert(Consume record);

    Consume selectByPrimaryKey(Integer consumeId);

    int updateByPrimaryKeySelective(Consume record);

    int updateByPrimaryKey(Consume record);
    void deleteByPrimaryKey(Integer consumeId);
}
