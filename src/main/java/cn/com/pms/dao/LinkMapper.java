package cn.com.pms.dao;

import java.util.List;
import java.util.Map;
import cn.com.pms.model.Linkget;


public interface LinkMapper {
	List<Map<String, Object>> selectAll(Linkget lg);
	int selectcount(Linkget lg);
}
