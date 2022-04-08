package cn.gxhunter.tourism.system.service.impl;

import cn.gxhunter.tourism.common.entity.SysRole;
import cn.gxhunter.tourism.common.entity.SysUser;
import cn.gxhunter.tourism.system.mapper.SysUserMapper;
import cn.gxhunter.tourism.system.service.SysUserService;
import org.apache.commons.lang.StringUtils;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class SysUserServiceImpl implements SysUserService {

    @Resource
    private SysUserMapper sysUserMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return sysUserMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(SysUser record) {
        return sysUserMapper.insert(record);
    }

    @Override
    public int insertSelective(SysUser record) {
        if (StringUtils.isBlank(record.getPassword())) {
            record.setPassword("000000");
        }
        //密码编码
        String encodePassword = new BCryptPasswordEncoder().encode(record.getPassword());
        //设置密码
        record.setPassword(encodePassword);

        return sysUserMapper.insertSelective(record);
    }

    @Override
    public SysUser selectByPrimaryKey(Integer id) {
        return sysUserMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(SysUser record) {
        if (StringUtils.isBlank(record.getPassword())) {
            record.setPassword(null);
        } else {
            //密码编码
            String encodePassword = new BCryptPasswordEncoder().encode(record.getPassword());
            //设置密码
            record.setPassword(encodePassword);
        }
        return sysUserMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(SysUser record) {
        return sysUserMapper.updateByPrimaryKey(record);
    }

    @Override
    public int updateBatch(List<SysUser> list) {
        return sysUserMapper.updateBatch(list);
    }

    @Override
    public int updateBatchSelective(List<SysUser> list) {
        return sysUserMapper.updateBatchSelective(list);
    }

    @Override
    public int batchInsert(List<SysUser> list) {
        return sysUserMapper.batchInsert(list);
    }

    /**
     * @param userName 用户名
     * @param name     姓名
     * @param pageNo   当前页
     * @param pageSize 每页记录数
     * @Description 根据用户名分页查询用户列表
     * @Author BinXiang
     * @Date 2020-02-17 10:43
     * @return: java.util.List<cn.gxhunter.ams.entity.SysUser>
     **/
    @Override
    public List<SysUser> list(String userName, String name, Integer pageNo, Integer pageSize) {
        //跳过多少条记录
        Integer skip = (pageNo - 1) * pageSize;
        //查询用户数据list
        List<SysUser> list = sysUserMapper.selectByRange(userName, name, skip, pageSize);
        //合并相同userId的角色数据
        setRoleList(list);
        return list;
    }

    //将user中的roleMessage整合到roles
    private void setRoleList(List<SysUser> userList) {
        //如果list为空,直接返回
        if (CollectionUtils.isEmpty(userList))
            return;

        for (SysUser user : userList) {
            //创建user的roles
            user.setRoles(new ArrayList<>());
            //如果roleMessage为空,跳出本次循环,执行下一次循环
            if (StringUtils.isBlank(user.getRoleMessage()))
                continue;
            //roleMessage格式: "id:name,id:name,id:name"
            String roleMessage = user.getRoleMessage();
            //stringList格式: ["id:name", "id:name", "id:name"]
            List<String> stringList = Arrays.asList(roleMessage.split(","));
            for (String str : stringList) {
                SysRole role = new SysRole();
                int index = str.indexOf(':');
                int length = str.length();
                //从str中取出roleId,并添加到role
                role.setId(Integer.valueOf(str.substring(0, index)));
                //从str中取出roleName,并添加到role
                role.setName(str.substring(index + 1, length));
                //将role添加到user的roles中
                user.getRoles().add(role);
            }
        }
    }

    /**
     * @param userName 用户名
     * @param name     姓名
     * @Description 分页查询对应总记录数
     * @Author BinXiang
     * @Date 2020-02-17 10:45
     * @return: int
     **/
    @Override
    public int count(String userName, String name) {
        return sysUserMapper.count(userName, name);
    }

    //根据用户名列表,获取用户列表
    @Override
    public List<SysUser> selectByUserNames(List<String> userNames) {
        return sysUserMapper.selectByUserNames(userNames);
    }

    @Override
    public SysUser selectByName(String username) {
        return sysUserMapper.selectByUserName(username);
    }
}





