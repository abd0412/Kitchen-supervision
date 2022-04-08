package cn.guet.kitchen.mapper;

import cn.guet.kitchen.entity.FoodCompany;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**

* @introduce: 

* @author: cyan

* @DATE: 2021/4/2

**/
@Mapper
public interface FoodCompanyMapper {
    int deleteByPrimaryKey(FoodCompany foodCompany);

    //int insert(FoodCompany record);

    int insertSelective(FoodCompany foodCompany);

    List<FoodCompany> selectByPrimaryKey(@Param("companyId") Integer companyId);

    int updateByPrimaryKeySelective(FoodCompany record);

    int updateByPrimaryKey(FoodCompany foodCompany);
}