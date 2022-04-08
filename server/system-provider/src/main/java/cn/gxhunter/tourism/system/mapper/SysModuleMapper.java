package cn.gxhunter.tourism.system.mapper;

import cn.gxhunter.tourism.common.entity.SysModule;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface SysModuleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SysModule record);

    int insertSelective(SysModule record);

    SysModule selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SysModule record);

    int updateByPrimaryKey(SysModule record);

    int updateBatch(List<SysModule> list);

    int updateBatchSelective(List<SysModule> list);

    int batchInsert(@Param("list") List<SysModule> list);
}