package cn.com.pms.dao;

import java.util.List;
import java.util.Map;

import cn.com.pms.model.Consume;

public interface ConsumeMapper {
    int deleteByPrimaryKey(Integer consumeId);

    int insert(Consume record);

    int insertSelective(Consume record);

    Consume selectByPrimaryKey(Integer consumeId);

    int updateByPrimaryKeySelective(Consume record);

    int updateByPrimaryKey(Consume record);
    
    //根据房间编号查询用户消费信息
    List<Map<String, Object>> queryConsumeInfoByHouseNumber(Map<String, Object> map);
    
    // 根据房间编号查询用户费用明细==用户折线图显示
    List<Map<String, Object>> displayChartByConsumeInfo(Map<String, Object> map);

    //根据房间编号查询用户消费信息数量
    int queryConsumeInfoByHouseNumberCount(Map<String, Object> map);
    
    //常规费用查询
    List<Map<String, Object>> queryStatisticsConsume(Map<String, Object> map);
    
    //查询统计数量
    int queryStatisticsConsumeCount(Map<String, Object> map);
    
    //常规费用查询--用于导出数据
    List<Map<String, Object>> selectAllConsumeInfo(Map<String, Object> map);
}