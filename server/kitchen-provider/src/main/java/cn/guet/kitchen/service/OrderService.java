package cn.guet.kitchen.service;

import cn.guet.kitchen.entity.DeviceMaintenanceOrder;
import cn.guet.kitchen.entity.CommonResult;

import javax.servlet.http.HttpServletRequest;

/**
 * @introduce:
 * @author: cyan
 * @DATE: 2021/3/29
 **/
public interface OrderService {
    CommonResult add(String json) throws Exception;
    CommonResult update(String json) throws Exception;
    CommonResult delete(String orderNumber) throws Exception;
    CommonResult select(String json) throws Exception;
    int putIn(DeviceMaintenanceOrder deviceMaintenanceOrder, String type);
    int deviceInfo(DeviceMaintenanceOrder deviceMaintenanceOrder, String type);//将关联设备的信息放入数据库
    int outDeviceInfo(DeviceMaintenanceOrder deviceMaintenanceOrder);
    CommonResult dispatchStaffUpdate(String json) throws Exception;
    CommonResult dispatchInfoUpdate(String json) throws Exception;
    CommonResult selectDispatchInfo(String json) throws Exception;
    CommonResult trackDispatchInfo(String orderNumber) throws Exception;
    String uploadAcceptancePicture(HttpServletRequest request) throws Exception;
    CommonResult autoGenOrders() throws Exception;
    CommonResult updateStatusByOrderNumber(String json) throws Exception;
}
