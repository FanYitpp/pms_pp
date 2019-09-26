package cn.com.pms.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginFilter implements Filter {
	 
	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest)req;
		HttpServletResponse response = (HttpServletResponse)res;
		HttpSession session = request.getSession();
		
		String path = request.getRequestURI();
		//如果访问的是登录页面和请求登录，放行
		if(path.indexOf("login.jsp") != -1 || path.indexOf("/admin/queryAdmin") != -1) {
			chain.doFilter(request, response);
		}else {
			if(session.getAttribute("loginAdmin")==null	){
				response.sendRedirect(request.getContextPath()+"/login.jsp");
			}else{
				chain.doFilter(request, response);
			}
		}
		
	}
 
	@Override
	public void init(FilterConfig arg0) throws ServletException {
	}
	
	@Override
	public void destroy() {
	}
	
}
