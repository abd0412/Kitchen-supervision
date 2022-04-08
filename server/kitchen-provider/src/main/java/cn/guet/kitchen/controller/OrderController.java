package cn.guet.kitchen.controller;

import cn.guet.kitchen.service.OrderService;
import cn.guet.kitchen.entity.CommonResult;
import com.alibaba.fastjson.JSONObject;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * @introduce:
 * @author: cyan
 * @DATE: 2021/3/29
 **/
@EnableScheduling
@RestController
@Slf4j  //打印日志
@RequestMapping(value = "/order")
public class OrderController {
    @Resource
    private OrderService orderService;
    /**
     * @api {post} /order/operation/add 新增订单
     * @apiVersion 0.0.1
     * @apiDescription  本例为运维端管理系统的新增订单说明。
     * @apiGroup operation-订单管理
     * @apiParam(入参) {String} orderType 订单类型编码（设备清洗、设备维修、设备安装），必填
     * @apiParam(入参) {int} foodCompanyId 餐饮企业ID，必填
     * @apiParam(入参) {double} money 订单金额
     * @apiParam(入参) {String} time 维保日期，必填
     * @apiParam(入参) {string} maintenanceTimeseg 维保时间段（09:00-10:30  10:30-12:00  14:00-15:30 15:30-17:00），必填
     * @apiParam(入参) {string} genType 订单产生方式（运维  餐饮  系统），必填
     * @apiParam(入参) {String} remark 备注
     * @apiParam(入参) {int} batch 订单批次
     * @apiParam(入参) {set} devices 设备关联，必填
     * @apiParam(入参) {array} normal 正常设备（父级：devices）
     * @apiParam(入参) {array} earlyWarning 预警设备（父级：devices）
     * @apiParam(入参) {array} alarm 报警设备（父级：devices）
     * @apiParam(入参) {String} deviceId 设备ID（父级：normal||earlyWarning||alarm）
     * @apiParamExample {json} 入参样例：
     * {
     *     "orderType": "设备清洗",
     *     "foodCompanyId": 1,
     *     "money": 90.5,
     *     "time": "2021-04-19",
     *     "maintenanceTimeseg": "09:00-10:30",
     *     "genType": "运维",
     *     "remark": "电话联系",
     *     "devices": {
     *         "normal": [
     *             {
     *                 "deviceId": "123456"
     *             },
     *             {
     *                 "deviceId": "123457"
     *             },
     *             {
     *                 "deviceId": "123458"
     *             }
     *         ],
     *         "earlyWarning": [
     *             {
     *                 "deviceId": "123459"
     *             },
     *             {
     *                 "deviceId": "123450"
     *             }
     *         ],
     *         "alarm": [
     *             {
     *                 "deviceId": "123451"
     *             }
     *         ]
     *     }
     * }
     *
     * @apiSuccess(出参) {String} Code 接口返回编码；200-创建订单成功；1201-请求条件中，缺少必填参数；2001-数据库执行有异常；
     * @apiSuccess(出参) {String} Message 消息描述
     * @apiSuccess(出参) {int} maintenanceId 订单序号
     * @apiSuccess(出参) {int} maintenanceCompanyId 派单公司ID（包括运维公司、维保公司）
     * @apiSuccess(出参) {int} oneProcessorId 订单在系统中生成时，系统根据算法指定的一个公司中的一位派单负责人
     * @apiSuccess(出参) {String} orderNumber 订单编号
     * @apiSuccess(出参) {String} flowNum 订单流水号
     *
     * @apiSuccessExample {json} 返回成功样例：
     * {
     *     "code": 200,
     *     "message": "订单创建成功",
     *     "data": {
     *         "maintenanceId": 17,
     *         "maintenanceCompanyId": 4,
     *         "isDeleted": null,
     *         "insertTime": "2021-06-23 20:01:14",
     *         "updateTime": null,
     *         "orderType": "设备清洗",
     *         "foodCompanyId": 1,
     *         "oneProcessorId": 0,
     *         "money": 90.5,
     *         "orderStatus": 1,
     *         "genType": "运维",
     *         "batch": null,
     *         "time": "2021-04-19",
     *         "maintenanceTimeseg": "09:00-10:30",
     *         "remark": "电话联系",
     *         "warnId": null,
     *         "orderNumber": "162444967488817",
     *         "flowNum": null,
     *         "devices": {
     *             "normal": [
     *                 {
     *                     "deviceId": "123456",
     *                     "pipeline": null,
     *                     "supervisionId": null
     *                 },
     *                 {
     *                     "deviceId": "123457",
     *                     "pipeline": null,
     *                     "supervisionId": null
     *                 },
     *                 {
     *                     "deviceId": "123458",
     *                     "pipeline": null,
     *                     "supervisionId": null
     *                 }
     *             ],
     *             "earlyWarning": [
     *                 {
     *                     "deviceId": "123459",
     *                     "pipeline": null,
     *                     "supervisionId": null
     *                 },
     *                 {
     *                     "deviceId": "123450",
     *                     "pipeline": null,
     *                     "supervisionId": null
     *                 }
     *             ],
     *             "alarm": [
     *                 {
     *                     "deviceId": "123451",
     *                     "pipeline": null,
     *                     "supervisionId": null
     *                 }
     *             ]
     *         },
     *         "insertTimeStart": null,
     *         "insertTimeEnd": null,
     *         "pageNumber": 0,
     *         "outSelectSerial": 0,
     *         "selectFlag": null,
     *         "companyName": "天华餐饮企业",
     *         "phone": "13132746998",
     *         "address": null,
     *         "processorIdArray": null,
     *         "dispatchTime": null,
     *         "clientEstimate": null,
     *         "signImg": null,
     *         "missionImg": null,
     *         "acceptanceTime": null,
     *         "updateDispatchTime": null
     *     }
     * }
     *
     * @apiErrorExample {json} 返回失败样例：
     * {
     *     "Code": "2001",
     * 	   "Message": "数据库执行有异常"
     * }
     */

