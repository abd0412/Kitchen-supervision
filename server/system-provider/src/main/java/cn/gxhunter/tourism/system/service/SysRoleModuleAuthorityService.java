package cn.gxhunter.tourism.system.service;

import cn.gxhunter.tourism.common.entity.SysRoleModuleAuthority;

import java.util.List;

public interface SysRoleModuleAuthorityService {


    int deleteByPrimaryKey(Integer id);

    int insert(SysRoleModuleAuthority record);

    int insertSelective(SysRoleModuleAuthority record);

    SysRoleModuleAuthority selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SysRoleModuleAuthority record);

    int updateByPrimaryKey(SysRoleModuleAuthority record);

    int updateBatch(List<SysRoleModuleAuthority> list);

    int updateBatchSelective(List<SysRoleModuleAuthority> list);

    int batchInsert(List<SysRoleModuleAuthority> list);

    //根据角色id,获取模块权限
    List<SysRoleModuleAuthority> listSysRoleModuleByRoleId(Integer roleId);

    //更新角色权限
    int updateSysRoleModule(List<SysRoleModuleAuthority> sysRoleModuleAuthorityList, Integer editerId);
}



