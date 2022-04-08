package cn.guet.kitchen.service.serviceimpl;

import cn.guet.kitchen.entity.Authority;
import cn.guet.kitchen.entity.AuthorityList;
import cn.guet.kitchen.entity.AuthorityNameList;
import cn.guet.kitchen.mapper.AuthorityMapper;
import cn.guet.kitchen.service.AuthorityService;
import cn.guet.kitchen.entity.CommonResult;
import com.alibaba.fastjson.JSON;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * @introduce:
 * @author: cyan
 * @DATE: 2021/4/10
 **/
@Service
public class AuthorityServiceImpl implements AuthorityService {
    @Resource
    private AuthorityMapper authorityMapper;

    @Override
    public CommonResult insertSelective(String json) {
        Authority authority;
        try {
            authority = JSON.parseObject(json, Authority.class);//转化为实体类
            //生成下单时间
            Calendar calendar = Calendar.getInstance(Locale.CHINA);
            Date date = calendar.getTime();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String insertTime = dateFormat.format(date);
            authority.setCreateTime(insertTime);
            authorityMapper.insertSelective(authority);
        } catch(Exception e) {
            e.printStackTrace();
            return new CommonResult(2001, "数据库执行有异常", null);
        }
        return new CommonResult( 200, "新增成功", authority);
    }

    @Override
    public CommonResult deleteByPrimaryKey(int authorityId) {
        if(authorityId == 0){
            return new CommonResult( 1201, "请求条件中，缺少必填参数", null);
        }
        try {
            authorityMapper.deleteByPrimaryKey(authorityId);
        } catch(Exception e) {
            e.printStackTrace();
            return new CommonResult(2001, "数据库执行有异常", null);
        }
        return new CommonResult( 200, "删除成功", null);
    }

    @Override
    public CommonResult updateByPrimaryKeySelective(String json) {
        Authority authority;
        try {
            authority = JSON.parseObject(json, Authority.class);//转化为实体类
            //插入更新时间
            Calendar calendar = Calendar.getInstance(Locale.CHINA);
            Date date = calendar.getTime();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String updateTime = dateFormat.format(date);
            authority.setModifiedTime(updateTime);
            int id = authority.getAuthorityId();
            authorityMapper.updateByPrimaryKeySelective(authority); //更新数据库
            authority = authorityMapper.selectByPrimaryKey(authority.getAuthorityId());
        } catch(Exception e) {
            e.printStackTrace();
            return new CommonResult( 2003, "更新失败", null);
        }
        return new CommonResult( 200, "更新成功", authority);
    }

    @Override
    public CommonResult selectByUserType(String userType) {
        AuthorityNameList authorityNameList = new AuthorityNameList();
        try {
            authorityNameList.setAuthorityNameList(authorityMapper.selectByUserType(userType)); //更新数据库
        } catch(Exception e) {
            e.printStackTrace();
            return new CommonResult( 2003, "查询失败", null);
        }
        return new CommonResult( 200, "查询成功", authorityNameList);
    }

    @Override
    public CommonResult selectAllInfo() {
        AuthorityList authorityList = new AuthorityList();
        try {
            authorityList.setAuthorityList(authorityMapper.selectAllInfo()); //更新数据库
        } catch(Exception e) {
            e.printStackTrace();
            return new CommonResult( 2003, "查询失败", null);
        }
        return new CommonResult( 200, "查询成功", authorityList);
    }
}
