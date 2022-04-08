package cn.guet.kitchen.service;

import cn.guet.kitchen.entity.CommonResult;

/**
 * @introduce:
 * @author: cyan
 * @DATE: 2021/4/2
 **/
public interface FoodCompanyService {
    CommonResult insertSelective(String json);

    CommonResult deleteByPrimaryKey(int companyId);

    CommonResult updateByPrimaryKey(String json);

    CommonResult selectByPrimaryKey(Integer companyId);


}
