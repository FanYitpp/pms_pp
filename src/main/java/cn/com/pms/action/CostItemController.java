package cn.com.pms.action;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.com.pms.model.Community;
import cn.com.pms.model.Costitem;
import cn.com.pms.model.House;
import cn.com.pms.model.Linkget;
import cn.com.pms.service.CommunityService;
import cn.com.pms.service.CostitemService;
import cn.com.pms.service.LinkService;

@Controller
@Scope("prototype")
@RequestMapping("/")
public class CostItemController {
	@Autowired
	private CommunityService cms;
	@Autowired
	private CostitemService cis;
	@Autowired
	private LinkService ls;
	@RequestMapping(value="expensemanage")
	public String costmanage(ModelMap modelMap,HttpServletRequest request) {
		String str="";
		List<Community> comm=cms.getAll();
		List<Costitem> ci=cis.getAll();
		modelMap.addAttribute("commlist", comm);
		modelMap.addAttribute("cilist",ci);
		return "expense_manage";
	}
	@RequestMapping(value="search")
	public String search(Linkget lg,ModelMap modelMap,HttpServletRequest request) {
		List<Map<String, Object>> list=new ArrayList<Map<String,Object>>();
			lg.setPagenum(10);
			lg.setPagesize(0);
			
			Linkget lg2=new Linkget();
			lg2.setPagenum(10);
			lg2.setPagesize(0);
			if(lg.getHostName()!=null&&lg.getHostName()!="") {
				lg2.setHostName(lg.getHostName());
				lg2.setCostitemId(lg.getCostitemId());
				lg2.setFirsttime(lg.getFirsttime());
				lg2.setLasttime(lg.getLasttime());
			}else if(lg.getHouseNumber()!=null&&lg.getHouseNumber()!="") {
				lg2.setHouseNumber(lg.getHouseNumber());
				lg2.setCostitemId(lg.getCostitemId());
				lg2.setFirsttime(lg.getFirsttime());
				lg2.setLasttime(lg.getLasttime());
			}else {
				lg2=lg;
			}
			list=ls.selectAll(lg2);

			Integer num=num(lg2);
			modelMap.addAttribute("lg",lg);
			modelMap.addAttribute("num",num);
			modelMap.addAttribute("consumelist",list);
		return "expense-community";
		
	}
	public Integer num(Linkget lg) {
		System.out.println(lg.toString());
		int num=ls.selectcount(lg);
		Integer number=(int) Math.ceil(num/(double)lg.getPagenum());
		return number;
	}
	@RequestMapping(value="pagechange")
	public String pagechange(Linkget lg,Integer page,Integer num,ModelMap modelMap,HttpServletRequest request) {
		List<Map<String, Object>> list=new ArrayList<Map<String,Object>>();
		if(page<0) {
			page=0;
		}if(page>(num-1)) {
			page=num-1;
		}
		lg.setPagesize(page);
		
		Linkget lg2=new Linkget();
		lg2.setPagesize(page);
		if(lg.getHostName()!=null&&lg.getHostName()!="") {
			lg2.setHostName(lg.getHostName());
			lg2.setCostitemId(lg.getCostitemId());
			lg2.setFirsttime(lg.getFirsttime());
			lg2.setLasttime(lg.getLasttime());
		}else if(lg.getHouseNumber()!=null&&lg.getHouseNumber()!="") {
			lg2.setHouseNumber(lg.getHouseNumber());
			lg2.setCostitemId(lg.getCostitemId());
			lg2.setFirsttime(lg.getFirsttime());
			lg2.setLasttime(lg.getLasttime());
		}else {
			lg2=lg;
		}
		list=ls.selectAll(lg2);

		
		
		modelMap.addAttribute("lg",lg);
		modelMap.addAttribute("num",num);
		modelMap.addAttribute("consumelist",list);
		return "expense-community";
	}
	@InitBinder
    public void initBinder(WebDataBinder binder) {
        //binder.setDisallowedFields("name");
        CustomDateEditor editor = new CustomDateEditor(new SimpleDateFormat("yyyy/MM/dd"),true);
        binder.registerCustomEditor(Date.class, editor);
	}
	public List<House> searchByhostName() {
		List<House> hlist=new ArrayList<House>();
		return hlist;
	}
	
	
}
