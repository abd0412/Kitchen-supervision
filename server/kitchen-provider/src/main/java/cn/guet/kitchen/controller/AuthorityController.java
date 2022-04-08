package cn.guet.kitchen.controller;

import cn.guet.kitchen.service.AuthorityService;
import cn.guet.kitchen.entity.CommonResult;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @introduce:
 * @author: cyan
 * @DATE: 2021/4/10
 **/
@RestController
@Slf4j
@RequestMapping(value = "/authority")
public class AuthorityController {
    @Resource
    private AuthorityService authorityService;

    /**
     * @api {post} /authority/add 新增权限
     * @apiVersion 0.0.1
     * @apiDescription  运维端管理系统-权限管理-新增权限接口说明。
     * @apiGroup operation-权限管理
     * @apiParam(入参) {String} userType 用户类型（运维公司、餐饮企业、监管部门、维保公司）。
     * @apiParam(入参) {String} authorityName 权限名称（增、删、改、查）
     * @apiParam(入参) {String} authorityCode 权限编码（add、delete、update、select）
     * @apiParamExample {json} 入参样例：
     * {
     *     "userType": "运维",
     *     "authorityName": "增",
     *     "authorityCode": "add"
     * }
     *
     * @apiSuccess(出参) {String} Code 接口返回编码；200-新增成功；1201-请求条件中，缺少必填参数；2001-数据库执行有异常；
     * @apiSuccess(出参) {String} Message 消息描述
     * @apiSuccess(出参) {int} authorityId 权限ID（唯一识别，系统生成）
     * @apiSuccessExample {json} 返回成功样例：
     * {
     *     "code": 200,
     *     "message": "新增成功",
     *     "data": {
     *         "authorityId": 1,
     *         "userType": "运维",
     *         "authorityName": "增",
     *         "authorityCode": "add",
     *         "createTime": "2021-04-10 21:48:27",
     *         "modifiedTime": null,
     *         "isDeleted": null
     *     }
     * }
     *
     * @apiErrorExample {json} 返回失败样例：
     * {
     *     "Code": "2001",
     * 	   "Message": "数据库执行有异常"
     * }
     */

    @ApiOperation("新增权限")
    @PostMapping("/add")
    public CommonResult addAuthority(@RequestBody String json) throws Exception {
        System.out.println("addAuthorityJson==>"+json);
        return authorityService.insertSelective(json);
    }

    /**
     * @api {get} /authority/delete?authorityId=1 删除权限
     * @apiVersion 0.0.1
     * @apiDescription  运维端管理系统-权限管理-删除权限接口说明。
     * @apiGroup operation-权限管理
     * @apiParam(入参) {String} authorityId 权限ID（唯一识别），必填。
     *
     * @apiSuccess(出参) {String} Code 接口返回编码；200-删除成功；1201-请求条件中，缺少必填参数；2001-数据库执行有异常；
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
    @ApiOperation("删除权限")
    @GetMapping("/delete")
    public CommonResult deleteAuthority(@RequestParam int authorityId) throws Exception {
        System.out.println("deleteAuthority==>"+authorityId);
        return authorityService.deleteByPrimaryKey(authorityId);
    }

    /**
     * @api {post} /authority/update 修改权限
     * @apiVersion 0.0.1
     * @apiDescription  运维端管理系统-权限管理-修改权限接口说明。
     * @apiGroup operation-权限管理
     * @apiParam(入参) {int} authority_id 权限ID（唯一识别），不可修改，必填。
     * @apiParam(入参) {String} userType 用户类型（运维公司、餐饮企业、监管部门、维保公司）。
     * @apiParam(入参) {String} authorityName 权限名称（增、删、改、查）
     * @apiParam(入参) {String} authorityCode 权限编码（add、delete、update、select）
     * @apiParamExample {json} 入参样例：
     * {
     *     "authorityId": 1
     *     "userType": "运维公司",
     *     "authorityName": "增",
     *     "authorityCode": "add"
     * }
     *
     * @apiSuccess(出参) {String} Code 接口返回编码；200-修改成功；1201-请求条件中，缺少必填参数；2001-数据库执行有异常；
     * @apiSuccess(出参) {String} Message 消息描述
     *
     * @apiSuccessExample {json} 返回成功样例：
     * {
     *     "code": 200,
     *     "message": "更新成功",
     *     "data": {
     *         "authorityId": 1,
     *         "userType": "运维公司",
     *         "authorityName": "增",
     *         "authorityCode": "add",
     *         "createTime": "2021-04-10 21:48:27.0",
     *         "modifiedTime": "2021-04-10 22:06:05.0",
     *         "isDeleted": false
     *     }
     * }
     *
     * @apiErrorExample {json} 返回失败样例：
     * {
     *     "Code": "2001",
     * 	   "Message": "数据库执行有异常"
     * }
     */

