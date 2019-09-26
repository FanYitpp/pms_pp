package cn.com.pms.model;

public class Unit {
    private Integer unitId;

    private String unitName;

    private Integer unitFloorNum;

    private Integer unitBuildingId;

    public Integer getUnitId() {
        return unitId;
    }

    public void setUnitId(Integer unitId) {
        this.unitId = unitId;
    }

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName == null ? null : unitName.trim();
    }

    public Integer getUnitFloorNum() {
        return unitFloorNum;
    }

    public void setUnitFloorNum(Integer unitFloorNum) {
        this.unitFloorNum = unitFloorNum;
    }

    public Integer getUnitBuildingId() {
        return unitBuildingId;
    }

    public void setUnitBuildingId(Integer unitBuildingId) {
        this.unitBuildingId = unitBuildingId;
    }
}