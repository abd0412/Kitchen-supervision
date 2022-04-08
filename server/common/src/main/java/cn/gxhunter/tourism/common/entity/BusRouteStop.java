package cn.gxhunter.tourism.common.entity;

import cn.gxhunter.tourism.common.util.DateToLongSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 路线站点表
 */
@ApiModel(value = "cn-gxhunter-tourism-common-entity-BusRouteStop")
@Data
public class BusRouteStop implements Serializable {

    /**
     * id
     */
    @ApiModelProperty(value = "id")
    private Integer id;

    /**
     * 路线id
     */
    @ApiModelProperty(value = "路线id")
    private Integer routeId;

    /**
     * 站点id
     */
    @ApiModelProperty(value = "站点id")
    private Integer stopId;

    /**
     * 路线站点顺序
     */
    @ApiModelProperty(value = "路线站点顺序")
    private Integer order;

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

    /**
     * 路线名称
     */
    @ApiModelProperty(value = "路线名称")
    private String routeName;

    /**
     * 站点名称
     */
    @ApiModelProperty(value = "站点名称")
    private String stopName;

    private static final long serialVersionUID = 1L;
}