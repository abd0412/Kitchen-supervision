package cn.guet.kitchen.mapper;

import cn.guet.kitchen.entity.NetworkGate;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface NetworkGateMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(NetworkGate record);

    int insertSelective(NetworkGate record);

    List<NetworkGate> selectBySomeKey(NetworkGate record);

    NetworkGate selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(NetworkGate record);

    int updateByPrimaryKey(NetworkGate record);
}