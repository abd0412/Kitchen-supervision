package cn.guet.kitchen.controller;

import cn.guet.kitchen.entity.NetworkGate;
import cn.guet.kitchen.service.NetworkGateService;
import cn.guet.kitchen.entity.CommonResult;
import com.alibaba.fastjson.JSON;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@Slf4j
@RequestMapping(value = "/gate")
public class NetworkGateController {
    @Resource
    private NetworkGateService networkGateService;

    /**
     * @api {post} /gate/add/device 新增监管/网关设备
     * @apiVersion 0.0.1
     * @apiDescription  运维方-上门扫码-设备管理之新增监管/网关设备接口说明。
     * @apiGroup 监管或网关设备管理
     * @apiParam(入参) {String} deviceCode 设备编码，手动填入，是设备出厂编号。
     * @apiParam(入参) {int} channelNum 通道数量
     * @apiParamExample {json} 入参样例：
     * {
     *     "deviceCode": "ceshi1",
     *     "channelNum": 16
     * }
     *
     * @apiSuccess(出参) {String} Code 接口返回编码；200-新增设备成功；1201-请求条件中，缺少必填参数；2001-数据库执行有异常；
     * @apiSuccess(出参) {int} id 监管/网关设备在系统中的唯一id
     * @apiSuccess(出参) {String} Message 消息描述
     *
     * @apiSuccessExample {json} 返回成功样例：
     *{
     *     "code": 200,
     *     "message": "注册成功",
     *     "data": {
     *         "id": 30,
     *         "deviceCode": "ceshi1",
     *         "channelNum": 16,
     *         "companyId": null,
     *         "ipAddress": null,
     *         "mac": null,
     *         "usedChannelNum": null,
     *         "freeChannelNum": null,
     *         "isDeleted": null,
     *         "insertTime": "2021-07-06 11:35:06",
     *         "updateTime": null,
     *         "status": null,
     *         "warnId": null
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
        NetworkGate networkGate = JSON.parseObject(json, NetworkGate.class);//转化为实体类
        return networkGateService.insertSelective(networkGate);
    }

    /**
     * @api {get} /gate/devices/delete?deviceId=20210410 删除监管/网关设备
     * @apiVersion 0.0.1
     * @apiDescription  运维方-上门扫码-设备管理之删除监管/网关设备接口说明
     * @apiGroup 监管或网关设备管理
     * @apiParam(入参) {int} id 设备ID（唯一识别），必填，系统生成。
     *
     * @apiSuccess(出参) {String} Code 接口返回编码；200-订单删除成功；1201-请求条件中，缺少必填参数；2001-数据库执行有异常；
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
    @ApiOperation("删除设备")
    @GetMapping("/devices/delete")
    public CommonResult deleteOrder(@RequestParam int deviceId) throws Exception {
        System.out.println("deleteOrderJson==>"+deviceId);
        return networkGateService.deleteByPrimaryKey(deviceId);
    }

    /**
     * @api {post} /gate/update/device 修改监管/网关设备
     * @apiVersion 0.0.1
     * @apiDescription  运维方-上门扫码-设备管理之修改监管/网关设备接口说明
     * @apiGroup 监管或网关设备管理
     * @apiParam(入参) {int} id 设备ID（唯一识别），不可修改，必填。
     * @apiParam(入参) {String} description 可根据id选择性修改下内容。
     * @apiParamExample {json} 入参样例：
     * {
     *     "id": 4,
     *     "channelNum": 12,
     *     "companyId": null,
     *     "ipAddress": null,
     *     "mac": null,
     *     "usedChannelNum": 0,
     *     "freeChannelNum": 0,
     *     "status": null,
     *     "warnId": null
     * }
     *
     * @apiSuccess(出参) {String} Code 接口返回编码；200-设备信息修改成功；1201-请求条件中，缺少必填参数；2001-数据库执行有异常；
     * @apiSuccess(出参) {String} Message 消息描述
     *
     * @apiSuccessExample {json} 返回成功样例：
     * {
     *     "code": 200,
     *     "message": "修改成功",
     *     "data": null
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
        NetworkGate networkGate = JSON.parseObject(json, NetworkGate.class);//转化为实体类
        return networkGateService.updateByPrimaryKeySelective(networkGate);
    }

    /**
     * @api {post} /gate/select/device 查询监管/网关设备
     * @apiVersion 0.0.1
     * @apiDescription  运维方-上门扫码-设备管理之查询监管/网关设备接口说明
     * @apiGroup 监管或网关设备管理
     * @apiParam(入参) {String} description 可支持以下条件查询，null为{}
     * @apiParamExample {json} 入参样例：
     * {
     *             "id": 6,
     *             "deviceCode": "fiuweg3988",
     *             "channelNum": 16,
     *             "companyId": null,
     *             "ipAddress": null,
     *             "mac": null,
     *             "usedChannelNum": 0,
     *             "freeChannelNum": 0,
     *             "isDeleted": false,
     *             "status": null,
     *             "warnId": null
     * }
     *
     * @apiSuccess(出参) {String} Code 接口返回编码；200-设备查询成功；2001-数据库执行有异常；
     * @apiSuccess(出参) {String} Message 消息描述
     * @apiSuccessExample {json} 返回成功样例：
     * {
     *     "code": 200,
     *     "message": "查询成功",
     *     "data": [
     *         {
     *             "id": 6,
     *             "deviceCode": "fiuweg3988",
     *             "channelNum": 16,
     *             "companyId": null,
     *             "ipAddress": null,
     *             "mac": null,
     *             "usedChannelNum": 0,
     *             "freeChannelNum": 0,
     *             "isDeleted": false,
     *             "insertTime": "2021-07-03 16:28:37.0",
     *             "updateTime": null,
     *             "status": null,
     *             "warnId": null
     *         }
     *     ]
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
        NetworkGate networkGate = JSON.parseObject(json, NetworkGate.class);//转化为实体类
        return networkGateService.selectBySomeKey(networkGate);
    }
}
