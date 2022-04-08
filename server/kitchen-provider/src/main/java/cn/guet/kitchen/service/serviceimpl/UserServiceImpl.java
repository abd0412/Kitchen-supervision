package cn.guet.kitchen.service.serviceimpl;

import cn.guet.kitchen.entity.Log;
import cn.guet.kitchen.entity.User;
import cn.guet.kitchen.mapper.LogMapper;
import cn.guet.kitchen.mapper.UserMapper;
import cn.guet.kitchen.service.UserService;
import cn.guet.kitchen.entity.CommonResult;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;


@Service
@Slf4j
public class UserServiceImpl implements UserService {
    @Resource
    private LogMapper logMapper;
    @Resource
    private UserMapper userMapper;
    @Override
    public JSONObject check(String json) {
        JSONObject returnJsonObject = new JSONObject();
        User user = JSON.parseObject(json, User.class);
        if(user.getCompanyId()==null|| user.getUserName()==null||user.getOpenid()==null){
            returnJsonObject.put("Code", 1201);
            returnJsonObject.put("Message", "请求条件中，缺少必填参数");
            return returnJsonObject;
        }
        try {
            long id = userMapper.selectCompanyIdAccountNumber(user);
            user.setId(id);
            userMapper.updateByPrimaryKeySelective(user);
        } catch(Exception e) {
            log.error("出现异常", e);
            returnJsonObject.put("Code", 2001);
            returnJsonObject.put("Message", "无此用户，验证失败");
            return returnJsonObject;
        }
        returnJsonObject.put("Code", 200);
        returnJsonObject.put("Message", "验证成功");
        return returnJsonObject;
    }

    @Override
    public CommonResult recharge(String json) {
        User user = JSON.parseObject(json, User.class);
        if(user.getOpenid()==null|| user.getMoney()==null){
            return new CommonResult( 1201, "请求条件中，缺少必填参数", null);
        }
        try {
            JSONObject jsonObject = userMapper.selectOpenidMoney(user.getOpenid());
            BigDecimal money = jsonObject.getBigDecimal("money");
            BigDecimal reMoney = money.add(user.getMoney());
            user.setMoney(reMoney);
            userMapper.updateByOpenid(user);
            int id = jsonObject.getInteger("id");
            Log log = new Log();
            log.setIntroduction("user");
            log.setModuleId(id);
            log.setCode("recharge");
            log.setDescription("用户充值");
            logMapper.insertSelective(log);
        }catch(Exception e){
            return new CommonResult(2001, "无此用户，查询失败", null);
        }
        return new CommonResult( 200, "充值成功", null);
    }

    @Override
    public CommonResult overageSelect(String openid) {
        JSONObject resJsonObject = new JSONObject();
        try {
            JSONObject jsonObject = userMapper.selectOpenidMoney(openid);
            BigDecimal money = jsonObject.getBigDecimal("money");
            resJsonObject.put("openid", openid);
            resJsonObject.put("money", money);
        }catch(Exception e){
            return new CommonResult(2001, "无此用户，查询失败", null);
        }
        return new CommonResult( 200, "查询成功", resJsonObject);
    }

    @Override
    public void serviceFeeCalculation() {
        try {
            int thisYearDay = LocalDate.now().lengthOfYear();//本年的天数
            //查找所有公司及是否是会员
            List<User> userList =  userMapper.selectCompanyIdMember();
            for(int i = 0; i < userList.size(); i++){
                User user = userList.get(i);
                int member = user.getMember();
                BigDecimal money = user.getMoney();
                //如果不是会员，一天一元
                if(member == 0){
                    BigDecimal dayFee = new BigDecimal(1);
                    user.setMoney(money.subtract(dayFee));
                }else if(member == 1){//如果是普通会员，一年300，每天0.82
                    double dayfee0 = (double) 300/thisYearDay;
                    BigDecimal b = new BigDecimal(dayfee0);
                    double f1 = b.setScale(2,   BigDecimal.ROUND_HALF_UP).doubleValue();
                    BigDecimal dayFee = new BigDecimal(f1);
                    user.setMoney(money.subtract(dayFee));
                    //如果会员费使用完毕，更新为非会员
                    if(user.getMoney().compareTo(BigDecimal.ZERO) < 0){//可用366天
                        user.setMember(0);
                    }
                }
                //更新金额
                int sFlag = userMapper.updateMoneyMemberByCompanyId(user);
                if(sFlag>0){
                    Calendar calendar = Calendar.getInstance(Locale.CHINA);
                    Date date = calendar.getTime();
                    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    String nowTime = dateFormat.format(date);
                    log.info("扣费成功：" + nowTime);
                }
            }
        }catch(Exception e){
            log.error("扣费出现异常", e);
        }
    }
}
