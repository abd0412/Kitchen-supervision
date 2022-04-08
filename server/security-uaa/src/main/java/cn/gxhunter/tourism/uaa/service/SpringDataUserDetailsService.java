package cn.gxhunter.tourism.uaa.service;

import cn.gxhunter.tourism.common.entity.UserDTO;
import cn.gxhunter.tourism.uaa.dao.UserDao;
import com.alibaba.fastjson.JSON;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Administrator
 * @version 1.0
 **/
@Service
public class SpringDataUserDetailsService implements UserDetailsService {

    @Autowired
    UserDao userDao;

    //根据 账号查询用户信息
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        //根据账号查询用户信息
        UserDTO userDto = userDao.getUserByUsername(username);
        if(userDto == null){
            //如果用户查不到，返回null，由provider来抛出异常
            return null;
        }
        //userDto转成json
        String principal = JSON.toJSONString(userDto);

        //根据用户的id查询用户的权限
        List<String> permissions = userDao.findPermissionsByUserId(userDto.getId());
        //将permissions转成数组
        String[] permissionArray = new String[permissions.size()];
        permissions.toArray(permissionArray);

        //根据用户id,查询用户角色信息
        String roles = userDao.findRolesByUserId(userDto.getId());

        UserDetails userDetails = null;
        if (StringUtils.isBlank(roles)){
            userDetails = User.withUsername(principal).password(userDto.getPassword()).authorities(permissionArray).build();
        }else {
            userDetails = User.withUsername(principal).password(userDto.getPassword()).roles(roles).authorities(permissionArray).build();
        }
        return userDetails;
    }
}