    @ApiOperation("新增订单")
    @PostMapping("/operation/add")
    public CommonResult addOrder(@RequestBody String json) throws Exception {
        log.info("addOrderJson==>"+json);
        return orderService.add(json);
    }

    /**
     * @api {get} /order/operation/delete?orderNumber=161752709559154 删除订单
     * @apiVersion 0.0.1
     * @apiDescription  本例为运维端管理系统的订单删除说明。
     * @apiGroup operation-订单管理
     * @apiParam(入参) {String} orderNumber 订单编号
     *
     * @apiSuccess(出参) {String} Code 接口返回编码；200-订单删除成功；1201-请求条件中，缺少必填参数；2001-数据库执行有异常；
     * @apiSuccess(出参) {String} Message 消息描述
     *
     * @apiSuccessExample {json} 返回成功样例：
     * {
     *     "code": 200,
     *     "message": "订单删除成功",
     *     "data": null
     * }
     *
     * @apiErrorExample {json} 返回失败样例：
     * {
     *     "Code": "2001",
     * 	   "Message": "数据库执行有异常"
     * }
     */
    @ApiOperation("删除订单")
    @GetMapping("/operation/delete")
    public CommonResult deleteOrder(@RequestParam String orderNumber) throws Exception {
        log.info("deleteOrder==>"+orderNumber);
        return orderService.delete(orderNumber);
    }

