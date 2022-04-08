package cn.guet.kitchen.controller;

import cn.guet.kitchen.service.FoodCompanyService;
import cn.guet.kitchen.entity.CommonResult;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @introduce:
 * @author: cyan
 * @DATE: 2021/4/2
 **/
@RestController
@Slf4j
public class FoodCompanyController {
    @Resource
    private FoodCompanyService foodCompanyService;

    /**
     * @api {post} /add/food/company 创建餐饮企业信息
     * @apiVersion 0.0.1
     * @apiDescription  基础数据之生成餐饮企业信息的接口。
     * @apiGroup Basic data-餐饮企业
     *
     * @apiParam(入参) {String} companyName 餐饮企业名称
     * @apiParam(入参) {String} businessLicense 营业执照
     * @apiParam(入参) {String} legalRepresentative 法人代表
     * @apiParam(入参) {String} phone 联系电话
     * @apiParam(入参) {String} address 地址
     * @apiParam(入参) {String} lngAndLat 经纬度
     * @apiParam(入参) {String} level 等级
     * @apiParam(入参) {String} adminCode 行政区域编码
     * @apiParamExample {json} 入参样例：
     * {
     *     "companyName": "好想来餐饮",
     *     "businessLicense": "12435980622",
     *     "legalRepresentative": "赵",
     *     "phone": "18630992352",
     *     "address": "广东省汕头市",
     *     "lngAndLat": "(113.23, 23.16)",
     *     "level": "第一等级",
     *     "adminCode": "440101"
     * }
     *
     * @apiSuccess(出参) {int} Code 接口返回编码：200-成功；2003-生成数据失败；
     * @apiSuccess(出参) {String} Message 消息描述
     * @apiSuccess(出参) {int} companyId 餐饮企业公司ID（唯一识别）
     *
     * @apiSuccessExample {json} 返回成功样例：
     * {
     *     "code": 200,
     *     "message": "创建成功",
     *     "data": {
     *         "companyId": 4,
     *         "memberId": null,
     *         "companyCode": null,
     *         "companyName": "好想来餐饮",
     *         "businessLicense": "12435980622",
     *         "legalRepresentative": "赵",
     *         "phone": "18630992352",
     *         "address": "广东省汕头市",
     *         "lngandlat": "(113.23, 23.16)",
     *         "isDeleted": null,
     *         "insertTime": null,
     *         "updateTime": "2021-04-05 19:54:27",
     *         "level": "第一等级",
     *         "isRecommend": null,
     *         "adminCode": "440101",
     *         "currentMaintenceBatch": null
     *     }
     * }
     *
     * @apiErrorExample {json} 返回失败样例：
     * {
     * 	"Code": 2003,
     * 	"Message": "生成数据失败"
     * }
     */
    @PostMapping("/add/food/company")
    public CommonResult addFoodCompany(@RequestBody String json) throws Exception {
        return foodCompanyService.insertSelective(json);
    }

    /**
     * @api {post} /delete/food/company?companyId=1 删除餐饮企业信息
     * @apiVersion 0.0.1
     * @apiDescription  基础数据之删除餐饮企业信息的接口。
     * @apiGroup Basic data-餐饮企业
     *
     * @apiParam(入参) {int} companyId 餐饮企业ID（唯一识别）
     *
     * @apiSuccess(出参) {String} Code 接口返回编码；200-删除成功；1201-请求条件中，缺少ID参数；2001-数据库执行有异常；
     * @apiSuccess(出参) {String} Message 消息描述
     *
     * @apiSuccessExample {json} 返回成功样例：
     * {
     *     "code": 200,
     *     "message": "删除成功",
     *     "data": null
     * }
     *
     * @apiErrorExample {json} 返回失败样例：
     * {
     *     "Code": "2001",
     * 	   "Message": "数据库执行有异常",
     * 	   "data": null
     * }
     */
    @ApiOperation("删除餐饮企业信息")
    @GetMapping("/delete/food/company")
    public CommonResult deleteFoodCompany(@RequestParam int companyId) throws Exception {
        System.out.println("deleteFoodCompany==>"+companyId);
        return foodCompanyService.deleteByPrimaryKey(companyId);
    }

