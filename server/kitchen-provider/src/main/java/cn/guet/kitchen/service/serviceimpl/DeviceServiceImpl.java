package cn.guet.kitchen.service.serviceimpl;

import cn.guet.kitchen.entity.Device;
import cn.guet.kitchen.entity.DeviceRunparam;
import cn.guet.kitchen.entity.Log;
import cn.guet.kitchen.entity.SelectOrder;
import cn.guet.kitchen.mapper.DeviceMapper;
import cn.guet.kitchen.mapper.DeviceRunparamMapper;
import cn.guet.kitchen.mapper.LogMapper;
import cn.guet.kitchen.service.DeviceService;
import cn.guet.kitchen.entity.CommonResult;
import com.alibaba.fastjson.JSON;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/**
 * @introduce:
 * @author: cyan
 * @DATE: 2021/4/7
 **/
@Service
public class DeviceServiceImpl implements DeviceService {
    @Resource
    private LogMapper logMapper;
    @Resource
    private DeviceMapper deviceMapper;
    @Resource
    private DeviceRunparamMapper deviceRunparamMapper;
    @Override
    public CommonResult insertSelective(String json) {
        Device device = JSON.parseObject(json, Device.class);//转化为实体类
        if(device.getDeviceId()==null||device.getCompanyId()==null||device.getManufacturerId()==null||device.getSeqNum()==null||device.getGateId()==null){
            return new CommonResult( 1201, "请求条件中，缺少必填参数", null);
        }
        try {
            //生成下单时间
            Calendar calendar = Calendar.getInstance(Locale.CHINA);
            Date date = calendar.getTime();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String insertTime = dateFormat.format(date);
            device.setInsertTime(insertTime);
            /*int fSeqNum = deviceMapper.selectByCompanyId(device.getCompanyId());
            device.setSeqNum(fSeqNum+1);*/
            device.setDeviceCode(device.getDeviceId());
            deviceMapper.insertSelective(device);
            Log log = new Log();
            log.setIntroduction("device");
            log.setModuleId(Integer.parseInt(device.getDeviceId()));
            log.setCode("addDevice");
            log.setDescription("添加设备");
            logMapper.insertSelective(log);
            DeviceRunparam deviceRunparam = new DeviceRunparam();
            deviceRunparam.setDeviceId(device.getDeviceId());
            deviceRunparam.setLastTime(device.getNearMaintanceTime());
            deviceRunparam.setMaintenanceRound(Integer.parseInt(device.getMaintenanceRound()));
            deviceRunparamMapper.insertRunparamByDeviceId(deviceRunparam);
            Log log1 = new Log();
            log1.setIntroduction("device_runparam");
            log1.setModuleId(deviceRunparam.getParamId());
            log1.setCode("addDeviceAndRunparam");
            log1.setDescription("在设备运行参数表中添加新注册的设备及两个参数值");
            logMapper.insertSelective(log1);
            //device = deviceMapper.selectByPrimaryKey(device.getDeviceCode());
        } catch(Exception e) {
            e.printStackTrace();
            return new CommonResult(2001, "数据库执行有异常", null);
        }
        return new CommonResult( 200, "新增设备成功", device);
    }

    @Override
    public CommonResult deleteByPrimaryKey(String deviceId) {
        if(deviceId == null){
            return new CommonResult( 1201, "请求条件中，缺少必填参数", null);
        }
        try {
            deviceMapper.deleteByPrimaryKey(deviceId);
            Log log2 = new Log();
            log2.setIntroduction("device");
            log2.setModuleId(Integer.parseInt(deviceId));
            log2.setCode("deleteDevice");
            log2.setDescription("删除设备");
            logMapper.insertSelective(log2);
            //删除参数表中的设备
            deviceMapper.updateRIsDeletedByPrimary(deviceId);
            Log log3 = new Log();
            log3.setIntroduction("device_runparam");
            log3.setModuleId(Integer.parseInt(deviceId));
            log3.setCode("deleteDeviceAndRunparam");
            log3.setDescription("在设备运行参数表中删除某个设备信息");
            logMapper.insertSelective(log3);
        } catch(Exception e) {
            e.printStackTrace();
            return new CommonResult(2001, "数据库执行有异常", null);
        }
        return new CommonResult( 200, "删除设备成功", null);
    }

