package cn.guet.kitchen.service;

import cn.guet.kitchen.entity.NetworkGate;
import cn.guet.kitchen.entity.CommonResult;

public interface NetworkGateService {
    CommonResult deleteByPrimaryKey(Integer id);

    CommonResult insertSelective(NetworkGate record);

    CommonResult selectBySomeKey(NetworkGate record);

    CommonResult updateByPrimaryKeySelective(NetworkGate record);
}
