package cn.com.pms.model;

import java.math.BigDecimal;
import java.util.Date;

public class Consume {
    private Integer consumeId;

    private Integer consumeHouseId;

    private BigDecimal consumeCount;

    private BigDecimal consumeTotalprice;

    private Date consumeTime;

    private Integer consumeStatus;

    private Date consumePayTime;

    private Integer consumeCostitemId;

    public Integer getConsumeId() {
        return consumeId;
    }

    public void setConsumeId(Integer consumeId) {
        this.consumeId = consumeId;
    }

    public Integer getConsumeHouseId() {
        return consumeHouseId;
    }

    public void setConsumeHouseId(Integer consumeHouseId) {
        this.consumeHouseId = consumeHouseId;
    }

    public BigDecimal getConsumeCount() {
        return consumeCount;
    }

    public void setConsumeCount(BigDecimal consumeCount) {
        this.consumeCount = consumeCount;
    }

    public BigDecimal getConsumeTotalprice() {
        return consumeTotalprice;
    }

    public void setConsumeTotalprice(BigDecimal consumeTotalprice) {
        this.consumeTotalprice = consumeTotalprice;
    }

    public Date getConsumeTime() {
        return consumeTime;
    }

    public void setConsumeTime(Date consumeTime) {
        this.consumeTime = consumeTime;
    }

    public Integer getConsumeStatus() {
        return consumeStatus;
    }

    public void setConsumeStatus(Integer consumeStatus) {
        this.consumeStatus = consumeStatus;
    }

    public Date getConsumePayTime() {
        return consumePayTime;
    }

    public void setConsumePayTime(Date consumePayTime) {
        this.consumePayTime = consumePayTime;
    }

    public Integer getConsumeCostitemId() {
        return consumeCostitemId;
    }

    public void setConsumeCostitemId(Integer consumeCostitemId) {
        this.consumeCostitemId = consumeCostitemId;
    }
}