    /**
     * @api {post} /order/operation/update 修改订单
     * @apiVersion 0.0.1
     * @apiDescription  本例为运维端管理系统的修改订单说明。
     * @apiGroup operation-订单管理
     * @apiParam(入参) {String} orderType 订单类型编码（设备清洗  设备维修  设备安装），必填
     * @apiParam(入参) {int} foodCompanyId 餐饮企业ID，必填
     * @apiParam(入参) {double} money 订单金额
     * @apiParam(入参) {String} time 维保日期，必填
     * @apiParam(入参) {String} maintenanceTimeSeg 维保时间段（09:00-10:30  10:30-12:00  14:00-15:30 15:30-17:00），必填
     * @apiParam(入参) {String} genType 订单产生方式（运维 餐饮 系统），必填
     * @apiParam(入参) {String} remark 备注
     * @apiParam(入参) {int} batch 订单批次
     * @apiParam(入参) {set} devices 设备关联，必填
     * @apiParam(入参) {array} normal 正常设备（父级：devices）
     * @apiParam(入参) {array} earlyWarning 预警设备（父级：devices）
     * @apiParam(入参) {array} alarm 报警设备（父级：devices）
     * @apiParam(入参) {String} deviceId 设备ID（父级：normal||earlyWarning||alarm）
     * @apiParam(入参) {int} maintenanceCompanyId 派单公司ID，必填
     * @apiParam(入参) {int} oneProcessorId 订单上原带有的派单负责人工号，必填
     * @apiParam(入参) {String} orderNumber 订单编号（不可修改），必填
     * @apiParam(入参) {String} flowNum 订单流水号（不可修改），必填
     * @apiParam(入参) {int} orderStatus 订单状态 (1：已分配（已分配到公司） 2:待确认（等待餐饮企业确认订单） 3：待派单（等待公司派单到员工）  4：待处理（等待员工处理）  5、已完成（含餐饮签名的照片上传）），必填
     * @apiParam(入参) {int} gateId 监管设备ID，此数值在添加设备时已经确定，此处不支持修改，由设备号带过来（7.3修改）
     * @apiParam(入参) {int} seqNum 监管设备的管道号，此数值在添加设备时已经确定，此处不支持修改，由设备号带过来（7.3修改）
     * @apiParamExample {json} 入参样例：
     * {
     *     "maintenanceId": 17,
     *     "maintenanceCompanyId": 4,
     *     "isDeleted": null,
     *     "insertTime": "2021-06-23 20:01:14",
     *     "updateTime": null,
     *     "orderType": "设备维修",
     *     "foodCompanyId": 1,
     *     "oneProcessorId": 0,
     *     "money": 100,
     *     "orderStatus": 1,
     *     "genType": "运维",
     *     "batch": null,
     *     "time": "2021-04-19",
     *     "maintenanceTimeseg": "09:00-10:30",
     *     "remark": "电话联系",
     *     "warnId": null,
     *     "orderNumber": "162444967488817",
     *     "flowNum": null,
     *     "devices": {
     *         "normal": [
     *             {
     *                 "deviceId": "123456"
     *             },
     *             {
     *                 "deviceId": "123457"
     *             },
     *             {
     *                 "deviceId": "123458"
     *             }
     *         ],
     *         "earlyWarning": [
     *             {
     *                 "deviceId": "123459"
     *             },
     *             {
     *                 "deviceId": "123450"
     *             }
     *         ],
     *         "alarm": [
     *         ]
     *     },
     *     "insertTimeStart": null,
     *     "insertTimeEnd": null,
     *     "pageNumber": 0,
     *     "outSelectSerial": 0,
     *     "selectFlag": null,
     *     "companyName": "天华餐饮企业",
     *     "phone": "13132746998",
     *     "address": null,
     *     "processorIdArray": null,
     *     "dispatchTime": null,
     *     "clientEstimate": null,
     *     "signImg": null,
     *     "missionImg": null,
     *     "acceptanceTime": null,
     *     "updateDispatchTime": null
     * }
     *
     * @apiParamExample {json} 安装订单添加设备入参样例：
     * {
     *
     *     "maintenanceId": 32,
     *     "maintenanceCompanyId": 1,
     *     "isDeleted": null,
     *     "insertTime": "2021-07-03 13:58:46",
     *     "updateTime": null,
     *     "orderType": "设备安装",
     *     "foodCompanyId": 1,
     *     "oneProcessorId": 0,
     *     "money": 90.5,
     *     "orderStatus": 1,
     *     "genType": "运维",
     *     "batch": null,
     *     "time": "2021-04-19",
     *     "maintenanceTimeseg": "09:00-10:30",
     *     "remark": "电话联系",
     *     "warnId": null,
     *     "orderNumber": "162529192730232",
     *     "flowNum": null,
     *     "devices": {
     *         "normal": [
     *                 {
     *                     "deviceId": "6",
     *                     "seqNum": 10,
     *                     "gateId": 1
     *                 },
     *                 {
     *                     "deviceId": "7",
     *                     "seqNum": 8,
     *                     "gateId": 1
     *                 },
     *                 {
     *                     "deviceId": "8",
     *                     "seqNum": 10,
     *                     "gateId": null
     *                 }
     *     ],
     *         "earlyWarning": [],
     *         "alarm": []
     *     },
     *     "insertTimeStart": null,
     *     "insertTimeEnd": null,
     *     "pageNumber": 0,
     *     "outSelectSerial": 0,
     *     "selectFlag": null,
     *     "companyName": "寨云居",
     *     "phone": "13132746998",
     *     "address": "广西壮族自治区桂林市象山区龙脊索道北",
     *     "processorIdArray": null,
     *     "dispatchTime": null,
     *     "clientEstimate": null,
     *     "signImg": null,
     *     "missionImg": null,
     *     "acceptanceTime": null,
     *     "updateDispatchTime": null
     * }
     *
     * @apiSuccess(出参) {String} Code 接口返回编码；200-订单更新成功；1201-请求条件中，缺少必填参数；2001-数据库执行有异常；
     * @apiSuccess(出参) {String} Message 消息描述
     * @apiSuccess(出参) {String} devices 设备关联
     *
     * @apiSuccessExample {json} 返回成功样例：
     * {
     *     "code": 200,
     *     "message": "订单更新成功",
     *     "data": {
     *         "maintenanceId": 32,
     *         "maintenanceCompanyId": 1,
     *         "isDeleted": false,
     *         "insertTime": "2021-07-03 13:58:46.0",
     *         "updateTime": "2021-07-03 14:20:21.0",
     *         "orderType": "设备安装",
     *         "foodCompanyId": 1,
     *         "oneProcessorId": 0,
     *         "money": 90.5,
     *         "orderStatus": 1,
     *         "genType": "运维",
     *         "batch": null,
     *         "time": "2021-04-19 00:00:00.0",
     *         "maintenanceTimeseg": "09:00-10:30",
     *         "remark": "电话联系",
     *         "warnId": null,
     *         "orderNumber": "162529192730232",
     *         "flowNum": null,
     *         "devices": {
     *             "normal": [
     *                 {
     *                     "deviceId": "6",
     *                     "seqNum": 10,
     *                     "gateId": 1
     *                 },
     *                 {
     *                     "deviceId": "7",
     *                     "seqNum": 8,
     *                     "gateId": 1
     *                 },
     *                 {
     *                     "deviceId": "8",
     *                     "seqNum": 10,
     *                     "gateId": null
     *                 }
     *             ],
     *             "earlyWarning": [],
     *             "alarm": []
     *         },
     *         "insertTimeStart": null,
     *         "insertTimeEnd": null,
     *         "pageNumber": 0,
     *         "outSelectSerial": 0,
     *         "selectFlag": null,
     *         "companyName": "寨云居",
     *         "phone": "13132746998",
     *         "address": "广西壮族自治区桂林市象山区龙脊索道北",
     *         "processorIdArray": null,
     *         "dispatchTime": null,
     *         "clientEstimate": null,
     *         "signImg": null,
     *         "missionImg": null,
     *         "acceptanceTime": null,
     *         "updateDispatchTime": null
     *     }
     * }
     *
     * @apiErrorExample {json} 返回失败样例：
     * {
     *     "Code": "2001",
     * 	   "Message": "数据库执行有异常"
     * }
     */
    @ApiOperation("更新订单")
    @PostMapping("/operation/update")
    public CommonResult updateOrder(@RequestBody String json) throws Exception {
        log.info("updateOrderJson==>"+json);
        return orderService.update(json);
    }

