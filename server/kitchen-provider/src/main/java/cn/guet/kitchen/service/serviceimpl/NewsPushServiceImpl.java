package cn.guet.kitchen.service.serviceimpl;

import cn.guet.kitchen.entity.Article;
import cn.guet.kitchen.entity.ArticleList;
import cn.guet.kitchen.entity.CommonResult;
import cn.guet.kitchen.mapper.ArticleMapper;
import cn.guet.kitchen.mapper.DeviceAlarmMapper;
import cn.guet.kitchen.mapper.UserMapper;
import cn.guet.kitchen.service.NewsPushService;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
@Slf4j
public class NewsPushServiceImpl implements NewsPushService {
    @Resource
    private DeviceAlarmMapper deviceAlarmMapper;
    @Resource
    private UserMapper userMapper;
    @Resource
    private ArticleMapper articleMapper;

    @Override
    public CommonResult selectPushInfo() {
        JSONObject resJsonObject = new JSONObject();
        try {
            //查找预警/报警设备
            JSONArray abnormalJsonArray = new JSONArray();
            List<JSONObject> abnormalDeviceInfoList = deviceAlarmMapper.selectAbnormalDeviceInfo();
            for (int i = 0; i < abnormalDeviceInfoList.size(); i++) {
                JSONObject abnormalDeviceInfo = abnormalDeviceInfoList.get(i);
                abnormalJsonArray.add(abnormalDeviceInfo);
            }
            resJsonObject.put("abnormalDeviceInfo", abnormalJsonArray);
            //会员即将到期
            JSONArray userJsonArray = new JSONArray();
            List<JSONObject> UserList = userMapper.selectUserByLessMoney();
            for (int i = 0; i < UserList.size(); i++) {
                JSONObject user = UserList.get(i);
                user.put("message", "会员即将到期");
                userJsonArray.add(user);
            }
            resJsonObject.put("memberExpire", userJsonArray);
        } catch (Exception e) {
            log.error("消息推送出现异常", e);
            return new CommonResult(2001, "数据库执行有异常", null);
        }
        return new CommonResult(200, "消息更新成功", resJsonObject);
    }

    @Override
    public CommonResult selectByCompanyIdAndType(int companyId, String companyType) {
        ArticleList articleList = new ArticleList();
        try {
            //做一个类型的转换
            if ("repast".equals(companyType)) {
                companyType = "food_company";
            } else if ("operation".equals(companyType)) {
                companyType = "operation_company";
            } else if ("maintenance".equals(companyType)) {
                companyType = "maintenance_company";
            }
            List<Article> articles =articleMapper.selectByCompanyIdAndType(companyId, companyType);
            articleList.setNewsList(articles);
        } catch (Exception e) {
            log.error("获取某公司所有消息出现异常", e);
            return new CommonResult(2001, "数据库执行有异常", null);
        }
        return new CommonResult(200, "获取消息成功", articleList);
    }
}
