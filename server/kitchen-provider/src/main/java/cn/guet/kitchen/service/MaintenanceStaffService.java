package cn.guet.kitchen.service;

import cn.guet.kitchen.entity.CommonResult;

/**
 * @introduce:
 * @author: cyan
 * @DATE: 2021/4/2
 **/
public interface MaintenanceStaffService {
    CommonResult insertSelective(String json);

    CommonResult deleteByPrimaryKey(String json);

    CommonResult updateByPrimaryKey(String json);

    CommonResult selectByPrimaryKey(String json);
}
