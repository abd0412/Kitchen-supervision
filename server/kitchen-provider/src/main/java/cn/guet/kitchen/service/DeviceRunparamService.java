package cn.guet.kitchen.service;

import cn.guet.kitchen.entity.CommonResult;

/**
 * @introduce:
 * @author: cyan
 * @DATE: 2021/4/9
 **/
public interface DeviceRunparamService {
    //int deleteByPrimaryKey(String deviceId);

    //int insert(DeviceRunparam record);

    //int insertSelective(DeviceRunparam record);

    //DeviceRunparam selectByPrimaryKey(String deviceId);

    //int updateByPrimaryKeySelective(DeviceRunparam record);

    //int updateByPrimaryKey(DeviceRunparam record);
    CommonResult selectByStatus(String status, int companyId);
    CommonResult selectMonitorInfo(String deviceId);
}
