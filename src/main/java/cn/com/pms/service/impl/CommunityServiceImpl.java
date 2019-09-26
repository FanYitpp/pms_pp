package cn.com.pms.service.impl;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import cn.com.pms.dao.CommunityMapper;
import cn.com.pms.model.Community;
import cn.com.pms.service.CommunityService;

@Service("communityService")
public class CommunityServiceImpl implements CommunityService{
	
	@Autowired
	private CommunityMapper communityMapper;

	@Override
	public List<Community> selectCommList() {
		return communityMapper.selectCommList();
	}
	
	
	
	
	
	
	@Autowired  
	private  HttpServletRequest request;  //获取request
	
	@Transactional
	@Override
	public ArrayList<Community> init() {
		ArrayList<Community> ALcomm=communityMapper.selectAll();
		request.setAttribute("ALcomm", ALcomm);
		return ALcomm;
	}

	@Transactional
	@Override
	public void insertComm(Community comm) {
		communityMapper.insertSelective(comm);                                                                                                   
	}

	@Transactional
	@Override
	public void delectComm(int id) {
		communityMapper.deleteByPrimaryKey(id);
	}

	@Transactional
	@Override
	public Community initEdit(int id) {
		Community comm=communityMapper.selectByPrimaryKey(id);
		request.setAttribute("comm", comm);
		return comm;
	}

	@Transactional
	@Override
	public void updateComm(Community comm) {
		communityMapper.updateByPrimaryKeySelective(comm);
	}
	
	@Transactional
	@Override
	public List<Community> getAll() {
		return communityMapper.getAll();
	}

}
