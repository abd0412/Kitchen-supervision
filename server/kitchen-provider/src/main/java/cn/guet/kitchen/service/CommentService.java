package cn.guet.kitchen.service;

import cn.guet.kitchen.entity.Comment;
import cn.guet.kitchen.entity.CommonResult;

public interface CommentService {
    //int insert(Comment record);

    CommonResult insertSelective(Comment comment);

    CommonResult selectInfoByUserId(String userId);

    //CommonResult selectByPrimaryKey(Long id);

    //CommonResult deleteByPrimaryKey(Long id);

    //int updateByPrimaryKeySelective(Comment record);

    //int updateByPrimaryKey(Comment record);
}
