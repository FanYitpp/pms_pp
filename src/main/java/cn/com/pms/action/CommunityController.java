package cn.com.pms.action;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import cn.com.pms.model.Community;
import cn.com.pms.service.CommunityService;


@Controller
@Scope("prototype")
@RequestMapping("/")
public class CommunityController {

	@Autowired
	CommunityService Service;
	
	@RequestMapping(value="initcomm")
	public String init(ModelMap modelMap,HttpServletRequest request){
		try {
			Service.init();
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		return "community_list";
	}
	
	@RequestMapping(value="initeditcomm")
	public String initEdit(int commid,ModelMap modelMap,HttpServletRequest request){
		try {
			Service.initEdit(commid);
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		return "community_edit";
	}
	
	@RequestMapping(value="insertcomm")
	public void insert(Community comm,ModelMap modelMap,HttpServletRequest request){
		try {
			Service.insertComm(comm);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value="updatecomm")
	public void update(Community comm,ModelMap modelMap,HttpServletRequest request){
		try {
			Service.updateComm(comm);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value="delectcomm")
	public String delect(int commid,ModelMap modelMap,HttpServletRequest request){
		try {
			Service.delectComm(commid);
			Service.init();
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		return "community_list";
	}
	
}
