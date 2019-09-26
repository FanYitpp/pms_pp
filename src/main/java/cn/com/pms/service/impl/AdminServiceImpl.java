package cn.com.pms.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cn.com.pms.dao.AdminMapper;
import cn.com.pms.model.Admin;
import cn.com.pms.service.AdminService;

@Service("adminService")
public class AdminServiceImpl implements AdminService{
	
	@Autowired
	private AdminMapper adminMapper;

	//管理员登录
	@Override
	public Admin queryAdmin(Admin admin) {
		return adminMapper.queryAdmin(admin);
	}

}
