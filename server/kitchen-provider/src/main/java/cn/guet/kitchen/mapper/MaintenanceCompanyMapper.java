package cn.guet.kitchen.mapper;

import cn.guet.kitchen.entity.MaintenanceCompany;
import org.apache.ibatis.annotations.Mapper;

/**
 * @introduce:
 * @author: cyan
 * @DATE: 2021/4/5
 **/
@Mapper
public interface MaintenanceCompanyMapper {
    int deleteByPrimaryKey(MaintenanceCompany MaintenanceCompany);

    //int insert(MaintenanceCompany record);

    Integer selectMinDispatchNum();

    int insertSelective(MaintenanceCompany record);

    MaintenanceCompany selectByPrimaryKey(Integer maintenanceCompanyId);

    //int updateByPrimaryKeySelective(MaintenanceCompany record);

    int updateByPrimaryKey(MaintenanceCompany MaintenanceCompany);
}