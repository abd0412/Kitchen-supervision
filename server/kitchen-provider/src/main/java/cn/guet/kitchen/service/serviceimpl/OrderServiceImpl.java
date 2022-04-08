package cn.guet.kitchen.service.serviceimpl;

import cn.guet.kitchen.entity.*;
import cn.guet.kitchen.mapper.*;
import cn.guet.kitchen.service.OrderService;
import cn.guet.kitchen.entity.CommonResult;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.text.SimpleDateFormat;
import java.util.*;

import static org.assertj.core.util.Strings.concat;

/**
 * @introduce:
 * @author: cyan
 * @DATE: 2021/3/29
 **/
@Slf4j
@Service
public class OrderServiceImpl implements OrderService {
    private static final Logger logger = LoggerFactory.getLogger(OrderServiceImpl.class);
    @Resource
    private LogMapper logMapper;

    @Resource
    private OrderMapper orderMapper;

    @Resource
    private OrderDeviceMap3Mapper orderDeviceMap3Mapper;

    @Resource
    private DeviceMapper deviceMapper;

    @Resource
    private UserMapper userMapper;

    //对输入数据做的校验
    @Override
    public int putIn(DeviceMaintenanceOrder deviceMaintenanceOrder, String type) {
        try {
            String orderTypeCode = deviceMaintenanceOrder.getOrderType(); //订单类型编码
            int foodCompanyId = deviceMaintenanceOrder.getFoodCompanyId(); //餐饮企业Id
            if (deviceMaintenanceOrder.getTime() == null) {//维保时间
                return 1201;
            }
            String maintenancePeriod = deviceMaintenanceOrder.getMaintenanceTimeseg(); //维保时间段
            String genType = deviceMaintenanceOrder.getGenType(); //订单产生方式
            if (!("install").equals(deviceMaintenanceOrder.getOrderType())) {
                //以下是设备关联信息的填写检测
                int normalSize = deviceMaintenanceOrder.getDevices().getNormal().size();
                int earlyWarningSize = deviceMaintenanceOrder.getDevices().getEarlyWarning().size();
                int alarmSize = deviceMaintenanceOrder.getDevices().getAlarm().size();
                if (normalSize == 0 && earlyWarningSize == 0 && alarmSize == 0) {//判错
                    return 1201;
                }
            }
            if (("update").equals(type)) {
                if (deviceMaintenanceOrder.getOrderNumber() == null && deviceMaintenanceOrder.getFlowNum() == null) {//维保时间
                    return 1201;
                }
                int maintenanceCompanyId = deviceMaintenanceOrder.getMaintenanceCompanyId(); //派单公司
                //int oneProcessorId = deviceMaintenanceOrder.getOneProcessorId(); //更新订单时带派单负责人员
                int orderStatus = deviceMaintenanceOrder.getOrderStatus(); //订单状态
            }
        } catch (Exception e) {
            logger.error("出现异常", e);
            return 1201;
        }
        return 200;
    }

    @Override
    public int deviceInfo(DeviceMaintenanceOrder deviceMaintenanceOrder, String type) {
        try {
            OrderDeviceMap3 orderDeviceMap3 = new OrderDeviceMap3();
            int normalSize = deviceMaintenanceOrder.getDevices().getNormal().size();
            int earlyWarningSize = deviceMaintenanceOrder.getDevices().getEarlyWarning().size();
            int alarmSize = deviceMaintenanceOrder.getDevices().getAlarm().size();
            String orderNumber = deviceMaintenanceOrder.getOrderNumber();
            if ("update".equals(type)) {
                orderDeviceMap3Mapper.updateByOrderNumber(orderNumber);//将之前根据该订单插入的设备删除
            }
            //生成创建时间
            Calendar calendar = Calendar.getInstance(Locale.CHINA);
            Date date = calendar.getTime();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String time = dateFormat.format(date);
            if (normalSize != 0) {//插入数据库
                for (int i = 0; i < normalSize; i++) {
                    String deviceId = deviceMaintenanceOrder.getDevices().getNormal().get(i).getDeviceId();
                    /*if(deviceMaintenanceOrder.getDevices().getNormal().get(i).getSeqNum()!=null) {
                        int SeqNum = deviceMaintenanceOrder.getDevices().getNormal().get(i).getSeqNum();
                        orderDeviceMap3.setSeqNum(SeqNum);
                    }
                    if(deviceMaintenanceOrder.getDevices().getNormal().get(i).getGateId()!=null){
                        int GateId = deviceMaintenanceOrder.getDevices().getNormal().get(i).getGateId();
                        orderDeviceMap3.setGateId(GateId);
                    }*/
                    orderDeviceMap3.setDeviceId(deviceId);
                    orderDeviceMap3.setOrderNumber(orderNumber);
                    orderDeviceMap3.setStatus("正常");
                    if ("add".equals(type)) {
                        orderDeviceMap3.setCreateTime(time);
                        orderDeviceMap3Mapper.insertSelective(orderDeviceMap3);
                    } else if ("update".equals(type)) {
                        orderDeviceMap3.setModifyTime(time);
                        orderDeviceMap3Mapper.insertSelective(orderDeviceMap3);//再重新插入
                    }
                }
            }
            if (earlyWarningSize != 0) {
                for (int i = 0; i < earlyWarningSize; i++) {
                    String deviceId = deviceMaintenanceOrder.getDevices().getEarlyWarning().get(i).getDeviceId();
                    orderDeviceMap3.setDeviceId(deviceId);
                    orderDeviceMap3.setOrderNumber(deviceMaintenanceOrder.getOrderNumber());
                    orderDeviceMap3.setStatus("预警");
                    if ("add".equals(type)) {
                        orderDeviceMap3.setCreateTime(time);
                        orderDeviceMap3Mapper.insertSelective(orderDeviceMap3);
                    } else if ("update".equals(type)) {
                        orderDeviceMap3.setModifyTime(time);
                        orderDeviceMap3Mapper.insertSelective(orderDeviceMap3);//再重新插入
                    }
                }
            }
            if (alarmSize != 0) {
                for (int i = 0; i < alarmSize; i++) {
                    String deviceId = deviceMaintenanceOrder.getDevices().getAlarm().get(i).getDeviceId();
                    orderDeviceMap3.setDeviceId(deviceId);//设备ID
                    orderDeviceMap3.setOrderNumber(deviceMaintenanceOrder.getOrderNumber());//订单ID
                    orderDeviceMap3.setStatus("报警");
                    if ("add".equals(type)) {
                        orderDeviceMap3.setCreateTime(time);
                        orderDeviceMap3Mapper.insertSelective(orderDeviceMap3);
                    } else if ("update".equals(type)) {
                        orderDeviceMap3.setModifyTime(time);
                        orderDeviceMap3Mapper.insertSelective(orderDeviceMap3);//再重新插入
                    }
                }
            }
        } catch (Exception e) {
            logger.error("出现异常", e);
            return 2001;
        }
        return 200;
    }

