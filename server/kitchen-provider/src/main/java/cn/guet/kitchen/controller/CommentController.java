package cn.guet.kitchen.controller;

import cn.guet.kitchen.entity.Comment;
import cn.guet.kitchen.service.CommentService;
import cn.guet.kitchen.entity.CommonResult;
import com.alibaba.fastjson.JSON;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;


@RestController
@Slf4j  //打印日志
@RequestMapping(value = "/assess")
public class CommentController {
    @Resource
    private CommentService commentService;
    /**
     * @api {post} /assess/food/insert 餐饮企业评价
     * @apiVersion 0.0.1
     * @apiDescription  餐饮企业员工对运维/维保公司员工完成的订单进行评价。
     * @apiGroup Common-评价
     * @apiParam(入参) {String} userId 用户ID，必填
     * @apiParam(入参) {String} orderNumber 订单编号，必填
     * @apiParam(入参) {double} clientEstimate 客户满意度（5星制：1-5），必填
     * @apiParam(入参) {String} content 评价内容（不超255字节）
     * @apiParamExample {json} 入参样例：
     *
     * {
     *     "orderNumber": "161797298403681",
     *     "userId": 4543565,
     *     "clientEstimate": 3.5,
     *     "content": "很好！"
     * }
     *
     * @apiSuccess(出参) {String} Code 接口返回编码；200-评价成功；1201-请求条件中，缺少必填参数；2001-数据库执行有异常；
     * @apiSuccess(出参) {String} Message 消息描述
     * @apiSuccess(出参) {String} acceptanceTime 上传时间
     *
     * @apiSuccessExample {json} 返回成功样例：
     * {
     *     "code": 200,
     *     "message": "上传成功",
     *     "data": {
     *         "orderStatus": 4,
     *         "orderNumber": "161797298403681",
     *         "clientEstimate": 1,
     *         "signImg": "xxx",
     *         "missionImg": "yyy",
     *         "acceptanceTime": "2021-04-16 13:39:10"
     *     }
     * }
     *
     * @apiErrorExample {json} 返回失败样例：
     * {
     *     "code": "2001",
     * 	   "Message": "数据库执行有异常"
     * }
     */
    @ApiOperation("订单评价")
    @PostMapping("/food/insert")
    public CommonResult assessFoodInsert(@RequestBody String json) throws Exception {
        log.info("assessFoodJson==>"+json);
        Comment comment = JSON.parseObject(json, Comment.class);//转化为实体类
        return commentService.insertSelective(comment);
    }

    /**
     * @api {get} /assess/food/select?userId=4543565 评价查询
     * @apiVersion 0.0.1
     * @apiDescription  根据用户ID查询该用户对订单的评价。
     * @apiGroup Common-评价
     * @apiParam(入参) {String} userId 用户ID，必填
     *
     * @apiSuccess(出参) {String} Code 接口返回编码；200-查询成功；2001-数据库执行有异常；
     * @apiSuccess(出参) {String} Message 消息描述
     * @apiSuccess(出参) {String} commentTime 评论时间
     *
     * @apiSuccessExample {json} 返回成功样例：
     * {
     *     "code": 200,
     *     "message": "查询成功",
     *     "data": [
     *         {
     *             "id": 1,
     *             "moduleId": null,
     *             "module": null,
     *             "userId": "4543565",
     *             "orderNumber": "161797298403681",
     *             "content": "很好！",
     *             "commentTime": "2021-04-28 13:49:32.0",
     *             "isDeleted": false,
     *             "clientEstimate": 3.5
     *         },
     *         {
     *             "id": 2,
     *             "moduleId": null,
     *             "module": null,
     *             "userId": "4543565",
     *             "orderNumber": "161820642138668",
     *             "content": "很棒！",
     *             "commentTime": "2021-04-28 15:14:01.0",
     *             "isDeleted": false,
     *             "clientEstimate": 4.0
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
    @ApiOperation("评价查询")
    @GetMapping("/food/select")
    public CommonResult assessFoodSelect(@RequestParam String userId) throws Exception {
        log.info("assessFoodSelect==>"+userId);
        return commentService.selectInfoByUserId(userId);
    }
}
