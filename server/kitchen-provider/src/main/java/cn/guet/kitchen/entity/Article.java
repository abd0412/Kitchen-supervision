package cn.guet.kitchen.entity;

import java.util.Date;

/**
    * ???????
    */
public class Article {
    private Long id;

    /**
    * ???????????ƣ????벻?????ظ?
    */
    private String articleTypeCode;

    /**
    * ???????????
    */
    private String articleTypeName;

    /**
    * ???±??
    */
    private String title;

    /**
    * ???????
    */
    private String content;

    /**
    * ????ʱ?
    */
    private Date releaseTime;

    /**
    * ?????
    */
    private String issuer;

    /**
    * ????????
    */
    private Integer playCount;

    /**
    * ?Ƿ??Ƽ?
    */
    private Boolean isRecommend;

    /**
    * ????ʱ?
    */
    private Date createTime;

    /**
    * ????ʱ?
    */
    private Date modifiedTime;

    /**
    * ?Ƿ?ɾ??
    */
    private Boolean isDeleted;

    private Boolean isEnable;

    private Long typeId;

    /**
    * 行政区域编码
    */
    private String adminCode;

    private String moduleCode;

    private Integer moduleId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getArticleTypeCode() {
        return articleTypeCode;
    }

    public void setArticleTypeCode(String articleTypeCode) {
        this.articleTypeCode = articleTypeCode;
    }

    public String getArticleTypeName() {
        return articleTypeName;
    }

    public void setArticleTypeName(String articleTypeName) {
        this.articleTypeName = articleTypeName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getReleaseTime() {
        return releaseTime;
    }

    public void setReleaseTime(Date releaseTime) {
        this.releaseTime = releaseTime;
    }

    public String getIssuer() {
        return issuer;
    }

    public void setIssuer(String issuer) {
        this.issuer = issuer;
    }

    public Integer getPlayCount() {
        return playCount;
    }

    public void setPlayCount(Integer playCount) {
        this.playCount = playCount;
    }

    public Boolean getIsRecommend() {
        return isRecommend;
    }

    public void setIsRecommend(Boolean isRecommend) {
        this.isRecommend = isRecommend;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getModifiedTime() {
        return modifiedTime;
    }

    public void setModifiedTime(Date modifiedTime) {
        this.modifiedTime = modifiedTime;
    }

    public Boolean getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    public Boolean getIsEnable() {
        return isEnable;
    }

    public void setIsEnable(Boolean isEnable) {
        this.isEnable = isEnable;
    }

    public Long getTypeId() {
        return typeId;
    }

    public void setTypeId(Long typeId) {
        this.typeId = typeId;
    }

    public String getAdminCode() {
        return adminCode;
    }

    public void setAdminCode(String adminCode) {
        this.adminCode = adminCode;
    }

    public String getModuleCode() {
        return moduleCode;
    }

    public void setModuleCode(String moduleCode) {
        this.moduleCode = moduleCode;
    }

    public Integer getModuleId() {
        return moduleId;
    }

    public void setModuleId(Integer moduleId) {
        this.moduleId = moduleId;
    }
}