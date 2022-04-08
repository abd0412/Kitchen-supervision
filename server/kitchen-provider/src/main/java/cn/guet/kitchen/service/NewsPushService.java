package cn.guet.kitchen.service;

import cn.guet.kitchen.entity.CommonResult;

public interface NewsPushService {
    CommonResult selectPushInfo();
    CommonResult selectByCompanyIdAndType(int companyId, String companyType);
}
