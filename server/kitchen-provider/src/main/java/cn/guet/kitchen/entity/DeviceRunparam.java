package cn.guet.kitchen.entity;

import java.util.Date;

/**

* @introduce: 

* @author: cyan

* @DATE: 2021/4/9

**/
public class DeviceRunparam {
    /**
    * 设备ID（唯一识别）
    */
    private String deviceId;

    /**
    * 不用
    */
    private Integer paramId;

    /**
    * 0停止/1运行
    */
    private Boolean isOnline;

    private Boolean isDeleted;

    private String insertTime;

    private String updateTime;

    /**
    * 距离下次维保还剩多少小时
    */
    private String nextTime;

    /**
    * 正常（默认）、运行、停止
    */
    private String status;

    private Integer maintenanceNum;

    private Integer startStopNum;

    private Date nearOnlineTime;

    private Date nearOfflineTime;

    /**
    * 维保周期（天）
    */
    private Integer maintenanceRound;

    /**
    * 设备安装以来的运行时长
    */
    private String totalUsedTime;
    /**
     * 实时运行时间-本次开机远行时间
     */
    private String realRunningTime;

    /**
     * 设备维保后使用时长
     */
    private String useTimeAfterMaintenance;
    /**
     * 上次维保时间
     */
    private String lastTime;

    private Date nearMaintanceTime;

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public Integer getParamId() {
        return paramId;
    }

    public void setParamId(Integer paramId) {
        this.paramId = paramId;
    }

    public Boolean getIsOnline() {
        return isOnline;
    }

    public void setIsOnline(Boolean isOnline) {
        this.isOnline = isOnline;
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

    public String getNextTime() {
        return nextTime;
    }

    public void setNextTime(String nextTime) {
        this.nextTime = nextTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getMaintenanceNum() {
        return maintenanceNum;
    }

    public void setMaintenanceNum(Integer maintenanceNum) {
        this.maintenanceNum = maintenanceNum;
    }

    public Integer getStartStopNum() {
        return startStopNum;
    }

    public void setStartStopNum(Integer startStopNum) {
        this.startStopNum = startStopNum;
    }

    public Date getNearOnlineTime() {
        return nearOnlineTime;
    }

    public void setNearOnlineTime(Date nearOnlineTime) {
        this.nearOnlineTime = nearOnlineTime;
    }

    public Date getNearOfflineTime() {
        return nearOfflineTime;
    }

    public void setNearOfflineTime(Date nearOfflineTime) {
        this.nearOfflineTime = nearOfflineTime;
    }

    public Integer getMaintenanceRound() {
        return maintenanceRound;
    }

    public void setMaintenanceRound(Integer maintenanceRound) {
        this.maintenanceRound = maintenanceRound;
    }

    public String getTotalUsedTime() {
        return totalUsedTime;
    }

    public void setTotalUsedTime(String totalUsedTime) {
        this.totalUsedTime = totalUsedTime;
    }

    public String getRealRunningTime() {
        return realRunningTime;
    }

    public void setRealRunningTime(String realRunningTime) {
        this.realRunningTime = realRunningTime;
    }

    public String getUseTimeAfterMaintenance() {
        return useTimeAfterMaintenance;
    }

    public void setUseTimeAfterMaintenance(String useTimeAfterMaintenance) {
        this.useTimeAfterMaintenance = useTimeAfterMaintenance;
    }

    public String getLastTime() {
        return lastTime;
    }

    public void setLastTime(String lastTime) {
        this.lastTime = lastTime;
    }

    public Date getNearMaintanceTime() {
        return nearMaintanceTime;
    }

    public void setNearMaintanceTime(Date nearMaintanceTime) {
        this.nearMaintanceTime = nearMaintanceTime;
    }
}