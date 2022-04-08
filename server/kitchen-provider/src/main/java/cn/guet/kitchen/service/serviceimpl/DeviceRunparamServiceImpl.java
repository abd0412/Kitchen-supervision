package cn.guet.kitchen.service.serviceimpl;

import cn.guet.kitchen.entity.DeviceRunparam;
import cn.guet.kitchen.entity.DeviceRunparamDeviceIdList;
import cn.guet.kitchen.mapper.DeviceRunparamMapper;
import cn.guet.kitchen.service.DeviceRunparamService;
import cn.guet.kitchen.entity.CommonResult;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @introduce:
 * @author: cyan
 * @DATE: 2021/4/9
 **/
@Service
@Slf4j
public class DeviceRunparamServiceImpl implements DeviceRunparamService {
    @Resource
    private DeviceRunparamMapper deviceRunparamMapper;
    @Override
    public CommonResult selectByStatus(String status, int companyId) {
        DeviceRunparamDeviceIdList deviceRunparamDeviceIdList = new DeviceRunparamDeviceIdList();
        try{
            List<JSONObject> aaa = deviceRunparamMapper.selectDeviceId(status, companyId);
            deviceRunparamDeviceIdList.setDeviceIdList(aaa);
        } catch(Exception e) {
            e.printStackTrace();
            return new CommonResult( 2001, "数据库执行有异常", null);
        }
        return new CommonResult( 200, "查询成功", deviceRunparamDeviceIdList);
    }

    @Override
    public CommonResult selectMonitorInfo(String deviceId) {
        DeviceRunparam deviceRunparam;
        try{
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            deviceRunparam = deviceRunparamMapper.selectMonitorInfo(deviceId);
            // 获取当前时间
            Date date = new Date();
            String nowtime = df.format(date);
            Date d1 = df.parse(nowtime);
            //获取近期上线时间，并做减法，得到设备开机后运行时长
            long diff = d1.getTime() - deviceRunparam.getNearOnlineTime().getTime();
            // 秒
            long sc = diff / (1000);
            deviceRunparam.setRealRunningTime(String.valueOf(sc));
            //获取最近一次维保时间，并做减法，得到设备维保后运行时长
            long diff1 = d1.getTime() - deviceRunparam.getNearMaintanceTime().getTime();
            // 微秒化为秒
            long sc1 = diff1 / (1000);
            deviceRunparam.setUseTimeAfterMaintenance(String.valueOf(sc1));
        } catch(Exception e) {
            log.error("查询设备监控信息出现异常", e);
            return new CommonResult( 2001, "数据库执行有异常", null);
        }
        return new CommonResult( 200, "查询成功", deviceRunparam);
    }
}
