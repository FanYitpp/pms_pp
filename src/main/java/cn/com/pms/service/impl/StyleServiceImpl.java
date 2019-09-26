package cn.com.pms.service.impl;

import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.pms.dao.StyleMapper;
import cn.com.pms.model.Style;
import cn.com.pms.service.StyleService;

@Service
public class StyleServiceImpl implements StyleService {

	@Autowired
	StyleMapper Mapper;
	
	@Autowired  
	private  HttpServletRequest request;  //获取request
	
	@Transactional
	@Override
	public void delectstyle(int id) {
		Mapper.deleteByPrimaryKey(id);
	}

	@Transactional
	@Override
	public ArrayList<Style> init() {
		ArrayList<Style> ALstyle=Mapper.selectAll();
		request.setAttribute("ALstyle", ALstyle);
		return ALstyle;
	}

	@Transactional
	@Override
	public Style initEdit(int id) {
		Style style=Mapper.selectByPrimaryKey(id);
		request.setAttribute("style", style);
		return style;
	}

	@Transactional
	@Override
	public void insertstyle(Style style) {
		Mapper.insertSelective(style);

	}

	@Transactional
	@Override
	public void updatestyle(Style style) {
		Mapper.updateByPrimaryKeySelective(style);
	}

}
