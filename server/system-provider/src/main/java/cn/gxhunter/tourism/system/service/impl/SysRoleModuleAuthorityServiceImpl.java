package cn.gxhunter.tourism.system.service.impl;

import cn.gxhunter.tourism.common.entity.SysRoleModuleAuthority;
import cn.gxhunter.tourism.system.mapper.SysRoleModuleAuthorityMapper;
import cn.gxhunter.tourism.system.service.SysRoleModuleAuthorityService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.List;

@Service
public class SysRoleModuleAuthorityServiceImpl implements SysRoleModuleAuthorityService {

    @Resource
    private SysRoleModuleAuthorityMapper sysRoleModuleAuthorityMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return sysRoleModuleAuthorityMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(SysRoleModuleAuthority record) {
        return sysRoleModuleAuthorityMapper.insert(record);
    }

    @Override
    public int insertSelective(SysRoleModuleAuthority record) {
        return sysRoleModuleAuthorityMapper.insertSelective(record);
    }

    @Override
    public SysRoleModuleAuthority selectByPrimaryKey(Integer id) {
        return sysRoleModuleAuthorityMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(SysRoleModuleAuthority record) {
        return sysRoleModuleAuthorityMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(SysRoleModuleAuthority record) {
        return sysRoleModuleAuthorityMapper.updateByPrimaryKey(record);
    }

    @Override
    public int updateBatch(List<SysRoleModuleAuthority> list) {
        return sysRoleModuleAuthorityMapper.updateBatch(list);
    }

    @Override
    public int updateBatchSelective(List<SysRoleModuleAuthority> list) {
        return sysRoleModuleAuthorityMapper.updateBatchSelective(list);
    }

    @Override
    public int batchInsert(List<SysRoleModuleAuthority> list) {
        return sysRoleModuleAuthorityMapper.batchInsert(list);
    }

    //根据角色id获取角色模块列表
    @Override
    public List<SysRoleModuleAuthority> listSysRoleModuleByRoleId(Integer roleId) {
        return sysRoleModuleAuthorityMapper.selectSysRoleModuleByRoleId(roleId);
    }

    //更新角色模块权限
    @Transactional
    @Override
    public int updateSysRoleModule(List<SysRoleModuleAuthority> sysRoleModuleAuthorityList, Integer editerId) {
        Integer sysRoleId = sysRoleModuleAuthorityList.get(0).getSysRoleId();
        //逻辑删除现有模块权限
        sysRoleModuleAuthorityMapper.updateStatusBySysRoleId(sysRoleId, editerId);
        //添加新的模块权限
        if (!CollectionUtils.isEmpty(sysRoleModuleAuthorityList)){
            for (SysRoleModuleAuthority sysRoleModuleAuthority: sysRoleModuleAuthorityList){
                sysRoleModuleAuthority.setEditerId(editerId);
                sysRoleModuleAuthority.setCreaterId(editerId);
            }
        }
        return sysRoleModuleAuthorityMapper.batchInsert(sysRoleModuleAuthorityList);
    }
}



