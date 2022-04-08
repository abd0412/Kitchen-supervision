package cn.gxhunter.tourism.common.entity.custom;

import cn.gxhunter.tourism.common.entity.HealthItem;
import cn.gxhunter.tourism.common.entity.HealthSubItem;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @Description 康养项目表包装类
 * @Author BinXiang
 * @Date 2020/9/14 15:43
 **/
@ApiModel(value = "cn-gxhunter-tourism-common-entity-custom-HealthItemCustom")
@Data
public class HealthItemCustom extends HealthItem {

    /**
     * 康养子分类名称
     */
    @ApiModelProperty(value="康养子分类名称")
    private String healthSubCategoryName;

    /**
     * 子模块列表
     */
    @ApiModelProperty(value="子模块")
    private List<HealthSubItem> healthSubItems;
}
