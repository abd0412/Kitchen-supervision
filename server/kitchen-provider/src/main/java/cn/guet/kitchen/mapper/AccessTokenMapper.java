package cn.guet.kitchen.mapper;

import cn.guet.kitchen.entity.AccessToken;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AccessTokenMapper {
    int deleteByPrimaryKey(String appid);

    int insert(AccessToken record);

    int insertSelective(AccessToken record);

    AccessToken selectByPrimaryKey(String appid);

    int updateByPrimaryKeySelective(AccessToken record);

    int updateByPrimaryKey(AccessToken record);

}