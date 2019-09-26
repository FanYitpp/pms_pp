package cn.com.pms.action;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.com.pms.model.Host;
import cn.com.pms.service.HostService;

@Controller
@RequestMapping("/host")
public class HostAction {
	
	@Resource
	private HostService hostService;

	@RequestMapping(value="/selectOne")
	public String selectOne(Model model , int hostId){
		Host host =  hostService.selectOne(hostId);
		model.addAttribute("host",host);
		return "forward:/host.jsp";
	}
	
	@RequestMapping(value="/hostInfo")
	public @ResponseBody Map<String, Object> selectHostInfo() {
		List<Host> hostInfoList = hostService.selectHostInfo();
		Map<String , Object> map = new LinkedHashMap<String, Object>();
		map.put("total", hostInfoList.size());
		map.put("rows", hostInfoList);
		return map;
	}
	
	@RequestMapping(value="/hostInfoPage")
	public @ResponseBody Map<String, Object> selectHostInfoPage(int page,int rows) {
		List<Host> hostInfoList = hostService.selectHostInfoPage(page,rows);
		int hostCount = hostService.selectHostCount();
		Map<String , Object> map = new LinkedHashMap<String, Object>();
		map.put("total", hostCount);
		map.put("rows", hostInfoList);
		return map;
	}
	
	@RequestMapping(value="/hostByCond")
	public @ResponseBody Map<String, Object> selectHostByCond(int commId,int buildId,int unitId,String hostName,int page,int rows) {
		System.out.println("commId:"+commId+"  buildId:"+buildId+"  unitId:"+unitId+"  hostName:"+hostName+" page:"+page+"  rows:"+rows);
		List<Map<String, Object>> hostList = hostService.selectHostByCond(commId,buildId,unitId,hostName,page,rows);
		int total = hostService.selectHostByCondPage(commId,buildId,unitId,hostName);
		Map<String, Object> map = new LinkedHashMap<String, Object>();
		map.put("total", total);
		map.put("rows", hostList);
		return map;
	}
	
	@RequestMapping(value="/selectHostByHouseNumber")
	public @ResponseBody Map<String, Object> selectHostByHouseNumber(String houseNumber) {
		System.out.println("houseNumber:"+houseNumber);
		List<Map<String, Object>> hostList = hostService.selectHostByHouseNumber(houseNumber);
		Map<String, Object> map = new LinkedHashMap<String, Object>();
		map.put("total", hostList.size());
		map.put("rows", hostList);
		return map;
	}
	
	@RequestMapping(value="/exportExcelInfo")
	public void exportExcelInfo(HttpServletResponse response,int commId,int buildId,int unitId,String hostName) {
		System.out.println("commId:"+commId+"  buildId:"+buildId+"  unitId:"+unitId+"  hostName:"+hostName);
		try {
			response.setContentType("application/x-excel");
			response.setHeader("Content-Disposition", "attachment;filename=" + new String("业主房产信息列表.xls".getBytes(),"ISO-8859-1"));
			ServletOutputStream outputStream = response.getOutputStream();
			
			List<Map<String, Object>> hostList = hostService.selectAllHostInfo(commId,buildId,unitId,hostName);
			hostService.exportExcelInfo(hostList,outputStream);
			
			System.out.println(outputStream.toString());
			
			if(outputStream != null) {
				outputStream.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
