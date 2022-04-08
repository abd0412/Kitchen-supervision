package cn.guet.kitchen.entity;

/**
 * @introduce:
 * @author: cyan
 * @DATE: 2021/4/5
 **/
public class OperationCompany {
    private Integer operationCompanyId;

    private String companyCode;

    private String companyName;

    private String businessLicense;

    private String legalRepresentative;

    private String phone;

    private String address;

    private String lngandlat;

    private String level;

    private String insertTime;

    private String updateTime;

    private Boolean isDeleted;

    private Boolean isRecommend;

    private String adminCode;

    private Integer dispatchNum;

    public Integer getOperationCompanyId() {
        return operationCompanyId;
    }

    public void setOperationCompanyId(Integer operationCompanyId) {
        this.operationCompanyId = operationCompanyId;
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

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
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

    public void setIsDeleted(Boolean deleted) {
        isDeleted = deleted;
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

    public Integer getDispatchNum() {
        return dispatchNum;
    }

    public void setDispatchNum(Integer dispatchNum) {
        this.dispatchNum = dispatchNum;
    }
}