    @Override
    public int outDeviceInfo(DeviceMaintenanceOrder deviceMaintenanceOrder) {
        OrderRelateType orderRelateType = new OrderRelateType();
        try {
            String orderNumber = deviceMaintenanceOrder.getOrderNumber();//得到订单号
            //正常
            List<OrderRelateDeviceId> normal = new ArrayList<>();
            List<JSONObject> normalList = orderDeviceMap3Mapper.selectDeviceIdByStatus(orderNumber, "正常");
            for (int i = 0; i < normalList.size(); i++) {
                OrderRelateDeviceId orderRelateDeviceId = new OrderRelateDeviceId();
                String deviceId = normalList.get(i).getString("device_id");
                orderRelateDeviceId.setDeviceId(deviceId);
                //根据这个deviceId去查网关ID和管道号
                JSONObject jsonObject = deviceMapper.selectseqNumAndGateId(deviceId);
                orderRelateDeviceId.setSeqNum(jsonObject.getInteger("seq_num"));
                orderRelateDeviceId.setGateId(jsonObject.getInteger("gate_id"));
                normal.add(orderRelateDeviceId);
            }
            orderRelateType.setNormal(normal);
            //预警
            List<OrderRelateDeviceId> earlyWarning = new ArrayList<>();
            List<JSONObject> earlyWarningList = orderDeviceMap3Mapper.selectDeviceIdByStatus(orderNumber, "预警");
            for (int i = 0; i < earlyWarningList.size(); i++) {
                OrderRelateDeviceId orderRelateDeviceId = new OrderRelateDeviceId();
                orderRelateDeviceId.setDeviceId(earlyWarningList.get(i).getString("device_id"));
                earlyWarning.add(orderRelateDeviceId);
            }
            orderRelateType.setEarlyWarning(earlyWarning);
            //报警
            List<OrderRelateDeviceId> alarm = new ArrayList<>();
            List<JSONObject> alarmList = orderDeviceMap3Mapper.selectDeviceIdByStatus(orderNumber, "报警");
            for (int i = 0; i < alarmList.size(); i++) {
                OrderRelateDeviceId orderRelateDeviceId = new OrderRelateDeviceId();
                orderRelateDeviceId.setDeviceId(alarmList.get(i).getString("device_id"));
                alarm.add(orderRelateDeviceId);
            }
            orderRelateType.setAlarm(alarm);
            deviceMaintenanceOrder.setDevices(orderRelateType);
        } catch (Exception e) {
            logger.error("出现异常", e);
            return 2001;
        }
        return 200;
    }

