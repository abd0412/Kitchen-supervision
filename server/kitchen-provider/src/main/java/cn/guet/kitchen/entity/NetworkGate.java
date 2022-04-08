package cn.guet.kitchen.entity;

public class NetworkGate {
    private Integer id;

    private String deviceCode;

    private Integer channelNum;

    private Integer companyId;

    private String ipAddress;

    private String mac;

    private Integer usedChannelNum;

    private Integer freeChannelNum;

    private Boolean isDeleted;

    private String insertTime;

    private String updateTime;

    private Integer status;

    private Integer warnId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDeviceCode() {
        return deviceCode;
    }

    public void setDeviceCode(String deviceCode) {
        this.deviceCode = deviceCode;
    }

    public Integer getChannelNum() {
        return channelNum;
    }

    public void setChannelNum(Integer channelNum) {
        this.channelNum = channelNum;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public String getMac() {
        return mac;
    }

    public void setMac(String mac) {
        this.mac = mac;
    }

    public Integer getUsedChannelNum() {
        return usedChannelNum;
    }

    public void setUsedChannelNum(Integer usedChannelNum) {
        this.usedChannelNum = usedChannelNum;
    }

    public Integer getFreeChannelNum() {
        return freeChannelNum;
    }

    public void setFreeChannelNum(Integer freeChannelNum) {
        this.freeChannelNum = freeChannelNum;
    }

    public Boolean getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    public String getInsertTime() {
        return insertTime;
    }

    public void setInsertTime(String insertTime) {
        this.insertTime = insertTime;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getWarnId() {
        return warnId;
    }

    public void setWarnId(Integer warnId) {
        this.warnId = warnId;
    }
}