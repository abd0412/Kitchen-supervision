package cn.guet.kitchen.service;

import com.alibaba.fastjson.JSONObject;

import java.io.IOException;
import java.security.GeneralSecurityException;

public interface MiniProgramPaymentService {
    JSONObject getAccessToken(String appletsType, String grant_type) throws Exception;
    JSONObject toObtainOpenid(String appletsType, String js_code, String grant_type);
    JSONObject getPrepaidOrder(String json) throws Exception;
    JSONObject toReceiveNotification(String weChatPayTimestamp, String weChatPayNonce, String requestBody, String weChatPaySerial, String weChatPaySignature) throws GeneralSecurityException, IOException;
    JSONObject toStatusSelect(String mchid, String out_trade_no);
}