    @Override
    public CommonResult add(String json) throws Exception {
        DeviceMaintenanceOrder deviceMaintenanceOrder = JSON.parseObject(json, DeviceMaintenanceOrder.class);//转化为实体类
        int putInResult = putIn(deviceMaintenanceOrder, "add");
        if (putInResult == 1201) {
            return new CommonResult(1201, "请求条件中，缺少必填参数", null);
        } else {
            try {
                //生成下单时间
                Calendar calendar = Calendar.getInstance(Locale.CHINA);
                Date date = calendar.getTime();
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String insertTime = dateFormat.format(date);
                deviceMaintenanceOrder.setInsertTime(insertTime);
                if (("wash").equals(deviceMaintenanceOrder.getOrderType())) {//如果是设备清洗
                    //派单：分配公司及公司人员
                    //找到派单公司
                    int minDispatchNum = Integer.MAX_VALUE;
                    int maintenanceCompanyId = 0;
                    List<String> maintenanceCompanyList = orderMapper.selectAllMaintenanceCompanyId();
                    for (String maintenanceCompany : maintenanceCompanyList) {
                        JSONObject maintenanceCompanyObject = JSONObject.parseObject(maintenanceCompany);
                        int dispatchNum = maintenanceCompanyObject.getInteger("dispatchNum");
                        if (dispatchNum < minDispatchNum) {
                            minDispatchNum = dispatchNum;
                            maintenanceCompanyId = maintenanceCompanyObject.getInteger("maintenanceCompanyId"); //选出派单公司
                        }
                    }
                    //找到派单公司的派单人员
                    int dispatchNum = minDispatchNum + 1; //该公司派单数量加1
                    orderMapper.updateCompanyNum(maintenanceCompanyId, dispatchNum);//更新
                    String maintenanceStaffId = null;//工号
                    int companyId = 0;
                    int leave = 0;
                    Date leaveStartTime = null;
                    Date leaveEndTime = null;
                    boolean foundStaff = false;
                    int finStaffDispatchNum = 0;
                    while (!foundStaff) { //知道找到当时没有请假的
                        int minStaffDispatchNum = Integer.MAX_VALUE;
                        List<String> maintenanceStaffList = orderMapper.selectAllMaintenanceStaffId(maintenanceCompanyId);
                        for (int i = 0; i < maintenanceStaffList.size(); i++) {
                            JSONObject maintenanceStaffObject = JSONObject.parseObject(maintenanceStaffList.get(i));
                            int staffDispatchNum = maintenanceStaffObject.getInteger("dispatchNum");
                            if (staffDispatchNum < minStaffDispatchNum) {
                                minStaffDispatchNum = staffDispatchNum;
                                maintenanceStaffId = maintenanceStaffObject.getString("maintenanceStaffId"); //选出派单员工
                                companyId = maintenanceStaffObject.getInteger("companyId");
                                leave = maintenanceStaffObject.getInteger("leave");//该员工是否请假
                                if (leave == 1) {
                                    leaveStartTime = maintenanceStaffObject.getDate("leaveStartTime");
                                    leaveEndTime = maintenanceStaffObject.getDate("leaveEndTime");
                                }
                            }
                        }
                        if (leave == 1) {
                            SimpleDateFormat sdfDay = new SimpleDateFormat("yyyy-MM-dd");
                            Date maintenanceTime = sdfDay.parse(deviceMaintenanceOrder.getTime());
                            long maintenanceTimestamp = maintenanceTime.getTime(); //维保日期的时间戳
                            long leaveStartTimestamp = leaveStartTime.getTime();
                            long leaveEndTimestamp = leaveEndTime.getTime();
                            if (leaveStartTimestamp < maintenanceTimestamp && maintenanceTimestamp < leaveEndTimestamp) {
                                int staffDispatchNum = minStaffDispatchNum + 1;
                                orderMapper.updateStaffNum(companyId, maintenanceStaffId, staffDispatchNum);
                            } else {
                                foundStaff = true;
                                finStaffDispatchNum = minStaffDispatchNum + 1;
                            }
                        } else {
                            foundStaff = true;
                            finStaffDispatchNum = minStaffDispatchNum + 1;
                        }
                    }
                    deviceMaintenanceOrder.setMaintenanceCompanyId(maintenanceCompanyId);
                    deviceMaintenanceOrder.setOneProcessorId(maintenanceStaffId);
                    deviceMaintenanceOrder.setOrderStatus(1);//状态设置已分配
                    orderMapper.updateStaffNum(companyId, maintenanceStaffId, finStaffDispatchNum);//更新分配信息
                } else {//如果是设备安装和设备维修
                    //派单：分配公司及公司人员
                    //找到派单公司
                    int minDispatchNum = Integer.MAX_VALUE;
                    int operationCompanyId = 0;
                    List<String> operationCompanyList = orderMapper.selectAllOperationCompanyId();
                    for (String operationCompany : operationCompanyList) {
                        JSONObject operationCompanyObject = JSONObject.parseObject(operationCompany);
                        int dispatchNum = operationCompanyObject.getInteger("dispatchNum");
                        if (dispatchNum < minDispatchNum) {
                            minDispatchNum = dispatchNum;
                            operationCompanyId = operationCompanyObject.getInteger("operationCompanyId"); //选出派单公司
                        }
                    }
                    //找到派单公司的派单人员
                    int dispatchNum = minDispatchNum + 1; //该公司派单数量加1
                    orderMapper.updateOperationNum(operationCompanyId, dispatchNum);//更新
                    String operationStaffId = null;
                    int companyId = 0;
                    int leave = 0;
                    Date leaveStartTime = null;
                    Date leaveEndTime = null;
                    boolean foundStaff = false;
                    int finStaffDispatchNum = 0;
                    while (!foundStaff) { //知道找到当时没有请假的
                        int minStaffDispatchNum = Integer.MAX_VALUE;
                        List<String> operationStaffList = orderMapper.selectAllOperationStaffId(operationCompanyId);
                        for (int i = 0; i < operationStaffList.size(); i++) {
                            JSONObject operationStaffObject = JSONObject.parseObject(operationStaffList.get(i));
                            int staffDispatchNum = operationStaffObject.getInteger("dispatchNum");
                            if (staffDispatchNum < minStaffDispatchNum) {
                                minStaffDispatchNum = staffDispatchNum;
                                operationStaffId = operationStaffObject.getString("operationStaffId"); //选出派单员工
                                companyId = operationStaffObject.getInteger("companyId");
                                leave = operationStaffObject.getInteger("leave");//该员工是否请假
                                if (leave == 1) {
                                    leaveStartTime = operationStaffObject.getDate("leaveStartTime");
                                    leaveEndTime = operationStaffObject.getDate("leaveEndTime");
                                }
                            }
                        }
                        if (leave == 1) {
                            SimpleDateFormat sdfDay = new SimpleDateFormat("yyyy-MM-dd");
                            Date operationTime = sdfDay.parse(deviceMaintenanceOrder.getTime());
                            long operationTimestamp = operationTime.getTime(); //维保日期的时间戳
                            long leaveStartTimestamp = leaveStartTime.getTime();
                            long leaveEndTimestamp = leaveEndTime.getTime();
                            if (leaveStartTimestamp < operationTimestamp && operationTimestamp < leaveEndTimestamp) {
                                int staffDispatchNum = minStaffDispatchNum + 1;
                                orderMapper.updateStaffNum(companyId, operationStaffId, staffDispatchNum);
                            } else {
                                foundStaff = true;
                                finStaffDispatchNum = minStaffDispatchNum + 1;
                            }
                        } else {
                            foundStaff = true;
                            finStaffDispatchNum = minStaffDispatchNum + 1;
                        }
                    }
                    deviceMaintenanceOrder.setMaintenanceCompanyId(operationCompanyId);
                    deviceMaintenanceOrder.setOneProcessorId(operationStaffId);
                    deviceMaintenanceOrder.setOrderStatus(1);//状态设置已分配
                    orderMapper.updateStaffNum(companyId, operationStaffId, finStaffDispatchNum);//更新分配信息
                }
                orderMapper.insertSelective(deviceMaintenanceOrder);//为订单分配序号
                Log log = new Log();
                log.setIntroduction("device_maintenance");
                log.setModuleId(deviceMaintenanceOrder.getMaintenanceId());
                log.setCode("addOrder");
                log.setDescription("手工新增订单");
                logMapper.insertSelective(log);
                //生成订单编号
                long nowTime = Calendar.getInstance().getTimeInMillis();
                String orderNumber = concat(nowTime, deviceMaintenanceOrder.getMaintenanceId());
                deviceMaintenanceOrder.setOrderNumber(orderNumber);
                //生成流水号：订单类型+餐饮企业ID+维保时间段+订单产生方式+订单批次
                /*String flowNum1 = concat(deviceMaintenanceOrder.getOrderTypeCode(), deviceMaintenanceOrder.getFoodCompanyId());
                String flowNum2 = concat(flowNum1, deviceMaintenanceOrder.getMaintenancePeriod());
                String flowNum3 = concat(flowNum2, deviceMaintenanceOrder.getGenType());
                String flowNum = concat(flowNum3, deviceMaintenanceOrder.getBatch());
                deviceMaintenanceOrder.setFlowNum(flowNum);*/
                orderMapper.updateOrderNumber(deviceMaintenanceOrder);
                int deviceInfoResult = deviceInfo(deviceMaintenanceOrder, "add");
                if (deviceInfoResult == 2001) {
                    return new CommonResult(1201, "生成设备关联信息失败", null);
                }
                DeviceMaintenanceOrder foodDeviceMaintenanceOrder = orderMapper.selectByCompanyId(deviceMaintenanceOrder.getFoodCompanyId());//得到餐饮企业的三个信息
                deviceMaintenanceOrder.setCompanyName(foodDeviceMaintenanceOrder.getCompanyName());//进行赋值
                deviceMaintenanceOrder.setPhone(foodDeviceMaintenanceOrder.getPhone());
                deviceMaintenanceOrder.setAddress(foodDeviceMaintenanceOrder.getAddress());
            } catch (Exception e) {
                logger.error("出现异常", e);
                return new CommonResult(2001, "数据库执行有异常", null);
            }
            return new CommonResult(200, "订单创建成功", deviceMaintenanceOrder);
        }
    }

