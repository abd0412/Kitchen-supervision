package cn.gxhunter.tourism.system.service;

import cn.gxhunter.tourism.common.entity.SysModule;

import java.util.List;

public interface SysModuleService {


    int deleteByPrimaryKey(Integer id);

    int insert(SysModule record);

    int insertSelective(SysModule record);

    SysModule selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SysModule record);

    int updateByPrimaryKey(SysModule record);

    int updateBatch(List<SysModule> list);

    int updateBatchSelective(List<SysModule> list);

    int batchInsert(List<SysModule> list);

}



