package cn.guet.kitchen.controller;

import cn.guet.kitchen.service.MaintenanceCompanyService;
import cn.guet.kitchen.entity.CommonResult;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @introduce:
 * @author: cyan
 * @DATE: 2021/4/1
 **/
@RestController
@Slf4j
public class MaintenanceCompanyController {
    @Resource
    private MaintenanceCompanyService maintenanceCompanyService;

    /**
     * @api {post} /add/maintenance/company 创建维保公司信息
     * @apiVersion 0.0.1
     * @apiDescription  基础数据之生成维保公司信息的接口。
     * @apiGroup Basic data-维保公司
     *
     * @apiParam(入参) {String} companyName 公司名称
     * @apiParam(入参) {String} businessLicense 营业执照
     * @apiParam(入参) {String} legalRepresentative 法人代表
     * @apiParam(入参) {String} phone 联系电话
     * @apiParam(入参) {String} address 地址
     * @apiParam(入参) {String} lngAndLat 经纬度
     * @apiParam(入参) {String} level 等级
     * @apiParam(入参) {String} adminCode 行政区域编码
     * @apiParamExample {json} 入参样例：
     * {
     *     "companyName": "你好公司",
     *     "businessLicense": "124359806",
     *     "legalRepresentative": "张三",
     *     "phone": "18630992356",
     *     "address": "广东省广州市",
     *     "lngAndLat": "(113.23, 23.16)",
     *     "level": "第一等级",
     *     "adminCode": "440100"
     * }
     *
     * @apiSuccess(出参) {int} Code 接口返回编码：200-创建成功；2003-生成数据失败；
     * @apiSuccess(出参) {String} Message 消息描述
     * @apiSuccess(出参) {int} maintenanceCompanyId 维保公司ID（唯一识别）
     *
     * @apiSuccessExample {json} 返回成功样例：
     * {
     *     "code": 200,
     *     "message": "创建成功",
     *     "data": {
     *         "maintenanceCompanyId": 3,
     *         "companyCode": null,
     *         "companyName": "你好公司",
     *         "businessLicense": "124359806",
     *         "legalRepresentative": "张三",
     *         "phone": "18630992356",
     *         "address": "广东省广州市",
     *         "lngandlat": "(113.23, 23.16)",
     *         "level": "第一等级",
     *         "insertTime": null,
     *         "updateTime": "2021-04-05 20:31:20",
     *         "idDeleted": null,
     *         "isRecommend": null,
     *         "memberId": null,
     *         "adminCode": "440100",
     *         "dispatchNum": null
     *     }
     * }
     *
     * @apiErrorExample {json} 返回失败样例：
     * {
     * 	"Code": 2003,
     * 	"Message": "生成数据失败"
     * }
     */
    @PostMapping("add/maintenance/company")
    public CommonResult addMaintenanceCompany(@RequestBody String json) throws Exception {
        return maintenanceCompanyService.insertSelective(json);
    }