    /**
     * @api {post} /order/operation/select 查询订单
     * @apiVersion 0.0.1
     * @apiDescription  运维端管理系统的查询订单接口说明，以下参数无值时为null。
     * @apiGroup operation-订单管理
     *
     * @apiParam(入参) {int} foodCompanyId 搜索范围（（默认）当前餐饮企业：对应ID  所有餐饮企业：null）
     * @apiParam(入参) {int} orderStatus 订单状态 (1：已分配（已分配到公司） 2:待确认（等待餐饮企业确认订单） 3：待派单（等待公司派单到员工）  4：待处理（等待员工处理）  5、已完成（含餐饮签名的照片上传）），必填
     * @apiParam(入参) {String} genType 下单方式（1：餐饮企业下单  2：系统下单  3：运维人员下单）
     * @apiParam(入参) {String} orderType 订单类型（1：设备清洗  2：设备维修  3：设备安装）
     * @apiParam(入参) {date} insertTimeStart 起始下单时间
     * @apiParam(入参) {date} insertTimeEnd 终止下单时间
     * @apiParam(入参) {String} orderNumber 订单编号
     * @apiParam(入参) {String} flowNum 订单流水号
     * @apiParam(入参) {int} maintenanceCompanyId 派单公司ID
     * @apiParam(入参) {int} processorId 派单员工工号
     * @apiParam(入参) {int} pageNumber 页号（默认为 1）
     * @apiParamExample {json} 入参样例：
     * {
     *     "orderNumber": "162529192730232"
     * }
     *
     * @apiSuccess(出参) {String} Code 接口返回编码；200-查询成功；2001-数据库执行有异常；
     * @apiSuccess(出参) {String} Message 消息描述
     * @apiSuccess(出参) {int} numberOfPages 页面数量
     * @apiSuccess(出参) {int} outSelectSerial 序号
     * @apiSuccess(出参) {int} selectCount 查询到的订单总数
     * @apiSuccessExample {json} 返回成功样例：
     * {
     *     "code": 200,
     *     "message": "查询成功",
     *     "data": {
     *         "numberOfPages": 1,
     *         "selectResult": [
     *             {
     *                 "maintenanceId": 32,
     *                 "maintenanceCompanyId": 4,
     *                 "isDeleted": false,
     *                 "insertTime": "2021-07-03 13:58:46.0",
     *                 "updateTime": "2021-07-03 14:20:21.0",
     *                 "orderType": "设备安装",
     *                 "foodCompanyId": 1,
     *                 "oneProcessorId": 0,
     *                 "money": 90.5,
     *                 "orderStatus": 2,
     *                 "genType": "运维",
     *                 "batch": null,
     *                 "time": "2021-04-19 00:00:00.0",
     *                 "maintenanceTimeseg": "09:00-10:30",
     *                 "remark": "电话联系",
     *                 "warnId": null,
     *                 "orderNumber": "162529192730232",
     *                 "flowNum": null,
     *                 "devices": {
     *                     "normal": [
     *                         {
     *                             "deviceId": "6",
     *                             "seqNum": 10,
     *                             "gateId": 1
     *                         },
     *                         {
     *                             "deviceId": "7",
     *                             "seqNum": 8,
     *                             "gateId": 1
     *                         },
     *                         {
     *                             "deviceId": "8",
     *                             "seqNum": 10,
     *                             "gateId": null
     *                         }
     *                     ],
     *                     "earlyWarning": [],
     *                     "alarm": []
     *                 },
     *                 "insertTimeStart": null,
     *                 "insertTimeEnd": null,
     *                 "pageNumber": 1,
     *                 "outSelectSerial": 1,
     *                 "selectFlag": null,
     *                 "companyName": "寨云居",
     *                 "phone": "13132746998",
     *                 "address": "广西壮族自治区桂林市象山区龙脊索道北",
     *                 "processorIdArray": null,
     *                 "dispatchTime": null,
     *                 "clientEstimate": null,
     *                 "signImg": null,
     *                 "missionImg": null,
     *                 "acceptanceTime": "",
     *                 "updateDispatchTime": null
     *             }
     *         ],
     *         "selectCount": 1,
     *         "dlist": null
     *     }
     * }
     *
     * @apiErrorExample {json} 返回失败样例：
     * {
     *     "Code": "2001",
     * 	   "Message": "数据库执行有异常"
     * }
     */
    @ApiOperation("查询订单")
    @PostMapping("/operation/select")
    public CommonResult selectOrder(@RequestBody String json) throws Exception {
        log.info("selectOrderJson==>"+json);
        return orderService.select(json);
    }

