package cn.guet.kitchen.mapper;

import cn.guet.kitchen.entity.User;
import com.alibaba.fastjson.JSONObject;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserMapper {
    int deleteByPrimaryKey(Long id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    int selectCompanyIdAccountNumber(User user);

    JSONObject selectOpenidMoney(String openid);

    int updateByOpenid(User user);

    List<User> selectCompanyIdMember();

    int updateMoneyMemberByCompanyId(User user);

    List<JSONObject> selectUserByLessMoney();

    String selectOpenIdByCompanyIdAndType( @Param("companyId") Integer companyId, @Param("userType") String userType);
}