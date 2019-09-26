package cn.com.pms.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.com.pms.model.Unit;
import cn.com.pms.service.UnitService;

@Controller
@RequestMapping("/unit")
public class UnitAction {
	
	@Resource
	private UnitService unitService;
	
	@RequestMapping("/selectUnitByBuild")
	public @ResponseBody List<Unit> selectUnitByBuild(int buildId){
		List<Unit> unitList = unitService.selectUnitByBuild(buildId);
		return unitList;
	}

}
