package cn.gxhunter.tourism.system.service.impl;

import cn.gxhunter.tourism.common.entity.SysUserRole;
import cn.gxhunter.tourism.system.mapper.SysUserRoleMapper;
import cn.gxhunter.tourism.system.service.SysUserRoleService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class SysUserRoleServiceImpl implements SysUserRoleService {

    @Resource
    private SysUserRoleMapper sysUserRoleMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return sysUserRoleMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(SysUserRole record) {
        return sysUserRoleMapper.insert(record);
    }

    @Override
    public int insertSelective(SysUserRole record) {
        return sysUserRoleMapper.insertSelective(record);
    }

    @Override
    public SysUserRole selectByPrimaryKey(Integer id) {
        return sysUserRoleMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(SysUserRole record) {
        return sysUserRoleMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(SysUserRole record) {
        return sysUserRoleMapper.updateByPrimaryKey(record);
    }

    @Override
    public int updateBatch(List<SysUserRole> list) {
        return sysUserRoleMapper.updateBatch(list);
    }

    @Override
    public int updateBatchSelective(List<SysUserRole> list) {
        return sysUserRoleMapper.updateBatchSelective(list);
    }

    @Override
    public int batchInsert(List<SysUserRole> list) {
        return sysUserRoleMapper.batchInsert(list);
    }

    //根据用户id获取用户角色列表
    @Override
    public List<SysUserRole> listSysUserRoleByUserId(Integer userId) {
        return sysUserRoleMapper.selectSysUserRoleByUserId(userId);
    }

    @Transactional
    @Override
    public int updateSysUserRole(Integer sysUserId, List<Integer>sysRoleIds, Integer editerId) {
        //删除原有用户角色
        sysUserRoleMapper.updateStatusBySysUserId(sysUserId, editerId);
        //添加新的用户角色
        List<SysUserRole> sysUserRoleList = new ArrayList<>();
        for (Integer roleId : sysRoleIds){
            SysUserRole sysUserRole = new SysUserRole();
            sysUserRole.setSysUserId(sysUserId);
            sysUserRole.setSysRoleId(roleId);
            sysUserRole.setCreaterId(editerId);
            sysUserRole.setEditerId(editerId);
            sysUserRoleList.add(sysUserRole);
        }
        return sysUserRoleMapper.batchInsert(sysUserRoleList);
    }
}



