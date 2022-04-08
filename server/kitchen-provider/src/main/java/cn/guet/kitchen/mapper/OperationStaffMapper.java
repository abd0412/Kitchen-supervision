package cn.guet.kitchen.mapper;

import cn.guet.kitchen.entity.OperationStaff;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**

* @introduce: 

* @author: cyan

* @DATE: 2021/4/9

**/
@Mapper
public interface OperationStaffMapper {
    int deleteByPrimaryKey(OperationStaff operationStaff);

    //int insert(OperationStaff record);
    Integer selectMinDispatchNum();

    int insertSelective(OperationStaff operationStaff);

    List<OperationStaff> selectByPrimaryKey(OperationStaff operationStaff);

    //int updateByPrimaryKeySelective(OperationStaff record);

    int updateByPrimaryKey(OperationStaff operationStaff);
}