    /**
     * @api {post} /order/dispatch/staff 派单给员工
     * @apiVersion 0.0.1
     * @apiDescription  支持运维/维保公司派单给多位员工而修改订单的派单人员信息的接口说明。
     * @apiGroup Common-订单
     * @apiParam(入参) {String} orderNumber 订单编号，必填
     * @apiParam(入参) {int} orderStatus 订单状态 (1：已分配（已分配到公司） 2:待确认（等待餐饮企业确认订单） 3：待派单（等待公司派单到员工）  4：待处理（等待员工处理）  5、已完成（含餐饮签名的照片上传）），必填
     * @apiParam(入参) {array} processorIdArray 派单员工工号数组，必填
     * @apiParam(入参) {int} processorId 派单员工工号（至少一位）
     * @apiParamExample {json} 入参样例：
     * {
     *     "orderNumber": "161797298403681",
     *     "orderStatus": 3,
     *     "processorIdArray": [
     *         {
     *             "processorId": 1111
     *         },
     *         {
     *             "processorId": 1112
     *         }
     *     ]
     * }
     *
     * @apiSuccess(出参) {String} Code 接口返回编码；200-派单成功；1201-请求条件中，缺少必填参数；2001-数据库执行有异常；
     * @apiSuccess(出参) {String} Message 消息描述
     *
     * @apiSuccessExample {json} 返回成功样例：
     * {
     *     "code": 200,
     *     "message": "派单成功"
     * }
     *
     * @apiErrorExample {json} 返回失败样例：
     * {
     *     "code": "2001",
     * 	   "Message": "数据库执行有异常"
     * }
     */
    @ApiOperation("派单给员工")
    @PostMapping("/dispatch/staff")
    public CommonResult dispatchStaffOrder(@RequestBody String json) throws Exception {
        log.info("dispatchStaffJson==>"+json);
        return orderService.dispatchStaffUpdate(json);
    }

    /**
     * @api {post} /order/dispatch/update 修改/取消派单
     * @apiVersion 0.0.1
     * @apiDescription  支持运维/维保公司修改/取消派单信息的接口说明。
     * @apiGroup Common-订单
     * @apiParam(入参) {String} orderNumber 订单编号，必填
     * @apiParam(入参) {int} orderStatus 订单状态 (1：已分配（已分配到公司） 2:待确认（等待餐饮企业确认订单） 3：待派单（等待公司派单到员工）  4：待处理（等待员工处理）  5、已完成（含餐饮签名的照片上传）），必填
     * @apiParam(入参) {array} processorIdArray 派单员工工号数组，必填
     * @apiParam(入参) {int} processorId 派单员工工号，若修改派单信息，员工号至少有一个，状态值为4；若取消派单，则传一个空processorIdArray，状态值为3。
     * @apiParamExample {json} 入参样例：
     * {
     *     "orderNumber": "161797298403681",
     *     "orderStatus": 3,
     *     "processorIdArray": [
     *
     *     ]
     * }
     *
     * @apiSuccess(出参) {String} Code 接口返回编码；200-修改派单信息成功；1201-请求条件中，缺少必填参数；2001-数据库执行有异常；
     * @apiSuccess(出参) {String} Message 消息描述
     *
     * @apiSuccessExample {json} 返回成功样例：
     * {
     *     "code": 200,
     *     "message": "修改派单信息成功",
     *     "data": null
     * }
     *
     * @apiErrorExample {json} 返回失败样例：
     * {
     *     "code": "2001",
     * 	   "Message": "数据库执行有异常"
     * }
     */
    @ApiOperation("修改/取消派单")
    @PostMapping("/dispatch/update")
    public CommonResult dispatchUpdateOrder(@RequestBody String json) throws Exception {
        log.info("dispatchUpdateJson==>"+json);
        return orderService.dispatchInfoUpdate(json);
    }

