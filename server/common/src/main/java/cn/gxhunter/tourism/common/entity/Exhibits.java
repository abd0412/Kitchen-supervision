package cn.gxhunter.tourism.common.entity;

import cn.gxhunter.tourism.common.util.DateToLongSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 展品
 */
@ApiModel(value = "cn-gxhunter-tourism-common-entity-Exhibits")
@Data
public class Exhibits implements Serializable {
    @ApiModelProperty(value = "")
    private Integer id;

    /**
     * 名称
     */
    @ApiModelProperty(value = "名称")
    private String name;

    /**
     * 编号
     */
    @ApiModelProperty(value = "编号")
    private String code;

    /**
     * 所属景点
     */
    @ApiModelProperty(value = "所属景点")
    private Integer scenicSpotId;

    /**
     * 推荐图片路径
     */
    @ApiModelProperty(value = "推荐图片路径")
    private String recommendedPicturePath;

    /**
     * 图片路径
     */
    @ApiModelProperty(value = "图片路径")
    private String picturePath;

    /**
     * 音频路径
     */
    @ApiModelProperty(value = "音频路径")
    private String audioPath;

    /**
     * 二维码图片路径
     */
    @ApiModelProperty(value = "二维码图片路径")
    private String qrCodeImagePath;

    /**
     * 介绍
     */
    @ApiModelProperty(value = "介绍")
    private String introduction;

    /**
     * 逻辑删除:0:未删除,1:已删除(默认值:0)
     */
    @ApiModelProperty(value = "逻辑删除:0:未删除,1:已删除(默认值:0)")
    private Boolean isDeleted;

    /**
     * 编辑时间
     */
    @ApiModelProperty(value = "编辑时间")
    @JsonSerialize(using = DateToLongSerializer.class)
    private Date editTime;

    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间")
    @JsonSerialize(using = DateToLongSerializer.class)
    private Date createTime;

    private static final long serialVersionUID = 1L;
}