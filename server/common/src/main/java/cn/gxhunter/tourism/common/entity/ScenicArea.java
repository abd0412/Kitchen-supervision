package cn.gxhunter.tourism.common.entity;

import cn.gxhunter.tourism.common.util.DateToLongSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * 景区信息表
 */
@ApiModel(value = "cn-gxhunter-tourism-common-entity-ScenicArea")
@Data
public class ScenicArea implements Serializable {
    /**
     * id
     */
    @ApiModelProperty(value = "id")
    private Integer id;

    /**
     * 所属行政区域编码
     */
    @ApiModelProperty(value = "所属行政区域编码")
    private String regionCode;

    /**
     * 景区简码
     */
    @ApiModelProperty(value = "景区简码")
    private String code;

    /**
     * 类别编码
     */
    @ApiModelProperty(value = "类别编码")
    private String categoryCode;

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
     * 推荐图片存放路径
     */
    @ApiModelProperty(value = "推荐图片存放路径")
    private String recommendedPicturePath;

    /**
     * 图片存放路径（以逗号间隔存放多个路径
     */
    @ApiModelProperty(value = "图片存放路径（以逗号间隔存放多个路径")
    private String picturePath;

    /**
     * 音频路径
     */
    @ApiModelProperty(value = "音频路径")
    private String audioPath;

    /**
     * 介绍
     */
    @ApiModelProperty(value = "介绍")
    private String introduction;

    /**
     * 星级（1 一星级 ，2 二星级，3 三星级，4 四星级，5 五星级）
     */
    @ApiModelProperty(value = "星级（1 一星级 ，2 二星级，3 三星级，4 四星级，5 五星级）")
    private Integer star;

    /**
     * 等级（1：A；2：AA；3：AAA；4：AAAA；5：AAAAA
     */
    @ApiModelProperty(value = "等级（1：A；2：AA；3：AAA；4：AAAA；5：AAAAA")
    private Integer grade;

    /**
     * 二维码图片存放路径
     */
    @ApiModelProperty(value = "二维码图片存放路径")
    private String qrCodeImagePath;

    /**
     * 支持
     */
    @ApiModelProperty(value = "支持")
    private String support;

    /**
     * 交通信息
     */
    @ApiModelProperty(value = "交通信息")
    private String trafficInformation;

    /**
     * 预计游览时长
     */
    @ApiModelProperty(value = "预计游览时长")
    private String duration;

    /**
     * 开放时间
     */
    @JsonSerialize(using = DateToLongSerializer.class)
    @ApiModelProperty(value = "开放时间")
    private Date openTime;

    /**
     * 关闭时间
     */
    @JsonSerialize(using = DateToLongSerializer.class)
    @ApiModelProperty(value = "关闭时间")
    private Date closeTime;

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
     * 是否推荐
     */
    @ApiModelProperty(value = "是否推荐")
    private Boolean isRecommend;

    /**
     * 景区活动
     */
    @ApiModelProperty(value = "景区活动")
    private String activity;

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
     * 所属行政区域名称
     */
    @ApiModelProperty(value = "所属行政区域名称")
    private String regionName;

    /**
     * 景区分类名称
     */
    @ApiModelProperty(value = "景区分类名称")
    private String categoryName;

    /**
     * 景区支持
     */
    @ApiModelProperty(value = "景区支持")
    private List<Support> supportList;

    private static final long serialVersionUID = 1L;
}