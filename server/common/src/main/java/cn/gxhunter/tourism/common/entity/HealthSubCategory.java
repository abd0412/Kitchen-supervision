package cn.gxhunter.tourism.common.entity;

import cn.gxhunter.tourism.common.util.DateToLongSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
    * 康养子类别表
    */
@ApiModel(value="cn-gxhunter-tourism-common-entity-HealthSubCategory")
@Data
public class HealthSubCategory implements Serializable {
    /**
    * id
    */
    @ApiModelProperty(value="id")
    private Integer id;

    /**
    * 编号
    */
    @ApiModelProperty(value="编号")
    private String code;

    /**
    * 名称
    */
    @ApiModelProperty(value="名称")
    private String name;

    /**
    * 所属康养类别编号
    */
    @ApiModelProperty(value="所属康养类别编号")
    private String healthCategoryCode;

    /**
    * 介绍
    */
    @ApiModelProperty(value="介绍")
    private String introduction;

    /**
    * 推荐图片路径
    */
    @ApiModelProperty(value="推荐图片路径")
    private String recommendedPicturePath;

    /**
    * 图片路径
    */
    @ApiModelProperty(value="图片路径")
    private String picturePath;

    /**
    * 图片介绍
    */
    @ApiModelProperty(value="图片介绍")
    private String pictureIntroduction;

    /**
    * 交通信息
    */
    @ApiModelProperty(value="交通信息")
    private String trafficInformation;

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