package cn.guet.kitchen.mapper;

import cn.guet.kitchen.entity.OpenId;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OpenIdMapper {
    int deleteByPrimaryKey(String openid);

    int insert(OpenId record);

    int insertSelective(OpenId record);

    OpenId selectByPrimaryKey(String openid);

    int updateByPrimaryKeySelective(OpenId record);

    int updateByPrimaryKey(OpenId record);
}