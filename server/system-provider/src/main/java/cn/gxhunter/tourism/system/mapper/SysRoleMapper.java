package cn.gxhunter.tourism.system.mapper;

import cn.gxhunter.tourism.common.entity.SysRole;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface SysRoleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SysRole record);

    int insertSelective(SysRole record);

    SysRole selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SysRole record);

    int updateByPrimaryKey(SysRole record);

    int updateBatch(List<SysRole> list);

    int updateBatchSelective(List<SysRole> list);

    int batchInsert(@Param("list") List<SysRole> list);

    //分页,模糊条件,获取角色列表
    List<SysRole> selectByRange(@Param("name") String name, @Param("skip") Integer skip, @Param("size") Integer pageSize);

    //对应分页查找记录总数
    int count(@Param("name") String name);
}