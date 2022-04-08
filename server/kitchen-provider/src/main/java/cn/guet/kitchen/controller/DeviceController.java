package cn.guet.kitchen.controller;

import cn.guet.kitchen.service.DeviceService;
import cn.guet.kitchen.entity.CommonResult;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @introduce:
 * @author: cyan
 * @DATE: 2021/4/7
 **/
@RestController
@Slf4j
public class DeviceController {
    @Resource
    private DeviceService deviceService;

    /**
     * @api {post} /add/device 新增设备
     * @apiVersion 0.0.1
     * @apiDescription  运维端管理系统-餐饮企业-设备管理之新增设备接口说明。
     * @apiGroup operation-设备管理
     * @apiParam(入参) {String} deviceId 设备ID（唯一识别），手动填入，是设备出厂编号，必填。
     * @apiParam(入参) {int} companyId 所属餐饮企业ID，必填
     * @apiParam(入参) {int} manufacturerId 设备厂商ID，必填
     * @apiParam(入参) {int} gateId 监管设备ID，必填，增加删除修改相关信息均调用此接口，结果原样返回。(增删改查都已支持)
     * @apiParam(入参) {int} seqNum 监管设备的管道号，必填，增加删除修改相关信息均调用此接口，结果原样返回。(增删改查都已支持)
     * @apiParam(入参) {String} nearMaintanceTime 上次维保时间
     * @apiParam(入参) {String} maintenanceRound 维保周期
     * @apiParamExample {json} 入参样例：
     * {
     *     "seqNum": 5,
     *     "gateId": 1,
     *     "deviceId": "20210710",
     *     "companyId": 1,
     *     "manufacturerId": 1,
     *     "nearMaintanceTime": "2021-07-03 22:51:32",
     *     "maintenanceRound": "30"
     * }
     *
     * @apiSuccess(出参) {String} Code 接口返回编码；200-新增设备成功；1201-请求条件中，缺少必填参数；2001-数据库执行有异常；
     * @apiSuccess(出参) {String} Message 消息描述
     * @apiSuccess(出参) {String} deviceId 设备ID（唯一识别）
     * @apiSuccess(出参) {int} companyId 所属餐饮企业ID
     * @apiSuccess(出参) {int} manufacturerId 设备厂商ID
     * @apiSuccess(出参) {String} insertTime 设备注册时间
     * @apiSuccess(出参) {int} seqNum 在餐饮企业序号（第几个设备）
     *
     * @apiSuccessExample {json} 返回成功样例：
     *{
     *     "code": 200,
     *     "message": "新增设备成功",
     *     "data": {
     *         "deviceId": "20210528",
     *         "companyId": 1,
     *         "manufacturerId": 1,
     *         "deviceCode": "20210710",
     *         "deviceName": null,
     *         "insertTime": "2021-07-10 15:47:46",
     *         "updateTime": null,
     *         "isDeleted": null,
     *         "seqNum": 5,
     *         "gateId": 1,
     *         "status": null,
     *         "isOnline": null,
     *         "allRunTime": null,
     *         "maintenanceNum": null,
     *         "maintenanceRound": 30,
     *         "nextTime": null,
     *         "startStopNum": null,
     *         "earlyWarningNum": null,
     *         "alarmNum": null,
     *         "pageNumber": 0,
     *         "outSelectSerial": 0,
     *         "pipeline": null,
     *         "supervisionId": null,
     *         "nearMaintanceTime": "2021-07-03 22:51:32"
     *     }
     * }
     *
     * @apiErrorExample {json} 返回失败样例：
     * {
     *     "Code": "2001",
     * 	   "Message": "数据库执行有异常"
     * }
     * @apiSampleRequest off
     */

    @ApiOperation("新增设备")
    @PostMapping("/add/device")
    public CommonResult addDevice(@RequestBody String json) throws Exception {
        System.out.println("addDeviceJson==>"+json);
        return deviceService.insertSelective(json);
    }

