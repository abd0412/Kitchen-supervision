package cn.gxhunter.tourism.common.entity;

import cn.gxhunter.tourism.common.util.DateToLongSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 欢迎大屏_公告通知
 */
@ApiModel(value = "cn-gxhunter-tourism-common-entity-WelcomeScreenAnnouncement")
@Data
public class WelcomeScreenAnnouncement implements Serializable {
    /**
     * id
     */
    @ApiModelProperty(value = "id")
    private Integer id;

    /**
     * 内容
     */
    @ApiModelProperty(value = "内容")
    private String content;

    /**
     * 排序编号
     */
    @ApiModelProperty(value = "排序编号")
    private Integer sort;

    /**
     * 是否启用,0:未启用,1:已启用(默认0:未启用)
     */
    @ApiModelProperty(value = "是否启用,0:未启用,1:已启用(默认0:未启用)")
    private Boolean isUsing;

    /**
     * 逻辑删除,0:未删除,1:已删除,默认为0
     */
    @ApiModelProperty(value = "逻辑删除,0:未删除,1:已删除,默认为0")
    private Boolean isDeleted;

    /**
     * 编辑时间
     */
    @JsonSerialize(using = DateToLongSerializer.class)
    @ApiModelProperty(value = "编辑时间")
    private Date editTime;

    /**
     * 创建时间
     */
    @JsonSerialize(using = DateToLongSerializer.class)
    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    private static final long serialVersionUID = 1L;
}