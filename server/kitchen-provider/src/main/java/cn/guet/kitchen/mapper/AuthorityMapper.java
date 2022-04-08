package cn.guet.kitchen.mapper;

import cn.guet.kitchen.entity.Authority;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @introduce:
 * @author: cyan
 * @DATE: 2021/4/10
 **/
@Mapper
public interface AuthorityMapper {
    int insertSelective(Authority authority);

    int deleteByPrimaryKey(Integer authorityId);

    //int insert(Authority record);

    int updateByPrimaryKeySelective(Authority authority);

    Authority selectByPrimaryKey(Integer authorityId);

    List<JSONObject> selectByUserType(String userType);

    List<Authority> selectAllInfo();

    //int updateByPrimaryKey(Authority record);
}