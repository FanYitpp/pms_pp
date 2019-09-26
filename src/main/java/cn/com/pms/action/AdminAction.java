package cn.com.pms.action;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import cn.com.pms.service.AdminService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import cn.com.pms.model.Admin;

@Controller
@RequestMapping("/admin")
public class AdminAction {

	@Resource
	private AdminService adminService;
	
	//管理员登录
	@RequestMapping("/queryAdmin")
	public String queryAdmin(HttpServletRequest request , Admin admin) {
		Admin loginAdmin = adminService.queryAdmin(admin);
		if(loginAdmin != null) {
			System.out.println("登录成功！");
			request.getSession().setAttribute("loginAdmin", loginAdmin);
			request.getSession().setMaxInactiveInterval(6000);
			return "redirect:/index.jsp";
		}else {
			return "redirect:/login.jsp";
		}
		
	}
	
	//注销的实现
	@RequestMapping("/logout")
	public String logout(HttpServletRequest request) {
		request.getSession().removeAttribute("loginAdmin");	
		return "redirect:/login.jsp";
	}
	
}
