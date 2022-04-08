package cn.guet.kitchen.service;

import cn.guet.kitchen.entity.CommonResult;

/**
 * @introduce:
 * @author: cyan
 * @DATE: 2021/4/10
 **/
public interface AuthorityService {
    CommonResult insertSelective(String json);

    CommonResult deleteByPrimaryKey(int authorityId);

    CommonResult updateByPrimaryKeySelective(String json);

    CommonResult selectByUserType(String userType);

    CommonResult selectAllInfo();
    //int insert(Authority record);
    //int updateByPrimaryKey(Authority record);
}
