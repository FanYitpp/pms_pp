package cn.com.pms.model;

import java.math.BigDecimal;

public class Style {
    private Integer styleId;

    private String styleName;

    private BigDecimal styleArea;

    public Integer getStyleId() {
        return styleId;
    }

    public void setStyleId(Integer styleId) {
        this.styleId = styleId;
    }

    public String getStyleName() {
        return styleName;
    }

    public void setStyleName(String styleName) {
        this.styleName = styleName == null ? null : styleName.trim();
    }

    public BigDecimal getStyleArea() {
        return styleArea;
    }

    public void setStyleArea(BigDecimal styleArea) {
        this.styleArea = styleArea;
    }
}