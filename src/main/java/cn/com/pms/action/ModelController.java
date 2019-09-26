package cn.com.pms.action;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.com.pms.model.Building;
import cn.com.pms.model.Community;
import cn.com.pms.model.Unit;
import cn.com.pms.service.AddModelService;

@Controller
@Scope("prototype")
@RequestMapping("/")
public class ModelController {

	@Autowired
	AddModelService Service;

	
	@RequestMapping(value="addModel")
	public String update(Community comm,Building buil,Unit unit,ModelMap modelMap,HttpServletRequest request){
		try {
			Service.insertModel(comm, buil, unit);
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		return "model_success";
	}
	
}
