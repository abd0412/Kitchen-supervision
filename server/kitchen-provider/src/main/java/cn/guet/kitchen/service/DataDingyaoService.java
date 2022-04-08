package cn.guet.kitchen.service;
import java.util.Date;
import java.util.List;

import cn.guet.kitchen.entity.DataDingyao;
public interface DataDingyaoService{


    int deleteByPrimaryKey(Integer id);

    int insert(DataDingyao record);

    int insertSelective(DataDingyao record);

    DataDingyao selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(DataDingyao record);

    int updateByPrimaryKey(DataDingyao record);



	List<DataDingyao> selectAllByImsi(String deviceCode, Date startTime, Date endTime, Integer pageNo, Integer pageSize);


}