    @Override
    public CommonResult update(String json) throws Exception {
        DeviceMaintenanceOrder deviceMaintenanceOrder = JSON.parseObject(json, DeviceMaintenanceOrder.class);//转化为实体类
        int putInResult = putIn(deviceMaintenanceOrder, "update");
        if (putInResult == 1201) {
            return new CommonResult(1201, "请求条件中，缺少必填参数", null);
        } else {
            try {
                //生成修改时间
                Calendar calendar = Calendar.getInstance(Locale.CHINA);
                Date date = calendar.getTime();
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String updateTime = dateFormat.format(date);
                deviceMaintenanceOrder.setUpdateTime(updateTime);
                orderMapper.updateByOrderNumber(deviceMaintenanceOrder);
                int maintenanceId = orderMapper.selectMaintenanceIdByOrderNumber(deviceMaintenanceOrder);
                Log log = new Log();
                log.setIntroduction("device_maintenance");
                log.setModuleId(maintenanceId);
                log.setCode("updateOrder");
                log.setDescription("修改订单");
                logMapper.insertSelective(log);
                int deviceInfoResult = deviceInfo(deviceMaintenanceOrder, "update");
                if (deviceInfoResult == 2001) {
                    return new CommonResult(1201, "生成设备关联信息失败", null);
                }
                deviceMaintenanceOrder = orderMapper.selectUpdateOrder(deviceMaintenanceOrder);
                int outDeviceInfoResult = outDeviceInfo(deviceMaintenanceOrder);
                if (outDeviceInfoResult == 2001) {
                    return new CommonResult(1201, "获取设备关联信息失败", null);
                }
            } catch (Exception e) {
                logger.error("出现异常", e);
                return new CommonResult(2001, "数据库执行有异常", null);
            }
            return new CommonResult(200, "订单更新成功", deviceMaintenanceOrder);
        }
    }

    @Override
    public CommonResult delete(String orderNumber) throws Exception {
        DeviceMaintenanceOrder deviceMaintenanceOrder = new DeviceMaintenanceOrder();//转化为实体类
        deviceMaintenanceOrder.setOrderNumber(orderNumber);
        if (deviceMaintenanceOrder.getOrderNumber() == null) {//订单编号
            return new CommonResult(1201, "请求条件中，缺少订单序号", null);
        }
        try {
            deviceMaintenanceOrder.setIsDeleted(true);
            orderMapper.updateByMaintenanceId(deviceMaintenanceOrder);
            int maintenanceId = orderMapper.selectMaintenanceIdByOrderNumber(deviceMaintenanceOrder);
            Log log = new Log();
            log.setIntroduction("device_maintenance");
            log.setModuleId(maintenanceId);
            log.setCode("deleteOrder");
            log.setDescription("删除订单");
            logMapper.insertSelective(log);
        } catch (Exception e) {
            logger.error("出现异常", e);
            return new CommonResult(2001, "数据库执行有异常", null);
        }
        return new CommonResult(200, "订单删除成功", null);
    }

    @Override
    public CommonResult select(String json) throws Exception {
        int pageNumber; //页号
        int count = 10; //每页10行
        int startSerial; //本页开始计数
        int endSerial; //本页结束计数
        int selectOrderListSize; //查找的订单结果
        int numberOfPages; //页面数量
        List<DeviceMaintenanceOrder> outSelectOrder = new ArrayList<>();
        SelectOrder selectOrder = new SelectOrder();
        DeviceMaintenanceOrder deviceMaintenanceOrder = JSON.parseObject(json, DeviceMaintenanceOrder.class);//转化为实体类
        try {
            if (0 == deviceMaintenanceOrder.getPageNumber()) {
                pageNumber = 1;
            } else {
                pageNumber = deviceMaintenanceOrder.getPageNumber();
            }
            startSerial = (pageNumber - 1) * count;
            endSerial = startSerial + count;
            deviceMaintenanceOrder.setIsDeleted(false);//没有被删除的
            List<DeviceMaintenanceOrder> selectOrderList = orderMapper.selectOrder(deviceMaintenanceOrder);
            selectOrderListSize = selectOrderList.size();
            if (endSerial > selectOrderListSize) {
                endSerial = selectOrderListSize;
            }
            for (int i = startSerial; i < endSerial; i++) {
                selectOrderList.get(i).setPageNumber(pageNumber);//属于哪一页
                selectOrderList.get(i).setOutSelectSerial(i + 1);//编序号
                int outDeviceInfoResult = outDeviceInfo(selectOrderList.get(i));
                if (outDeviceInfoResult == 2001) {
                    return new CommonResult(1201, "获取设备关联信息失败", null);
                }
                outSelectOrder.add(selectOrderList.get(i));
            }
            numberOfPages = (int) Math.ceil((double) selectOrderListSize / count);
            selectOrder.setSelectResult(outSelectOrder);
            selectOrder.setNumberOfPages(numberOfPages);
            selectOrder.setSelectCount(selectOrderListSize);
        } catch (Exception e) {
            logger.error("出现异常", e);
            return new CommonResult(2001, "数据库执行有异常", null);
        }
        return new CommonResult(200, "查询成功", selectOrder);
    }

