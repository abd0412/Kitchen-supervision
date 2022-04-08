package cn.guet.kitchen.controller;

import cn.guet.kitchen.service.UserService;
import cn.guet.kitchen.entity.CommonResult;
import com.alibaba.fastjson.JSONObject;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@Slf4j
@RequestMapping(value = "/user")
public class UserController {
    @Resource
    private UserService userService;

    /**
     * @api {post} /user/login 用户登录
     * @apiVersion 0.0.1
     * @apiDescription  用户登录接口，通过公司ID和员工号校验
     * @apiGroup Common-用户
     * @apiParam(入参) {int} companyId 公司ID，必填。
     * @apiParam(入参) {String} userName 工号，必填，公司+工号要确保唯一性。
     * @apiParam(入参) {String} openid 用户唯一标识，必填。
     * @apiParam(入参) {String} phone 手机号
     * @apiParamExample {json} 入参样例：
     * {
     *     "companyId": 1,
     *     "userName": "admin",
     *     "phone": 15894568909,
     *     "openid": ""
     * }
     *
     * @apiSuccess(出参) {String} Code 接口返回编码；200-新增设备成功；1201-请求条件中，缺少必填参数；2001-无此用户，验证失败；
     * @apiSuccess(出参) {String} Message 消息描述
     *
     * @apiSuccessExample {json} 返回成功样例：
     * {
     *     "Message": "验证成功",
     *     "Code": 200
     * }
     *
     * @apiErrorExample {json} 返回失败样例：
     * {
     *     "Code": "2001",
     * 	   "Message": "无此用户，验证失败"
     * }
     */

    @ApiOperation("用户登录")
    @PostMapping("/login")
    public JSONObject userLogin(@RequestBody String json) throws Exception {
        System.out.println("userLoginJson==>"+json);
        return userService.check(json);
    }
    /**
     * @api {post} /user/recharge 用户充值
     * @apiVersion 0.0.1
     * @apiDescription  用户充值支付成功之后，调用这个接口。
     * @apiGroup Common-用户
     * @apiParam(入参) {String} openid 用户唯一标识
     * @apiParam(入参) {double} money 金额
     * @apiParamExample {json} 入参样例：
     * {
     *     "openid": "oBtC65KeWP0E_FFe8trbI3RuBJ0A",
     *     "money": 100.01
     * }
     *
     * @apiSuccess(出参) {String} Code 接口返回编码；200-充值成功；1201-请求条件中，缺少必填参数；2001-无此用户，充值失败；
     * @apiSuccess(出参) {String} Message 消息描述
     *
     * @apiSuccessExample {json} 返回成功样例：
     * {
     *     "Message": "充值成功",
     *     "Code": 200
     * }
     *
     * @apiErrorExample {json} 返回失败样例：
     * {
     *     "Code": "2001",
     * 	   "Message": "无此用户，充值失败"
     * }
     */

    @ApiOperation("用户充值")
    @PostMapping("/recharge")
    public CommonResult userRecharge(@RequestBody String json) throws Exception {
        System.out.println("userRechargeJson==>"+json);
        return userService.recharge(json);
    }

    /**
     * @api {get} /user/overage/select?openid=oBtC65KeWP0E_FFe8trbI3RuBJ0A 查询充值余额
     * @apiVersion 0.0.1
     * @apiDescription  查询充值余额。
     * @apiGroup Common-用户
     * @apiParam(入参) {String} openid 用户唯一标识

     * @apiSuccess(出参) {String} Code 接口返回编码；200-查询余额成功；2001-无此用户，查询失败；
     * @apiSuccess(出参) {String} Message 消息描述
     *
     * @apiSuccessExample {json} 返回成功样例：
     * {
     *     "code": 200,
     *     "message": "查询成功",
     *     "data": {
     *         "money": 299.91,
     *         "openid": "oBtC65KeWP0E_FFe8trbI3RuBJ0A"
     *     }
     * }
     *
     * @apiErrorExample {json} 返回失败样例：
     * {
     *     "code": 2001,
     *     "message": "无此用户，查询失败",
     *     "data": null
     * }
     */
    @ApiOperation("查询充值余额")
    @GetMapping("/overage/select")
    public CommonResult userOverageSelect(@RequestParam String openid) throws Exception {
        System.out.println("userOverageSelect==>"+openid);
        return userService.overageSelect(openid);
    }
    /**
     * @api {get} /user/serviceFee/calculation 平台服务扣费
     * @apiVersion 0.0.1
     * @apiDescription 每天上午9点系统后台自动从用户充值余额扣除当天平台服务费，非会员服务费：一天一元，会员服务费：年费/本年天数，会员可分种类。扣费信息有日志记录。
     * @apiGroup Common-用户
     */
    @ApiOperation("平台服务费计算")
    @Scheduled(cron = "0 0 9 * * ?")    //每天上午9点扣费
    @GetMapping("/serviceFee/calculation")
    public void userServiceFeeCalculation() throws Exception {
        userService.serviceFeeCalculation();
    }
}
