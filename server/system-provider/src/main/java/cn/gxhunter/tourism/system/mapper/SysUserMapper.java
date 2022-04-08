package cn.gxhunter.tourism.system.mapper;

import cn.gxhunter.tourism.common.entity.SysUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface SysUserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SysUser record);

    int insertSelective(SysUser record);

    SysUser selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SysUser record);

    int updateByPrimaryKey(SysUser record);

    int updateBatch(List<SysUser> list);

    int updateBatchSelective(List<SysUser> list);

    int batchInsert(@Param("list") List<SysUser> list);

    //根据用户名分页查询用户列表
    List<SysUser> selectByRange(@Param("userName") String userName, @Param("name") String name, @Param("skip") Integer skip, @Param("size") Integer pageSize);

    //分页查询对应记录总数
    int count(@Param("userName") String userName, @Param("name") String name);

    //根据用户名列表,获取用户列表
    List<SysUser> selectByUserNames(@Param("userNames") List<String> userNames);

    //根据用户名,获取用户信息
    SysUser selectByUserName(@Param("username") String username);
}