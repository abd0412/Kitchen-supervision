package cn.guet.kitchen.entity;

import java.util.Date;

public class DeviceAlarm {
    private Integer deviceId;

    /**
    * 01：正常；02：预警；03：报警
    */
    private String warnCode;

    /**
    * 正常、预警、报警
    */
    private String warnMessage;

    private Boolean isDeleted;

    private Date insertTime;

    private Date updateTime;

    private Boolean isDealed;

    /**
    * 预警次数
    */
    private Integer earlyWarningNum;

    /**
    * 报警次数
    */
    private Integer alarmNum;

    public Integer getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(Integer deviceId) {
        this.deviceId = deviceId;
    }

    public String getWarnCode() {
        return warnCode;
    }

    public void setWarnCode(String warnCode) {
        this.warnCode = warnCode;
    }

    public String getWarnMessage() {
        return warnMessage;
    }

    public void setWarnMessage(String warnMessage) {
        this.warnMessage = warnMessage;
    }

    public Boolean getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    public Date getInsertTime() {
        return insertTime;
    }

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Boolean getIsDealed() {
        return isDealed;
    }

    public void setIsDealed(Boolean isDealed) {
        this.isDealed = isDealed;
    }

    public Integer getEarlyWarningNum() {
        return earlyWarningNum;
    }

    public void setEarlyWarningNum(Integer earlyWarningNum) {
        this.earlyWarningNum = earlyWarningNum;
    }

    public Integer getAlarmNum() {
        return alarmNum;
    }

    public void setAlarmNum(Integer alarmNum) {
        this.alarmNum = alarmNum;
    }
}