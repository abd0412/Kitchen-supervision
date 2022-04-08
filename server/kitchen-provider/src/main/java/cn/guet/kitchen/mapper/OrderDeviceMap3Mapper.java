package cn.guet.kitchen.mapper;

import cn.guet.kitchen.entity.OrderDeviceMap3;
import cn.guet.kitchen.entity.OrderRelateDeviceId;
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
public interface OrderDeviceMap3Mapper {
    int deleteByPrimaryKey(Long id);

    int insert(OrderDeviceMap3 record);

    int insertSelective(OrderDeviceMap3 orderDeviceMap3);

    OrderDeviceMap3 selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(OrderDeviceMap3 record);

    int updateByPrimaryKey(OrderDeviceMap3 record);

    int updateByOrderNumber(String orderNumber);//根据订单号进行删除

    List<JSONObject> selectDeviceIdByStatus(@Param("orderNumber") String orderNumber, @Param("status") String status);
}