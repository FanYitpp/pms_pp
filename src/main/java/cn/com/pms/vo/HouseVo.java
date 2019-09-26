package cn.com.pms.vo;

import cn.com.pms.model.House;

public class HouseVo {
	
    private House house;
    private String hostName;
    private String styleName;
    private String styleArea;
	public House getHouse() {
		return house;
	}
	public void setHouse(House house) {
		this.house = house;
	}
	public String getHostName() {
		return hostName;
	}
	public void setHostName(String hostName) {
		this.hostName = hostName;
	}
	public String getStyleName() {
		return styleName;
	}
	public void setStyleName(String styleName) {
		this.styleName = styleName;
	}
	public String getStyleArea() {
		return styleArea;
	}
	public void setStyleArea(String styleArea) {
		this.styleArea = styleArea;
	}
    
    
}