package cn.guet.kitchen.entity;

/**
 * @introduce:
 * @author: cyan
 * @DATE: 2021/4/7
 **/
public class Device {
    /**
     * 设备ID，唯一识别，手动填入（设备出厂编号）
     */
    private String deviceId;

    /**
     * 设备所属餐饮企业ID
     */
    private Integer companyId;

    /**
     * 设备厂商ID
     */
    private Integer manufacturerId;

    /**
     * 暂时不用
     */
    private String deviceCode;

    /**
     * 暂时空值
     */
    private String deviceName;

    /**
     * 设备注册时间
     */
    private String insertTime;

    /**
     * 修改时间
     */
    private String updateTime;

    /**
     * 是否删除
     */
    private Boolean isDeleted;

    /**
     * 在餐饮企业序号（第几个设备）
     */
    private Integer seqNum;

    private Integer gateId;

    private String status;//设备状态

    private Integer isOnline; //0：停止  1：运行

    private Integer allRunTime;

    private Integer maintenanceNum;
    //维保周期
    private String maintenanceRound;

    private String nextTime;

    private Integer startStopNum;

    private Integer earlyWarningNum;

    private Integer alarmNum;

    //页号
    private int pageNumber;

    //对查询结果编号
    private int outSelectSerial;

    private Integer pipeline;

    private String supervisionId;
    //上次维保时间
    private String nearMaintanceTime;

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public Integer getManufacturerId() {
        return manufacturerId;
    }

    public void setManufacturerId(Integer manufacturerId) {
        this.manufacturerId = manufacturerId;
    }

    public String getDeviceCode() {
        return deviceCode;
    }

    public void setDeviceCode(String deviceCode) {
        this.deviceCode = deviceCode;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
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

    public Boolean getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    public Integer getSeqNum() {
        return seqNum;
    }

    public void setSeqNum(Integer seqNum) {
        this.seqNum = seqNum;
    }

    public Integer getGateId() {
        return gateId;
    }

    public void setGateId(Integer gateId) {
        this.gateId = gateId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getIsOnline() {
        return isOnline;
    }

    public void setIsOnline(Integer isOnline) {
        this.isOnline = isOnline;
    }

    public Integer getAllRunTime() {
        return allRunTime;
    }

    public void setAllRunTime(Integer allRunTime) {
        this.allRunTime = allRunTime;
    }

    public Integer getMaintenanceNum() {
        return maintenanceNum;
    }

    public void setMaintenanceNum(Integer maintenanceNum) {
        this.maintenanceNum = maintenanceNum;
    }

    public String getMaintenanceRound() {
        return maintenanceRound;
    }

    public void setMaintenanceRound(String maintenanceRound) {
        this.maintenanceRound = maintenanceRound;
    }

    public String getNextTime() {
        return nextTime;
    }

    public void setNextTime(String nextTime) {
        this.nextTime = nextTime;
    }

    public Integer getStartStopNum() {
        return startStopNum;
    }

    public void setStartStopNum(Integer startStopNum) {
        this.startStopNum = startStopNum;
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

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public int getOutSelectSerial() {
        return outSelectSerial;
    }

    public void setOutSelectSerial(int outSelectSerial) {
        this.outSelectSerial = outSelectSerial;
    }

    public Integer getPipeline() {
        return pipeline;
    }

    public void setPipeline(Integer pipeline) {
        this.pipeline = pipeline;
    }

    public String getSupervisionId() {
        return supervisionId;
    }

    public void setSupervisionId(String supervisionId) {
        this.supervisionId = supervisionId;
    }

    public String getNearMaintanceTime() {
        return nearMaintanceTime;
    }

    public void setNearMaintanceTime(String nearMaintanceTime) {
        this.nearMaintanceTime = nearMaintanceTime;
    }
}