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
 * 公共基础设施表
 */
@ApiModel(value = "cn-gxhunter-tourism-common-entity-Infrastructure")
@Data
public class Infrastructure implements Serializable {
    /**
     * id
     */
    @ApiModelProperty(value = "id")
    private Integer id;

    /**
     * 所属区域编码
     */
    @ApiModelProperty(value = "所属区域编码")
    private String regionCode;

    /**
     * 名称
     */
    @ApiModelProperty(value = "名称")
    private String name;

    /**
     * 类别编号
     */
    @ApiModelProperty(value = "类别编号")
    private String categoryCode;

    /**
     * 图片路径（以逗号间隔存放多个路径）
     */
    @ApiModelProperty(value = "图片路径（以逗号间隔存放多个路径）")
    private String picturePath;

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
     * 建设标准（如厕所的A AA AAA）
     */
    @ApiModelProperty(value = "建设标准（如厕所的A AA AAA）")
    private String level;

    /**
     * 建设年份
     */
    @ApiModelProperty(value = "建设年份")
    private Integer buildYear;

    /**
     * 联系人
     */
    @ApiModelProperty(value = "联系人")
    private String contact;

    /**
     * 联系电话
     */
    @ApiModelProperty(value = "联系电话")
    private String contactPhone;

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
     * 所属区域名称
     */
    @ApiModelProperty(value = "所属区域名称")
    private String regionName;

    private static final long serialVersionUID = 1L;
}