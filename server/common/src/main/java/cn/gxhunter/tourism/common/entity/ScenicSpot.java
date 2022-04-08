package cn.gxhunter.tourism.common.entity;

import cn.gxhunter.tourism.common.entity.custom.ExhibitsCustom;
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
 * 景点信息表
 */
@ApiModel(value = "cn-gxhunter-tourism-common-entity-ScenicSpot")
@Data
public class ScenicSpot implements Serializable {
    /**
     * id
     */
    @ApiModelProperty(value = "id")
    private Integer id;

    /**
     * 所属景区id
     */
    @ApiModelProperty(value = "所属景区id")
    private Integer scenicAreaId;

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
     * 景点简码
     */
    @ApiModelProperty(value = "景点简码")
    private String code;

    /**
     * 推荐图片存放路径
     */
    @ApiModelProperty(value = "推荐图片存放路径")
    private String recommendedPicturePath;

    /**
     * 图片路径（以逗号间隔存放多个路径
     */
    @ApiModelProperty(value = "图片路径（以逗号间隔存放多个路径")
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

    /**
     * 是否推荐
     */
    @ApiModelProperty(value = "是否推荐")
    private Boolean isRecommend;

    @ApiModelProperty(value = "")
    private Integer playCount;

    @ApiModelProperty(value = "")
    private Integer upCount;

    @ApiModelProperty(value = "")
    private Integer commentCount;

    /**
     * 所属景区名称
     */
    @ApiModelProperty(value = "所属景区名称")
    private String scenicAreaName;

    /**
     * 景点分类名称
     */
    @ApiModelProperty(value = "景点分类名称")
    private String categoryName;

    /**
     * 展品列表
     */
    @ApiModelProperty(value = "展品列表")
    private List<ExhibitsCustom> exhibitsList;

    private static final long serialVersionUID = 1L;
}