    /**
     * @api {post} /update/food/company 更新餐饮企业信息
     * @apiVersion 0.0.1
     * @apiDescription  基础数据之更新餐饮企业信息的接口。
     * @apiGroup Basic data-餐饮企业
     *
     * @apiParam(入参) {int} companyId 餐饮企业ID（唯一识别，必填）
     * @apiParam(入参) {String} companyName 餐饮企业名称
     * @apiParam(入参) {String} businessLicense 营业执照
     * @apiParam(入参) {String} legalRepresentative 法人代表
     * @apiParam(入参) {String} phone 联系电话
     * @apiParam(入参) {String} address 地址
     * @apiParam(入参) {String} lngAndLat 经纬度
     * @apiParam(入参) {String} level 等级
     * @apiParam(入参) {String} adminCode 行政区域编码
     * @apiParamExample {json} 入参样例：
     * {
     *     "companyId": 4,
     *     "companyName": "好想来餐饮吃饭",
     *     "businessLicense": "12435980622",
     *     "legalRepresentative": "赵",
     *     "phone": "18630992352",
     *     "address": "广东省汕头市",
     *     "lngAndLat": "(113.23, 23.16)",
     *     "level": "第一等级",
     *     "adminCode": "440101"
     * }
     *
     * @apiSuccess(出参) {int} Code 接口返回编码：200-更新成功；2003-更新失败；
     * @apiSuccess(出参) {String} Message 消息描述
     *
     * @apiSuccessExample {json} 返回成功样例：
     * {
     *     "code": 200,
     *     "message": "更新成功",
     *     "data": {
     *         "companyId": 4,
     *         "memberId": null,
     *         "companyCode": null,
     *         "companyName": "好想来餐饮吃饭",
     *         "businessLicense": "12435980622",
     *         "legalRepresentative": "赵",
     *         "phone": "18630992352",
     *         "address": "广东省汕头市",
     *         "lngandlat": "(113.23, 23.16)",
     *         "isDeleted": null,
     *         "insertTime": null,
     *         "updateTime": "2021-04-05 19:54:27",
     *         "level": "第一等级",
     *         "isRecommend": null,
     *         "adminCode": "440101",
     *         "currentMaintenceBatch": null
     *     }
     * }
     *
     * @apiErrorExample {json} 返回失败样例：
     * {
     * 	"Code": 2003,
     * 	"Message": "更新失败"
     * }
     */
    @PostMapping("/update/food/company")
    public CommonResult updateFoodCompany(@RequestBody String json) throws Exception {
        return foodCompanyService.updateByPrimaryKey(json);
    }

    /**
     * @api {get} /select/food/company?companyId=4 查询单/多个餐饮企业信息
     * @apiVersion 0.0.1
     * @apiDescription  基础数据之查询餐饮企业信息的接口，若查询所有餐饮企业不传值即可，即 /select/food/company?companyId=
     * @apiGroup Basic data-餐饮企业
     *
     * @apiParam(入参) {int} companyId 餐饮企业ID（唯一识别）
     *
     * @apiSuccess(出参) {int} Code 接口返回编码：200-查询成功；2001-数据库执行有异常；
     * @apiSuccess(出参) {String} Message 消息描述
     * @apiSuccess(出参) {array} foodCompanies 餐饮企业数组
     *
     * @apiSuccessExample {json} 返回成功样例：
     * {
     *     "code": 200,
     *     "message": "查询成功",
     *     "data": {
     *         "foodCompanies": [
     *             {
     *                 "companyId": 1,
     *                 "memberId": null,
     *                 "companyCode": "food1",
     *                 "companyName": "六三好食在·柴火妈妈饭",
     *                 "businessLicense": "",
     *                 "legalRepresentative": "李湘太",
     *                 "phone": "15078327874",
     *                 "address": "广西壮族自治区桂林市七星区空明西路27号",
     *                 "lngandlat": "110.262663,25.269412",
     *                 "isDeleted": false,
     *                 "insertTime": null,
     *                 "updateTime": "2021-07-10 20:18:32.0",
     *                 "level": "4",
     *                 "isRecommend": null,
     *                 "adminCode": "450000,450300,450305",
     *                 "currentMaintenceBatch": null
     *             }
     *         ]
     *     }
     * }
     *
     * @apiErrorExample {json} 返回失败样例：
     * {
     * 	"Code": 2001,
     * 	"Message": "数据库执行有异常"
     * }
     */
    @GetMapping("/select/food/company")
    public CommonResult selectFoodCompany(@RequestParam Integer companyId) throws Exception {
        System.out.println("selectFoodCompany==>"+companyId);
        return foodCompanyService.selectByPrimaryKey(companyId);
    }
}
