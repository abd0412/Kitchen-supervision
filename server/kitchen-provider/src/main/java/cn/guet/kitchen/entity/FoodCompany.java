package cn.guet.kitchen.entity;

import java.util.Date;

/**

* @introduce: 

* @author: cyan

* @DATE: 2021/4/2

**/
public class FoodCompany {
    private Integer companyId;

    private String memberId;

    private String companyCode;

    private String companyName;

    private String businessLicense;

    private String legalRepresentative;

    private String phone;

    private String address;

    private String lngandlat;

    private Boolean isDeleted;

    private String insertTime;

    private String updateTime;

    private String level;

    private Boolean isRecommend;

    private String adminCode;

    private String currentMaintenceBatch;

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getBusinessLicense() {
        return businessLicense;
    }

    public void setBusinessLicense(String businessLicense) {
        this.businessLicense = businessLicense;
    }

    public String getLegalRepresentative() {
        return legalRepresentative;
    }

    public void setLegalRepresentative(String legalRepresentative) {
        this.legalRepresentative = legalRepresentative;
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

    public String getLngandlat() {
        return lngandlat;
    }

    public void setLngandlat(String lngandlat) {
        this.lngandlat = lngandlat;
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

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public Boolean getIsRecommend() {
        return isRecommend;
    }

    public void setIsRecommend(Boolean isRecommend) {
        this.isRecommend = isRecommend;
    }

    public String getAdminCode() {
        return adminCode;
    }

    public void setAdminCode(String adminCode) {
        this.adminCode = adminCode;
    }

    public String getCurrentMaintenceBatch() {
        return currentMaintenceBatch;
    }

    public void setCurrentMaintenceBatch(String currentMaintenceBatch) {
        this.currentMaintenceBatch = currentMaintenceBatch;
    }

}