    @Override
    public CommonResult dispatchStaffUpdate(String json) throws Exception {
        DeviceMaintenanceOrder deviceMaintenanceOrder = JSON.parseObject(json, DeviceMaintenanceOrder.class);//转化为实体类
        if (deviceMaintenanceOrder.getOrderNumber() == null || deviceMaintenanceOrder.getOrderStatus() == null || deviceMaintenanceOrder.getProcessorIdArray().size() == 0) {
            return new CommonResult(1201, "请求条件中，缺少必填参数", null);
        } else {
            try {
                //生成修改时间
                Calendar calendar = Calendar.getInstance(Locale.CHINA);
                Date date = calendar.getTime();
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String dispatchTime = dateFormat.format(date);
                deviceMaintenanceOrder.setDispatchTime(dispatchTime);
                String orderNumber = deviceMaintenanceOrder.getOrderNumber();
                int orderStatus = deviceMaintenanceOrder.getOrderStatus();
                orderMapper.updateStatusByOrderNumber(deviceMaintenanceOrder); //更新状态及派单时间
                int maintenanceId = orderMapper.selectMaintenanceIdByOrderNumber(deviceMaintenanceOrder);
                Log log = new Log();
                log.setIntroduction("device_maintenance user_order_map");
                log.setModuleId(maintenanceId);
                log.setCode("dispatchStaff");
                log.setDescription("派单给员工");
                logMapper.insertSelective(log);
                //插入员工订单信息
                for (int i = 0; i < deviceMaintenanceOrder.getProcessorIdArray().size(); i++) {
                    int processorId = deviceMaintenanceOrder.getProcessorIdArray().get(i).getProcessorId();
                    orderMapper.insertProcessorIdInfo(orderNumber, processorId);
                }
            } catch (Exception e) {
                logger.error("出现异常", e);
                return new CommonResult(2001, "数据库执行有异常", null);
            }
            return new CommonResult(200, "派单成功", null);
        }
    }

    @Override
    public CommonResult dispatchInfoUpdate(String json) throws Exception {
        DeviceMaintenanceOrder deviceMaintenanceOrder = JSON.parseObject(json, DeviceMaintenanceOrder.class);//转化为实体类
        if (deviceMaintenanceOrder.getOrderNumber() == null || deviceMaintenanceOrder.getOrderStatus() == null) {
            return new CommonResult(1201, "请求条件中，缺少必填参数", null);
        } else {
            try {
                //生成修改时间
                Calendar calendar = Calendar.getInstance(Locale.CHINA);
                Date date = calendar.getTime();
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String updateDispatchTime = dateFormat.format(date);
                deviceMaintenanceOrder.setUpdateDispatchTime(updateDispatchTime);
                String orderNumber = deviceMaintenanceOrder.getOrderNumber();
                int orderStatus = deviceMaintenanceOrder.getOrderStatus();
                orderMapper.updateStatusByOrderNumber(deviceMaintenanceOrder); //更新状态及修改派单时间
                int maintenanceId = orderMapper.selectMaintenanceIdByOrderNumber(deviceMaintenanceOrder);
                Log log = new Log();
                log.setIntroduction("device_maintenance user_order_map");
                log.setModuleId(maintenanceId);
                log.setCode("dispatchInfoUpdate");
                log.setDescription("修改员工派单信息");
                logMapper.insertSelective(log);
                orderMapper.deletePreDispatchInfoByOrderNumber(orderNumber);//删除原有派单信息
                int processorIdNum = deviceMaintenanceOrder.getProcessorIdArray().size();
                for (int i = 0; i < processorIdNum; i++) {
                    int processorId = deviceMaintenanceOrder.getProcessorIdArray().get(i).getProcessorId();
                    orderMapper.insertProcessorIdInfo(orderNumber, processorId);
                }
            } catch (Exception e) {
                logger.error("出现异常", e);
                return new CommonResult(2001, "数据库执行有异常", null);
            }
            return new CommonResult(200, "修改派单信息成功", null);
        }
    }

