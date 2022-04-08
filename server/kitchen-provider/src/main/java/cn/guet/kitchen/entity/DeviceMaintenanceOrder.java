package cn.guet.kitchen.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**

* @introduce: 

* @author: cyan

* @DATE: 2021/3/31

**/
public class DeviceMaintenanceOrder implements Serializable {
    private Integer maintenanceId;

    private Integer maintenanceCompanyId;

    private Boolean isDeleted;

    private String insertTime;

    private String updateTime;

    /**
     * 订单类型：设备清洗、设备维修、设备安装
     */
    private String orderType;

    private Integer foodCompanyId;
    /**
     * 订单在系统中生成时，系统根据算法指定的一个公司中的一位派单负责人
     */
    private String oneProcessorId;

    private Integer processorId;

    private Double money;

    /**
     * 1、已分配  2、已处理  3、待确认  4、已确认
     */
    private Integer orderStatus;

    /**
     * 产生类型：餐饮企业下单、系统下单、运维人员下单、系统自动下单
     */
    private String genType;

    /**
     * 批次
     */
    private Integer batch;

    private String time;

    /**
     * 时间段
     */
    private String maintenanceTimeseg;

    private String remark;

    private Integer warnId;

    private String orderNumber;

    private String flowNum;

    private OrderRelateType devices;

    private Date insertTimeStart;

    private Date insertTimeEnd;

    private int pageNumber; //页号（不要改变类型）

    private int outSelectSerial; //对查询结果编号

    private Boolean selectFlag;

    private String companyName;//餐饮企业名字

    private String phone;//餐饮企业电话

    private String address;//餐饮企业地址

    private List<ProcessorId> processorIdArray; //派单员工数组

    private String dispatchTime; //派单时间

    private Integer clientEstimate; //客户满意度

    private String signImg; //签名图片的url

    private String missionImg; //员工完成任务时拍摄的图片url

    private String acceptanceTime; //验收时间

    private String updateDispatchTime; //修改派单信息时间

    public Integer getMaintenanceId() {
        return maintenanceId;
    }

    public void setMaintenanceId(Integer maintenanceId) {
        this.maintenanceId = maintenanceId;
    }

    public Integer getMaintenanceCompanyId() {
        return maintenanceCompanyId;
    }

    public void setMaintenanceCompanyId(Integer maintenanceCompanyId) {
        this.maintenanceCompanyId = maintenanceCompanyId;
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

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    public Integer getFoodCompanyId() {
        return foodCompanyId;
    }

    public void setFoodCompanyId(Integer foodCompanyId) {
        this.foodCompanyId = foodCompanyId;
    }

    public String getOneProcessorId() {
        return oneProcessorId;
    }

    public void setOneProcessorId(String oneProcessorId) {
        this.oneProcessorId = oneProcessorId;
    }

    public Integer getProcessorId() {
        return processorId;
    }

    public void setProcessorId(Integer processorId) {
        this.processorId = processorId;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public Integer getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getGenType() {
        return genType;
    }

    public void setGenType(String genType) {
        this.genType = genType;
    }

    public Integer getBatch() {
        return batch;
    }

    public void setBatch(Integer batch) {
        this.batch = batch;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getMaintenanceTimeseg() {
        return maintenanceTimeseg;
    }

    public void setMaintenanceTimeseg(String maintenanceTimeseg) {
        this.maintenanceTimeseg = maintenanceTimeseg;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getWarnId() {
        return warnId;
    }

    public void setWarnId(Integer warnId) {
        this.warnId = warnId;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getFlowNum() {
        return flowNum;
    }

    public void setFlowNum(String flowNum) {
        this.flowNum = flowNum;
    }

    public OrderRelateType getDevices() {
        return devices;
    }

    public void setDevices(OrderRelateType devices) {
        this.devices = devices;
    }

    public Date getInsertTimeStart() {
        return insertTimeStart;
    }

    public void setInsertTimeStart(Date insertTimeStart) {
        this.insertTimeStart = insertTimeStart;
    }

    public Date getInsertTimeEnd() {
        return insertTimeEnd;
    }

    public void setInsertTimeEnd(Date insertTimeEnd) {
        this.insertTimeEnd = insertTimeEnd;
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

    public Boolean getSelectFlag() {
        return selectFlag;
    }

    public void setSelectFlag(Boolean selectFlag) {
        this.selectFlag = selectFlag;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getClientEstimate() {
        return clientEstimate;
    }

    public void setClientEstimate(Integer clientEstimate) {
        this.clientEstimate = clientEstimate;
    }

    public String getSignImg() {
        return signImg;
    }

    public void setSignImg(String signImg) {
        this.signImg = signImg;
    }

    public String getMissionImg() {
        return missionImg;
    }

    public void setMissionImg(String missionImg) {
        this.missionImg = missionImg;
    }

    public String getDispatchTime() {
        return dispatchTime;
    }

    public void setDispatchTime(String dispatchTime) {
        this.dispatchTime = dispatchTime;
    }

    public String getAcceptanceTime() {
        return acceptanceTime;
    }

    public void setAcceptanceTime(String acceptanceTime) {
        this.acceptanceTime = acceptanceTime;
    }

    public List<ProcessorId> getProcessorIdArray() {
        return processorIdArray;
    }

    public void setProcessorIdArray(List<ProcessorId> processorIdArray) {
        this.processorIdArray = processorIdArray;
    }

    public String getUpdateDispatchTime() {
        return updateDispatchTime;
    }

    public void setUpdateDispatchTime(String updateDispatchTime) {
        this.updateDispatchTime = updateDispatchTime;
    }
}