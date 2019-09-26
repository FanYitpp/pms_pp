package cn.com.pms.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class LoginInterceptor implements HandlerInterceptor {

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object obj, Exception e)
			throws Exception {
		
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object obj, ModelAndView e)
			throws Exception {
		
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object obj) throws Exception {
		
		// 在拦截点执行前拦截，如果返回true则不执行拦截点后的操作（拦截成功）
		// 返回false则不执行拦截
		HttpSession session = request.getSession();
		String uri = request.getRequestURI(); // 获取登录的uri，这个是不进行拦截的	
		System.out.println("===============uri:"+uri);
		
		System.out.println("=================session:"+session.getAttribute("loginAdmin"));
		if(session.getAttribute("loginAdmin")!=null ) {
			System.out.println("============================成功");
			// 登录成功不拦截
			return true;
		}else {
			// 拦截后进入登录页面
			System.out.println("============================失败");
			response.sendRedirect(request.getContextPath()+"/login.jsp");
			return false;
		}

	}

}
