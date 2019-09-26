package cn.com.pms.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import cn.com.pms.model.House;
import cn.com.pms.service.HouseService;


@Controller
@Scope("prototype")
@RequestMapping("/")
public class HouseController {

	@Autowired
	HouseService Service;
	
	@RequestMapping(value="inithouse")
	public String init(int unitid,HttpServletRequest request){
		try {
			Service.init(unitid);
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		return "house_list";
	}
	
	@RequestMapping(value="initedithouse")
	public String initEdit(int houseid,ModelMap modelMap,HttpServletRequest request){
		try {
			Service.initEdit(houseid);
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		return "house_edit";
	}
	
	@RequestMapping(value="inserthouse")
	public void insert(House house,String houseHostIdName,ModelMap modelMap,HttpServletRequest request){
		try {
			Service.inserthouse(house,houseHostIdName);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value="updatehouse")
	public void update(House house,ModelMap modelMap,HttpServletRequest request){
		try {
			Service.updatehouse(house);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value="delecthouse")
	public String delect(int houseid,int unitid,ModelMap modelMap,HttpServletRequest request){
		try {
			Service.delecthouse(houseid);
			Service.init(unitid);
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		return "house_list";
	}
	
	@RequestMapping(value="initaddhouse")
	public String initAdd(ModelMap modelMap,HttpServletRequest request){
		try {
			Service.initadd();
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		return "house_add";
	}
	@RequestMapping(value="selectByUnitId")
	public void selectByCommunityId(HttpServletRequest request,
			HttpServletResponse response) {
		PrintWriter out=null;
		Integer houseUnitId=Integer.parseInt(request.getParameter("houseUnitId"));
		String str="";
		response.setContentType("text/html; charset=utf-8");
		try {
			out=response.getWriter();
			List<House> hlist=Service.selectByUnitId(houseUnitId);
			for (House house : hlist) {
				str+=house.getHouseId()+","+house.getHouseName()+";";
			}
			str=str.substring(0, str.length()-1);
			out.print(str);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			out.close();
		}
		
		
	}
	/*public @ResponseBody String selectByUnitId(int houseUnitId){
		String str="";
		List<house> hlist=Service.selectByUnitId(houseUnitId);
		for (house house : hlist) {
			str+=house.getHouseId()+","+house.getHouseName()+";";
		}
		str.substring(0, str.length()-1);
		return str;
	}*/
}
