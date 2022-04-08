package cn.guet.kitchen.controller;

import cn.guet.kitchen.service.MaintenanceStaffService;
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
 * @DATE: 2021/4/2
 **/
@RestController
@Slf4j
public class MaintenanceStaffController {
    @Resource
    private MaintenanceStaffService maintenanceStaffService;

    /**
     * @api {post} /add/maintenance/staff 创建维保公司员工信息
     * @apiVersion 0.0.1
     * @apiDescription  基础数据之生成维保公司员工信息的接口。
     * @apiGroup Basic data-维保员工
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
     *     "id": 111105,
     *     "name": "你好公司员工5号",
     *     "age": 30,
     *     "sex": "男",
     *     "phone": "15768042390",
     *     "companyId": 1,
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
     *         "id": 111105,
     *         "name": "你好公司员工5号",
     *         "age": 30,
     *         "sex": "男",
     *         "phone": "15768042390",
     *         "companyId": 1,
     *         "cardNum": "410823198607126060",
     *         "update": "2021-04-05 21:29:57",
     *         "cleaningNum": null
     *     }
     * }
     *
     * @apiErrorExample {json} 返回失败样例：
     * {
     * 	"Code": 2003,
     * 	"Message": "生成数据失败"
     * }
     */
    @PostMapping("add/maintenance/staff")
    public CommonResult addMaintenanceStaff(@RequestBody String json) throws Exception {
        return maintenanceStaffService.insertSelective(json);
    }

    /**
     * @api {post} /delete/maintenance/staff 删除维保公司员工信息
     * @apiVersion 0.0.1
     * @apiDescription  基础数据之删除维保公司员工信息的接口。
     * @apiGroup Basic data-维保员工
     *
     * @apiParam(入参) {int} id 维保公司员工工号ID（唯一识别）
     * @apiParamExample {json} 入参样例：
     * {
     *     "id": 111105
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
    @ApiOperation("删除维保公司员工信息")
    @PostMapping("/delete/maintenance/staff")
    public CommonResult deleteMaintenanceStaff(@RequestBody String json) throws Exception {
        System.out.println("deleteMaintenanceStaffJson==>"+json);
        return maintenanceStaffService.deleteByPrimaryKey(json);
    }

    /**
     * @api {post} /update/maintenance/staff 更新维保公司员工信息
     * @apiVersion 0.0.1
     * @apiDescription  基础数据之更新维保公司员工信息的接口。
     * @apiGroup Basic data-维保员工
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
     *     "id": 111105,
     *     "name": "你好公司员工5号！！",
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
     *         "id": 111105,
     *         "name": "你好公司员工5号！！",
     *         "age": 30,
     *         "sex": "男",
     *         "phone": "15768042390",
     *         "companyId": 1,
     *         "cardNum": "410823198607126060",
     *         "update": "2021-04-06 22:33:18",
     *         "ifLeave": null,
     *         "dispatchNum": null,
     *         "leaveStartTime": null,
     *         "leaveEndTime": null,
     *         "idDeleted": null
     *     }
     * }
     *
     * @apiErrorExample {json} 返回失败样例：
     * {
     * 	"Code": 2003,
     * 	"Message": "更新失败"
     * }
     */
    @PostMapping("update/maintenance/staff")
    public CommonResult updateMaintenanceStaff(@RequestBody String json) throws Exception {
        return maintenanceStaffService.updateByPrimaryKey(json);
    }

    /**
     * @api {post} /select/maintenance/staff 查询维保公司员工信息
     * @apiVersion 0.0.1
     * @apiDescription  基础数据之查询维保公司员工信息的接口。
     * @apiGroup Basic data-维保员工
     *
     * @apiParam(入参) {int} id 员工工号（唯一识别），或：此值为空查询所有员工
     * @apiParamExample {json} 入参样例：
     * {
     *     "id": 111105
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
     *         "id": 111105,
     *         "name": "你好公司员工5号",
     *         "age": 30,
     *         "sex": "男",
     *         "phone": "15768042390",
     *         "companyId": 1,
     *         "cardNum": "410823198607126060",
     *         "update": "2021-04-05 21:29:57.0",
     *         "ifLeave": false,
     *         "dispatchNum": 0,
     *         "leaveStartTime": null,
     *         "leaveEndTime": null
     *     }
     * }
     *
     * @apiErrorExample {json} 返回失败样例：
     * {
     * 	"Code": 2001,
     * 	"Message": "数据库执行有异常"
     * }
     */
    @PostMapping("select/maintenance/staff")
    public CommonResult selectMaintenanceStaff(@RequestBody String json) throws Exception {
        System.out.println("selectMaintenanceStaffJson==>"+json);
        return maintenanceStaffService.selectByPrimaryKey(json);
    }

}
