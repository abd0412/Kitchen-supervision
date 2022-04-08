package cn.guet.kitchen.controller;

import cn.guet.kitchen.service.MiniProgramPaymentService;
import com.alibaba.fastjson.JSONObject;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;

@RequestMapping(value = "/payment")
@RestController
@Slf4j
public class MiniProgramPaymentController {
    @Resource
    private MiniProgramPaymentService miniProgramPaymentService;

    /**
     * @api {get} /payment/access/token?appletsType=repast&grant_type=client_credential 获取token
     * @apiVersion 0.0.1
     * @apiDescription 获取小程序全局唯一后台接口调用凭据（access_token）。
     * @apiGroup MiniProgram-支付
     * @apiParam(入参) {string} appletsType 用来区分获取哪个小程序的相关信息，必填，取值为：餐饮企业小程序：repast；运维小程序：operation；维保小程序：maintenance
     * @apiParam(入参) {string} grant_type 填写 client_credential，必填
     *
     * @apiSuccess(出参) {string} access_token 获取到的凭证
     * @apiSuccess(出参) {int} expires_in 凭证有效时间，单位：秒。目前是7200秒之内的值。
     * @apiSuccess(出参) {int} errcode 的合法值：-1	系统繁忙，此时请开发者稍候再试；0	请求成功；40001	AppSecret 错误或者 AppSecret 不属于这个小程序，请开发者确认 AppSecret 的正确性；40002	请确保 grant_type 字段值为 client_credential；40013	不合法的 AppID，请开发者检查 AppID 的正确性，避免异常字符，注意大小写。
     * @apiSuccess(出参) {string} errmsg 错误信息
     * @apiSuccessExample {json} 返回成功样例：
     * {
     *     "access_token": "44_cSxcYHErmAJT3SBdDer_fOR8ErQPAhxFds_PNtmfLHQXBCeberYn-vWKExfDh7fsOXPOcME34eSn40f3z4xxx_l5MN3SBSMMwL_3fSCvJNaE1c66U-HHby_rnHka8Qo-oHBTJGGba46qu0fbOKQbAGAVRX",
     *     "expires_in": 7200
     * }
     *
     * @apiErrorExample {json} 返回失败样例：
     * {
     *     "errcode": 40013,
     *     "errmsg": "invalid appid rid: 608b6fb5-64fd614c-0ed57e11"
     * }
     */

    @ApiOperation("获取token")
    @GetMapping("/access/token")
    public JSONObject accessToken(@RequestParam String appletsType, @RequestParam String grant_type) throws Exception {
        log.info("appletsType==>" + appletsType);
        log.info("grant_type==>" + grant_type);
        return miniProgramPaymentService.getAccessToken(appletsType, grant_type);
    }

    /**
     * @api {get} /payment/obtain/openid?appletsType=repast&js_code=JSCODE&grant_type=authorization_code 获取用户标识openid
     * @apiVersion 0.0.1
     * @apiDescription 主要获取用户在商户appid下的唯一标识openid。
     * @apiGroup Common-用户
     * @apiParam(入参) {string} appletsType 用来区分获取哪个小程序的相关信息，必填，取值为：餐饮企业小程序：repast；运维小程序：operation；维保小程序：maintenance
     * @apiParam(入参) {string} js_code 登录时获取的 code
     * @apiParam(入参) {string} grant_type 授权类型，此处只需填写 authorization_code
     */

    @ApiOperation("获取用户标识openid")
    @GetMapping("/obtain/openid")
    public JSONObject obtainOpenid(@RequestParam String appletsType, @RequestParam String js_code, @RequestParam String grant_type) throws Exception {
        log.info("obtainOpenidAppletsType==>"+appletsType);
        log.info("obtainOpenidJs_code==>"+js_code);
        log.info("obtainOpenidGrant_type==>"+grant_type);
        return miniProgramPaymentService.toObtainOpenid(appletsType, js_code, grant_type);
    }

