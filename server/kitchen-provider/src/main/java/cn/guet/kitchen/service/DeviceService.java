package cn.guet.kitchen.service;

import cn.guet.kitchen.entity.CommonResult;

/**
 * @introduce:
 * @author: cyan
 * @DATE: 2021/4/7
 **/
public interface DeviceService {
    CommonResult insertSelective(String json);

    CommonResult deleteByPrimaryKey(String deviceId);

    //int insert(Device record);

    //Device selectByPrimaryKey(String deviceId);

    //int updateByPrimaryKeySelective(Device record);

    CommonResult updateByPrimaryKey(String json);
    CommonResult selectDevice(String json);
}