    /**
     * @api {post} /order/dispatch/select 派单查询
     * @apiVersion 0.0.1
     * @apiDescription  根据员工号或订单状态查询该员工的派单信息。
     * @apiGroup Common-订单
     *
     * @apiParam(入参) {int} processorId 派单员工工号，必填
     * @apiParam(入参) {int} orderStatus 订单状态（4：待处理（等待员工处理）  5、已完成（含餐饮签名的照片上传）），若查询全部-值为null。
     * @apiParamExample {json} 入参样例：
     * {
     *     "processorId": 1111,
     *     "orderStatus": 3
     * }
     *
     * @apiSuccess(出参) {String} Code 接口返回编码；200-查询成功；2001-数据库执行有异常；
     * @apiSuccess(出参) {String} Message 消息描述
     * @apiSuccess(出参) {array} data 结果集
     * @apiSuccess(出参) {array} devices 设备
     * @apiSuccess(出参) {array} processorIdArray 派单员工
     * @apiSuccess(出参) {String} dispatchTime 派单时间
     * @apiSuccessExample {json} 返回成功样例：
     * {
     *     "code": 200,
     *     "message": "查询成功",
     *     "data": [
     *         {
     *             "money": 90.5,
     *             "orderStatus": 3,
     *             "time": "2021-06-19",
     *             "maintenancePeriod": 2,
     *             "remark": "电话联系",
     *             "orderNumber": "161797298403681",
     *             "flowNum": "1121null",
     *             "devices": {
     *                 "normal": [
     *                     {
     *                         "deviceId": "123456"
     *                     },
     *                     {
     *                         "deviceId": "123457"
     *                     },
     *                     {
     *                         "deviceId": "123458"
     *                     }
     *                 ],
     *                 "earlyWarning": [
     *                     {
     *                         "deviceId": "123450"
     *                     }
     *                 ],
     *                 "alarm": []
     *             },
     *             "companyName": "好吃餐饮",
     *             "phone": "18630992352",
     *             "address": "广东省汕头市",
     *             "processorIdArray": [
     *                 {
     *                     "processorId": 1111
     *                 },
     *                 {
     *                     "processorId": 1112
     *                 }
     *             ],
     *             "dispatchTime": "2021-04-16 11:35:38"
     *         },
     *         {
     *             "money": 90.5,
     *             "orderStatus": 3,
     *             "time": "2021-04-19",
     *             "maintenancePeriod": 2,
     *             "remark": "设备安装",
     *             "orderNumber": "161804062344690",
     *             "flowNum": "3121null",
     *             "devices": {
     *                 "normal": [
     *                     {
     *                         "deviceId": "123456"
     *                     },
     *                     {
     *                         "deviceId": "123457"
     *                     },
     *                     {
     *                         "deviceId": "123458"
     *                     }
     *                 ],
     *                 "earlyWarning": [
     *                     {
     *                         "deviceId": "123459"
     *                     }
     *                 ],
     *                 "alarm": []
     *             },
     *             "companyName": "好想来餐饮",
     *             "phone": "18630992352",
     *             "address": "广东省汕头市",
     *             "processorIdArray": [
     *                 {
     *                     "processorId": 1111
     *                 },
     *                 {
     *                     "processorId": 1112
     *                 }
     *             ],
     *             "dispatchTime": "2021-04-16 11:35:38"
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
    @ApiOperation("派单查询")
    @PostMapping("/dispatch/select")
    public CommonResult dispatchSelectOrder(@RequestBody String json) throws Exception {
        log.info("dispatchSelectOrderJson==>"+json);
        return orderService.selectDispatchInfo(json);
    }

    /**
     * @api {get} /order/dispatch/track?orderNumber=161804062344690 追踪订单的派单信息
     * @apiVersion 0.0.1
     * @apiDescription  根据订单号查询出该订单派给了谁。
     * @apiGroup Common-订单
     *
     * @apiParam(入参) {String} orderNumber 订单号
     *
     * @apiSuccess(出参) {String} Code 接口返回编码；200-查询成功；2001-数据库执行有异常；
     * @apiSuccess(出参) {String} Message 消息描述
     * @apiSuccess(出参) {array} data 结果集
     * @apiSuccess(出参) {array} devices 设备
     * @apiSuccess(出参) {array} processorIdArray 派单员工
     * @apiSuccess(出参) {String} dispatchTime 派单时间
     * @apiSuccess(出参) {String} updateDispatchTime 修改派单信息时间
     * @apiSuccessExample {json} 返回成功样例：
     * {
     *     "code": 200,
     *     "message": "查询成功",
     *     "data": {
     *         "maintenanceId": null,
     *         "maintenanceCompanyId": null,
     *         "isDeleted": null,
     *         "insertTime": null,
     *         "updateTime": null,
     *         "orderTypeCode": null,
     *         "foodCompanyId": null,
     *         "processorId": null,
     *         "money": 90.5,
     *         "orderStatus": 4,
     *         "genType": null,
     *         "batch": null,
     *         "time": "2021-04-19",
     *         "maintenancePeriod": 2,
     *         "remark": "设备安装",
     *         "warnId": null,
     *         "orderNumber": "161804062344690",
     *         "flowNum": "3121null",
     *         "devices": {
     *             "normal": [
     *                 {
     *                     "deviceId": "123456"
     *                 },
     *                 {
     *                     "deviceId": "123457"
     *                 },
     *                 {
     *                     "deviceId": "123458"
     *                 }
     *             ],
     *             "earlyWarning": [
     *                 {
     *                     "deviceId": "123459"
     *                 }
     *             ],
     *             "alarm": []
     *         },
     *         "insertTimeStart": null,
     *         "insertTimeEnd": null,
     *         "pageNumber": 0,
     *         "outSelectSerial": 0,
     *         "selectFlag": null,
     *         "companyName": "好想来餐饮",
     *         "phone": "18630992352",
     *         "address": "广东省汕头市",
     *         "processorIdArray": [
     *             {
     *                 "processorId": 1
     *             },
     *             {
     *                 "processorId": 2
     *             }
     *         ],
     *         "dispatchTime": "2021-04-19 18:57:04",
     *         "clientEstimate": 1,
     *         "signImg": "xxx",
     *         "missionImg": "yyy",
     *         "acceptanceTime": "2021-04-19 18:58:27",
     *         "updateDispatchTime": "2021-04-20 22:44:00"
     *     }
     * }
     *
     * @apiErrorExample {json} 返回失败样例：
     * {
     *     "Code": "2001",
     * 	   "Message": "数据库执行有异常"
     * }
     */
    @ApiOperation("追踪订单派单信息")
    @GetMapping("/dispatch/track")
    public CommonResult dispatchTrackOrder(@RequestParam String orderNumber) throws Exception {
        log.info("dispatchTrackOrder==>"+orderNumber);
        return orderService.trackDispatchInfo(orderNumber);
    }

