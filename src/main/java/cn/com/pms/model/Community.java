package cn.com.pms.model;

import java.math.BigDecimal;
import java.util.Date;

public class Community {
    private Integer communityId;

    private String communityName;

    private Integer communityBuildingingnum;

    private String communityAddress;

    private String communityManager;

    private String communityManagerLink;

    private BigDecimal communityArea;

    private Date communityCreatetime;

    public Integer getCommunityId() {
        return communityId;
    }

    public void setCommunityId(Integer communityId) {
        this.communityId = communityId;
    }

    public String getCommunityName() {
        return communityName;
    }

    public void setCommunityName(String communityName) {
        this.communityName = communityName == null ? null : communityName.trim();
    }

    public Integer getCommunityBuildingingnum() {
        return communityBuildingingnum;
    }

    public void setCommunityBuildingingnum(Integer communityBuildingingnum) {
        this.communityBuildingingnum = communityBuildingingnum;
    }

    public String getCommunityAddress() {
        return communityAddress;
    }

    public void setCommunityAddress(String communityAddress) {
        this.communityAddress = communityAddress == null ? null : communityAddress.trim();
    }

    public String getCommunityManager() {
        return communityManager;
    }

    public void setCommunityManager(String communityManager) {
        this.communityManager = communityManager == null ? null : communityManager.trim();
    }

    public String getCommunityManagerLink() {
        return communityManagerLink;
    }

    public void setCommunityManagerLink(String communityManagerLink) {
        this.communityManagerLink = communityManagerLink == null ? null : communityManagerLink.trim();
    }

    public BigDecimal getCommunityArea() {
        return communityArea;
    }

    public void setCommunityArea(BigDecimal communityArea) {
        this.communityArea = communityArea;
    }

    public Date getCommunityCreatetime() {
        return communityCreatetime;
    }

    public void setCommunityCreatetime(Date communityCreatetime) {
        this.communityCreatetime = communityCreatetime;
    }
}