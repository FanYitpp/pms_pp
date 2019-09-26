package cn.com.pms.action;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import cn.com.pms.model.Community;
import cn.com.pms.service.CommunityService;

@Controller
@RequestMapping("/community")
public class CommunityAction {
	
	@Resource
	private CommunityService communityService;
	
	@RequestMapping(value="/selectCommList")
	public @ResponseBody List<Community> selectCommList(){
		List<Community> communityList = communityService.selectCommList();
		return communityList;
	}

}
