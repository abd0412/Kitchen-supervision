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
 * 租赁公司表
 */
@ApiModel(value = "cn-gxhunter-tourism-common-entity-RentalCompany")
@Data
public class RentalCompany implements Serializable {
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
     * 出租类型（1：租车；2：包车；3：既可租车亦可包车；）
     */
    @ApiModelProperty(value = "出租类型（1：租车；2：包车；3：既可租车亦可包车；）")
    private Integer type;

    /**
     * 联系方式
     */
    @ApiModelProperty(value = "联系方式")
    private String contact;

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
     * 逻辑删除(0:已删除,1:未删除.默认为0)
     */
    @ApiModelProperty(value = "逻辑删除(0:已删除,1:未删除.默认为0)")
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