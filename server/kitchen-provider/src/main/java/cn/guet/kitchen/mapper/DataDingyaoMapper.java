package cn.guet.kitchen.mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

import cn.guet.kitchen.entity.DataDingyao;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DataDingyaoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(DataDingyao record);

    int insertSelective(DataDingyao record);

    DataDingyao selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(DataDingyao record);

    int updateByPrimaryKey(DataDingyao record);
    List<DataDingyao> selectAllByImsi(@Param("deviceCode")String deviceCode, @Param("startTime") Date startTime, @Param("endTime")Date endTime, @Param("skip") Integer skip, @Param("pageSize") Integer pageSize);


}