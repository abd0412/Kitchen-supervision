package cn.guet.kitchen.entity;

import java.util.List;

/**
 * @introduce:
 * @author: cyan
 * @DATE: 2021/4/4
 **/
public class SelectOrder {
    private int numberOfPages;

    private List<DeviceMaintenanceOrder> selectResult;

    private int selectCount;//总共多少条

    List<Device> DList;

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public List<DeviceMaintenanceOrder> getSelectResult() {
        return selectResult;
    }

    public void setSelectResult(List<DeviceMaintenanceOrder> selectResult) {
        this.selectResult = selectResult;
    }

    public int getSelectCount() {
        return selectCount;
    }

    public void setSelectCount(int selectCount) {
        this.selectCount = selectCount;
    }

    public List<Device> getDList() {
        return DList;
    }

    public void setDList(List<Device> DList) {
        this.DList = DList;
    }
}
