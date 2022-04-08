package cn.guet.kitchen.service;

import cn.guet.kitchen.entity.CommonResult;

/**
 * @introduce:
 * @author: cyan
 * @DATE: 2021/4/5
 **/
public interface OperationCompanyService {
    CommonResult insertSelective(String json);

    CommonResult deleteByPrimaryKey(int operationCompanyId);

    CommonResult updateByPrimaryKey(String json);

    CommonResult selectByPrimaryKey(Integer operationCompanyId);
}
