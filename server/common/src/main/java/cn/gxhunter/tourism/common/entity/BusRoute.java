package cn.gxhunter.tourism.common.entity;

import cn.gxhunter.tourism.common.util.DateToLongSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 公交路线表
 */
@ApiModel(value = "cn-gxhunter-tourism-common-entity-BusRoute")
@Data
public class BusRoute implements Serializable {
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
     * 首班时间
     */
    @ApiModelProperty(value = "首班时间")
    @JsonSerialize(using = DateToLongSerializer.class)
    private Date firstBusTime;

    /**
     * 末班时间
     */
    @ApiModelProperty(value = "末班时间")
    @JsonSerialize(using = DateToLongSerializer.class)
    private Date lastBusTime;

    /**
     * 起始站
     */
    @ApiModelProperty(value = "起始站")
    private Integer startPointId;

    /**
     * 终点站
     */
    @ApiModelProperty(value = "终点站")
    private Integer finishPointId;

    /**
     * 价格（根据路程收取对应的费用，以文字形式描述）
     */
    @ApiModelProperty(value = "价格（根据路程收取对应的费用，以文字形式描述）")
    private String price;

    /**
     * 间隔时间（多久一趟）
     */
    @ApiModelProperty(value = "间隔时间（多久一趟）")
    private String intervalTime;

    /**
     * 逻辑删除(0:已删除,1:未删除.默认为0)
     */
    @ApiModelProperty(value = "逻辑删除(0:已删除,1:未删除.默认为0)")
    private Boolean isDeleted;

    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间")
    @JsonSerialize(using = DateToLongSerializer.class)
    private Date createTime;

    /**
     * 编辑时间
     */
    @ApiModelProperty(value = "编辑时间")
    @JsonSerialize(using = DateToLongSerializer.class)
    private Date editTime;

    /**
     * 公交站点列表Str
     */
    @ApiModelProperty(hidden = true)
    private String busStopListStr;

    /**
     * 公交站点列表
     */
    @ApiModelProperty(value = "公交站点列表")
    private List<BusStop> busStopList;

    /**
     * 起始站名称
     */
    @ApiModelProperty(value = "起始站名称")
    private String startPointName;

    /**
     * 终点站名称
     */
    @ApiModelProperty(value = "终点站名称")
    private String finishPointName;

    private static final long serialVersionUID = 1L;
}