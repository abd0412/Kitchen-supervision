package cn.gxhunter.tourism.common.entity;

import cn.gxhunter.tourism.common.util.DateToLongSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 房型表
 */
@ApiModel(value = "cn-gxhunter-tourism-common-entity-RoomType")
@Data
public class RoomType implements Serializable {
    /**
     * id
     */
    @ApiModelProperty(value = "id")
    private Integer id;

    /**
     * 酒店/民宿id
     */
    @ApiModelProperty(value = "酒店/民宿id")
    private Integer hotelId;

    /**
     * 名称
     */
    @ApiModelProperty(value = "名称")
    private String name;

    /**
     * 介绍
     */
    @ApiModelProperty(value = "介绍")
    private String introduction;

    /**
     * 参考价格
     */
    @ApiModelProperty(value = "参考价格")
    private BigDecimal price;

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
     * 面积
     */
    @ApiModelProperty(value = "面积")
    private Integer area;

    /**
     * 楼层
     */
    @ApiModelProperty(value = "楼层")
    private Integer floor;

    /**
     * 是否有窗（0：无；1：有）
     */
    @ApiModelProperty(value = "是否有窗（0：无；1：有）")
    private Boolean hasWindow;

    /**
     * 是否有wifi（0：无；1：有）
     */
    @ApiModelProperty(value = "是否有wifi（0：无；1：有）")
    private Boolean hasWifi;

    /**
     * 有无早餐（0：无；1：有）
     */
    @ApiModelProperty(value = "有无早餐（0：无；1：有）")
    private Boolean hasBreakfast;

    /**
     * 入住人数
     */
    @ApiModelProperty(value = "入住人数")
    private Integer customerNumber;

    /**
     * 文字描述床的长度、床的数量
     */
    @ApiModelProperty(value = "文字描述床的长度、床的数量")
    private String bed;

    /**
     * 标签
     */
    @ApiModelProperty(value = "标签")
    private String label;

    /**
     * 逻辑删除（0：未删除，1：删除，默认值：0）
     */
    @ApiModelProperty(value = "逻辑删除（0：未删除，1：删除，默认值：0）")
    private Boolean isDeleted;

    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间")
    @JsonSerialize(using = DateToLongSerializer.class)
    private Date createTime;

    /**
     * 编辑时间
     */
    @ApiModelProperty(value = "编辑时间")
    @JsonSerialize(using = DateToLongSerializer.class)
    private Date editTime;

    /**
     * 酒店/民宿名称
     */
    @ApiModelProperty(value = "酒店/民宿名称")
    private String hotelName;

    private static final long serialVersionUID = 1L;
}