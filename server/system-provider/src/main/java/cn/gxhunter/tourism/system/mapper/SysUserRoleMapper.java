package cn.gxhunter.tourism.system.mapper;

import cn.gxhunter.tourism.common.entity.SysUserRole;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface SysUserRoleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SysUserRole record);

    int insertSelective(SysUserRole record);

    SysUserRole selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SysUserRole record);

    int updateByPrimaryKey(SysUserRole record);

    int updateBatch(List<SysUserRole> list);

    int updateBatchSelective(List<SysUserRole> list);

    int batchInsert(@Param("list") List<SysUserRole> list);

    //根据用户id,获取用户角色列表
    List<SysUserRole> selectSysUserRoleByUserId(@Param("userId") Integer userId);

    //根据userId逻辑删除
    int updateStatusBySysUserId(@Param("userId") Integer userId, @Param("editerId") Integer editerId);
}