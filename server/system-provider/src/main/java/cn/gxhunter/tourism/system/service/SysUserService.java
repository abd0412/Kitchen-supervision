package cn.gxhunter.tourism.system.service;

import cn.gxhunter.tourism.common.entity.SysUser;

import java.util.List;

public interface SysUserService {


    int deleteByPrimaryKey(Integer id);

    int insert(SysUser record);

    int insertSelective(SysUser record);

    SysUser selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SysUser record);

    int updateByPrimaryKey(SysUser record);

    int updateBatch(List<SysUser> list);

    int updateBatchSelective(List<SysUser> list);

    int batchInsert(List<SysUser> list);

    //根据用户名模糊分页查询用户列表
    List<SysUser> list(String userName, String name, Integer pageNo, Integer pageSize);

    //分页查询对应记录总数
    int count(String userName, String name);

    //根据用户名列表,获取用户列表
    List<SysUser> selectByUserNames(List<String> userNames);

    //根据用户名,获取用户信息
    SysUser selectByName(String username);
}





