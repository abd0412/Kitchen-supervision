package cn.guet.kitchen.controller;

import cn.guet.kitchen.service.DeviceRunparamService;
import cn.guet.kitchen.entity.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @introduce:
 * @author: cyan
 * @DATE: 2021/4/9
 **/
@RestController
@Slf4j
public class DeviceRunparamController {
    @Resource
    private DeviceRunparamService deviceRunparamService;

    /**
     * @api {get} /select/status/device?status=正常&companyId=1 查询XX状态的设备
     * @apiVersion 0.0.1
     * @apiDescription  运维端管理系统-餐饮企业-订单管理-新增订单-设备关联接口说明。
     * @apiGroup operation-订单管理
     *
     * @apiParam(入参) {String} status 设备状态（正常、预警、报警）
     * @apiParam(入参) {int} companyId 订单中的餐饮企业ID（必填）
     *
     * @apiSuccess(出参) {int} Code 接口返回编码：200-查询成功；2001-数据库执行有异常；
     * @apiSuccess(出参) {String} Message 消息描述
     * @apiSuccess(出参) {array} deviceIdList 结果集
     * @apiSuccess(出参) {String} device_id 设备ID（唯一识别）
     *
     * @apiSuccessExample {json} 返回成功样例：
     * {
     *     "code": 200,
     *     "message": "查询成功",
     *     "data": {
     *         "deviceIdList": [
     *             {
     *                 "device_id": "20210410"
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
    @GetMapping("/select/status/device")
    public CommonResult selectStatusDevice(@RequestParam String status, @RequestParam int companyId) throws Exception {
        System.out.println("selectStatusDevice==>"+status);
        System.out.println("selectCompanyIdDevice==>"+companyId);
        return deviceRunparamService.selectByStatus(status, companyId);
    }

    /**
     * @api {get} /select/device/monitor/info?deviceId=20210488 查询设备监控信息
     * @apiVersion 0.0.1
     * @apiDescription  查询设备的相关监控信息。
     * @apiGroup operation-设备管理
     *
     * @apiParam(入参) {String} deviceId 设备ID
     *
     * @apiSuccess(出参) {int} Code 接口返回编码：200-查询成功；2001-数据库执行有异常；
     * @apiSuccess(出参) {String} Message 消息描述
     * @apiSuccess(出参) {String} deviceId 设备ID（唯一识别）
     * @apiSuccess(出参) {boolean} isOnline 设备实时运行状况监测（true：运行  false：停止）
     * @apiSuccess(出参) {String} updateTime 参数更新时间
     * @apiSuccess(出参) {String} nextTime 距离下次维保还剩多少小时
     * @apiSuccess(出参) {String} status 三种类型：正常、预警、报警
     * @apiSuccess(出参) {String} realRunningTime 本次开机运行时长(秒)  (注：时间戳对应年月日时分秒！！！)
     * @apiSuccess(出参) {String} totalUsedTime 设备自安装累计使用时长
     * @apiSuccess(出参) {String} useTimeAfterMaintenance 设备维保后使用时长（秒）
     * @apiSuccess(出参) {String} lastTime 上次维保时间
     * @apiSuccess(出参) {date} nearMaintanceTime 上次维保时间
     * @apiSuccess(出参) {int} maintenanceNum 设备维保次数
     * @apiSuccessExample {json} 返回成功样例：
     * {
     *     "code": 200,
     *     "message": "查询成功",
     *     "data": {
     *         "deviceId": "20210488",
     *         "paramId": null,
     *         "isOnline": false,
     *         "isDeleted": null,
     *         "insertTime": null,
     *         "updateTime": "2021-05-29 22:59:03.0",
     *         "nextTime": null,
     *         "status": "1",
     *         "maintenanceNum": 25,
     *         "startStopNum": null,
     *         "nearOnlineTime": "2021-07-02T13:06:30.000+0000",
     *         "nearOfflineTime": null,
     *         "maintenanceRound": null,
     *         "totalUsedTime": "0",
     *         "realRunningTime": "677600",
     *         "useTimeAfterMaintenance": "152898",
     *         "lastTime": "2021-07-08 22:51:32.0",
     *         "nearMaintanceTime": "2021-07-08T14:51:32.000+0000"
     *     }
     * }
     *
     * @apiErrorExample {json} 返回失败样例：
     * {
     * 	"Code": 2001,
     * 	"Message": "数据库执行有异常"
     * }
     */
    @GetMapping("/select/device/monitor/info")
    public CommonResult monitorInfo(@RequestParam String deviceId) throws Exception {
        System.out.println("monitorInfoDeviceId==>"+deviceId);
        return deviceRunparamService.selectMonitorInfo(deviceId);
    }
}
