package cn.guet.kitchen.mapper;

import cn.guet.kitchen.entity.DeviceAlarm;
import com.alibaba.fastjson.JSONObject;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface DeviceAlarmMapper {
    int deleteByPrimaryKey(Integer deviceId);

    int insert(DeviceAlarm record);

    int insertSelective(DeviceAlarm record);

    DeviceAlarm selectByPrimaryKey(Integer deviceId);

    int updateByPrimaryKeySelective(DeviceAlarm record);

    int updateByPrimaryKey(DeviceAlarm record);

    List<JSONObject> selectAbnormalDeviceInfo();
}