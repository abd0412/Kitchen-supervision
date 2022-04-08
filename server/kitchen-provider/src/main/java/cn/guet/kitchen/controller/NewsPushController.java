package cn.guet.kitchen.controller;

import cn.guet.kitchen.entity.CommonResult;
import cn.guet.kitchen.service.NewsPushService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author cyan
 */
@RestController
@Slf4j
@RequestMapping(value = "/news")
public class NewsPushController {
    @Resource
    private NewsPushService newsPushService;

    /**
     * @api {get} /news/push 消息推送
     * @apiVersion 0.0.1
     * @apiDescription 推送消息：预警/报警、会员到期。
     * @apiGroup restaurant-消息推送
     * @apiSuccess(出参) {String} Code 接口返回编码；200-消息更新成功；2001-数据库执行有异常；
     * @apiSuccess(出参) {String} Message 消息描述
     * @apiSuccess(出参) {array} memberExpire 所有的会员即将到期列表。例：Id为1的餐饮企业会员即将过期，可通知的人员有两位；若有其它餐饮企业会员即将过期，类似前述信息也会出现在这里。
     * @apiSuccess(出参) {array} abnormalDeviceInfo 所有的预警/报警设备列表。数组里是：哪家的哪个设备出现故障可通知哪些人员。
     * @apiSuccess(出参) {int} device_id改为id，意仍为设备ID
     * @apiSuccessExample {json} 返回成功样例：
     * {
     * "code": 200,
     * "message": "消息更新成功",
     * "data": {
     * "memberExpire": [
     * {
     * "company_id": 1,
     * "openid": "oBtC65KeWP0E_FFe8trbI3RuBJ0B",
     * "message": "会员即将到期"
     * },
     * {
     * "company_id": 1,
     * "openid": "sfggr68599",
     * "message": "会员即将到期"
     * }
     * ],
     * "abnormalDeviceInfo": [
     * {
     * "id": 20210410,
     * "company_id": 2,
     * "openid": "235295034gfdsfg",
     * "warn_message": "预警"
     * },
     * {
     * "id": 20210410,
     * "company_id": 2,
     * "openid": "oBtC65KeWP0E_FFe8trbI3RuBJ0A",
     * "warn_message": "预警"
     * }
     * ]
     * }
     * }
     * @apiErrorExample {json} 返回失败样例：
     * {
     * "Code": "2001",
     * "Message": "数据库执行有异常"
     * }
     */
    @ApiOperation("消息推送")
    @GetMapping("/push")
    public CommonResult newsPush() throws Exception {
        return newsPushService.selectPushInfo();
    }

    /**
     * @api {get} /news/list?companyId=1&companyType=repast 获取消息
     * @apiVersion 0.0.1
     * @apiDescription 获取某企业/公司的所有消息。
     * @apiGroup Common-获取消息
     * @apiParam(入参) {int} companyId 公司ID，取值是系统生成的，必填
     * @apiParam(入参) {String} companyType 公司类型，必填，取值为：餐饮：repast；运维：operation；维保：maintenance
     * @apiSuccess(出参) {String} Code 接口返回编码；200-消息更新成功；2001-数据库执行有异常；
     * @apiSuccess(出参) {String} Message 消息描述
     * @apiSuccess(出参) {array} newsList 消息列表
     * @apiSuccessExample {json} 返回成功样例：
     * {
     *     "code": 200,
     *     "message": "获取消息成功",
     *     "data": {
     *         "newsList": [
     *             {
     *                 "id": 4,
     *                 "articleTypeCode": "message",
     *                 "articleTypeName": "消息",
     *                 "title": "关于食在不一样餐饮企业欠费通知",
     *                 "content": "关于食在不一样餐饮企业欠费通知关于食在不一样餐饮企业欠费通知关于食在不一样餐饮企业欠费通知关于食在不一样餐饮企业欠费通知关于食在不一样餐饮企业欠费通知关于食在不一样餐饮企业欠费通知关于食在不一样餐饮企业欠费通知关于食在不一样餐饮企业欠费通知关于食在不一样餐饮企业欠费通知关于食在不一样餐饮企业欠费通知关于食在不一样餐饮企业欠费通知关于食在不一样餐饮企业欠费通知关于食在不一样餐饮企业欠费通知关于食在不一样餐饮企业欠费通知关于食在不一样餐饮企业欠费通知关于食在不一样餐饮企业欠费通知关于食在不一样餐饮企业欠费通知",
     *                 "releaseTime": "2021-07-25T12:21:38.000+0000",
     *                 "issuer": "李思琪",
     *                 "playCount": 23,
     *                 "isRecommend": true,
     *                 "createTime": "2021-07-12T09:31:55.000+0000",
     *                 "modifiedTime": "2021-07-12T09:31:55.000+0000",
     *                 "isDeleted": false,
     *                 "isEnable": true,
     *                 "typeId": null,
     *                 "adminCode": "",
     *                 "moduleCode": "food_company",
     *                 "moduleId": 1
     *             },
     *             {
     *                 "id": 5,
     *                 "articleTypeCode": "message",
     *                 "articleTypeName": "消息",
     *                 "title": "怪味青年螺蛳粉设备连续预警7天",
     *                 "content": "怪味青年螺蛳粉设备连续预警7天怪味青年螺蛳粉设备连续预警7天怪味青年螺蛳粉设备连续预警7天怪味青年螺蛳粉设备连续预警7天怪味青年螺蛳粉设备连续预警7天怪味青年螺蛳粉设备连续预警7天怪味青年螺蛳粉设备连续预警7天怪味青年螺蛳粉设备连续预警7天怪味青年螺蛳粉设备连续预警7天怪味青年螺蛳粉设备连续预警7天怪味青年螺蛳粉设备连续预警7天怪味青年螺蛳粉设备连续预警7天怪味青年螺蛳粉设备连续预警7天怪味青年螺蛳粉设备连续预警7天怪味青年螺蛳粉设备连续预警7天",
     *                 "releaseTime": "2021-07-25T12:30:18.000+0000",
     *                 "issuer": "黄铭",
     *                 "playCount": 34,
     *                 "isRecommend": true,
     *                 "createTime": "2021-07-12T09:31:55.000+0000",
     *                 "modifiedTime": "2021-07-12T09:31:55.000+0000",
     *                 "isDeleted": false,
     *                 "isEnable": true,
     *                 "typeId": null,
     *                 "adminCode": "",
     *                 "moduleCode": "food_company",
     *                 "moduleId": 1
     *             }
     *         ]
     *     }
     * }
     * @apiErrorExample {json} 返回失败样例：
     * {
     * "Code": "2001",
     * "Message": "数据库执行有异常"
     * }
     */
    @ApiOperation("获取消息")
    @GetMapping("/list")
    public CommonResult newsList(@RequestParam int companyId, @RequestParam String companyType) throws Exception {
        log.info("companyId==>" + companyId);
        log.info("companyType==>" + companyType);
        return newsPushService.selectByCompanyIdAndType(companyId, companyType);
    }
}
