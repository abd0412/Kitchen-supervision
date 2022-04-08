package cn.gxhunter.tourism.common.entity.custom;

import cn.gxhunter.tourism.common.entity.HealthSubCategory;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Description 康养子类别表包装类
 * @Author BinXiang
 * @Date 2020/9/14 15:41
 **/
@ApiModel(value = "cn-gxhunter-tourism-common-entity-custom-HealthSubCategoryCustom")
@Data
public class HealthSubCategoryCustom extends HealthSubCategory {
    /**
     * 所属康养类别名称
     */
    @ApiModelProperty(value="所属康养类别名称")
    private String healthCategoryName;
}
