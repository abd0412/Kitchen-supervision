package cn.gxhunter.tourism.common.entity;

import cn.gxhunter.tourism.common.util.DateToLongSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 景点类别表
 */
@ApiModel(value = "cn-gxhunter-tourism-common-entity-ScenicSpotCategory")
@Data
public class ScenicSpotCategory implements Serializable {
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
     * 类别编码
     */
    @ApiModelProperty(value = "类别编码")
    private String code;

    /**
     * 父级类别编码
     */
    @ApiModelProperty(value = "父级类别编码")
    private String upCode;

    @ApiModelProperty(value = "类别描述")
    private String description;

    /**
     * 逻辑删除(1:已删除,0:未删除.默认为0)
     */
    @ApiModelProperty(value = "逻辑删除(1:已删除,0:未删除.默认为0)")
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
     * 父级类别名称
     */
    @ApiModelProperty(value = "父级类别名称")
    private String upName;

    private static final long serialVersionUID = 1L;
}