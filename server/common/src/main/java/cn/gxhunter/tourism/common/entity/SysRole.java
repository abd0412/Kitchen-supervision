package cn.gxhunter.tourism.common.entity;

import cn.gxhunter.tourism.common.util.DateToLongSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@ApiModel(value = "cn-gxhunter-tourism-common-entity-SysRole")
@Data
public class SysRole implements Serializable {
    /**
     * 角色id
     */
    @ApiModelProperty(value = "角色id")
    private Integer id;

    /**
     * 角色编号
     */
    @ApiModelProperty(value = "角色编号")
    private String code;

    /**
     * 角色名称
     */
    @ApiModelProperty(value = "角色名称")
    private String name;

    @ApiModelProperty(value = "")
    private String flag;

    /**
     * 备注
     */
    @ApiModelProperty(value = "备注")
    private String remark;

    /**
     * 创建人id
     */
    @ApiModelProperty(value = "创建人id")
    private Integer createrId;

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
     * 编辑人
     */
    @ApiModelProperty(value = "编辑人")
    private String editer;

    /**
     * 编辑时间
     */
    @ApiModelProperty(value = "编辑时间")
    @JsonSerialize(using = DateToLongSerializer.class)
    private Date editTime;

    /**
     * 逻辑删除(0:已删除,1:未删除.默认为0)
     */
    @ApiModelProperty(value = "逻辑删除(0:已删除,1:未删除.默认为0)")
    private Boolean isDeleted;

    private static final long serialVersionUID = 1L;
}