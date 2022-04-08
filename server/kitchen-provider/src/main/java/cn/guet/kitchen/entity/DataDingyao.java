package cn.guet.kitchen.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

@ApiModel(value="cn-guet-kitchen-entity-DataDingyao")
@Data
public class DataDingyao implements Serializable {
    /**
    * 
    */
    @ApiModelProperty(value="")
    private Integer id;

    /**
    * 
    */
    @ApiModelProperty(value="")
    private String imsi;

    /**
    * 
    */
    @ApiModelProperty(value="")
    private String lat;

    /**
    * 
    */
    @ApiModelProperty(value="")
    private String lng;

    /**
    * 
    */
    @ApiModelProperty(value="")
    private String times;

    /**
    * 
    */
    @ApiModelProperty(value="")
    private String angle;

    /**
    * 
    */
    @ApiModelProperty(value="")
    private String speed;

    /**
    * 
    */
    @ApiModelProperty(value="")
    private String vail;

    /**
    * 
    */
    @ApiModelProperty(value="")
    private String vail1;

    /**
    * 
    */
    @ApiModelProperty(value="")
    private Date insertTime;

    /**
    * 
    */
    @ApiModelProperty(value="")
    private Date updateTime;

    private static final long serialVersionUID = 1L;
}