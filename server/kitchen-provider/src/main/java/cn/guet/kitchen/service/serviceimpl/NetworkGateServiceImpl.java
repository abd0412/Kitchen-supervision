package cn.guet.kitchen.service.serviceimpl;

import cn.guet.kitchen.entity.Log;
import cn.guet.kitchen.entity.NetworkGate;
import cn.guet.kitchen.mapper.LogMapper;
import cn.guet.kitchen.mapper.NetworkGateMapper;
import cn.guet.kitchen.service.NetworkGateService;
import cn.guet.kitchen.entity.CommonResult;
import com.alibaba.fastjson.JSONArray;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
@Slf4j
public class NetworkGateServiceImpl implements NetworkGateService {
    @Resource
    private LogMapper logMapper;
    @Resource
    private NetworkGateMapper networkGateMapper;

    @Override
    public CommonResult deleteByPrimaryKey(Integer id) {
        try{
            networkGateMapper.deleteByPrimaryKey(id);
            Log log = new Log();
            log.setIntroduction("network_gate");
            log.setModuleId(id);
            log.setCode("deleteNetworkGate");
            log.setDescription("删除网关");
            logMapper.insertSelective(log);
        }catch(Exception e){
            log.error("删除监管/网关设备出现异常", e);
            return new CommonResult( 2001, "数据库执行有异常", null);
        }
        return new CommonResult( 200, "删除成功", null);
    }

    @Override
    public CommonResult insertSelective(NetworkGate record) {
        try{
            Calendar calendar = Calendar.getInstance(Locale.CHINA);
            Date date = calendar.getTime();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String insertTime = dateFormat.format(date);
            record.setInsertTime(insertTime);
            networkGateMapper.insertSelective(record);
            Log log = new Log();
            log.setIntroduction("network_gate");
            log.setModuleId(record.getId());
            log.setCode("addNetworkGate");
            log.setDescription("新增网关");
            logMapper.insertSelective(log);
        }catch(Exception e){
            log.error("注册监管/网关设备出现异常", e);
            return new CommonResult( 2001, "数据库执行有异常", null);
        }
        return new CommonResult( 200, "注册成功", record);
    }

    @Override
    public CommonResult selectBySomeKey(NetworkGate record) {
        List<NetworkGate> networkGateList = new ArrayList<>();
        JSONArray jsonArray = new JSONArray();
        try{
            networkGateList = networkGateMapper.selectBySomeKey(record);
            for (NetworkGate networkGate : networkGateList) {
                jsonArray.add(networkGate);
            }
        }catch(Exception e){
            log.error("注册监管/网关设备出现异常", e);
            return new CommonResult( 2001, "数据库执行有异常", null);
        }
        return new CommonResult( 200, "查询成功", jsonArray);
    }

    @Override
    public CommonResult updateByPrimaryKeySelective(NetworkGate record) {
        try{
            Calendar calendar = Calendar.getInstance(Locale.CHINA);
            Date date = calendar.getTime();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String updateTime = dateFormat.format(date);
            record.setUpdateTime(updateTime);
            networkGateMapper.updateByPrimaryKeySelective(record);
            Log log = new Log();
            log.setIntroduction("network_gate");
            log.setModuleId(record.getId());
            log.setCode("updateNetworkGate");
            log.setDescription("修改网关");
            logMapper.insertSelective(log);
        }catch(Exception e){
            log.error("修改监管/网关设备出现异常", e);
            return new CommonResult( 2001, "数据库执行有异常", null);
        }
        return new CommonResult( 200, "修改成功", null);
    }
}