    /**
     * @api {post} /order/weChat/uploadImage 上传图片
     * @apiVersion 0.0.1
     * @apiDescription  上传签名照和取证照片的接口说明。
     * @apiGroup Common-订单
     *
     * @apiParam(入参) {String} signImgFile 签名照key，必填
     * @apiParam(入参) {String} missionImgFile 拍照key，必填
     * @apiParam(入参) {String} orderNumber 订单编号，必填
     * @apiParam(入参) {int} orderStatus 订单状态 (1：已分配（已分配到公司） 2:待确认（等待餐饮企业确认订单） 3：待派单（等待公司派单到员工）  4：待处理（等待员工处理）  5、已完成（含餐饮签名的照片上传）），必填
     * @apiParam(入参) {String} orderType 订单类型(设备清洗、设备维修、设备安装)，必填
     *
     * @apiSuccess(出参) {String} Code 接口返回编码；200-url；2001-上传失败；
     * @apiSuccess(出参) {String} Message 消息描述
     * @apiSuccess(出参) {String} acceptanceTime 上传时间
     *
     * @apiSuccessExample {json} 返回成功样例：
     * {
     *     "data": "http://106.15.73.226/acc-image/2021042223354757.jpg",
     *     "statusCode": 200
     * }
     *
     * @apiErrorExample {json} 返回失败样例：
     * {
     *     "code": "2001",
     * 	   "Message": "上传失败"
     * }
     */
    @PostMapping("/weChat/uploadImage")
    public JSONObject uploadImage(HttpServletRequest request) throws Exception {
        JSONObject jsonObject = new JSONObject();
        String msg =  orderService.uploadAcceptancePicture(request);
        if(("error").equals(msg)){
            jsonObject.put("statusCode", 2001);
            jsonObject.put("data", "上传失败");
        }else {
            jsonObject.put("statusCode", 200);
            jsonObject.put("data", msg);
        }
        return jsonObject;

    }

