package cn.guet.kitchen.entity;

/**
 * 评论表
 */
public class Comment {
    private Long id;

    /**
     * 模块记录id
     */
    private Long moduleId;

    /**
     * 文件所属模块代码
     */
    private String module;

    /**
     * id
     */
    private String userId;

    /**
     * 订单号
     */
    private String orderNumber;

    /**
     * 评论内容
     */
    private String content;

    /**
     * 评论时间
     */
    private String commentTime;

    /**
     * 是否删除
     */
    private Boolean isDeleted;

    /**
     * 客户满意度（5星制）
     */
    private Double clientEstimate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getModuleId() {
        return moduleId;
    }

    public void setModuleId(Long moduleId) {
        this.moduleId = moduleId;
    }

    public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCommentTime() {
        return commentTime;
    }

    public void setCommentTime(String commentTime) {
        this.commentTime = commentTime;
    }

    public Boolean getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    public Double getClientEstimate() {
        return clientEstimate;
    }

    public void setClientEstimate(Double clientEstimate) {
        this.clientEstimate = clientEstimate;
    }
}