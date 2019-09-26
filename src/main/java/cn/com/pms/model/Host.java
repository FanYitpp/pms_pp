package cn.com.pms.model;

import java.io.Serializable;

public class Host implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private Integer hostId;

    private String hostName;

    private String hostGender;

    private String hostLink;

    private String hostLink2;

    private String hostCard;

    public Integer getHostId() {
        return hostId;
    }

    public void setHostId(Integer hostId) {
        this.hostId = hostId;
    }

    public String getHostName() {
        return hostName;
    }

    public void setHostName(String hostName) {
        this.hostName = hostName == null ? null : hostName.trim();
    }

    public String getHostGender() {
        return hostGender;
    }

    public void setHostGender(String hostGender) {
        this.hostGender = hostGender == null ? null : hostGender.trim();
    }

    public String getHostLink() {
        return hostLink;
    }

    public void setHostLink(String hostLink) {
        this.hostLink = hostLink == null ? null : hostLink.trim();
    }

    public String getHostLink2() {
        return hostLink2;
    }

    public void setHostLink2(String hostLink2) {
        this.hostLink2 = hostLink2 == null ? null : hostLink2.trim();
    }

    public String getHostCard() {
        return hostCard;
    }

    public void setHostCard(String hostCard) {
        this.hostCard = hostCard == null ? null : hostCard.trim();
    }
}