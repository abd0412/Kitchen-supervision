package cn.guet.kitchen.service.serviceimpl;

import cn.guet.kitchen.entity.MaintenanceCompany;
import cn.guet.kitchen.mapper.MaintenanceCompanyMapper;
import cn.guet.kitchen.service.MaintenanceCompanyService;
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
 * @DATE: 2021/4/1
 **/
@Service
public class MaintenanceCompanyServiceImpl implements MaintenanceCompanyService {
    @Resource
    private MaintenanceCompanyMapper maintenanceCompanyMapper;

    @Override
    public CommonResult insertSelective(String json) {
        System.out.println("addMaintenanceCompanyJson==>"+json);
        MaintenanceCompany maintenanceCompany;
        try{
            int dispatchNum;
            maintenanceCompany = JSON.parseObject(json, MaintenanceCompany.class);//转化为实体类
            //插入更新时间
            Calendar calendar = Calendar.getInstance(Locale.CHINA);
            Date date = calendar.getTime();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String updateTime = dateFormat.format(date);
            maintenanceCompany.setUpdateTime(updateTime);
            if(maintenanceCompanyMapper.selectMinDispatchNum()==null){
                dispatchNum = 0;
            }else{
                dispatchNum = maintenanceCompanyMapper.selectMinDispatchNum();//得到未删除的公司的最小派单数
            }
            maintenanceCompany.setDispatchNum(dispatchNum);//新注册公司派单数赋值
            maintenanceCompanyMapper.insertSelective(maintenanceCompany); //更新数据库
        } catch(Exception e) {
            e.printStackTrace();
            return new CommonResult( 2003, "生成数据失败", null);
        }
        return new CommonResult( 200, "创建成功", maintenanceCompany);
    }

    @Override
    public CommonResult deleteByPrimaryKey(int maintenanceCompanyId) {
        MaintenanceCompany maintenanceCompany = new MaintenanceCompany();
        maintenanceCompany.setMaintenanceCompanyId(maintenanceCompanyId);
        if (maintenanceCompany.getMaintenanceCompanyId() == null){//公司ID
            return new CommonResult( 1201, "请求条件中，缺少ID参数", null);
        }
        try{
            maintenanceCompany.setIdDeleted(true);
            maintenanceCompanyMapper.deleteByPrimaryKey(maintenanceCompany);
        } catch(Exception e){
            e.printStackTrace();
            return new CommonResult( 2001, "数据库执行有异常", null);
        }
        return new CommonResult( 200, "删除成功", null);
    }

    @Override
    public CommonResult updateByPrimaryKey(String json) {
        System.out.println("updateMaintenanceCompanyJson==>"+json);
        MaintenanceCompany maintenanceCompany;
        try{
            maintenanceCompany = JSON.parseObject(json, MaintenanceCompany.class);//转化为实体类
            //插入更新时间
            Calendar calendar = Calendar.getInstance(Locale.CHINA);
            Date date = calendar.getTime();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String updateTime = dateFormat.format(date);
            maintenanceCompany.setUpdateTime(updateTime);
            maintenanceCompanyMapper.updateByPrimaryKey(maintenanceCompany); //更新数据库
        } catch(Exception e) {
            e.printStackTrace();
            return new CommonResult( 2003, "更新失败", null);
        }
        return new CommonResult( 200, "更新成功", maintenanceCompany);
    }

    @Override
    public CommonResult selectByPrimaryKey(Integer maintenanceCompanyId) {
        MaintenanceCompany maintenanceCompany;
        try{
            maintenanceCompany = maintenanceCompanyMapper.selectByPrimaryKey(maintenanceCompanyId);
        } catch(Exception e) {
            e.printStackTrace();
            return new CommonResult( 2001, "数据库执行有异常", null);
        }
        return new CommonResult( 200, "查询成功", maintenanceCompany);
    }
}
