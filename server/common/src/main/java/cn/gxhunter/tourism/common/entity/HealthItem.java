package cn.gxhunter.tourism.common.entity;

import cn.gxhunter.tourism.common.util.DateToLongSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
    * 康养项目表
    */
@ApiModel(value="cn-gxhunter-tourism-common-entity-HealthItem")
@Data
public class HealthItem implements Serializable {
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
    * 康养子分类编号
    */
    @ApiModelProperty(value="康养子分类编号")
    private String healthSubCategoryCode;

    /**
    * 推荐图片路径
    */
    @ApiModelProperty(value="推荐图片路径")
    private String recommendedPicturePath;

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
    * 音频路径
    */
    @ApiModelProperty(value="音频路径")
    private String audioPath;

    /**
    * 相关人物
    */
    @ApiModelProperty(value="相关人物")
    private String relevantPerson;

    /**
    * 相关人物介绍
    */
    @ApiModelProperty(value="相关人物介绍")
    private String relevantPersonIntroduction;

    /**
    * 逻辑删除,0:未删除,1:已删除,默认:0
    */
    @ApiModelProperty(value="逻辑删除,0:未删除,1:已删除,默认:0")
    private Boolean isDeleted;

    /**
    * 创建时间
    */
    @JsonSerialize(using = DateToLongSerializer.class)
    @ApiModelProperty(value="创建时间")
    private Date createTime;

    /**
    * 编辑时间
    */
    @JsonSerialize(using = DateToLongSerializer.class)
    @ApiModelProperty(value="编辑时间")
    private Date editTime;

    private static final long serialVersionUID = 1L;
}