    @Override
    public CommonResult selectDispatchInfo(String json) throws Exception {
        System.out.println("stringJson==>" + json);
        List<DeviceMaintenanceOrder> outSelectOrder = new ArrayList<>();
        JSONObject jsonObject;
        int inProcessorId;
        int orderStatus = 0;
        try {
            jsonObject = JSONObject.parseObject(json);
            inProcessorId = jsonObject.getInteger("processorId");
        } catch (Exception e) {
            logger.error("出现异常", e);
            return new CommonResult(1201, "请求条件中，缺少必填参数", null);
        }
        try {
            if (jsonObject.getInteger("orderStatus") == null) {
                orderStatus = 0;
            } else {
                orderStatus = jsonObject.getInteger("orderStatus");
            }
            //查询该员工被派的单
            List<JSONObject> orderNumberList = orderMapper.selectDispatchOrderNumber(inProcessorId, orderStatus);
            for (int i = 0; i < orderNumberList.size(); i++) {
                List<ProcessorId> processorIdArray = new ArrayList<>();
                String aOrderNumber = orderNumberList.get(i).getString("order_number");
                //根据订单号查出与他一同派单的人
                List<JSONObject> processorIdList = orderMapper.selectDispatchProcessorId(aOrderNumber);
                for (int j = 0; j < processorIdList.size(); j++) {
                    int processorId = processorIdList.get(j).getInteger("processor_id");
                    ProcessorId outProcessorId = new ProcessorId();
                    outProcessorId.setProcessorId(processorId);
                    processorIdArray.add(outProcessorId);
                }
                //查询一些派单信息
                DeviceMaintenanceOrder deviceMaintenanceOrder = orderMapper.selectDispatchOrderInfo(aOrderNumber, orderStatus);
                deviceMaintenanceOrder.setProcessorIdArray(processorIdArray);//将一起的员工放入
                int outDeviceInfoResult = outDeviceInfo(deviceMaintenanceOrder);
                if (outDeviceInfoResult == 2001) {
                    return new CommonResult(1201, "获取设备关联信息失败", null);
                }
                outSelectOrder.add(deviceMaintenanceOrder);
            }
        } catch (Exception e) {
            logger.error("出现异常", e);
            return new CommonResult(2001, "数据库执行有异常", null);
        }
        return new CommonResult(200, "查询成功", outSelectOrder);
    }

    @Override
    public CommonResult trackDispatchInfo(String orderNumber) throws Exception {
        DeviceMaintenanceOrder deviceMaintenanceOrder;

        //return new CommonResult( 1201, "请求条件中，缺少必填参数", null);
        try {
            //根据订单号查出与他一同派单的人
            List<JSONObject> processorIdList = orderMapper.selectDispatchProcessorId(orderNumber);
            List<ProcessorId> processorIdArray = new ArrayList<>();
            for (int j = 0; j < processorIdList.size(); j++) {
                int processorId = processorIdList.get(j).getInteger("processor_id");
                ProcessorId outProcessorId = new ProcessorId();
                outProcessorId.setProcessorId(processorId);
                processorIdArray.add(outProcessorId);
            }
            //查询一些派单信息
            deviceMaintenanceOrder = orderMapper.selectDispatchOrderInfo(orderNumber, 0);
            deviceMaintenanceOrder.setProcessorIdArray(processorIdArray);//将一起的员工放入
            int outDeviceInfoResult = outDeviceInfo(deviceMaintenanceOrder);
            if (outDeviceInfoResult == 2001) {
                return new CommonResult(1201, "获取设备关联信息失败", null);
            }
        } catch (Exception e) {
            logger.error("出现异常", e);
            return new CommonResult(2001, "数据库执行有异常", null);
        }
        return new CommonResult(200, "查询成功", deviceMaintenanceOrder);
    }

    @Value("${file.uploadFolder}")
    private String uploadFolder;

    @Override
    public String uploadAcceptancePicture(HttpServletRequest request) throws IOException {
        DeviceMaintenanceOrder deviceMaintenanceOrder = new DeviceMaintenanceOrder();
        MultipartHttpServletRequest req = (MultipartHttpServletRequest) request;
        MultipartFile multipartFile = null;
        String type = null;
        String url;
        if (req.getFile("signImgFile") != null) {
            multipartFile = req.getFile("signImgFile");
            type = "signImg";
        } else if (req.getFile("missionImgFile") != null) {
            multipartFile = req.getFile("missionImgFile");
            type = "missionImg";
        }
        log.info("multipartFile==>" + multipartFile);
        String realPath = uploadFolder;
        System.out.println("realPath==>" + realPath);
        try {
            File dir = new File(realPath);
            if (!dir.exists()) {
                dir.mkdir();
            }
            Date dt = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
            String data = sdf.format(dt);
            String orderNumber = request.getParameter("orderNumber");
            int orderStatus = Integer.parseInt(request.getParameter("orderStatus"));
            String orderType = request.getParameter("orderType");//订单类型
            deviceMaintenanceOrder.setOrderNumber(orderNumber);
            deviceMaintenanceOrder.setOrderStatus(orderStatus);
            int maintenanceId = Integer.parseInt(orderNumber.substring(13));//取出该订单的序列号
            String imageName = data + maintenanceId + ".jpg";//图片的名字
            File file = new File(realPath, imageName);
            multipartFile.transferTo(file);
            url = "http://120.79.31.81/imagesUpload/" + imageName;
            System.out.println("url==>" + url);
            if (("signImg").equals(type)) {
                deviceMaintenanceOrder.setSignImg(url);
            } else if (("missionImg").equals(type)) {
                deviceMaintenanceOrder.setMissionImg(url);
            }
            //生成验证时间
            Calendar calendar = Calendar.getInstance(Locale.CHINA);
            Date date = calendar.getTime();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String acceptanceTime = dateFormat.format(date);
            deviceMaintenanceOrder.setAcceptanceTime(acceptanceTime);
            orderMapper.updateStatusByOrderNumber(deviceMaintenanceOrder); //进行更新状态、更新url
            int maintenanceId1 = orderMapper.selectMaintenanceIdByOrderNumber(deviceMaintenanceOrder);
            Log log = new Log();
            log.setIntroduction("device_maintenance");
            log.setModuleId(maintenanceId1);
            log.setCode("uploadAcceptancePicture");
            log.setDescription("上传图片");
            logMapper.insertSelective(log);
            if (("wash").equals(orderType)) {
                outDeviceInfo(deviceMaintenanceOrder);//得到这个订单所关联的设备
                int earlyWarningNum = deviceMaintenanceOrder.getDevices().getEarlyWarning().size();
                for (int i = 0; i < earlyWarningNum; i++) {
                    String deviceId = deviceMaintenanceOrder.getDevices().getEarlyWarning().get(i).getDeviceId();
                    orderMapper.updateIfInCleanOrder(deviceId, false);
                }
                int alarmNum = deviceMaintenanceOrder.getDevices().getAlarm().size();
                for (int i = 0; i < alarmNum; i++) {
                    String deviceId = deviceMaintenanceOrder.getDevices().getAlarm().get(i).getDeviceId();
                    orderMapper.updateIfInCleanOrder(deviceId, false);
                }
            }
        } catch (IOException e) {
            logger.error("出现异常", e);
            return "error";
        } catch (IllegalStateException e) {
            logger.error("出现异常", e);
            return "error";
        }
        return url;
    }

