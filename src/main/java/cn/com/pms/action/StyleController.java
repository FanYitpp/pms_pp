package cn.com.pms.action;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.com.pms.model.Style;
import cn.com.pms.service.StyleService;


@Controller
@Scope("prototype")
@RequestMapping("/")
public class StyleController {

	@Autowired
	StyleService Service;
	
	@RequestMapping(value="initstyle")
	public String init(HttpServletRequest request){
		try {
			Service.init();
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		return "style_list";
	}
	
	@RequestMapping(value="initeditstyle")
	public String initEdit(int styleid,ModelMap modelMap,HttpServletRequest request){
		try {
			Service.initEdit(styleid);
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		return "style_edit";
	}
	
	@RequestMapping(value="insertstyle")
	public void insert(Style style,ModelMap modelMap,HttpServletRequest request){
		try {
			Service.insertstyle(style);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value="updatestyle")
	public void update(Style style,ModelMap modelMap,HttpServletRequest request){
		try {
			Service.updatestyle(style);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value="delectstyle")
	public String delect(int styleid,ModelMap modelMap,HttpServletRequest request){
		try {
			Service.delectstyle(styleid);
			Service.init();
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		return "style_list";
	}
	
}
