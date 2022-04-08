package cn.gxhunter.tourism.common.entity;

import cn.gxhunter.tourism.common.util.DateToLongSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 节日表
 */
@ApiModel(value = "cn-gxhunter-tourism-common-entity-Festival")
@Data
public class Festival implements Serializable {
    /**
     * id
     */
    @ApiModelProperty(value = "id")
    private Integer id;

    /**
     * 名称
     */
    @ApiModelProperty(value = "名称")
    private String name;

    /**
     * 举办时间
     */
    @ApiModelProperty(value = "举办时间")
    private String holdTime;

    /**
     * 举报地点
     */
    @ApiModelProperty(value = "举报地点")
    private String holdPlace;

    /**
     * 介绍
     */
    @ApiModelProperty(value = "介绍")
    private String introduction;

    /**
     * 节日起源故事
     */
    @ApiModelProperty(value = "节日起源故事")
    private String origin;

    /**
     * 图片存放路径
     */
    @ApiModelProperty(value = "图片存放路径")
    private String picturePath;

    /**
     * 二维码图片路径
     */
    @ApiModelProperty(value = "二维码图片路径")
    private String qrCodeImagePath;

    /**
     * 是否推荐
     */
    @ApiModelProperty(value = "是否推荐")
    private Boolean isRecommend;

    /**
     * 逻辑删除（0：未删除，1：删除，默认值：0）
     */
    @ApiModelProperty(value = "逻辑删除（0：未删除，1：删除，默认值：0）")
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