package cn.gxhunter.tourism.common.entity;

import cn.gxhunter.tourism.common.util.DateToLongSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 欢迎大屏_宣传广告
 */
@ApiModel(value = "cn-gxhunter-tourism-common-entity-WelcomeScreenBasicImage")
@Data
public class WelcomeScreenBasicImage implements Serializable {
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
     * 图片路径
     */
    @ApiModelProperty(value = "图片路径")
    private String imagePath;

    /**
     * 类型,1:标题图片,2:标题背景图片,3:主体背景图片
     */
    @ApiModelProperty(value = "类型,1:标题图片,2:标题背景图片,3:主体背景图片")
    private Integer type;

    /**
     * 是否启用,0:未启用,1:已启用(默认0:未启用)
     */
    @ApiModelProperty(value = "是否启用,0:未启用,1:已启用(默认0:未启用)")
    private Boolean isUsing;

    /**
     * 逻辑删除(0:未删除,1:已删除,默认:0)
     */
    @ApiModelProperty(value = "逻辑删除(0:未删除,1:已删除,默认:0)")
    private Boolean isDeleted;

    /**
     * 创建时间
     */
    @JsonSerialize(using = DateToLongSerializer.class)
    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    /**
     * 编辑时间
     */
    @JsonSerialize(using = DateToLongSerializer.class)
    @ApiModelProperty(value = "编辑时间")
    private Date editTime;

    private static final long serialVersionUID = 1L;
}