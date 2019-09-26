package cn.com.pms.action;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import cn.com.pms.model.Building;
import cn.com.pms.service.BuildingService;

@Controller
@RequestMapping("/building")
public class BuildingAction {

	@Resource
	private BuildingService buildingService;
	
	@RequestMapping("/selectBuildByComm")
	public @ResponseBody List<Building> selectBuildByComm(int commId) {
        //hahah
		List<Building> buildList = buildingService.selectBuildByComm(commId);
		return buildList;
	}
	
}
