package cn.gxhunter.tourism.system.service;

import cn.gxhunter.tourism.common.entity.SysRole;

import java.util.List;

public interface SysRoleService {


    int deleteByPrimaryKey(Integer id);

    int insert(SysRole record);

    int insertSelective(SysRole record);

    SysRole selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SysRole record);

    int updateByPrimaryKey(SysRole record);

    int updateBatch(List<SysRole> list);

    int updateBatchSelective(List<SysRole> list);

    int batchInsert(List<SysRole> list);

    //条件分页查询
    List<SysRole> list(String name, Integer pageNo, Integer pageSize);

    //分页查询对应记录总数
    int count(String name);
}



