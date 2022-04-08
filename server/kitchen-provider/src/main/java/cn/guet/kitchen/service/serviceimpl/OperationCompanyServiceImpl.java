package cn.guet.kitchen.service.serviceimpl;

import cn.guet.kitchen.entity.CommonResult;
import cn.guet.kitchen.entity.OperationCompany;
import cn.guet.kitchen.entity.OperationCompanyList;
import cn.guet.kitchen.mapper.OperationCompanyMapper;
import cn.guet.kitchen.service.OperationCompanyService;
import com.alibaba.fastjson.JSON;
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
 * @DATE: 2021/4/5
 **/
@Service
public class OperationCompanyServiceImpl implements OperationCompanyService {
    @Resource
    private OperationCompanyMapper operationCompanyMapper;
    @Override
    public CommonResult insertSelective(String json) {
        System.out.println("addOperationCompanyJson==>"+json);
        OperationCompany operationCompany;
        try{
            int dispatchNum;
            operationCompany = JSON.parseObject(json, OperationCompany.class);//转化为实体类
            //插入更新时间
            Calendar calendar = Calendar.getInstance(Locale.CHINA);
            Date date = calendar.getTime();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String updateTime = dateFormat.format(date);
            operationCompany.setUpdateTime(updateTime);
            if(operationCompanyMapper.selectMinDispatchNum()==null){
                dispatchNum = 0;
            }else{
                dispatchNum = operationCompanyMapper.selectMinDispatchNum();//得到未删除的公司的最小派单数
            }
            operationCompany.setDispatchNum(dispatchNum);//新注册公司派单数赋值
            operationCompanyMapper.insertSelective(operationCompany); //更新数据库
        } catch(Exception e) {
            e.printStackTrace();
            return new CommonResult( 2003, "生成数据失败", null);
        }
        return new CommonResult( 200, "创建成功", operationCompany);
    }

    @Override
    public CommonResult deleteByPrimaryKey(int operationCompanyId) {
        OperationCompany operationCompany = new OperationCompany();
        operationCompany.setOperationCompanyId(operationCompanyId);
        if (operationCompany.getOperationCompanyId() == null){//公司ID
            return new CommonResult( 1201, "请求条件中，缺少ID参数", null);
        }
        try{
            operationCompany.setIsDeleted(true);
            operationCompanyMapper.deleteByPrimaryKey(operationCompany);
        } catch(Exception e){
            e.printStackTrace();
            return new CommonResult( 2001, "数据库执行有异常", null);
        }
        return new CommonResult( 200, "删除成功", null);
    }

    @Override
    public CommonResult updateByPrimaryKey(String json) {
        System.out.println("updateOperationCompanyJson==>"+json);
        OperationCompany operationCompany;
        try{
            operationCompany = JSON.parseObject(json, OperationCompany.class);//转化为实体类
            //插入更新时间
            Calendar calendar = Calendar.getInstance(Locale.CHINA);
            Date date = calendar.getTime();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String updateTime = dateFormat.format(date);
            operationCompany.setUpdateTime(updateTime);
            operationCompanyMapper.updateByPrimaryKey(operationCompany); //更新数据库
        } catch(Exception e) {
            e.printStackTrace();
            return new CommonResult( 2003, "更新失败", null);
        }
        return new CommonResult( 200, "更新成功", operationCompany);
    }

    @Override
    public CommonResult selectByPrimaryKey(Integer operationCompanyId) {
        OperationCompanyList operationCompanyList = new OperationCompanyList();
        try{
            List<OperationCompany> operationCompanys = operationCompanyMapper.selectByPrimaryKey(operationCompanyId);
            operationCompanyList.setOperationCompanies(operationCompanys);
        } catch(Exception e) {
            e.printStackTrace();
            return new CommonResult( 2001, "数据库执行有异常", null);
        }
        return new CommonResult( 200, "查询成功", operationCompanyList);
    }
}
