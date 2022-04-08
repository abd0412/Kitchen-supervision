package cn.gxhunter.tourism.common.entity;

import cn.gxhunter.tourism.common.util.DateToLongSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
    * 康养子项目表
    */
@ApiModel(value="cn-gxhunter-tourism-common-entity-HealthSubItem")
@Data
public class HealthSubItem implements Serializable {
    /**
    * id
    */
    @ApiModelProperty(value="id")
    private Integer id;

    /**
    * 名称
    */
    @ApiModelProperty(value="名称")
    private String name;

    /**
    * 所属康养项目id
    */
    @ApiModelProperty(value="所属康养项目id")
    private Integer healthItemId;

    /**
    * 介绍
    */
    @ApiModelProperty(value="介绍")
    private String introduction;

    /**
    * 图片路径
    */
    @ApiModelProperty(value="图片路径")
    private String picturePath;

    /**
    * 逻辑删除,0:未删除,1:已删除,默认:0
    */
    @ApiModelProperty(value="逻辑删除,0:未删除,1:已删除,默认:0")
    private Boolean isDeleted;

    /**
    * 编辑时间
    */
    @JsonSerialize(using = DateToLongSerializer.class)
    @ApiModelProperty(value="编辑时间")
    private Date editTime;

    /**
    * 创建时间
    */
    @JsonSerialize(using = DateToLongSerializer.class)
    @ApiModelProperty(value="创建时间")
    private Date createTime;

    private static final long serialVersionUID = 1L;
}