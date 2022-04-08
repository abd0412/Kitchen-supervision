package cn.guet.kitchen.controller;

import cn.guet.kitchen.service.OperationStaffService;
import cn.guet.kitchen.entity.CommonResult;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @introduce:
 * @author: cyan
 * @DATE: 2021/4/9
 **/
@RestController
@Slf4j
public class OperationStaffController {
    @Resource
    private OperationStaffService operationStaffService;

    /**
     * @api {post} /add/operation/staff 创建运维公司员工信息
     * @apiVersion 0.0.1
     * @apiDescription  基础数据之生成运维公司员工信息的接口。
     * @apiGroup Basic data-运维员工
     *
     * @apiParam(入参) {int} id 员工工号（唯一识别，必填）
     * @apiParam(入参) {String} name 员工姓名
     * @apiParam(入参) {int} age 年龄
     * @apiParam(入参) {String} sex 性别
     * @apiParam(入参) {String} phone 联系电话
     * @apiParam(入参) {int} companyId 公司ID
     * @apiParam(入参) {String} cardNum 身份证号
     * @apiParamExample {json} 入参样例：
     * {
     *     "id": 67910,
     *     "name": "大运维公司员工3号",
     *     "age": 31,
     *     "sex": "女",
     *     "phone": "15768042390",
     *     "companyId": 2,
     *     "cardNum": "410823198607126060"
     * }
     * @apiSuccess(出参) {int} Code 接口返回编码：200-成功；2003-生成数据失败；
     * @apiSuccess(出参) {String} Message 消息描述
     *
     * @apiSuccessExample {json} 返回成功样例：
     * {
     *     "code": 200,
     *     "message": "创建成功",
     *     "data": {
     *         "id": 67910,
     *         "name": "大运维公司员工3号",
     *         "age": 31,
     *         "sex": "女",
     *         "phone": "15768042390",
     *         "companyId": 2,
     *         "cardNum": "410823198607126060",
     *         "update": "2021-04-09 22:51:52.0",
     *         "ifLeave": false,
     *         "dispatchNum": 0,
     *         "leaveStartTime": null,
     *         "leaveEndTime": null,
     *         "idDeleted": false
     *     }
     * }
     *
     * @apiErrorExample {json} 返回失败样例：
     * {
     * 	"Code": 2003,
     * 	"Message": "生成数据失败"
     * }
     */
    @PostMapping("add/operation/staff")
    public CommonResult addOperationStaff(@RequestBody String json) throws Exception {
        return operationStaffService.insertSelective(json);
    }

    /**
     * @api {post} /delete/operation/staff 删除运维公司员工信息
     * @apiVersion 0.0.1
     * @apiDescription  基础数据之删除运维公司员工信息的接口。
     * @apiGroup Basic data-运维员工
     *
     * @apiParam(入参) {int} id 运维公司员工工号ID（唯一识别）
     * @apiParamExample {json} 入参样例：
     * {
     *     "id": 57986
     * }
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
     * 	   "Message": "数据库执行有异常"
     * }
     */
    @ApiOperation("删除运维公司员工信息")
    @PostMapping("/delete/operation/staff")
    public CommonResult deleteOperationStaff(@RequestBody String json) throws Exception {
        System.out.println("deleteOperationStaffJson==>"+json);
        return operationStaffService.deleteByPrimaryKey(json);
    }

    /**
     * @api {post} /update/operation/staff 更新运维公司员工信息
     * @apiVersion 0.0.1
     * @apiDescription  基础数据之更新运维公司员工信息的接口。
     * @apiGroup Basic data-运维员工
     *
     * @apiParam(入参) {int} id 员工工号（唯一识别，必填）
     * @apiParam(入参) {String} name 员工姓名
     * @apiParam(入参) {int} age 年龄
     * @apiParam(入参) {String} sex 性别
     * @apiParam(入参) {String} phone 联系电话
     * @apiParam(入参) {int} companyId 公司ID
     * @apiParam(入参) {String} cardNum 身份证号
     * @apiParamExample {json} 入参样例：
     * {
     *     "id": 57986,
     *     "name": "大运维公司员工1号！！",
     *     "age": 30,
     *     "sex": "男",
     *     "phone": "15768042390",
     *     "companyId": 1,
     *     "cardNum": "410823198607126060"
     * }
     * @apiSuccess(出参) {int} Code 接口返回编码：200-更新成功；2003-更新失败；
     * @apiSuccess(出参) {String} Message 消息描述
     *
     * @apiSuccessExample {json} 返回成功样例：
     * {
     *     "code": 200,
     *     "message": "更新成功",
     *     "data": {
     *         "id": 57986,
     *         "name": "大运维公司员工1号！！",
     *         "age": 30,
     *         "sex": "男",
     *         "phone": "15768042390",
     *         "companyId": 1,
     *         "cardNum": "410823198607126060",
     *         "update": "2021-04-09 23:15:42.0",
     *         "ifLeave": false,
     *         "dispatchNum": 0,
     *         "leaveStartTime": null,
     *         "leaveEndTime": null,
     *         "idDeleted": false
     *     }
     * }
     *
     * @apiErrorExample {json} 返回失败样例：
     * {
     * 	"Code": 2003,
     * 	"Message": "更新失败"
     * }
     */
    @PostMapping("update/operation/staff")
    public CommonResult updateOperationStaff(@RequestBody String json) throws Exception {
        return operationStaffService.updateByPrimaryKey(json);
    }

    /**
     * @api {post} /select/operation/staff 查询运维公司员工信息
     * @apiVersion 0.0.1
     * @apiDescription  基础数据之查询运维公司员工信息的接口。
     * @apiGroup Basic data-运维员工
     *
     * @apiParam(入参) {int} id 员工工号（唯一识别），或：此值为空查询所有员工
     * @apiParamExample {json} 入参样例：
     * {
     *     "id": 57986
     * }
     * @apiSuccess(出参) {int} Code 接口返回编码：200-查询成功；2001-数据库执行有异常；
     * @apiSuccess(出参) {String} Message 消息描述
     * @apiSuccess(出参) {boolean} ifLeave 是否请假（false：没有  true：请假）
     *
     * @apiSuccessExample {json} 返回成功样例：
     * {
     *     "code": 200,
     *     "message": "查询成功",
     *     "data": {
     *         "ostaffList": [
     *             {
     *                 "id": 57986,
     *                 "name": "大运维公司员工1号！！",
     *                 "age": 30,
     *                 "sex": "男",
     *                 "phone": "15768042390",
     *                 "companyId": 1,
     *                 "cardNum": "410823198607126060",
     *                 "update": "2021-04-09 23:15:42.0",
     *                 "ifLeave": false,
     *                 "dispatchNum": 0,
     *                 "leaveStartTime": null,
     *                 "leaveEndTime": null,
     *                 "idDeleted": false
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
    @PostMapping("select/operation/staff")
    public CommonResult selectOperationStaff(@RequestBody String json) throws Exception {
        System.out.println("selectOperationStaffJson==>"+json);
        return operationStaffService.selectByPrimaryKey(json);
    }
}
