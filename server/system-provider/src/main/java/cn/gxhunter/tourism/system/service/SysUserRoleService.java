package cn.gxhunter.tourism.system.service;

import cn.gxhunter.tourism.common.entity.SysUserRole;

import java.util.List;

public interface SysUserRoleService {


    int deleteByPrimaryKey(Integer id);

    int insert(SysUserRole record);

    int insertSelective(SysUserRole record);

    SysUserRole selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SysUserRole record);

    int updateByPrimaryKey(SysUserRole record);

    int updateBatch(List<SysUserRole> list);

    int updateBatchSelective(List<SysUserRole> list);

    int batchInsert(List<SysUserRole> list);

    //获取用户角色
    List<SysUserRole> listSysUserRoleByUserId(Integer userId);

    //更新用户角色
    int updateSysUserRole(Integer sysUserId, List<Integer>sysRoleIds, Integer editerId);
}