    @Override
    public CommonResult updateByPrimaryKey(String json) {
        int SeqNum = 0;
        Device device = JSON.parseObject(json, Device.class);//转化为实体类
        if(device.getDeviceId()==null||device.getCompanyId()==null||device.getManufacturerId()==null||device.getSeqNum()==null||device.getGateId()==null){
            return new CommonResult( 1201, "请求条件中，缺少必填参数", null);
        }
        try {
            //生成更新时间
            Calendar calendar = Calendar.getInstance(Locale.CHINA);
            Date date = calendar.getTime();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String updateTime = dateFormat.format(date);
            device.setUpdateTime(updateTime);
            /*int fCompanyId = deviceMapper.selectCompanyIdByPrimaryKey(device.getDeviceId());//查找设备原来在哪个餐饮企业
            int fSeqNum = deviceMapper.selectByCompanyId(device.getCompanyId());
            if(fCompanyId == device.getCompanyId()){//如果就在原来餐饮企业
                SeqNum = fSeqNum;//序号不变
            }else{
                SeqNum = fSeqNum+1;//否则新企业加1
            }
            device.setSeqNum(SeqNum);*/
            deviceMapper.updateByPrimaryKey(device);
            Log log4 = new Log();
            log4.setIntroduction("device");
            log4.setModuleId(Integer.parseInt(device.getDeviceId()));
            log4.setCode("updateDevice");
            log4.setDescription("修改设备");
            logMapper.insertSelective(log4);
            deviceMapper.updateRunparamBydeviceId(device);
            Log log5 = new Log();
            log5.setIntroduction("device_runparam");
            log5.setModuleId(Integer.parseInt(device.getDeviceId()));
            log5.setCode("updateDeviceAndRunparam");
            log5.setDescription("在设备运行参数表中修改某个设备的两个参数信息");
            logMapper.insertSelective(log5);
            device = deviceMapper.selectByPrimaryKey(device.getDeviceId());
        } catch(Exception e) {
            e.printStackTrace();
            return new CommonResult(2001, "数据库执行有异常", null);
        }
        return new CommonResult( 200, "修改设备信息成功", device);
    }

    @Override
    public CommonResult selectDevice(String json) {
        int pageNumber; //页号
        int count = 10; //每页10行
        int startSerial; //本页开始计数
        int endSerial; //本页结束计数
        int selectOrderListSize; //查找的订单结果
        int numberOfPages; //页面数量 List<Device> DList
        SelectOrder selectOrder = new SelectOrder();
        Device device = JSON.parseObject(json, Device.class);//转化为实体类
        try {
            if (0 == device.getPageNumber()) {
                pageNumber = 1;
            } else {
                pageNumber = device.getPageNumber();
            }
            startSerial = (pageNumber - 1) * count;
            endSerial = startSerial + count;
            device.setIsDeleted(false);//没有删除的
            List<Device> selectOrderList = deviceMapper.selectDevice(device);
            selectOrderListSize = selectOrderList.size();
            if (endSerial > selectOrderListSize) {
                endSerial = selectOrderListSize;
            }
            for (int i = startSerial; i < endSerial; i++) {
                selectOrderList.get(i).setPageNumber(pageNumber);//属于哪一页
                selectOrderList.get(i).setOutSelectSerial(i+1);//编序号
            }
            numberOfPages = (int) Math.ceil((double) selectOrderListSize / count);
            selectOrder.setDList(selectOrderList);
            selectOrder.setNumberOfPages(numberOfPages);
            selectOrder.setSelectCount(selectOrderListSize);
        } catch(Exception e) {
            e.printStackTrace();
            return new CommonResult(2001, "数据库执行有异常", null);
        }
        return new CommonResult( 200, "查询设备成功", selectOrder);
    }
}
