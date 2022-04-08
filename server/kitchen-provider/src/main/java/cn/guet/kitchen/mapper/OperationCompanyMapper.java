package cn.guet.kitchen.mapper;

import cn.guet.kitchen.entity.OperationCompany;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @introduce:
 * @author: cyan
 * @DATE: 2021/4/5
 **/
@Mapper
public interface OperationCompanyMapper {
    int deleteByPrimaryKey(OperationCompany operationCompany);

    //int insert(OperationCompany record);
    Integer selectMinDispatchNum();

    int insertSelective(OperationCompany record);

    List<OperationCompany> selectByPrimaryKey(@Param("operationCompanyId") Integer operationCompanyId);

    //int updateByPrimaryKeySelective(OperationCompany record);

    int updateByPrimaryKey(OperationCompany operationCompany);
}