package cn.com.pms.model;

import java.math.BigDecimal;

public class Costitem {
    private Integer costitemId;

    private String costitemName;

    private String costitemUnit;

    private BigDecimal costitemPrice;

    public Integer getCostitemId() {
        return costitemId;
    }

    public void setCostitemId(Integer costitemId) {
        this.costitemId = costitemId;
    }

    public String getCostitemName() {
        return costitemName;
    }

    public void setCostitemName(String costitemName) {
        this.costitemName = costitemName == null ? null : costitemName.trim();
    }

    public String getCostitemUnit() {
        return costitemUnit;
    }

    public void setCostitemUnit(String costitemUnit) {
        this.costitemUnit = costitemUnit == null ? null : costitemUnit.trim();
    }

    public BigDecimal getCostitemPrice() {
        return costitemPrice;
    }

    public void setCostitemPrice(BigDecimal costitemPrice) {
        this.costitemPrice = costitemPrice;
    }
}