package cn.gxhunter.tourism.common.entity;

import cn.gxhunter.tourism.common.util.DateToLongSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 公共基础设施类别表
 */
@ApiModel(value = "cn-gxhunter-tourism-common-entity-InfrastructureCategory")
@Data
public class InfrastructureCategory implements Serializable {
    /**
     * id
     */
    @ApiModelProperty(value = "id")
    private Integer id;

    /**
     * 分类编码
     */
    @ApiModelProperty(value = "分类编码")
    private String code;

    @ApiModelProperty(value = "上级分类编码")
    private String upCode;

    /**
     * 名称
     */
    @ApiModelProperty(value = "名称")
    private String name;

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