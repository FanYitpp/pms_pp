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
import cn.com.pms.model.Unit;
import cn.com.pms.service.UnitService;


@Controller
@Scope("prototype")
@RequestMapping("/")
public class UnitController {

	@Autowired
	UnitService Service;
	
	@RequestMapping(value="initunit")
	public String init(int builid,HttpServletRequest request){
		try {
			Service.init(builid);
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		return "unit_list";
	}
	
	@RequestMapping(value="initeditunit")
	public String initEdit(int unitid,ModelMap modelMap,HttpServletRequest request){
		try {
			Service.initEdit(unitid);
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		return "unit_edit";
	}
	
	@RequestMapping(value="insertunit")
	public void insert(Unit unit,ModelMap modelMap,HttpServletRequest request){
		try {
			Service.insertunit(unit);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value="updateunit")
	public void update(Unit unit,ModelMap modelMap,HttpServletRequest request){
		try {
			Service.updateunit(unit);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value="delectunit")
	public String delect(int unitid,int builid,ModelMap modelMap,HttpServletRequest request){
		try {
			Service.delectunit(unitid);
			Service.init(builid);
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		return "unit_list";
	}
	@RequestMapping(value="selectByBuildingId")
	public void selectByCommunityId(HttpServletRequest request,
			HttpServletResponse response) {
		PrintWriter out=null;
		Integer unitBuildingId=Integer.parseInt(request.getParameter("unitBuildingId"));
		String str="";
		
		response.setContentType("text/html; charset=utf-8");
		try {
			out=response.getWriter();
			List<Unit> ulist=Service.selectByBuildingId(unitBuildingId);
			for (Unit unit : ulist) {
				str+=unit.getUnitId()+","+unit.getUnitName()+";";
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
	/*public @ResponseBody String selectByBuildingId(int unitBuildingId) {
		String str="";
		List<unit> ulist=Service.selectByBuildingId(unitBuildingId);
		for (unit unit : ulist) {
			str+=unit.getUnitId()+","+unit.getUnitName()+";";
		}
		str.substring(0, str.length()-1);
		
		return str;
	}
	*/
}
