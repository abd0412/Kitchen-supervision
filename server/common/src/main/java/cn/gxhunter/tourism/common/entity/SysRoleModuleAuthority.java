package cn.gxhunter.tourism.common.entity;

import cn.gxhunter.tourism.common.util.DateToLongSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@ApiModel(value = "cn-gxhunter-tourism-common-entity-SysRoleModuleAuthority")
@Data
public class SysRoleModuleAuthority implements Serializable {
    /**
     * 角色功能id
     */
    @ApiModelProperty(value = "角色功能id")
    private Integer id;

    /**
     * 角色id
     */
    @ApiModelProperty(value = "角色id")
    private Integer sysRoleId;

    /**
     * 模块id
     */
    @ApiModelProperty(value = "模块id")
    private Integer sysModuleId;

    /**
     * 操作权限
     */
    @ApiModelProperty(value = "操作权限")
    private String function;

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

    /**
     * 模块code
     */
    @ApiModelProperty(value = "模块code")
    private String sysModuleCode;

    private static final long serialVersionUID = 1L;
}