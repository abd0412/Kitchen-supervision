package cn.gxhunter.tourism.common.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @Description
 * @Author BinXiang
 * @Date 2020-03-13 15:03
 **/
@ApiModel(value = "cn.gxhunter.ams.common.entity.TreeInfo")
@Data
public class TreeInfo implements Serializable {

    @ApiModelProperty(value = "id或code")
    private String value;

    @ApiModelProperty(value = "name名称")
    private String label;

    @ApiModelProperty(value = "子列表")
    private List<TreeInfo> children;

    private static final long serialVersionUID = 1L;
}
