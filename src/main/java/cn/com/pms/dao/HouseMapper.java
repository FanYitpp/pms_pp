package cn.com.pms.dao;

import java.util.ArrayList;
import java.util.List;

import cn.com.pms.model.House;

public interface HouseMapper {
    int deleteByPrimaryKey(Integer houseId);

    int insert(House record);

    int insertSelective(House record);

    House selectByPrimaryKey(Integer houseId);

    int updateByPrimaryKeySelective(House record);

    int updateByPrimaryKey(House record);
    
    
    ArrayList<House> selectAllByUnit(Integer unitid);
    List<House> selectByUnitId(Integer houseUnitId);
    House selectByHouseNumber(String houseNumber);
}