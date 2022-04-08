package cn.guet.kitchen.service.serviceimpl;

import cn.guet.kitchen.entity.CommonResult;
import cn.guet.kitchen.entity.FoodCompany;
import cn.guet.kitchen.entity.FoodCompanyList;
import cn.guet.kitchen.mapper.FoodCompanyMapper;
import cn.guet.kitchen.service.FoodCompanyService;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/**
 * @introduce:
 * @author: cyan
 * @DATE: 2021/4/2
 **/
@Service
@Slf4j
public class FoodCompanyServiceImpl implements FoodCompanyService {
    @Resource
    private FoodCompanyMapper foodCompanyMapper;

    @Override
    public CommonResult insertSelective(String json) {
        System.out.println("addFoodCompanyJsonObject==>"+json);
        FoodCompany foodCompany;
        try{
            foodCompany = JSON.parseObject(json, FoodCompany.class);//转化为实体类
            //插入更新时间
            Calendar calendar = Calendar.getInstance(Locale.CHINA);
            Date date = calendar.getTime();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String updateTime = dateFormat.format(date);
            foodCompany.setUpdateTime(updateTime);
            foodCompanyMapper.insertSelective(foodCompany); //更新数据库
        } catch(Exception e) {
            log.error("添加餐饮企业信息出现异常", e);
            e.printStackTrace();
            return new CommonResult( 2003, "生成数据失败", null);
        }
        return new CommonResult( 200, "创建成功", foodCompany);
    }

    @Override
    public CommonResult deleteByPrimaryKey(int companyId) {
        FoodCompany foodCompany = new FoodCompany();
        foodCompany.setCompanyId(companyId);
        if (foodCompany.getCompanyId() == null){//公司ID
            return new CommonResult( 1201, "请求条件中，缺少ID参数", null);
        }
        try{
            foodCompany.setIsDeleted(true);
            foodCompanyMapper.deleteByPrimaryKey(foodCompany);
        } catch(Exception e){
            log.error("删除餐饮企业信息出现异常", e);
            return new CommonResult( 2001, "数据库执行有异常", null);
        }
        return new CommonResult( 200, "删除成功", null);
    }

    @Override
    public CommonResult updateByPrimaryKey(String json) {
        System.out.println("updateFoodCompanyJson==>"+json);
        FoodCompanyList foodCompanyList = new FoodCompanyList();
        FoodCompany foodCompany;
        try{
            foodCompany = JSON.parseObject(json, FoodCompany.class);//转化为实体类
            //插入更新时间
            Calendar calendar = Calendar.getInstance(Locale.CHINA);
            Date date = calendar.getTime();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String updateTime = dateFormat.format(date);
            foodCompany.setUpdateTime(updateTime);
            foodCompanyMapper.updateByPrimaryKeySelective(foodCompany); //更新数据库
            List<FoodCompany> foodCompanies = foodCompanyMapper.selectByPrimaryKey(foodCompany.getCompanyId());
            foodCompanyList.setFoodCompanies(foodCompanies);
        } catch(Exception e) {
            log.error("更新餐饮企业信息出现异常", e);
            return new CommonResult( 2003, "更新失败", null);
        }
        return new CommonResult( 200, "更新成功", foodCompanyList);
    }

    @Override
    public CommonResult selectByPrimaryKey(Integer companyId) {
        FoodCompanyList foodCompanyList = new FoodCompanyList();
        try{
            List<FoodCompany> foodCompanies = foodCompanyMapper.selectByPrimaryKey(companyId);
            foodCompanyList.setFoodCompanies(foodCompanies);
        } catch(Exception e) {
            log.error("查询餐饮企业信息出现异常", e);
            return new CommonResult( 2001, "数据库执行有异常", null);
        }
        return new CommonResult( 200, "查询成功", foodCompanyList);
    }
}
