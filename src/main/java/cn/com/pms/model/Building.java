package cn.com.pms.model;

import java.util.Date;

public class Building {
    private Integer buildingId;

    private String buildingName;

    private Integer buildingUnitnum;

    private Integer buildingFloornum;

    private Integer buildingCommunityId;

    private Date buildingCreatetime;

    public Integer getBuildingId() {
        return buildingId;
    }

    public void setBuildingId(Integer buildingId) {
        this.buildingId = buildingId;
    }

    public String getBuildingName() {
        return buildingName;
    }

    public void setBuildingName(String buildingName) {
        this.buildingName = buildingName == null ? null : buildingName.trim();
    }

    public Integer getBuildingUnitnum() {
        return buildingUnitnum;
    }

    public void setBuildingUnitnum(Integer buildingUnitnum) {
        this.buildingUnitnum = buildingUnitnum;
    }

    public Integer getBuildingFloornum() {
        return buildingFloornum;
    }

    public void setBuildingFloornum(Integer buildingFloornum) {
        this.buildingFloornum = buildingFloornum;
    }

    public Integer getBuildingCommunityId() {
        return buildingCommunityId;
    }

    public void setBuildingCommunityId(Integer buildingCommunityId) {
        this.buildingCommunityId = buildingCommunityId;
    }

    public Date getBuildingCreatetime() {
        return buildingCreatetime;
    }

    public void setBuildingCreatetime(Date buildingCreatetime) {
        this.buildingCreatetime = buildingCreatetime;
    }
}