package cn.guet.kitchen.service.serviceimpl;

import cn.guet.kitchen.entity.*;
import cn.guet.kitchen.mapper.MaintenanceStaffMapper;
import cn.guet.kitchen.service.MaintenanceStaffService;
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
 * @DATE: 2021/4/2
 **/
@Service
public class MaintenanceStaffServiceImpl implements MaintenanceStaffService {
    @Resource
    private MaintenanceStaffMapper maintenanceStaffMapper;

    @Override
    public CommonResult insertSelective(String json) {
        System.out.println("addMaintenanceStaffJson==>"+json);
        MaintenanceStaff maintenanceStaff;
        try{
            int dispatchNum;
            maintenanceStaff = JSON.parseObject(json, MaintenanceStaff.class);//转化为实体类
            //插入更新时间
            Calendar calendar = Calendar.getInstance(Locale.CHINA);
            Date date = calendar.getTime();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String updateTime = dateFormat.format(date);
            maintenanceStaff.setUpdate(updateTime);
            int id = maintenanceStaff.getId();
            if(maintenanceStaffMapper.selectMinDispatchNum()==null){
                dispatchNum = 0;
            }else {
                dispatchNum = maintenanceStaffMapper.selectMinDispatchNum();//得到未删除的员工的最小派单数
            }
            maintenanceStaff.setDispatchNum(dispatchNum);//新注册员工派单数赋值
            maintenanceStaffMapper.insertSelective(maintenanceStaff); //更新数据库
        } catch(Exception e) {
            e.printStackTrace();
            return new CommonResult( 2003, "生成数据失败", null);
        }
        return new CommonResult( 200, "创建成功", maintenanceStaff);
    }

    @Override
    public CommonResult deleteByPrimaryKey(String json) {
        MaintenanceStaff maintenanceStaff = JSON.parseObject(json, MaintenanceStaff.class);//转化为实体类
        if (maintenanceStaff.getId() == null){//员工工号
            return new CommonResult( 1201, "请求条件中，缺少ID参数", null);
        }
        try{
            maintenanceStaff.setIdDeleted(true);
            maintenanceStaffMapper.deleteByPrimaryKey(maintenanceStaff);
        } catch(Exception e){
            e.printStackTrace();
            return new CommonResult( 2001, "数据库执行有异常", null);
        }
        return new CommonResult( 200, "删除成功", null);
    }

    @Override
    public CommonResult updateByPrimaryKey(String json) {
        System.out.println("updateMaintenanceStaffJson==>"+json);
        MaintenanceStaff maintenanceStaff;
        try{
            maintenanceStaff = JSON.parseObject(json, MaintenanceStaff.class);//转化为实体类
            //插入更新时间
            Calendar calendar = Calendar.getInstance(Locale.CHINA);
            Date date = calendar.getTime();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String updateTime = dateFormat.format(date);
            maintenanceStaff.setUpdate(updateTime);
            int id = maintenanceStaff.getId();
            maintenanceStaffMapper.updateByPrimaryKey(maintenanceStaff); //更新数据库
        } catch(Exception e) {
            e.printStackTrace();
            return new CommonResult( 2003, "更新失败", null);
        }
        return new CommonResult( 200, "更新成功", maintenanceStaff);
    }

    @Override
    public CommonResult selectByPrimaryKey(String json) {
        MaintenanceStaff maintenanceStaff;
        MaintenanceStaffList maintenanceStaffList = new MaintenanceStaffList();
        try{
            maintenanceStaff = JSON.parseObject(json, MaintenanceStaff.class);//转化为实体类
            maintenanceStaff.setIdDeleted(false);//没有被删除的
            maintenanceStaffList.setMTStaffList(maintenanceStaffMapper.selectByPrimaryKey(maintenanceStaff));
        } catch(Exception e) {
            e.printStackTrace();
            return new CommonResult( 2001, "数据库执行有异常", null);
        }
        return new CommonResult( 200, "查询成功", maintenanceStaffList);
    }
}