    /**
     * @api {get} /delete/maintenance/company?maintenanceCompanyId=1 删除维保公司信息
     * @apiVersion 0.0.1
     * @apiDescription  基础数据之删除维保公司信息的接口。
     * @apiGroup Basic data-维保公司
     *
     * @apiParam(入参) {int} maintenanceCompanyId 维保公司ID（唯一识别）
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
    @ApiOperation("删除维保公司信息")
    @GetMapping("/delete/maintenance/company")
    public CommonResult deleteMaintenanceCompany(@RequestParam int maintenanceCompanyId) throws Exception {
        System.out.println("deleteMaintenanceCompany==>"+maintenanceCompanyId);
        return maintenanceCompanyService.deleteByPrimaryKey(maintenanceCompanyId);
    }

    /**
     * @api {post} /update/maintenance/company 更新维保公司信息
     * @apiVersion 0.0.1
     * @apiDescription  基础数据之更新维保公司信息的接口。
     * @apiGroup Basic data-维保公司
     *
     * @apiParam(入参) {int} maintenanceCompanyId 维保公司ID（唯一识别，必填）
     * @apiParam(入参) {String} companyName 公司名称
     * @apiParam(入参) {String} businessLicense 营业执照
     * @apiParam(入参) {String} legalRepresentative 法人代表
     * @apiParam(入参) {String} phone 联系电话
     * @apiParam(入参) {String} address 地址
     * @apiParam(入参) {String} lngAndLat 经纬度
     * @apiParam(入参) {String} level 等级
     * @apiParam(入参) {String} adminCode 行政区域编码
     * @apiParamExample {json} 入参样例：
     * {
     *     "maintenanceCompanyId": 3,
     *     "companyName": "你好公司啊",
     *     "businessLicense": "124359806",
     *     "legalRepresentative": "张三",
     *     "phone": "18630992356",
     *     "address": "广东省广州市",
     *     "lngAndLat": "(113.23, 23.16)",
     *     "level": "第一等级",
     *     "adminCode": "440100"
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
     *         "maintenanceCompanyId": 3,
     *         "companyCode": null,
     *         "companyName": "你好公司啊",
     *         "businessLicense": "124359806",
     *         "legalRepresentative": "张三",
     *         "phone": "18630992356",
     *         "address": "广东省广州市",
     *         "lngandlat": "(113.23, 23.16)",
     *         "level": "第一等级",
     *         "insertTime": null,
     *         "updateTime": "2021-04-06 22:27:16",
     *         "idDeleted": null,
     *         "isRecommend": null,
     *         "memberId": null,
     *         "adminCode": "440100",
     *         "dispatchNum": null
     *     }
     * }
     *
     * @apiErrorExample {json} 返回失败样例：
     * {
     * 	"Code": 2003,
     * 	"Message": "更新失败",
     * 	"data": null
     * }
     */
    @PostMapping("update/maintenance/company")
    public CommonResult updateMaintenanceCompany(@RequestBody String json) throws Exception {
        return maintenanceCompanyService.updateByPrimaryKey(json);
    }

    /**
     * @api {get} /select/maintenance/company?maintenanceCompanyId=3 查询维保公司信息
     * @apiVersion 0.0.1
     * @apiDescription  基础数据之查询维保公司信息的接口。
     * @apiGroup Basic data-维保公司
     *
     * @apiParam(入参) {int} maintenanceCompanyId 维保公司ID（唯一识别）
     *
     * @apiSuccess(出参) {int} Code 接口返回编码：200-查询成功；2001-数据库执行有异常；
     * @apiSuccess(出参) {String} Message 消息描述
     *
     * @apiSuccessExample {json} 返回成功样例：
     * {
     *     "code": 200,
     *     "message": "查询成功",
     *     "data": {
     *         "maintenanceCompanyId": 3,
     *         "companyCode": null,
     *         "companyName": "你好公司",
     *         "businessLicense": "124359806",
     *         "legalRepresentative": "张三",
     *         "phone": "18630992356",
     *         "address": "广东省广州市",
     *         "lngandlat": "(113.23, 23.16)",
     *         "level": "第一等级",
     *         "insertTime": null,
     *         "updateTime": "2021-04-05 20:31:20.0",
     *         "idDeleted": null,
     *         "isRecommend": null,
     *         "memberId": null,
     *         "adminCode": "440100",
     *         "dispatchNum": 0
     *     }
     * }
     *
     * @apiErrorExample {json} 返回失败样例：
     * {
     * 	"Code": 2001,
     * 	"Message": "数据库执行有异常"
     * }
     */
    @GetMapping("select/maintenance/company")
    public CommonResult selectMaintenanceCompany(@RequestParam int maintenanceCompanyId) throws Exception {
        System.out.println("selectMaintenanceCompany==>"+maintenanceCompanyId);
        return maintenanceCompanyService.selectByPrimaryKey(maintenanceCompanyId);
    }
}
