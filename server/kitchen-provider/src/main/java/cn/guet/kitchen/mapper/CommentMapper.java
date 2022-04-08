package cn.guet.kitchen.mapper;

import cn.guet.kitchen.entity.Comment;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CommentMapper {

    //int insert(Comment record);

    int insertSelective(Comment record);

    List<Comment> selectInfoByUserId(String userId);

    //int deleteByPrimaryKey(Long id);

    //Comment selectByPrimaryKey(Long id);

    //int updateByPrimaryKeySelective(Comment record);

    //int updateByPrimaryKey(Comment record);
}