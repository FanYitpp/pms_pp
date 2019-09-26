package cn.com.pms.action;

import java.io.PrintWriter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import cn.com.pms.service.ConsumeService;

/**
 * @author fan
 */
@Controller
@Scope("prototype")
@RequestMapping("/")
public class ConsumeController {
	@Autowired
	ConsumeService cs;
	@RequestMapping(value="deleteByConsumeId")
	public void deleteByPrimaryKey(HttpServletRequest request, HttpServletResponse response) {
		PrintWriter out=null;
		Integer consumeId=Integer.parseInt(request.getParameter("consumeId"));
		
		response.setContentType("text/html; charset=utf-8");
		cs.deleteByPrimaryKey(consumeId);
		out.print("success");
        out.close();
		
	}
}
