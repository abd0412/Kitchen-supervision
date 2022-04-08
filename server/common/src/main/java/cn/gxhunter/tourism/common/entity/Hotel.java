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
 * 酒店民宿表
 */
@ApiModel(value = "cn-gxhunter-tourism-common-entity-Hotel")
@Data
public class Hotel implements Serializable {
    /**
     * id
     */
    @ApiModelProperty(value = "id")
    private Integer id;

    /**
     * 类别（1：酒店；2：民宿；）
     */
    @ApiModelProperty(value = "类别（1：酒店；2：民宿；）")
    private Integer type;

    /**
     * 酒店民宿片区id
     */
    @ApiModelProperty(value = "酒店民宿片区id")
    private Integer areaId;

    /**
     * 所属区域表
     */
    @ApiModelProperty(value = "所属区域表")
    private String regionCode;

    /**
     * 名称
     */
    @ApiModelProperty(value = "名称")
    private String name;

    /**
     * 位置
     */
    @ApiModelProperty(value = "位置")
    private String location;

    /**
     * 经度
     */
    @ApiModelProperty(value = "经度")
    private BigDecimal longitude;

    /**
     * 纬度
     */
    @ApiModelProperty(value = "纬度")
    private BigDecimal latitude;

    /**
     * 介绍
     */
    @ApiModelProperty(value = "介绍")
    private String introduction;

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
     * 二维码图片路径
     */
    @ApiModelProperty(value = "二维码图片路径")
    private String qrCodeImagePath;

    /**
     * 星级（1：一星；2：二星；3：三星；4：四星；5：五星）
     */
    @ApiModelProperty(value = "星级（1：一星；2：二星；3：三星；4：四星；5：五星）")
    private Integer star;

    /**
     * 档次（1：经济型；2：舒适型；3：高档型）
     */
    @ApiModelProperty(value = "档次（1：经济型；2：舒适型；3：高档型）")
    private Integer grade;

    /**
     * 地标
     */
    @ApiModelProperty(value = "地标")
    private String landmark;

    /**
     * 装修时间
     */
    @JsonSerialize(using = DateToLongSerializer.class)
    @ApiModelProperty(value = "装修时间")
    private Date renovationTime;

    /**
     * 开业时间
     */
    @JsonSerialize(using = DateToLongSerializer.class)
    @ApiModelProperty(value = "开业时间")
    private Date openTime;

    /**
     * 楼层高度
     */
    @ApiModelProperty(value = "楼层高度")
    private Integer floorHeight;

    /**
     * 客房总量
     */
    @ApiModelProperty(value = "客房总量")
    private Integer roomTotal;

    /**
     * 停车场（0：无；1：有）
     */
    @ApiModelProperty(value = "停车场（0：无；1：有）")
    private Boolean hasParking;

    /**
     * 联系方式
     */
    @ApiModelProperty(value = "联系方式")
    private String contact;

    /**
     * 是否属于康养
     */
    @ApiModelProperty(value = "是否属于康养")
    private Boolean isRecuperation;

    /**
     * 评论数量
     */
    @ApiModelProperty(value = "评论数量")
    private Integer commentCount;

    /**
     * 浏览数量
     */
    @ApiModelProperty(value = "浏览数量")
    private Integer playCount;

    /**
     * 点赞数量
     */
    @ApiModelProperty(value = "点赞数量")
    private Integer upCount;

    /**
     * 逻辑删除（0：未删除，1：删除，默认值：0）
     */
    @ApiModelProperty(value = "逻辑删除（0：未删除，1：删除，默认值：0）")
    private Boolean isDeleted;

    /**
     * 创建时间
     */
    @JsonSerialize(using = DateToLongSerializer.class)
    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    /**
     * 编辑时间
     */
    @JsonSerialize(using = DateToLongSerializer.class)
    @ApiModelProperty(value = "编辑时间")
    private Date editTime;

    /**
     * 所属区域名称
     */
    @ApiModelProperty(value = "所属区域名称")
    private String regionName;

    /**
     * 酒店民宿片区名称
     */
    @ApiModelProperty(value = "酒店民宿片区名称")
    private String areaName;

    /**
     * 参考价格
     */
    @ApiModelProperty(value = "参考价格")
    private BigDecimal price;

    private static final long serialVersionUID = 1L;
}