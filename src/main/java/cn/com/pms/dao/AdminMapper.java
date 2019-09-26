package cn.com.pms.dao;

import cn.com.pms.model.Admin;

public interface AdminMapper {

	//管理员登录
	Admin queryAdmin(Admin admin);
}