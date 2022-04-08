package cn.gxhunter.tourism.uaa.dao;

import cn.gxhunter.tourism.common.entity.SysRole;
import cn.gxhunter.tourism.common.entity.SysRoleModuleAuthority;
import cn.gxhunter.tourism.common.entity.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Administrator
 * @version 1.0
 **/
@Repository
public class UserDao {
    private final static String ADMIN_CODE = "1001";
    private final static String ROLE_NAME = "ADMIN";

    @Autowired
    JdbcTemplate jdbcTemplate;

    //根据账号查询用户信息
    public UserDTO getUserByUsername(String username) {
        String sql = "select id,user_name as username,password from sys_user where is_deleted = 0 and user_name = ?";
        //连接数据库查询用户
        List<UserDTO> list = jdbcTemplate.query(sql, new Object[]{username}, new BeanPropertyRowMapper<>(UserDTO.class));
        if (list != null && list.size() == 1) {
            return list.get(0);
        }
        return null;
    }

    //根据用户id查询用户权限
    public List<String> findPermissionsByUserId(String userId) {
        List<String> permissions = new ArrayList<>();

        String sql = "select m.code as sysModuleCode, a.function\n" +
                "from sys_role_module_authority a\n" +
                "left join sys_module m on m.id = a.sys_module_id and m.is_deleted = 0\n" +
                "left join sys_role r on r.id = a.sys_role_id and r.is_deleted = 0\n" +
                "left join sys_user_role ur on ur.sys_role_id = r.id and ur.is_deleted = 0\n" +
                "left join sys_user u on u.id = ur.sys_user_id and u.is_deleted = 0\n" +
                "where a.is_deleted = 0 and u.id = ?";
        //连接数据库查询用户权限
        List<SysRoleModuleAuthority> sysRoleModuleAuthorityList = jdbcTemplate.query(sql, new Object[]{userId}, new BeanPropertyRowMapper<>(SysRoleModuleAuthority.class));
        for (SysRoleModuleAuthority sysRoleModuleAuthority : sysRoleModuleAuthorityList){
            String[] functions = sysRoleModuleAuthority.getFunction().split(",");
            for (String str : functions){
                permissions.add(sysRoleModuleAuthority.getSysModuleCode()+"_"+ str);
            }
        }
        return permissions;
    }
    //根据用户id,查询角色信息
    public String findRolesByUserId(String id) {
        String sql = "select r.code\n" +
                "from sys_role r \n" +
                "left join sys_user_role sur on r.id = sur.sys_role_id and sur.is_deleted = 0\n" +
                "where r.is_deleted = 0 and sur.sys_user_id = ?";
        //连接数据库查询用户
        List<SysRole> list = jdbcTemplate.query(sql, new Object[]{id}, new BeanPropertyRowMapper<>(SysRole.class));
        for (SysRole role : list){
            //约定:编号为1001的为超级管理员
            if (role.getCode().equals(ADMIN_CODE)){
                return ROLE_NAME;
            }
        }
        return null;
    }
}
