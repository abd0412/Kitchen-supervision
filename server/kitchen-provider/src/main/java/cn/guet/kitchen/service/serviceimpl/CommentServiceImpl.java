package cn.guet.kitchen.service.serviceimpl;

import cn.guet.kitchen.entity.Comment;
import cn.guet.kitchen.entity.Log;
import cn.guet.kitchen.mapper.CommentMapper;
import cn.guet.kitchen.mapper.LogMapper;
import cn.guet.kitchen.service.CommentService;
import cn.guet.kitchen.entity.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

@Service
@Slf4j
public class CommentServiceImpl implements CommentService {
    @Resource
    private LogMapper logMapper;
    @Resource
    private CommentMapper commentMapper;

    @Override
    public CommonResult insertSelective(Comment comment) {
        if(comment.getUserId()==null||comment.getOrderNumber()==null||comment.getClientEstimate()==null){
            return new CommonResult( 1201, "请求条件中，缺少必填参数", null);
        }else {
            try {
                //生成评价时间
                Calendar calendar = Calendar.getInstance(Locale.CHINA);
                Date date = calendar.getTime();
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String commentTime = dateFormat.format(date);
                comment.setCommentTime(commentTime);
                commentMapper.insertSelective(comment); //进行更新
                Log log = new Log();
                log.setIntroduction("comment");
                log.setModuleId(Integer.parseInt(comment.getId().toString()));
                log.setCode("addComment");
                log.setDescription("新增订单评价");
                logMapper.insertSelective(log);
            } catch(Exception e){
                log.error("出现异常", e);
                return new CommonResult( 2001, "数据库执行有异常", null);
            }
            return new CommonResult(200, "评价成功", null);
        }
    }

    @Override
    public CommonResult selectInfoByUserId(String userId) {
        List<Comment> commentList;
        try {
            commentList =  commentMapper.selectInfoByUserId(userId); //进行更新
        } catch(Exception e){
            log.error("出现异常", e);
            return new CommonResult( 2001, "数据库执行有异常", null);
        }
        return new CommonResult(200, "查询成功", commentList);
    }
}