    /**
     * @api {get} /devices/delete?deviceId=20210410 删除设备
     * @apiVersion 0.0.1
     * @apiDescription  运维端管理系统-餐饮企业-设备管理之删除设备接口说明。
     * @apiGroup operation-设备管理
     * @apiParam(入参) {String} deviceId 设备ID（唯一识别），必填。
     *
     * @apiSuccess(出参) {String} Code 接口返回编码；200-订单删除成功；1201-请求条件中，缺少必填参数；2001-数据库执行有异常；
     * @apiSuccess(出参) {String} Message 消息描述
     *
     * @apiSuccessExample {json} 返回成功样例：
     * {
     *     "code": 200,
     *     "message": "删除设备成功",
     *     "data": null
     * }
     *
     * @apiErrorExample {json} 返回失败样例：
     * {
     *     "Code": "2001",
     * 	   "Message": "数据库执行有异常"
     * }
     */
    @ApiOperation("删除设备")
    @GetMapping("/devices/delete")
    public CommonResult deleteOrder(@RequestParam String deviceId) throws Exception {
        System.out.println("deleteOrderJson==>"+deviceId);
        return deviceService.deleteByPrimaryKey(deviceId);
    }

    /**
     * @api {post} /update/device 修改设备
     * @apiVersion 0.0.1
     * @apiDescription  运维端管理系统-餐饮企业-设备管理之修改设备信息接口说明。
     * @apiGroup operation-设备管理
     * @apiParam(入参) {String} deviceId 设备ID（唯一识别），不可修改，必填。
     * @apiParam(入参) {int} companyId 所属餐饮企业ID，必填
     * @apiParam(入参) {int} manufacturerId 设备厂商ID，必填
     * @apiParam(入参) {String} nearMaintanceTime 上次维保时间
     * @apiParam(入参) {String} maintenanceRound 维保周期
     * @apiParamExample {json} 入参样例：
     * {
     *     "seqNum": 10,
     *     "gateId": 5,
     *     "deviceId": "20210488",
     *     "companyId": 2,
     *     "manufacturerId": 1,
     *     "nearMaintanceTime": "2021-07-08 22:51:32",
     *     "maintenanceRound": "60"
     * }
     *
     * @apiSuccess(出参) {String} Code 接口返回编码；200-设备信息修改成功；1201-请求条件中，缺少必填参数；2001-数据库执行有异常；
     * @apiSuccess(出参) {String} Message 消息描述
     * @apiSuccess(出参) {String} deviceId 设备ID（唯一识别）
     * @apiSuccess(出参) {int} companyId 所属餐饮企业ID
     * @apiSuccess(出参) {int} manufacturerId 设备厂商ID
     * @apiSuccess(出参) {String} insertTime 设备注册时间
     * @apiSuccess(出参) {String} updateTime 设备信息修改时间
     * @apiSuccess(出参) {int} seqNum 在餐饮企业序号（第几个设备）
     *
     * @apiSuccessExample {json} 返回成功样例：
     * {
     *     "code": 200,
     *     "message": "修改设备信息成功",
     *     "data": {
     *         "deviceId": "20210488",
     *         "companyId": 2,
     *         "manufacturerId": 1,
     *         "deviceCode": "PDI8564",
     *         "deviceName": null,
     *         "insertTime": "2021-07-06 12:54:08.0",
     *         "updateTime": "2021-07-10 16:46:21.0",
     *         "isDeleted": false,
     *         "seqNum": 10,
     *         "gateId": 5,
     *         "status": null,
     *         "isOnline": null,
     *         "allRunTime": null,
     *         "maintenanceNum": null,
     *         "maintenanceRound": 60,
     *         "nextTime": null,
     *         "startStopNum": null,
     *         "earlyWarningNum": null,
     *         "alarmNum": null,
     *         "pageNumber": 0,
     *         "outSelectSerial": 0,
     *         "pipeline": null,
     *         "supervisionId": null,
     *         "nearMaintanceTime": "2021-07-08 22:51:32.0"
     *     }
     * }
     *
     * @apiErrorExample {json} 返回失败样例：
     * {
     *     "Code": "2001",
     * 	   "Message": "数据库执行有异常"
     * }
     */

    @ApiOperation("修改设备信息")
    @PostMapping("/update/device")
    public CommonResult updateDevice(@RequestBody String json) throws Exception {
        System.out.println("updateDeviceJson==>"+json);
        return deviceService.updateByPrimaryKey(json);
    }

