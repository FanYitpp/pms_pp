package cn.com.pms.service.impl;

import java.util.List;
import java.util.Map;
import cn.com.pms.dao.LinkMapper;
import cn.com.pms.model.Linkget;
import cn.com.pms.service.LinkService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class LinkServiceImpl implements LinkService {
	
	@Autowired
	public LinkMapper lm;
	@Transactional
	public List<Map<String, Object>> selectAll(Linkget lg) {
		return lm.selectAll(lg);
	}
	@Transactional
	public int selectcount(Linkget lg) {
		return lm.selectcount(lg);
	}
}