    @Override
    public CommonResult autoGenOrders() throws Exception {
        List<DeviceMaintenanceOrder> outDeviceMaintenanceOrderList = new ArrayList<>();
        int threshold = 1; //预警+报警数量的阈值
        int findEarlyWarningNum; //预警设备数量
        int findAlarmNum; //报警设备数量
        int allNum;
        //任务执行的时间
        Calendar calendar = Calendar.getInstance(Locale.CHINA);
        Date date = calendar.getTime();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String executeTime = dateFormat.format(date);
        try {
            int foodCompanySize = orderMapper.selectAllFoodCompany();
            for (int i = 1; i <= foodCompanySize; i++) {//访问每一个餐饮企业
                DeviceMaintenanceOrder outDeviceMaintenanceOrder = new DeviceMaintenanceOrder();
                List<JSONObject> earlyWarningList = orderMapper.selectDeviceIdByFoodId(i, "预警");
                List<JSONObject> alarmList = orderMapper.selectDeviceIdByFoodId(i, "报警");
                findEarlyWarningNum = earlyWarningList.size();
                findAlarmNum = alarmList.size();
                allNum = findEarlyWarningNum + findAlarmNum;
                //清洗价格
                double price = 20;
                double money = 0;
                List<JSONObject> addOrderNumberList = orderMapper.selectOrderNumberByStatus(i, 4);//等待派单员工处理的状态4前的单都可以增加新的设备进来
                int addOrderNumberSize = addOrderNumberList.size();
                if ((findEarlyWarningNum > 0 && addOrderNumberSize != 0) || (findAlarmNum > 0 && addOrderNumberSize != 0)) {//有未确认的订单并且也有预警或报警设备
                    //把新发现的设备添加到最新的一个订单里，并查询出该订单号的订单信息
                    DeviceMaintenanceOrder deviceMaintenanceOrder = new DeviceMaintenanceOrder();
                    String orderNumber = addOrderNumberList.get(addOrderNumberSize - 1).getString("order_number");
                    money = addOrderNumberList.get(addOrderNumberSize - 1).getDouble("money");
                    money += allNum * price;
                    deviceMaintenanceOrder.setOrderNumber(orderNumber);
                    deviceMaintenanceOrder.setIsDeleted(false);
                    List<DeviceMaintenanceOrder> oneDeviceMaintenanceOrderList = orderMapper.selectOrder(deviceMaintenanceOrder);
                    outDeviceMaintenanceOrder = oneDeviceMaintenanceOrderList.get(0);
                    outDeviceMaintenanceOrder.setMoney(money);
                    outDeviceMaintenanceOrder.setOrderStatus(2);
                    outDeviceMaintenanceOrder.setGenType("系统修改生成");//自动派单
                    outDeviceInfo(outDeviceMaintenanceOrder);
                    if (findEarlyWarningNum != 0 || findAlarmNum != 0) {
                        for (int m = 0; m < findEarlyWarningNum; m++) {//将剩余的预警设备加入订单
                            String findRemainDeviceId = earlyWarningList.get(m).getString("device_id");
                            OrderRelateDeviceId orderRelateDeviceId = new OrderRelateDeviceId();
                            orderRelateDeviceId.setDeviceId(findRemainDeviceId);
                            outDeviceMaintenanceOrder.getDevices().getEarlyWarning().add(orderRelateDeviceId);
                        }
                        for (int m = 0; m < findAlarmNum; m++) {//将剩余的报警设备加入订单
                            String findRemainDeviceId = alarmList.get(m).getString("device_id");
                            OrderRelateDeviceId orderRelateDeviceId = new OrderRelateDeviceId();
                            orderRelateDeviceId.setDeviceId(findRemainDeviceId);
                            outDeviceMaintenanceOrder.getDevices().getAlarm().add(orderRelateDeviceId);
                        }
                        //更新订单信息
                        CommonResult commonResult = update(JSON.toJSONString(outDeviceMaintenanceOrder));
                        if (commonResult.getCode() == 200) {
                            outDeviceMaintenanceOrderList.add((DeviceMaintenanceOrder) commonResult.getData());
                            //将新修改生成的清洗订单通知给餐饮企业
                            notification(outDeviceMaintenanceOrder, i, "food");
                        } else {
                            return new CommonResult(2001, "订单更新失败", null);
                        }
                    }
                } else if (allNum >= threshold) {//如果总和大于10，但是没有未确认的订单，则新增订单
                    OrderRelateType orderRelateType = new OrderRelateType();
                    List<OrderRelateDeviceId> outEarlyWarningList = new ArrayList<>();
                    List<OrderRelateDeviceId> outAlarmList = new ArrayList<>();
                    List<OrderRelateDeviceId> outNormalList = new ArrayList<>();
                    for (int m = 0; m < findEarlyWarningNum; m++) {//将剩余的预警设备加入订单
                        String findRemainDeviceId = earlyWarningList.get(m).getString("device_id");
                        OrderRelateDeviceId orderRelateDeviceId = new OrderRelateDeviceId();
                        orderRelateDeviceId.setDeviceId(findRemainDeviceId);
                        outEarlyWarningList.add(orderRelateDeviceId);
                    }
                    for (int m = 0; m < findAlarmNum; m++) {//将剩余的报警设备加入订单
                        String findRemainDeviceId = alarmList.get(m).getString("device_id");
                        OrderRelateDeviceId orderRelateDeviceId = new OrderRelateDeviceId();
                        orderRelateDeviceId.setDeviceId(findRemainDeviceId);
                        outAlarmList.add(orderRelateDeviceId);
                    }
                    orderRelateType.setEarlyWarning(outEarlyWarningList);
                    orderRelateType.setAlarm(outAlarmList);
                    orderRelateType.setNormal(outNormalList);
                    outDeviceMaintenanceOrder.setDevices(orderRelateType);
                    outDeviceMaintenanceOrder.setOrderType("wash");
                    outDeviceMaintenanceOrder.setFoodCompanyId(i);
                    outDeviceMaintenanceOrder.setTime(executeTime);//暂定
                    //outDeviceMaintenanceOrder.setMaintenanceTimeseg(1);//暂定
                    outDeviceMaintenanceOrder.setGenType("系统生成");//自动派单
                    money = allNum * price;
                    outDeviceMaintenanceOrder.setMoney(money);
                    CommonResult commonResult = add(JSON.toJSONString(outDeviceMaintenanceOrder));
                    if (commonResult.getCode() == 200) {
                        outDeviceMaintenanceOrder = (DeviceMaintenanceOrder) commonResult.getData();
                        int maintenanceId = orderMapper.selectMaintenanceIdByOrderNumber(outDeviceMaintenanceOrder);
                        Log log = new Log();
                        log.setIntroduction("device_maintenance");
                        log.setModuleId(maintenanceId);
                        log.setCode("autoGenOrder");
                        log.setDescription("自动生成订单");
                        logMapper.insertSelective(log);
                        outDeviceMaintenanceOrderList.add(outDeviceMaintenanceOrder);
                        //将新生成的清洗订单通知给餐饮企业
                        notification(outDeviceMaintenanceOrder, i, "food");
                    } else {
                        return new CommonResult(2001, "订单添加失败", null);
                    }
                }
                for (int k = 0; k < findEarlyWarningNum; k++) {
                    String deviceId = earlyWarningList.get(k).getString("device_id");
                    orderMapper.updateIfInCleanOrder(deviceId, true);//预警设备更新为已被加入订单
                }
                for (int k = 0; k < findAlarmNum; k++) {
                    String deviceId = alarmList.get(k).getString("device_id");//报警设备更新为已被加入订单
                    orderMapper.updateIfInCleanOrder(deviceId, true);
                }
            }
        } catch (Exception e) {
            logger.error("出现异常", e);
            return new CommonResult(2001, "数据库执行有异常", null);
        }
        return new CommonResult(200, executeTime + " 自动生成订单成功", outDeviceMaintenanceOrderList);
    }