    /**
     * @api {post} /payment/prepaid/order 生成预付单
     * @apiVersion 0.0.1
     * @apiDescription 在微信小程序对订单进行下单，发起支付，生成预付单（1-6）。
     * @apiGroup MiniProgram-支付
     * @apiParam(入参) {string} out_trade_no 订单号，必填
     * @apiParam(入参) {string} description 商品描述，Image形象店-深圳腾大-QQ公仔，必填
     * @apiParam(入参) {object} payer 支付者，必填
     * @apiParam(入参) {string} openid 用户标识，父级payer，必填
     * @apiParam(入参) {object} amount 订单金额，必填
     * @apiParam(入参) {int} total 订单总金额，单位为分，父级amount，必填
     * @apiParam(入参) {object} currency 货币类型，CNY：人民币，境内商户号仅支持人民币，父级amount。
     * @apiParam(入参) {string} appletsType 用来区分获取哪个小程序的相关信息，必填，餐饮企业为：repast。
     * @apiParamExample {json} 入参样例：
     * {
     *     "out_trade_no": "1217752501201407033233368318",
     *     "description": "Image形象店-深圳腾大-QQ公仔",
     *     "amount": {
     *         "total": 1,
     *         "currency": "CNY"
     *     },
     *     "payer": {
     *         "openid": "oBtC65KeWP0E_FFe8trbI3RuBJ0A"
     *     },
     *     "appletsType": "repast"
     * }
     * @apiSuccess(出参) {string} prepay_id 预支付交易会话标识，预支付交易会话标识。用于后续接口调用中使用，该值有效期为2小时
     * @apiSuccessExample {json} 返回成功样例：
     * {
     *     "timeStamp": 1620805873,
     *     "paySign": "JkRR5QCDk0rOlbhcwoGnUtXo+Ae7j5Xc0INgldLanAR76QUQghoKehbmSDheqKXaPU7nKkJE/E3d7QzkAG56L8T2TBwpWF3PYw8onIIXEtdJYCYAvECl9glQ5LJd4OArk4fOKCi5RUIoM2mjYM5KyQI7TkXPiQho3qGueitdCwezHMAFHUnazCpJU6jyjWcdZ2Zp5XD8aQ2hS5CecVFDkAVCRtju3d6dqoiJfvWnNtNObP9Z+zaykLFTTjPvk9dDQDs+SSzEJNJX7JFire8qwroAduuOQjltndTySRiOyJ1VTokU9W174j7a9Y/0wLOIxGC52OoEK7kyJXWGIDz9zw==",
     *     "appid": "wxc2c2d16a2d9ab49d",
     *     "nonceStr": "M4vmagsg8WN2C9x5Oktk5XwzUaH50aMW",
     *     "prepay_id": "wx1215511458536182505793acb197ac0000"
     * }
     *
     */
    @ApiOperation("生成预付单")
    @PostMapping("/prepaid/order")
    public JSONObject prepaidOrder(@RequestBody String json) throws Exception {
        log.info("prepaidOrder==>"+json);
        return miniProgramPaymentService.getPrepaidOrder(json);
    }

    /**
     * @api {post} /payment/receive/notification 接收通知（微信支付系统调用）
     * @apiVersion 0.0.1
     * @apiDescription 微信支付通过支付通知接口将用户支付成功消息通知给商户。
     * @apiGroup MiniProgram-支付
     * @apiParamExample {json} 入参样例：
     * {
     *     "id":"EV-2018022511223320873",
     *     "create_time":"2015-05-20T13:29:35+08:00",
     *     "resource_type":"encrypt-resource",
     *     "event_type":"TRANSACTION.SUCCESS",
     *     "resource":{
     *         "algorithm":"AEAD_AES_256_GCM",
     *         "ciphertext":"...",
     *         "nonce":"...",
     *         "original_type":"transaction",
     *         "associated_data":""
     *     },
     *     "summary":"支付成功"
     * }
     * @apiParamExample {json} 解密参数：
     * {
     *     "mchid": "1608995427",
     *     "appid": "wxc2c2d16a2d9ab49d",
     *     "out_trade_no": "162090628514989",
     *     "transaction_id": "4200001043202105133398534300",
     *     "trade_type": "JSAPI",
     *     "trade_state": "SUCCESS",
     *     "trade_state_desc": "支付成功",
     *     "bank_type": "OTHERS",
     *     "attach": "",
     *     "success_time": "2021-05-13T19:46:36+08:00",
     *     "payer": {
     *         "openid": "oBtC65KeWP0E_FFe8trbI3RuBJ0A"
     *     },
     *     "amount": {
     *         "total": 1,
     *         "payer_total": 1,
     *         "currency": "CNY",
     *         "payer_currency": "CNY"
     *     }
     * }
     *
     * @apiSuccessExample {json} 返回成功样例：
     * {
     *     "code": "SUCCESS",
     *     "message": "成功"
     * }
     */
    @ApiOperation("接收通知")
    @PostMapping("/receive/notification")
    public void receiveNotification(HttpServletRequest request, HttpServletResponse response, BufferedReader br) throws Exception {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json;charset=UTF-8");
        String inputLine;
        String requestBody = "";
        JSONObject responseJSON;
        String weChatPayTimestamp = request.getHeader("Wechatpay-Timestamp");
        System.out.println("Wechatpay-Timestamp==>"+weChatPayTimestamp);
        String weChatPayNonce = request.getHeader("Wechatpay-Nonce");
        System.out.println("Wechatpay-Nonce==>"+weChatPayNonce);
        String weChatPaySerial = request.getHeader("Wechatpay-Serial");
        System.out.println("Wechatpay-Serial==>"+weChatPaySerial);
        String weChatPaySignature = request.getHeader("Wechatpay-Signature");
        System.out.println("Wechatpay-Signature==>"+weChatPaySignature);
        while ((inputLine = br.readLine()) != null) {
            requestBody += inputLine;
        }
        br.close();
        System.out.println("requestBody==>"+requestBody);
        responseJSON = miniProgramPaymentService.toReceiveNotification(weChatPayTimestamp, weChatPayNonce, requestBody, weChatPaySerial, weChatPaySignature);
        response.getWriter().write(String.valueOf(responseJSON));
        //response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        response.setStatus(HttpServletResponse.SC_OK);
        System.out.println("response===>"+response.getStatus());
    }

