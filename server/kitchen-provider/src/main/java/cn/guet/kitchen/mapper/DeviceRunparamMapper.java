package cn.guet.kitchen.mapper;

import cn.guet.kitchen.entity.DeviceRunparam;
import com.alibaba.fastjson.JSONObject;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**

* @introduce: 

* @author: cyan

* @DATE: 2021/4/9

**/
@Mapper
public interface DeviceRunparamMapper {
    //int deleteByPrimaryKey(String deviceId);

    //int insert(DeviceRunparam record);

    //int insertSelective(DeviceRunparam record);

    //DeviceRunparam selectByPrimaryKey(String deviceId);

    //int updateByPrimaryKeySelective(DeviceRunparam record);

    //int updateByPrimaryKey(DeviceRunparam record);

    List<JSONObject> selectDeviceId(@Param("status") String status, @Param("companyId") int companyId);
    DeviceRunparam selectMonitorInfo(String deviceId);
    int insertRunparamByDeviceId(DeviceRunparam deviceRunparam);
}