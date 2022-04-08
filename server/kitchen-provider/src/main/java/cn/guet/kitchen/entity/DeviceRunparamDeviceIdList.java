package cn.guet.kitchen.entity;
import com.alibaba.fastjson.JSONObject;


import java.util.List;

/**
 * @introduce:
 * @author: cyan
 * @DATE: 2021/4/9
 **/
public class DeviceRunparamDeviceIdList {
    private List<JSONObject> deviceIdList;

    public List<JSONObject> getDeviceIdList() {
        return deviceIdList;
    }

    public void setDeviceIdList(List<JSONObject> deviceIdList) {
        this.deviceIdList = deviceIdList;
    }
}
