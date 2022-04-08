package cn.guet.kitchen.service.serviceimpl;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import cn.guet.kitchen.entity.DataDingyao;
import cn.guet.kitchen.mapper.DataDingyaoMapper;
import cn.guet.kitchen.service.DataDingyaoService;
@Service
public class DataDingyaoServiceImpl implements DataDingyaoService{

    @Resource
    private DataDingyaoMapper dataDingyaoMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return dataDingyaoMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(DataDingyao record) {
        return dataDingyaoMapper.insert(record);
    }

    @Override
    public int insertSelective(DataDingyao record) {
        return dataDingyaoMapper.insertSelective(record);
    }

    @Override
    public DataDingyao selectByPrimaryKey(Integer id) {
        return dataDingyaoMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(DataDingyao record) {
        return dataDingyaoMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(DataDingyao record) {
        return dataDingyaoMapper.updateByPrimaryKey(record);
    }

	@Override
	public List<DataDingyao> selectAllByImsi(String deviceCode, Date startTime, Date endTime, Integer pageNo, Integer pageSize){

        Integer skip = null;
        if (pageNo != null && pageSize != null) {
            skip = (pageNo - 1) * pageSize;
        }
		 return dataDingyaoMapper.selectAllByImsi(deviceCode,startTime,endTime,skip,pageSize);
	}




}
