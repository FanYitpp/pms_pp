package cn.com.pms.model;

import java.math.BigDecimal;
import java.util.Date;

public class House {
    private Integer houseId;

    private Integer houseName;

    private String houseNumber;

    private Integer houseHostId;

    private Integer houseStyleId;

    private Integer houseType;

    private Integer houseUnitId;

    private BigDecimal houseBalance;

    private Date houseCreatetime;

    public Integer getHouseId() {
        return houseId;
    }

    public void setHouseId(Integer houseId) {
        this.houseId = houseId;
    }

    public Integer getHouseName() {
        return houseName;
    }

    public void setHouseName(Integer houseName) {
        this.houseName = houseName;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    public Integer getHouseHostId() {
        return houseHostId;
    }

    public void setHouseHostId(Integer houseHostId) {
        this.houseHostId = houseHostId;
    }

    public Integer getHouseStyleId() {
        return houseStyleId;
    }

    public void setHouseStyleId(Integer houseStyleId) {
        this.houseStyleId = houseStyleId;
    }

    public Integer getHouseType() {
        return houseType;
    }

    public void setHouseType(Integer houseType) {
        this.houseType = houseType;
    }

    public Integer getHouseUnitId() {
        return houseUnitId;
    }

    public void setHouseUnitId(Integer houseUnitId) {
        this.houseUnitId = houseUnitId;
    }

    public BigDecimal getHouseBalance() {
        return houseBalance;
    }

    public void setHouseBalance(BigDecimal houseBalance) {
        this.houseBalance = houseBalance;
    }

    public Date getHouseCreatetime() {
        return houseCreatetime;
    }

    public void setHouseCreatetime(Date houseCreatetime) {
        this.houseCreatetime = houseCreatetime;
    }
}