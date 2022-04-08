package cn.gxhunter.tourism.common.entity;

import cn.gxhunter.tourism.common.util.DateToLongSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 导游信息表
 */
@ApiModel(value = "cn-gxhunter-tourism-common-entity-TourGuide")
@Data
public class TourGuide implements Serializable {
    /**
     * id
     */
    @ApiModelProperty(value = "id")
    private Integer id;

    /**
     * 所属旅行社id
     */
    @ApiModelProperty(value = "所属旅行社id")
    private Integer travelAgencyId;

    /**
     * 导游证号
     */
    @ApiModelProperty(value = "导游证号")
    private String code;

    /**
     * 姓名
     */
    @ApiModelProperty(value = "姓名")
    private String name;

    /**
     * 性别（1：男；0：女）
     */
    @ApiModelProperty(value = "性别（1：男；0：女）")
    private Integer gender;

    /**
     * 年龄
     */
    @ApiModelProperty(value = "年龄")
    private Integer age;

    /**
     * 语种（1：普通话；2：外语）
     */
    @ApiModelProperty(value = "语种（1：普通话；2：外语）")
    private Integer language;

    /**
     * 个人荣誉
     */
    @ApiModelProperty(value = "个人荣誉")
    private String personalHonor;

    /**
     * 导游照片
     */
    @ApiModelProperty(value = "导游照片")
    private String photoPath;

    /**
     * qq联系方式
     */
    @ApiModelProperty(value = "qq联系方式")
    private String qq;

    /**
     * 微信联系方式
     */
    @ApiModelProperty(value = "微信联系方式")
    private String wechat;

    /**
     * 电话联系方式
     */
    @ApiModelProperty(value = "电话联系方式")
    private String telephone;

    /**
     * 等级（1：初级；2：中级；3：高级；4：特级）
     */
    @ApiModelProperty(value = "等级（1：初级；2：中级；3：高级；4：特级）")
    private Integer grade;

    /**
     * 评价星级（1：一星；2：二星；3：三星；4：四星；5：五星）
     */
    @ApiModelProperty(value = "评价星级（1：一星；2：二星；3：三星；4：四星；5：五星）")
    private Integer star;

    /**
     * 从业年限
     */
    @ApiModelProperty(value = "从业年限")
    private Integer workingLife;

    /**
     * 是否推荐
     */
    @ApiModelProperty(value = "是否推荐（0：未推荐，1：推荐，默认值：0）")
    private Boolean isRecommend;

    /**
     * 逻辑删除（0：未删除，1：删除，默认值：0）
     */
    @ApiModelProperty(value = "逻辑删除（0：未删除，1：删除，默认值：0）")
    private Boolean isDeleted;

    /**
     * 编辑时间
     */
    @JsonSerialize(using = DateToLongSerializer.class)
    @ApiModelProperty(value = "编辑时间")
    private Date editTime;

    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间")
    @JsonSerialize(using = DateToLongSerializer.class)
    private Date createTime;

    /**
     * 所属旅行社名称
     */
    @ApiModelProperty(value = "所属旅行社名称")
    private String travelAgencyName;

    private static final long serialVersionUID = 1L;
}