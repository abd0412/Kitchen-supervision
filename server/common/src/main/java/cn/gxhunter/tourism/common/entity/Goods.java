package cn.gxhunter.tourism.common.entity;

import cn.gxhunter.tourism.common.util.DateToLongSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 文创商品表
 */
@ApiModel(value = "cn-gxhunter-tourism-common-entity-Goods")
@Data
public class Goods implements Serializable {
    /**
     * id
     */
    @ApiModelProperty(value = "id")
    private Integer id;

    /**
     * 名字
     */
    @ApiModelProperty(value = "名字")
    private String name;

    /**
     * 类别编号
     */
    @ApiModelProperty(value = "类别编号")
    private String categoryCode;

    /**
     * 推荐图片存放路径
     */
    @ApiModelProperty(value = "推荐图片存放路径")
    private String recommendedPicturePath;

    /**
     * 图片路径（以逗号间隔存放多个路径）
     */
    @ApiModelProperty(value = "图片路径（以逗号间隔存放多个路径）")
    private String picturePath;

    /**
     * 介绍
     */
    @ApiModelProperty(value = "介绍")
    private String introduction;

    /**
     * 起源故事
     */
    @ApiModelProperty(value = "起源故事")
    private String origin;

    /**
     * 逻辑删除（0：未删除，1：删除，默认值：0）
     */
    @ApiModelProperty(value = "逻辑删除（0：未删除，1：删除，默认值：0）")
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

    /**
     * 类别名称
     */
    @ApiModelProperty(value = "类别名称")
    private String categoryName;

    /**
     * 类别名称
     */
    @ApiModelProperty(value = "类别名称(英文)")
    private String categoryNameEN;

    private static final long serialVersionUID = 1L;
}