    /**
     * @api {get} /order/auto/generated 自动生成订单
     * @apiVersion 0.0.1
     * @apiDescription  针对预警/报警设备进行设备清洗，假定运维端系统每天凌晨4点自动生成餐饮企业的设备清洗订单。
     * @apiGroup operation-订单管理
     *
     * @apiSuccess(出参) {String} Code 接口返回编码；200-2021-04-20 18:39:12 自动生成订单成功；2001-数据库执行有异常；
     * @apiSuccess(出参) {String} Message 消息描述
     * @apiSuccess(出参) {array} data 各餐饮企业可能产生的订单的数组
     *
     * @apiSuccessExample {json} 返回成功样例：
     *{
     *     "code": 200,
     *     "message": "2021-07-14 21:55:16 自动生成订单成功",
     *     "data": [
     *         {
     *             "maintenanceId": 42,
     *             "maintenanceCompanyId": 4,
     *             "isDeleted": false,
     *             "insertTime": "2021-07-14 21:36:56.0",
     *             "updateTime": "2021-07-14 21:55:17.0",
     *             "orderType": "wash",
     *             "foodCompanyId": 1,
     *             "oneProcessorId": null,
     *             "processorId": null,
     *             "money": 100.0,
     *             "orderStatus": 2,
     *             "genType": "系统修改生成",
     *             "batch": null,
     *             "time": "2021-07-14 21:36:52.0",
     *             "maintenanceTimeseg": null,
     *             "remark": null,
     *             "warnId": null,
     *             "orderNumber": "162626981704642",
     *             "flowNum": null,
     *             "devices": {
     *                 "normal": [],
     *                 "earlyWarning": [
     *                     {
     *                         "deviceId": "20210533",
     *                         "seqNum": null,
     *                         "gateId": null
     *                     }
     *                 ],
     *                 "alarm": [
     *                     {
     *                         "deviceId": "20210532",
     *                         "seqNum": null,
     *                         "gateId": null
     *                     }
     *                 ]
     *             },
     *             "insertTimeStart": null,
     *             "insertTimeEnd": null,
     *             "pageNumber": 0,
     *             "outSelectSerial": 0,
     *             "selectFlag": null,
     *             "companyName": "六三好食在·柴火妈妈饭",
     *             "phone": "15078327874",
     *             "address": "广西壮族自治区桂林市七星区空明西路27号",
     *             "processorIdArray": null,
     *             "dispatchTime": null,
     *             "clientEstimate": null,
     *             "signImg": null,
     *             "missionImg": null,
     *             "acceptanceTime": null,
     *             "updateDispatchTime": null
     *         },
     *         {
     *             "maintenanceId": 43,
     *             "maintenanceCompanyId": 3,
     *             "isDeleted": null,
     *             "insertTime": "2021-07-14 21:55:19",
     *             "updateTime": null,
     *             "orderType": "wash",
     *             "foodCompanyId": 2,
     *             "oneProcessorId": 0,
     *             "processorId": null,
     *             "money": 20.0,
     *             "orderStatus": 1,
     *             "genType": "系统生成",
     *             "batch": null,
     *             "time": "2021-07-14 21:55:16",
     *             "maintenanceTimeseg": null,
     *             "remark": null,
     *             "warnId": null,
     *             "orderNumber": "162627091984343",
     *             "flowNum": null,
     *             "devices": {
     *                 "normal": [],
     *                 "earlyWarning": [],
     *                 "alarm": [
     *                     {
     *                         "deviceId": "20210532",
     *                         "seqNum": null,
     *                         "gateId": null
     *                     }
     *                 ]
     *             },
     *             "insertTimeStart": null,
     *             "insertTimeEnd": null,
     *             "pageNumber": 0,
     *             "outSelectSerial": 0,
     *             "selectFlag": null,
     *             "companyName": "常德津市特色牛肉面馆",
     *             "phone": "13132746992",
     *             "address": "",
     *             "processorIdArray": null,
     *             "dispatchTime": null,
     *             "clientEstimate": null,
     *             "signImg": null,
     *             "missionImg": null,
     *             "acceptanceTime": null,
     *             "updateDispatchTime": null
     *         }
     *     ]
     * }
     *
     * @apiErrorExample {json} 返回失败样例：
     * {
     *     "code": "2001",
     * 	   "Message": "数据库执行有异常"
     * }
     */
    //@Scheduled(cron = "0 0 4 * * ?")    //每天凌晨4点执行
    @GetMapping("/auto/generated")
    public CommonResult autoGenOrders() throws Exception {
        log.info("每天固定时间查看是否需要自动生成订单");
        return orderService.autoGenOrders();
    }

    /**
     * @api {post} /order/update/status 更新订单状态
     * @apiVersion 0.0.1
     * @apiDescription  根据订单号更新订单状态，目前仅供用户支付后更改订单状态使用，其它某些地方使用会出问题。
     * @apiGroup operation-订单管理
     *
     * @apiParam(入参) {int} orderStatus 订单状态 (1：已分配（已分配到公司） 2:待确认（等待餐饮企业确认订单） 3：待派单（等待公司派单到员工）  4：待处理（等待员工处理）  5、已完成（含餐饮签名的照片上传）），必填
     * @apiParam(入参) {String} orderNumber 订单编号，必填
     * @apiParamExample {json} 入参样例：
     * {
     *     "orderNumber": "161797298403681",
     *     "orderStatus": 3
     * }
     *
     * @apiSuccess(出参) {String} Code 接口返回编码；200-更新订单状态成功；2001-数据库执行有异常；1201-请求条件中，缺少必填参数；
     * @apiSuccess(出参) {String} Message 消息描述
     * @apiSuccessExample {json} 返回成功样例：
     * {
     *     "code": 200,
     *     "message": "更新订单状态成功"
     * }
     *
     * @apiErrorExample {json} 返回失败样例：
     * {
     *     "Code": "2001",
     * 	   "Message": "数据库执行有异常"
     * }
     */
    @ApiOperation("更新订单状态")
    @PostMapping("update/status")
    public CommonResult updateStatus(@RequestBody String json) throws Exception {
        log.info("updateStatus==>"+json);
        return orderService.updateStatusByOrderNumber(json);
    }
}
