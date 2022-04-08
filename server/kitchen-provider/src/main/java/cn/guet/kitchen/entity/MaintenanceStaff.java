package cn.guet.kitchen.entity;

import java.util.Date;

/**
 * @introduce:
 * @author: cyan
 * @DATE: 2021/4/5
 **/
public class MaintenanceStaff {
    /**
     * 员工工号
     */
    private Integer id;

    private String name;

    private Integer age;

    private String sex;

    private String phone;

    private Integer companyId;

    /**
     * 身份证号
     */
    private String cardNum;

    private String update;

    /**
     * 0：在岗  1：请假
     */
    private Boolean ifLeave;

    private Integer dispatchNum;

    private Date leaveStartTime;

    private Date leaveEndTime;

    private Boolean idDeleted;

    private Boolean selectFlag;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public String getCardNum() {
        return cardNum;
    }

    public void setCardNum(String cardNum) {
        this.cardNum = cardNum;
    }

    public String getUpdate() {
        return update;
    }

    public void setUpdate(String update) {
        this.update = update;
    }

    public Boolean getIfLeave() {
        return ifLeave;
    }

    public void setIfLeave(Boolean ifLeave) {
        this.ifLeave = ifLeave;
    }

    public Integer getDispatchNum() {
        return dispatchNum;
    }

    public void setDispatchNum(Integer dispatchNum) {
        this.dispatchNum = dispatchNum;
    }

    public Date getLeaveStartTime() {
        return leaveStartTime;
    }

    public void setLeaveStartTime(Date leaveStartTime) {
        this.leaveStartTime = leaveStartTime;
    }

    public Date getLeaveEndTime() {
        return leaveEndTime;
    }

    public void setLeaveEndTime(Date leaveEndTime) {
        this.leaveEndTime = leaveEndTime;
    }

    public Boolean getIdDeleted() {
        return idDeleted;
    }

    public void setIdDeleted(Boolean idDeleted) {
        this.idDeleted = idDeleted;
    }

    public Boolean getSelectFlag() {
        return selectFlag;
    }

    public void setSelectFlag(Boolean selectFlag) {
        this.selectFlag = selectFlag;
    }
}