    /**
     * @api {post} /select/device 查询设备
     * @apiVersion 0.0.1
     * @apiDescription  运维端管理系统-餐饮企业-设备管理之查询设备接口说明，将选以下参数作为查询条件，不选为null。
     * @apiGroup operation-设备管理
     * @apiParam(入参) {String} deviceId 设备ID（唯一识别），即设备编码。
     * @apiParam(入参) {int} companyId 所属餐饮企业ID
     * @apiParam(入参) {int} manufacturerId 设备厂商ID
     * @apiParam(入参) {String} status 设备状态（正常、预警、报警）
     * @apiParam(入参) {int} isOnline 停止/运行（0：停止  1：运行）
     * @apiParam(入参) {int} seqNum 监管设备ID。
     * @apiParam(入参) {int} gateId 监管设备的管道号。
     * @apiParamExample {json} 入参样例：
     * {
     *
     * }
     * @apiSuccess(出参) {String} Code 接口返回编码；200-设备查询成功；2001-数据库执行有异常；
     * @apiSuccess(出参) {String} Message 消息描述
     * @apiSuccess(出参) {String} deviceId 设备编号
     * @apiSuccess(出参) {int} companyId 所属餐饮企业ID
     * @apiSuccess(出参) {int} manufacturerId 设备厂商ID
     * @apiSuccess(出参) {String} status 设备状态（正常、预警、报警）
     * @apiSuccess(出参) {int} isOnline 停止/运行（0：停止  1：运行）
     * @apiSuccess(出参) {String} totalUsedTime 设备安装以来的运行时长运行时长（分）
     * @apiSuccess(出参) {int} maintenanceNum 维保次数
     * @apiSuccess(出参) {String} maintenanceRound 维保周期（天）
     * @apiSuccess(出参) {String} nearMaintanceTime 上次维保时间
     * @apiSuccess(出参) {String} nextTime 下次维保时间
     * @apiSuccess(出参) {int} startStopNum 启停次数（超链接）
     * @apiSuccess(出参) {int} seqNum 在餐饮企业序号（第几个设备）
     * @apiSuccess(出参) {String} insertTime 设备注册时间
     * @apiSuccess(出参) {String} updateTime 设备信息修改时间
     * @apiSuccess(出参) {array} dlist 查询结果集
     * @apiSuccess(出参) {int} numberOfPages 页面数量
     * @apiSuccess(出参) {int} outSelectSerial 订单序号
     * @apiSuccess(出参) {int} selectCount 查询到的订单总数
     * @apiSuccessExample {json} 返回成功样例：
     * {
     *     "code": 200,
     *     "message": "查询设备成功",
     *     "data": {
     *         "numberOfPages": 1,
     *         "selectResult": null,
     *         "selectCount": 2,
     *         "dlist": [
     *             {
     *                 "deviceId": "20210410",
     *                 "companyId": 2,
     *                 "manufacturerId": 1,
     *                 "deviceCode": null,
     *                 "deviceName": null,
     *                 "insertTime": "2021-04-07 20:10:38",
     *                 "updateTime": null,
     *                 "isDeleted": null,
     *                 "seqNum": 1,
     *                 "status": "正常",
     *                 "isOnline": 1,
     *                 "allRunTime": 1234,
     *                 "maintenanceNum": 1,
     *                 "maintenanceRound": null,
     *                 "nextTime": "2021-04-30 16:57:12.0",
     *                 "startStopNum": 1,
     *                 "earlyWarningNum": 2,
     *                 "alarmNum": 3,
     *                 "pageNumber": 1,
     *                 "outSelectSerial": 1,
     *                 "seqNum": 2,
     *                 "gateId": 2
     *             },
     *             {
     *                 "deviceId": "20210412",
     *                 "companyId": 4,
     *                 "manufacturerId": 2,
     *                 "deviceCode": null,
     *                 "deviceName": null,
     *                 "insertTime": "2021-04-07 20:32:25",
     *                 "updateTime": "2021-04-07 21:05:03",
     *                 "isDeleted": null,
     *                 "seqNum": 1,
     *                 "status": null,
     *                 "isOnline": null,
     *                 "allRunTime": null,
     *                 "maintenanceNum": null,
     *                 "maintenanceRound": null,
     *                 "nextTime": null,
     *                 "startStopNum": null,
     *                 "earlyWarningNum": null,
     *                 "alarmNum": null,
     *                 "pageNumber": 1,
     *                 "outSelectSerial": 2
     *             }
     *         ]
     *     }
     * }
     *
     * @apiErrorExample {json} 返回失败样例：
     * {
     *     "Code": "2001",
     * 	   "Message": "数据库执行有异常"
     * }
     */
    @ApiOperation("查询设备")
    @PostMapping("/select/device")
    public CommonResult selectDevice(@RequestBody String json) throws Exception {
        System.out.println("selectDeviceJson==>"+json);
        return deviceService.selectDevice(json);
    }
}
