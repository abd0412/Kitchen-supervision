package cn.gxhunter.tourism.common.entity;

import cn.gxhunter.tourism.common.util.DateToLongSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@ApiModel(value = "cn-gxhunter-tourism-common-entity-SysModule")
@Data
public class SysModule implements Serializable {
    /**
     * 模块id
     */
    @ApiModelProperty(value = "模块id")
    private Integer id;

    /**
     * 模块编号
     */
    @ApiModelProperty(value = "模块编号")
    private String code;

    /**
     * 模块名称
     */
    @ApiModelProperty(value = "模块名称")
    private String name;

    /**
     * 上级模块编号
     */
    @ApiModelProperty(value = "上级模块编号")
    private String parent;

    @ApiModelProperty(value = "")
    private String parentName;

    /**
     * 模块操作
     */
    @ApiModelProperty(value = "模块操作")
    private String function;

    /**
     * 编辑人
     */
    @ApiModelProperty(value = "编辑人")
    private String editer;

    /**
     * 创建人
     */
    @ApiModelProperty(value = "创建人")
    private String creater;

    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间")
    @JsonSerialize(using = DateToLongSerializer.class)
    private Date createTime;

    /**
     * 编辑人id
     */
    @ApiModelProperty(value = "编辑人id")
    private Integer editerId;

    /**
     * 创建人id
     */
    @ApiModelProperty(value = "创建人id")
    private Integer createrId;

    /**
     * 编辑时间
     */
    @ApiModelProperty(value = "编辑时间")
    @JsonSerialize(using = DateToLongSerializer.class)
    private Date editTime;

    /**
     * 模块地址
     */
    @ApiModelProperty(value = "模块地址")
    private String url;

    /**
     * 逻辑删除(0:已删除,1:未删除.默认为0)
     */
    @ApiModelProperty(value = "逻辑删除(0:已删除,1:未删除.默认为0)")
    private Boolean isDeleted;

    private static final long serialVersionUID = 1L;
}