package cn.guet.kitchen.entity;

import java.io.Serializable;
import java.util.List;

/**
 * @introduce:
 * @author: cyan
 * @DATE: 2021/3/31
 **/
public class OrderRelateType implements Serializable {
    private List<OrderRelateDeviceId> normal;
    private List<OrderRelateDeviceId> earlyWarning;
    private List<OrderRelateDeviceId> alarm;

    public List<OrderRelateDeviceId> getNormal() {
        return normal;
    }

    public void setNormal(List<OrderRelateDeviceId> normal) {
        this.normal = normal;
    }

    public List<OrderRelateDeviceId> getEarlyWarning() {
        return earlyWarning;
    }

    public void setEarlyWarning(List<OrderRelateDeviceId> earlyWarning) {
        this.earlyWarning = earlyWarning;
    }

    public List<OrderRelateDeviceId> getAlarm() {
        return alarm;
    }

    public void setAlarm(List<OrderRelateDeviceId> alarm) {
        this.alarm = alarm;
    }
}
