package cn.com.pms.action;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.com.pms.model.Costitem;
import cn.com.pms.service.CostitemService;

@Controller
@RequestMapping("/costitem")
public class CostitemAction {
	
	@Autowired
	private CostitemService costitemService;
	
	@RequestMapping(value="/selectCostitemList")
	public @ResponseBody Map<String, Object> selectCostitemList() {
		List<Costitem> costitemList = costitemService.selectCostitemList();
		Map<String , Object> map = new LinkedHashMap<String, Object>();
		map.put("total", costitemList.size());
		map.put("rows", costitemList);
		return map;
	}
	
	
	@RequestMapping(value="/addCostitem")
	public void addCostitem(Costitem costitem) {
		costitemService.addCostitem(costitem);
		
	}
	
}
