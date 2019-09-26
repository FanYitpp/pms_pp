package cn.com.pms.dao;

import java.util.ArrayList;

import cn.com.pms.model.Style;

public interface StyleMapper {
    int deleteByPrimaryKey(Integer styleId);

    int insert(Style record);

    int insertSelective(Style record);

    Style selectByPrimaryKey(Integer styleId);

    int updateByPrimaryKeySelective(Style record);

    int updateByPrimaryKey(Style record);
    
    ArrayList<Style> selectAll();
}