package cn.guet.kitchen.mapper;

import cn.guet.kitchen.entity.DeviceMaintenanceOrder;
import com.alibaba.fastjson.JSONObject;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @introduce:
 * @author: cyan
 * @DATE: 2021/3/29
 **/
@Mapper
public interface OrderMapper {
    int insertSelective(DeviceMaintenanceOrder deviceMaintenanceOrder);
    List<String> selectAllMaintenanceCompanyId();
    List<String> selectAllOperationCompanyId();
    void updateCompanyNum(@Param("maintenanceCompanyId") int maintenanceCompanyId, @Param("dispatchNum") int dispatchNum);
    void updateOperationNum(@Param("operationCompanyId") int operationCompanyId, @Param("dispatchNum") int dispatchNum);
    List<String> selectAllMaintenanceStaffId(@Param("maintenanceCompanyId") int maintenanceCompanyId);
    List<String> selectAllOperationStaffId(@Param("operationCompanyId") int operationCompanyId);
    void updateStaffNum(@Param("companyId") int companyId, @Param("maintenanceStaffId") String maintenanceStaffId, @Param("staffDispatchNum") int staffDispatchNum);
    void updateOrderNumber(DeviceMaintenanceOrder deviceMaintenanceOrder);
    void updateByOrderNumber(DeviceMaintenanceOrder deviceMaintenanceOrder);
    int selectMaintenanceIdByOrderNumber(DeviceMaintenanceOrder deviceMaintenanceOrder);
    void updateByMaintenanceId(DeviceMaintenanceOrder deviceMaintenanceOrder);
    List<DeviceMaintenanceOrder> selectOrder(DeviceMaintenanceOrder deviceMaintenanceOrder);
    DeviceMaintenanceOrder selectUpdateOrder(DeviceMaintenanceOrder deviceMaintenanceOrder);
    DeviceMaintenanceOrder selectByCompanyId(int companyId);//根据餐饮企业ID进行查找
    int updateStatusByOrderNumber(DeviceMaintenanceOrder deviceMaintenanceOrder);
    void updateIfInCleanOrder(@Param("deviceId") String deviceId, @Param("ifInOrder") Boolean ifInOrder);
    void deletePreDispatchInfoByOrderNumber(String orderNumber);
    void insertProcessorIdInfo(@Param("orderNumber") String orderNumber, @Param("processorId") int processorId);
    List<JSONObject> selectDispatchOrderNumber(@Param("processorId") int processorId, @Param("orderStatus") int orderStatus);
    List<JSONObject> selectDispatchProcessorId(@Param("orderNumber") String orderNumber);
    DeviceMaintenanceOrder selectDispatchOrderInfo(@Param("orderNumber") String orderNumber, @Param("orderStatus") int orderStatus);
    int selectAllFoodCompany();
    List<JSONObject> selectDeviceIdByFoodId(@Param("companyId") int companyId, @Param("status") String status);
    List<JSONObject> selectOrderNumberByStatus(@Param("foodCompanyId") int foodCompanyId, @Param("orderStatus") int orderStatus);
}
