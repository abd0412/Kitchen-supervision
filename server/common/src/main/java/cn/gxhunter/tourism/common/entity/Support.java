package cn.gxhunter.tourism.common.entity;

import cn.gxhunter.tourism.common.util.DateToLongSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
    * 支持表
    */
@ApiModel(value="cn-gxhunter-tourism-common-entity-Support")
@Data
public class Support implements Serializable {
    @ApiModelProperty(value="")
    private Integer id;

    /**
    * 名称
    */
    @ApiModelProperty(value="名称")
    private String name;

    /**
    * 图标
    */
    @ApiModelProperty(value="图标")
    private String fontIcon;

    /**
    * 创建时间
    */
    @ApiModelProperty(value="创建时间")
    @JsonSerialize(using = DateToLongSerializer.class)
    private Date createTime;

    /**
    * 编辑时间
    */
    @ApiModelProperty(value="编辑时间")
    @JsonSerialize(using = DateToLongSerializer.class)
    private Date editTime;

    private static final long serialVersionUID = 1L;
}