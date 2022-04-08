package cn.gxhunter.tourism.common.entity;

import cn.gxhunter.tourism.common.util.DateToLongSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 特色美食表
 */
@ApiModel(value = "cn-gxhunter-tourism-common-entity-SpecialFood")
@Data
public class SpecialFood implements Serializable {
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
     * 描述
     */
    @ApiModelProperty(value = "描述")
    private String introduction;

    /**
     * 起源故事
     */
    @ApiModelProperty(value = "起源故事")
    private String origin;

    /**
     * 类别编号
     */
    @ApiModelProperty(value = "类别编号")
    private String categoryCode;

    /**
     * 类型,1:小吃,2:农产品
     */
    @ApiModelProperty(value = "类型,1:小吃,2:农产品")
    private Integer type;

    /**
     * 图片路径（以逗号间隔存放多个路径）
     */
    @ApiModelProperty(value = "图片路径（以逗号间隔存放多个路径）")
    private String picturePath;

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
     * 类别名称
     */
    @ApiModelProperty(value = "类别名称")
    private String categoryName;

    private static final long serialVersionUID = 1L;
}