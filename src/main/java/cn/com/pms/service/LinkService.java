package cn.com.pms.service;

import java.util.List;
import java.util.Map;
import cn.com.pms.model.Linkget;

public interface LinkService {
	List<Map<String, Object>> selectAll(Linkget lg);
	int selectcount(Linkget lg);
	
	
}
