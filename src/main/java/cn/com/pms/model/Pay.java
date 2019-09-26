package cn.com.pms.model;

import java.util.Date;

public class Pay {
    private Integer payId;

    private Integer payHouseId;

    private Long payMoney;

    private Date payTime;

    private String payType;

    public Integer getPayId() {
        return payId;
    }

    public void setPayId(Integer payId) {
        this.payId = payId;
    }

    public Integer getPayHouseId() {
        return payHouseId;
    }

    public void setPayHouseId(Integer payHouseId) {
        this.payHouseId = payHouseId;
    }

    public Long getPayMoney() {
        return payMoney;
    }

    public void setPayMoney(Long payMoney) {
        this.payMoney = payMoney;
    }

    public Date getPayTime() {
        return payTime;
    }

    public void setPayTime(Date payTime) {
        this.payTime = payTime;
    }

    public String getPayType() {
        return payType;
    }

    public void setPayType(String payType) {
        this.payType = payType == null ? null : payType.trim();
    }
}