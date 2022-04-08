package cn.guet.kitchen.service.serviceimpl;

import cn.guet.kitchen.entity.OperationStaff;
import cn.guet.kitchen.entity.OperationStaffList;
import cn.guet.kitchen.mapper.OperationStaffMapper;
import cn.guet.kitchen.service.OperationStaffService;
import cn.guet.kitchen.entity.CommonResult;
import com.alibaba.fastjson.JSON;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @introduce:
 * @author: cyan
 * @DATE: 2021/4/9
 **/
@Service
public class OperationStaffServiceImpl implements OperationStaffService {
    @Resource
    private OperationStaffMapper operationStaffMapper;

    @Override
    public CommonResult insertSelective(String json) {
        System.out.println("addOperationStaffJson==>"+json);
        List<OperationStaff> oneOperationStaff;
        try{
            int dispatchNum;
            OperationStaff operationStaff = JSON.parseObject(json, OperationStaff.class);//转化为实体类
            int id = operationStaff.getId();

            if(operationStaffMapper.selectMinDispatchNum()==null){
                dispatchNum = 0;
            }else{
                dispatchNum = operationStaffMapper.selectMinDispatchNum();//得到未删除的员工的最小派单数
            }
            operationStaff.setDispatchNum(dispatchNum);//新注册员工派单数赋值
            operationStaffMapper.insertSelective(operationStaff); //更新数据库
            operationStaff.setIdDeleted(false);//没有被删除的
            oneOperationStaff = operationStaffMapper.selectByPrimaryKey(operationStaff);//从数据库得到插入结果
        } catch(Exception e) {
            e.printStackTrace();
            return new CommonResult( 2003, "生成数据失败", null);
        }
        return new CommonResult( 200, "创建成功", oneOperationStaff.get(0));
    }

    @Override
    public CommonResult deleteByPrimaryKey(String json) {
        OperationStaff operationStaff = JSON.parseObject(json, OperationStaff.class);//转化为实体类
        if (operationStaff.getId() == null){//员工工号
            return new CommonResult( 1201, "请求条件中，缺少ID参数", null);
        }
        try{
            operationStaff.setIdDeleted(true);//删除员工
            operationStaffMapper.deleteByPrimaryKey(operationStaff);
        } catch(Exception e){
            e.printStackTrace();
            return new CommonResult( 2001, "数据库执行有异常", null);
        }
        return new CommonResult( 200, "删除成功", null);
    }

    @Override
    public CommonResult updateByPrimaryKey(String json) {
        System.out.println("updateOperationStaffJson==>"+json);
        List<OperationStaff> oneOperationStaff;
        try{
            OperationStaff operationStaff = JSON.parseObject(json, OperationStaff.class);//转化为实体类
            int id = operationStaff.getId();
            operationStaffMapper.updateByPrimaryKey(operationStaff); //更新数据库
            operationStaff.setIdDeleted(false);//没有被删除的
            oneOperationStaff = operationStaffMapper.selectByPrimaryKey(operationStaff);//从数据库得到更新结果
        } catch(Exception e) {
            e.printStackTrace();
            return new CommonResult( 2003, "更新失败", null);
        }
        return new CommonResult( 200, "更新成功", oneOperationStaff.get(0));
    }

    @Override
    public CommonResult selectByPrimaryKey(String json) {
        OperationStaffList operationStaffList = new OperationStaffList();
        try{
            OperationStaff operationStaff = JSON.parseObject(json, OperationStaff.class);//转化为实体类
            operationStaff.setIdDeleted(false);//没有被删除的
            operationStaffList.setOStaffList(operationStaffMapper.selectByPrimaryKey(operationStaff));
        } catch(Exception e) {
            e.printStackTrace();
            return new CommonResult( 2001, "数据库执行有异常", null);
        }
        return new CommonResult( 200, "查询成功", operationStaffList);
    }
}
