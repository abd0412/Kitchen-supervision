package cn.gxhunter.tourism.system.service.impl;

import cn.gxhunter.tourism.common.entity.SysModule;
import cn.gxhunter.tourism.system.mapper.SysModuleMapper;
import cn.gxhunter.tourism.system.service.SysModuleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class SysModuleServiceImpl implements SysModuleService {

    @Resource
    private SysModuleMapper sysModuleMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return sysModuleMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(SysModule record) {
        return sysModuleMapper.insert(record);
    }

    @Override
    public int insertSelective(SysModule record) {
        return sysModuleMapper.insertSelective(record);
    }

    @Override
    public SysModule selectByPrimaryKey(Integer id) {
        return sysModuleMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(SysModule record) {
        return sysModuleMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(SysModule record) {
        return sysModuleMapper.updateByPrimaryKey(record);
    }

    @Override
    public int updateBatch(List<SysModule> list) {
        return sysModuleMapper.updateBatch(list);
    }

    @Override
    public int updateBatchSelective(List<SysModule> list) {
        return sysModuleMapper.updateBatchSelective(list);
    }

    @Override
    public int batchInsert(List<SysModule> list) {
        return sysModuleMapper.batchInsert(list);
    }

}