    /**
     * @api {get} /payment/status/select?mchid=1608995427&out_trade_no=161944758928971 支付状态查询
     * @apiVersion 0.0.1
     * @apiDescription 商户可以通过查询订单接口主动查询订单状态，完成下一步的业务逻辑。查询订单状态可通过微信支付订单号或商户订单号两种方式查询，这里通过商户订单号查询。
     * @apiGroup MiniProgram-支付
     * @apiParam(入参) {string} mchid 直连商户号，必填
     * @apiParam(入参) {string} out_trade_no 商户订单号，必填
     *
     * @apiSuccessExample {json} 返回成功样例：
     * {
     * 	"amount": {
     * 		"currency": "CNY",
     * 		"payer_currency": "CNY",
     * 		"payer_total": 1,
     * 		"total": 1
     *        },
     * 	"appid": "wxdace645e0bc2cXXX",
     * 	"attach": "",
     * 	"bank_type": "OTHERS",
     * 	"mchid": "1900006XXX",
     * 	"out_trade_no": "44_2126281063_5504",
     * 	"payer": {
     * 		"openid": "o4GgauJP_mgWEWictzA15WT15XXX"
     *    },
     * 	"promotion_detail": [],
     * 	"success_time": "2021-03-22T10:29:05+08:00",
     * 	"trade_state": "SUCCESS",
     * 	"trade_state_desc": "支付成功",
     * 	"trade_type": "JSAPI",
     * 	"transaction_id": "4200000891202103228088184743"
     * }
     */
    @ApiOperation("支付状态查询")
    @PostMapping("/status/select")
    public JSONObject statusSelect(@RequestParam String mchid, @RequestParam String out_trade_no) throws Exception {
        log.info("mchid==>"+mchid);
        log.info("out_trade_no==>"+out_trade_no);
        return miniProgramPaymentService.toStatusSelect(mchid, out_trade_no);
    }

    /*@Before
    public void setup() throws IOException {
        // 加载商户私钥（privateKey：私钥字符串）
        PrivateKey merchantPrivateKey = PemUtil
                .loadPrivateKey(new ByteArrayInputStream(privateKey.getBytes("utf-8")));

        // 加载平台证书（mchId：商户号,mchSerialNo：商户证书序列号,apiV3Key：V3密钥）
        String mchId = null;
        String mchSerialNo = null;
        ClassHistogramElement apiV3Key = null;
        AutoUpdateCertificatesVerifier verifier = new AutoUpdateCertificatesVerifier(
                new WechatPay2Credentials(mchId, new PrivateKeySigner(mchSerialNo, merchantPrivateKey)), apiV3Key.getBytes("utf-8"));

        // 初始化httpClient
        CloseableHttpClient httpClient = WechatPayHttpClientBuilder.create()
                .withMerchant(mchId, mchSerialNo, merchantPrivateKey)
                .withValidator(new WechatPay2Validator(verifier)).build();
    }

    @After
    public void after() throws IOException {
        httpClient.close();
    }*/
}
