package cn.guet.kitchen.mapper;

import cn.guet.kitchen.entity.Device;
import com.alibaba.fastjson.JSONObject;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @introduce:
 * @author: cyan
 * @DATE: 2021/4/7
 **/
@Mapper
public interface DeviceMapper {
    int deleteByPrimaryKey(String deviceId);

    //int insert(Device record);

    int insertSelective(Device device);

    void updateRIsDeletedByPrimary(String deviceId);

    Device selectByPrimaryKey(String deviceId);

    int selectCompanyIdByPrimaryKey(String deviceId);

    //int updateByPrimaryKeySelective(Device record);

    int updateByPrimaryKey(Device device);

    void updateRunparamBydeviceId(Device device);

    int selectByCompanyId(int companyId);

    List<Device> selectDevice(Device device);

    JSONObject selectseqNumAndGateId(String deviceId);
}