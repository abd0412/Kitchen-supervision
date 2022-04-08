package cn.gxhunter.tourism.common.entity;

import cn.gxhunter.tourism.common.util.DateToLongSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@ApiModel(value = "cn-gxhunter-tourism-common-entity-SysUser")
@Data
public class SysUser implements Serializable {
    /**
     * 用户id
     */
    @ApiModelProperty(value = "用户id")
    private Integer id;

    /**
     * 用户名(登录账号)
     */
    @ApiModelProperty(value = "用户名(登录账号)")
    private String userName;

    /**
     * 用户密码
     */
    @ApiModelProperty(value = "用户密码")
    private String password;

    /**
     * 名称
     */
    @ApiModelProperty(value = "名称")
    private String name;

    @ApiModelProperty(value = "")
    private String flag;

    /**
     * 备注
     */
    @ApiModelProperty(value = "备注")
    private String remark;

    /**
     * 微信授权open_id
     */
    @ApiModelProperty(value = "微信授权open_id")
    private String wxOpenId;

    /**
     * 逻辑删除(0:已删除,1:未删除.默认为0)
     */
    @ApiModelProperty(value = "逻辑删除(0:已删除,1:未删除.默认为0)")
    private Boolean isDeleted;

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
     * 角色信息
     */
    @ApiModelProperty(value = "角色信息")
    private List<SysRole> roles;

    /**
     * 角色信息
     */
    @ApiModelProperty(hidden = true)
    private String roleMessage;

    private static final long serialVersionUID = 1L;
}