    @Override
    public CommonResult updateStatusByOrderNumber(String json) throws Exception {
        DeviceMaintenanceOrder deviceMaintenanceOrder = JSON.parseObject(json, DeviceMaintenanceOrder.class);//转化为实体类
        if (deviceMaintenanceOrder.getOrderNumber() == null || deviceMaintenanceOrder.getOrderStatus() == null) {
            return new CommonResult(1201, "请求条件中，缺少必填参数", null);
        } else {
            try {
                //生成验证时间
                Calendar calendar = Calendar.getInstance(Locale.CHINA);
                Date date = calendar.getTime();
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String updateTime = dateFormat.format(date);
                deviceMaintenanceOrder.setUpdateTime(updateTime);
                orderMapper.updateStatusByOrderNumber(deviceMaintenanceOrder); //进行更新
                int maintenanceId = orderMapper.selectMaintenanceIdByOrderNumber(deviceMaintenanceOrder);
                Log log = new Log();
                log.setIntroduction("device_maintenance");
                log.setModuleId(maintenanceId);
                log.setCode("updateStatus");
                log.setDescription("更新订单状态");
                logMapper.insertSelective(log);
            } catch (Exception e) {
                logger.error("出现异常", e);
                return new CommonResult(2001, "数据库执行有异常", null);
            }
            return new CommonResult(200, "更新订单状态成功", null);
        }
    }

    public void notification(DeviceMaintenanceOrder deviceMaintenanceOrder, int companyId, String companyType) throws URISyntaxException, IOException {
        String templateId = "10LE8EXPuxfz-nrID0tTEa-lqFaoD7sx7MhawpzHaCI";
        String order = "2";
        String orderType = deviceMaintenanceOrder.getOrderType();
        String orderNumber = deviceMaintenanceOrder.getOrderNumber();
        String genType = deviceMaintenanceOrder.getGenType();
        Double money = deviceMaintenanceOrder.getMoney();
        String insertTime = deviceMaintenanceOrder.getInsertTime();
        //查找员工的openId
        String openId = userMapper.selectOpenIdByCompanyIdAndType(companyId, companyType);
        // 创建Httpclient对象
        CloseableHttpClient Httpclient = HttpClients.createDefault();
        // 定义请求的参数
        URI uri = new URIBuilder("https://m170973k01.51mypc.cn/test3/BUS_MANAGE/sendMessage2.php").setParameter("openid", openId).addParameter("template_id", templateId).addParameter("order", order)
                .addParameter("data1", orderType).addParameter("data2", orderNumber).addParameter("data3", genType).addParameter("data4", String.valueOf(money)).addParameter("data5", insertTime).build();
        System.out.println("uri==>" + uri);
        // 创建http GET请求
        HttpGet httpGet = new HttpGet(uri);
        //response 对象
        CloseableHttpResponse response = null;
        try {
            // 执行http get请求
            response = Httpclient.execute(httpGet);
            String content = EntityUtils.toString(response.getEntity(), "UTF-8");
            System.out.println("content==>" + content);
            //responseObject = JSONObject.parseObject ( content );
            // 若返回状态是否为200，则把token放入数据库
            if (response.getStatusLine().getStatusCode() != 200) {
                int maintenanceId = orderMapper.selectMaintenanceIdByOrderNumber(deviceMaintenanceOrder);
                Log log = new Log();
                log.setIntroduction("device_maintenance");
                log.setModuleId(maintenanceId);
                log.setCode("notificationFail");
                log.setDescription("通知失败");
                logMapper.insertSelective(log);
            }
        } finally {
            if (response != null) {
                response.close();
            }
            Httpclient.close();
        }
    }
}

