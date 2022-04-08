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
 * 旅行社表
 */
@ApiModel(value = "cn-gxhunter-tourism-common-entity-TravelAgency")
@Data
public class TravelAgency implements Serializable {
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
     * 许可证号
     */
    @ApiModelProperty(value = "许可证号")
    private String code;

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
     * 经营场所范围（经营行政区域的所有权）
     */
    @ApiModelProperty(value = "经营场所范围（经营行政区域的所有权）")
    private String businessPlace;

    /**
     * 企业标志存放路径
     */
    @ApiModelProperty(value = "企业标志存放路径")
    private String logoPath;

    /**
     * 营业执照存放路径
     */
    @ApiModelProperty(value = "营业执照存放路径")
    private String picturePath;

    /**
     * 法人代表
     */
    @ApiModelProperty(value = "法人代表")
    private String legalPerson;

    /**
     * 注册资金
     */
    @ApiModelProperty(value = "注册资金")
    private Long registeredCapital;

    /**
     * 注册时间
     */
    @ApiModelProperty(value = "注册时间")
    @JsonSerialize(using = DateToLongSerializer.class)
    private Date registeredTime;

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
     * 所属区域名称
     */
    @ApiModelProperty(value = "所属区域名称")
    private String regionName;

    private static final long serialVersionUID = 1L;
}