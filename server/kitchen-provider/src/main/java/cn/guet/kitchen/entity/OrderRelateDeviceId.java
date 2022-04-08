package cn.guet.kitchen.entity;

import java.io.Serializable;

/**
 * @introduce:
 * @author: cyan
 * @DATE: 2021/3/31
 **/
public class OrderRelateDeviceId implements Serializable {
    private String deviceId;
    private Integer seqNum;
    private Integer gateId;

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public Integer getSeqNum() {
        return seqNum;
    }

    public void setSeqNum(Integer seqNum) {
        this.seqNum = seqNum;
    }

    public Integer getGateId() {
        return gateId;
    }

    public void setGateId(Integer gateId) {
        this.gateId = gateId;
    }
}
