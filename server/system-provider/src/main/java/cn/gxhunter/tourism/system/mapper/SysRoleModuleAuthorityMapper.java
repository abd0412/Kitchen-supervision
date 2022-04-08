package cn.gxhunter.tourism.system.mapper;

import cn.gxhunter.tourism.common.entity.SysRoleModuleAuthority;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface SysRoleModuleAuthorityMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SysRoleModuleAuthority record);

    int insertSelective(SysRoleModuleAuthority record);

    SysRoleModuleAuthority selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SysRoleModuleAuthority record);

    int updateByPrimaryKey(SysRoleModuleAuthority record);

    int updateBatch(List<SysRoleModuleAuthority> list);

    int updateBatchSelective(List<SysRoleModuleAuthority> list);

    int batchInsert(@Param("list") List<SysRoleModuleAuthority> list);

    //根据角色id,获取角色模块列表
    List<SysRoleModuleAuthority> selectSysRoleModuleByRoleId(Integer roleId);

    //角色id,批量逻辑删除
    int updateStatusBySysRoleId(@Param("sysRoleId") Integer sysRoleId, @Param("editerId") Integer editerId);
}