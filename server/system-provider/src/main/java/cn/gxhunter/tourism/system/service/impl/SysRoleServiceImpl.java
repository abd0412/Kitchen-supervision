package cn.gxhunter.tourism.system.service.impl;

import cn.gxhunter.tourism.common.entity.SysRole;
import cn.gxhunter.tourism.system.mapper.SysRoleMapper;
import cn.gxhunter.tourism.system.service.SysRoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class SysRoleServiceImpl implements SysRoleService {

    @Resource
    private SysRoleMapper sysRoleMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return sysRoleMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(SysRole record) {
        return sysRoleMapper.insert(record);
    }

    @Override
    public int insertSelective(SysRole record) {
        return sysRoleMapper.insertSelective(record);
    }

    @Override
    public SysRole selectByPrimaryKey(Integer id) {
        return sysRoleMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(SysRole record) {
        return sysRoleMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(SysRole record) {
        return sysRoleMapper.updateByPrimaryKey(record);
    }

    @Override
    public int updateBatch(List<SysRole> list) {
        return sysRoleMapper.updateBatch(list);
    }

    @Override
    public int updateBatchSelective(List<SysRole> list) {
        return sysRoleMapper.updateBatchSelective(list);
    }

    @Override
    public int batchInsert(List<SysRole> list) {
        return sysRoleMapper.batchInsert(list);
    }

    /**
     * @Description 根据角色名称模糊分页查询角色列表
     * @Author      BinXiang
     * @Date        2020-02-14 17:24
     * @param name      角色名称
     * @param pageNo    当前页
     * @param pageSize  每页记录数
     * @return: java.util.Map<java.lang.String,java.lang.Object>
     **/
    @Override
    public List<SysRole> list(String name, Integer pageNo, Integer pageSize) {
        //跳过多少条记录
        Integer skip = (pageNo - 1) * pageSize;
        //获取角色数据list
        return sysRoleMapper.selectByRange(name, skip, pageSize);
    }

    /**
     * @Description 分页查询总记录数
     * @Author      BinXiang
     * @Date        2020-02-17 10:31
     * @param name  角色名称
     * @return: int
     **/
    public int count(String name){
        return sysRoleMapper.count(name);
    }
}



