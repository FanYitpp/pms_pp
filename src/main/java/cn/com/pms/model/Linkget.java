package cn.com.pms.model;

import java.util.Date;

public class Linkget {
	public Integer communityId;
	public Integer buildingId;
	public Integer unitId;
	public Integer houseId;
	public Integer costitemId;
	public Date firsttime;
	public Date lasttime;
	public String houseNumber;
	public String hostName;
	public Integer pagesize;
	public Integer pagenum;
	
	public Linkget(Integer communityId, Integer buildingId, Integer unitId, Integer houseId, Integer costitemId,
			Date firsttime, Date lasttime, String houseNumber, String hostName, Integer pagesize, Integer pagenum) {
		super();
		this.communityId = communityId;
		this.buildingId = buildingId;
		this.unitId = unitId;
		this.houseId = houseId;
		this.costitemId = costitemId;
		this.firsttime = firsttime;
		this.lasttime = lasttime;
		this.houseNumber = houseNumber;
		this.hostName = hostName;
		this.pagesize = pagesize;
		this.pagenum = pagenum;
	}
	public Linkget() {
	}
	public Integer getCommunityId() {
		return communityId;
	}
	public void setCommunityId(Integer communityId) {
		this.communityId = communityId;
	}
	public Integer getBuildingId() {
		return buildingId;
	}
	public void setBuildingId(Integer buildingId) {
		this.buildingId = buildingId;
	}
	public Integer getUnitId() {
		return unitId;
	}
	public void setUnitId(Integer unitId) {
		this.unitId = unitId;
	}
	public Integer getHouseId() {
		return houseId;
	}
	public void setHouseId(Integer houseId) {
		this.houseId = houseId;
	}
	public Integer getCostitemId() {
		return costitemId;
	}
	public void setCostitemId(Integer costitemId) {
		this.costitemId = costitemId;
	}
	public Date getFirsttime() {
		return firsttime;
	}
	public void setFirsttime(Date firsttime) {
		this.firsttime = firsttime;
	}
	public Date getLasttime() {
		return lasttime;
	}
	public void setLasttime(Date lasttime) {
		this.lasttime = lasttime;
	}
	public String getHouseNumber() {
		return houseNumber;
	}
	public void setHouseNumber(String houseNumber) {
		this.houseNumber = houseNumber;
	}
	public String getHostName() {
		return hostName;
	}
	public void setHostName(String hostName) {
		this.hostName = hostName;
	}
	public Integer getPagesize() {
		return pagesize;
	}
	public void setPagesize(Integer pagesize) {
		this.pagesize = pagesize;
	}
	public Integer getPagenum() {
		return pagenum;
	}
	public void setPagenum(Integer pagenum) {
		this.pagenum = pagenum;
	}
	@Override
	public String toString() {
		return "linkget [communityId=" + communityId + ", buildingId=" + buildingId + ", unitId=" + unitId
				+ ", houseId=" + houseId + ", costitemId=" + costitemId + ", firsttime=" + firsttime + ", lasttime="
				+ lasttime + ", houseNumber=" + houseNumber + ", hostName=" + hostName + ", pagesize=" + pagesize
				+ ", pagenum=" + pagenum + "]";
	}
	

}
