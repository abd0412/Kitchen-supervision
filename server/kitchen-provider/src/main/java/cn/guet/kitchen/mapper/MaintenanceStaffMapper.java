package cn.guet.kitchen.mapper;

import cn.guet.kitchen.entity.MaintenanceStaff;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @introduce:
 * @author: cyan
 * @DATE: 2021/4/5
 **/
@Mapper
public interface MaintenanceStaffMapper {
    int deleteByPrimaryKey(MaintenanceStaff maintenanceStaff);

    //int insert(MaintenanceStaff record);
    Integer selectMinDispatchNum();

    int insertSelective(MaintenanceStaff maintenanceStaff);

    List<MaintenanceStaff> selectByPrimaryKey(MaintenanceStaff maintenanceStaff);

    //int updateByPrimaryKeySelective(MaintenanceStaff record);

    int updateByPrimaryKey(MaintenanceStaff maintenanceStaff);
}