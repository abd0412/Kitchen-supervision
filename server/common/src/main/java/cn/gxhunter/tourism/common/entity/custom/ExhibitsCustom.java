package cn.gxhunter.tourism.common.entity.custom;

import cn.gxhunter.tourism.common.entity.Exhibits;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Description 展品包装类
 * @Author BinXiang
 * @Date 2020/7/22 14:02
 **/
@ApiModel(value = "cn-gxhunter-tourism-common-entity-custom-ExhibitsCustom")
@Data
public class ExhibitsCustom extends Exhibits {
    /**
     * 所属景点名称
     */
    @ApiModelProperty(value = "所属景点名称")
    private String scenicSpotName;
}
