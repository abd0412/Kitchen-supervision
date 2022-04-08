package cn.guet.kitchen.service;

import cn.guet.kitchen.entity.CommonResult;
import com.alibaba.fastjson.JSONObject;

public interface UserService {
    JSONObject check(String json);
    CommonResult recharge(String json);
    CommonResult overageSelect(String openid);
    void serviceFeeCalculation();
}
