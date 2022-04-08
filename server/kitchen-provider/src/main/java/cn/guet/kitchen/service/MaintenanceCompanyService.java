package cn.guet.kitchen.service;

import cn.guet.kitchen.entity.CommonResult;

/**
 * @introduce:
 * @author: cyan
 * @DATE: 2021/4/1
 **/
public interface MaintenanceCompanyService {
    CommonResult insertSelective(String json);

    CommonResult deleteByPrimaryKey(int maintenanceCompanyId);

    CommonResult selectByPrimaryKey(Integer maintenanceCompanyId);

    CommonResult updateByPrimaryKey(String json);
}
