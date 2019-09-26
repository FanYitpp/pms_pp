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
import cn.com.pms.model.Building;
import cn.com.pms.service.BuildingService;


@Controller
@Scope("prototype")
@RequestMapping("/")
public class BuildingController {

	@Autowired
	BuildingService Service;
	
	@RequestMapping(value="initbuil")
	public String init(int commid,HttpServletRequest request){
		try {
			Service.init(commid);
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		return "building_list";
	}
	
	@RequestMapping(value="initeditbuil")
	public String initEdit(int builid,ModelMap modelMap,HttpServletRequest request){
		try {
			Service.initEdit(builid);
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		return "building_edit";
	}
	
	@RequestMapping(value="insertbuil")
	public void insert(Building buil,ModelMap modelMap,HttpServletRequest request){
		try {
			Service.insertbuil(buil);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value="updatebuil")
	public void update(Building buil,ModelMap modelMap,HttpServletRequest request){
		try {
			Service.updatebuil(buil);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value="delectbuil")
	public String delect(int builid,int commid,ModelMap modelMap,HttpServletRequest request){
		try {
			Service.delectbuil(builid);
			Service.init(commid);
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		return "building_list";
	}
	@RequestMapping(value="selectByCommunityId")
	public void selectByCommunityId(HttpServletRequest request,
			HttpServletResponse response) {
		PrintWriter out=null;
		Integer buildingCommunityId=Integer.parseInt(request.getParameter("buildingCommunityId"));
		String str="";
		
		response.setContentType("text/html; charset=utf-8");
		try {
			out=response.getWriter();
			List<Building> blist=Service.selectByCommunityId(buildingCommunityId);
			for (Building building : blist) {
				str+=building.getBuildingId()+","+building.getBuildingName()+";";
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
	/*@ResponseBody
	  public String selectByCommunityId(Integer buildingCommunityId) {
		String str="";
		
		List<building> blist=Service.selectByCommunityId(buildingCommunityId);
		for (building building : blist) {
			str+=building.getBuildingId()+","+building.getBuildingName()+";";
		}
		System.out.println(buildingCommunityId);
		System.out.println(str);
		str=str.substring(0, str.length()-1);
		
		return str;
	}*/
}