    @ApiOperation("修改权限")
    @PostMapping("/update")
    public CommonResult updateAuthority(@RequestBody String json) throws Exception {
        System.out.println("updateAuthorityJson==>"+json);
        return authorityService.updateByPrimaryKeySelective(json);
    }

    /**
     * @api {get} /authority/userType/select?userType=运维公司 查询权限
     * @apiVersion 0.0.1
     * @apiDescription  运维端管理系统-权限管理-查询权限接口说明，以用户类型为单位进行查询。
     * @apiGroup operation-权限管理
     * @apiParam(入参) {String} userType 用户类型（运维公司、餐饮企业、监管部门、维保公司）。
     *
     * @apiSuccess(出参) {String} Code 接口返回编码；200-设备查询成功；2001-数据库执行有异常；
     * @apiSuccess(出参) {String} Message 消息描述
     * @apiSuccess(出参) {String} deviceId 设备编号
     * @apiSuccess(出参) {array} authorityNameList 查询结果集
     * @apiSuccess(出参) {String} authority_name 权限名称
     *
     * @apiSuccessExample {json} 返回成功样例：
     * {
     *     "code": 200,
     *     "message": "查询成功",
     *     "data": {
     *         "authorityNameList": [
     *             {
     *                 "authority_name": "删"
     *             },
     *             {
     *                 "authority_name": "改"
     *             }
     *         ]
     *     }
     * }
     * @apiErrorExample {json} 返回失败样例：
     * {
     *     "Code": "2001",
     * 	   "Message": "数据库执行有异常"
     * }
     */
    @ApiOperation("对应查询权限")
    @PostMapping("/userType/select")
    public CommonResult selectAuthority(@RequestParam String userType) throws Exception {
        System.out.println("selectAuthority==>"+userType);
        return authorityService.selectByUserType(userType);
    }

    /**
     * @api {get} /authority/all/select 查询所有权限信息
     * @apiVersion 0.0.1
     * @apiDescription  运维端管理系统-权限管理-查询所有权限信息接口说明，没有入参。
     * @apiGroup operation-权限管理
     *
     * @apiSuccess(出参) {String} Code 接口返回编码；200-设备查询成功；2001-数据库执行有异常；
     * @apiSuccess(出参) {String} Message 消息描述
     * @apiSuccess(出参) {String} deviceId 设备编号
     * @apiSuccess(出参) {array} authorityList 查询结果集
     *
     * @apiSuccessExample {json} 返回成功样例：
     * {
     *     "code": 200,
     *     "message": "查询成功",
     *     "data": {
     *         "authorityList": [
     *             {
     *                 "authorityId": 2,
     *                 "userType": "运维公司",
     *                 "authorityName": "删",
     *                 "authorityCode": "delect",
     *                 "createTime": "2021-04-10 22:24:52.0",
     *                 "modifiedTime": null,
     *                 "isDeleted": false
     *             },
     *             {
     *                 "authorityId": 3,
     *                 "userType": "运维公司",
     *                 "authorityName": "改",
     *                 "authorityCode": "update",
     *                 "createTime": "2021-04-10 22:25:10.0",
     *                 "modifiedTime": null,
     *                 "isDeleted": false
     *             }
     *         ]
     *     }
     * }
     * @apiErrorExample {json} 返回失败样例：
     * {
     *     "Code": "2001",
     * 	   "Message": "数据库执行有异常"
     * }
     */
    @ApiOperation("查询所有权限")
    @GetMapping("/all/select")
    public CommonResult allSelectAuthority() throws Exception {
        return authorityService.selectAllInfo();
    }
}
