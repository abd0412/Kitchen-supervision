package cn.guet.kitchen.controller;

import cn.guet.kitchen.service.OperationCompanyService;
import cn.guet.kitchen.entity.CommonResult;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @introduce:
 * @author: cyan
 * @DATE: 2021/4/5
 **/
@RestController
@Slf4j
public class OperationCompanyController {
    @Resource
    private OperationCompanyService operationCompanyService;

    /**
     * @api {post} /add/operation/company 创建运维公司信息
     * @apiVersion 0.0.1
     * @apiDescription  基础数据之生成运维公司信息的接口。
     * @apiGroup Basic data-运维公司
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
     *     "companyName": "运维公司",
     *     "businessLicense": "124359806",
     *     "legalRepresentative": "周",
     *     "phone": "18630992356",
     *     "address": "广西桂林",
     *     "lngAndLat": "(113.23, 23.16)",
     *     "level": "第一等级",
     *     "adminCode": "440100"
     * }
     *
     * @apiSuccess(出参) {int} Code 接口返回编码：200-创建成功；2003-生成数据失败；
     * @apiSuccess(出参) {String} Message 消息描述
     * @apiSuccess(出参) {int} operationCompanyId 运维公司Id（唯一识别）
     *
     * @apiSuccessExample {json} 返回成功样例：
     * {
     *     "code": 200,
     *     "message": "创建成功",
     *     "data": {
     *         "operationCompanyId": 1,
     *         "companyCode": null,
     *         "companyName": "运维公司",
     *         "businessLicense": "124359806",
     *         "legalRepresentative": "周",
     *         "phone": "18630992356",
     *         "address": "广西桂林",
     *         "lngandlat": "(113.23, 23.16)",
     *         "level": "第一等级",
     *         "insertTime": null,
     *         "updateTime": "2021-04-05 20:55:38",
     *         "idDeleted": null,
     *         "isRecommend": null,
     *         "adminCode": "440100"
     *     }
     * }
     *
     * @apiErrorExample {json} 返回失败样例：
     * {
     * 	"Code": 2003,
     * 	"Message": "生成数据失败"
     * }
     */
    @PostMapping("add/operation/company")
    public CommonResult addOperationCompany(@RequestBody String json) throws Exception {
        return operationCompanyService.insertSelective(json);
    }

    /**
     * @api {get} /delete/operation/company?operationCompanyId=1 删除运维公司信息
     * @apiVersion 0.0.1
     * @apiDescription  基础数据之删除运维公司信息的接口。
     * @apiGroup Basic data-运维公司
     *
     * @apiParam(入参) {int} operationCompanyId 运维公司ID（唯一识别）
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
    @ApiOperation("删除运维公司信息")
    @GetMapping("/delete/operation/company")
    public CommonResult deleteOperationCompany(@RequestParam int operationCompanyId) throws Exception {
        System.out.println("deleteOperationCompany==>"+operationCompanyId);
        return operationCompanyService.deleteByPrimaryKey(operationCompanyId);
    }

    /**
     * @api {post} /update/operation/company 更新运维公司信息
     * @apiVersion 0.0.1
     * @apiDescription  基础数据之更新运维公司信息的接口。
     * @apiGroup Basic data-运维公司
     * @apiParam(入参) {int} operationCompanyId 运维公司ID（唯一识别）
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
     *     "operationCompanyId": 1,
     *     "companyName": "运维公司！！",
     *     "businessLicense": "124359806",
     *     "legalRepresentative": "周",
     *     "phone": "18630992356",
     *     "address": "广西桂林",
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
     *         "operationCompanyId": 1,
     *         "companyCode": null,
     *         "companyName": "运维公司！！",
     *         "businessLicense": "124359806",
     *         "legalRepresentative": "周",
     *         "phone": "18630992356",
     *         "address": "广西桂林",
     *         "lngandlat": "(113.23, 23.16)",
     *         "level": "第一等级",
     *         "insertTime": null,
     *         "updateTime": "2021-04-06 22:35:16",
     *         "idDeleted": null,
     *         "isRecommend": null,
     *         "adminCode": "440100"
     *     }
     * }
     *
     * @apiErrorExample {json} 返回失败样例：
     * {
     * 	"Code": 2003,
     * 	"Message": "更新失败"
     * }
     */
    @PostMapping("update/operation/company")
    public CommonResult updateOperationCompany(@RequestBody String json) throws Exception {
        return operationCompanyService.updateByPrimaryKey(json);
    }

    /**
     * @api {get} /select/operation/company?operationCompanyId=1 查询单/多个运维公司信息
     * @apiVersion 0.0.1
     * @apiDescription  基础数据之查询运维公司信息的接口，若查询所有运维公司信息不传值即可，即 /select/operation/company?operationCompanyId=
     * @apiGroup Basic data-运维公司
     *
     * @apiParam(入参) {int} operationCompanyId 运维公司ID

     *
     * @apiSuccess(出参) {int} Code 接口返回编码：200-创建成功；2001-数据库执行有异常；
     * @apiSuccess(出参) {String} Message 消息描述
     * @apiSuccess(出参) {array} operationCompanies 运维公司数组
     *
     * @apiSuccessExample {json} 返回成功样例：
     * {
     *     "code": 200,
     *     "message": "查询成功",
     *     "data": {
     *         "operationCompanies": [
     *             {
     *                 "operationCompanyId": 1,
     *                 "companyCode": "ss",
     *                 "companyName": "运维1",
     *                 "businessLicense": "",
     *                 "legalRepresentative": "",
     *                 "phone": "",
     *                 "address": "",
     *                 "lngandlat": "110.306176,25.285181",
     *                 "level": "",
     *                 "insertTime": "2021-06-20 17:01:07.0",
     *                 "updateTime": null,
     *                 "isDeleted": false,
     *                 "isRecommend": false,
     *                 "adminCode": "450000,450300,450305",
     *                 "dispatchNum": null
     *             },
     *             {
     *                 "operationCompanyId": 2,
     *                 "companyCode": "tt",
     *                 "companyName": "ww",
     *                 "businessLicense": "asd",
     *                 "legalRepresentative": "s",
     *                 "phone": "15875465254",
     *                 "address": "ad",
     *                 "lngandlat": "110.306176,25.285181",
     *                 "level": "2",
     *                 "insertTime": "2021-06-20 17:01:11.0",
     *                 "updateTime": null,
     *                 "isDeleted": false,
     *                 "isRecommend": false,
     *                 "adminCode": "sad",
     *                 "dispatchNum": null
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
    @GetMapping("select/operation/company")
    public CommonResult selectOperationCompany(@RequestParam Integer operationCompanyId) throws Exception {
        System.out.println("selectOperationCompany==>"+operationCompanyId);
        return operationCompanyService.selectByPrimaryKey(operationCompanyId);
    }

}
