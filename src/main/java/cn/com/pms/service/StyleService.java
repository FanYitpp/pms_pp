package cn.com.pms.service;

import java.util.ArrayList;
import cn.com.pms.model.Style;

public interface StyleService {
	ArrayList<Style> init();
	Style initEdit(int id);
	void insertstyle(Style style);
	void delectstyle(int id);
	void updatestyle(Style style);
}
