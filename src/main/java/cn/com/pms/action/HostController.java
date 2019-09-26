package cn.com.pms.action;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import cn.com.pms.model.Host;
import cn.com.pms.service.HostService;


@Controller
@Scope("prototype")
@RequestMapping("/")
public class HostController {

	@Autowired
	HostService Service;
	
	@RequestMapping(value="inithost")
	public String init(int houseHostId,HttpServletRequest request){
		try {
			Service.init(houseHostId);
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		return "host_edit";
	}
	

	
	@RequestMapping(value="updatehost")
	public void update(Host host,ModelMap modelMap,HttpServletRequest request){
		try {
			Service.updatehost(host);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
