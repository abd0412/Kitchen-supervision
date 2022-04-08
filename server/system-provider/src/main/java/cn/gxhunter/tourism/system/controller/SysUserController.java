package cn.gxhunter.tourism.system.controller;


import cn.gxhunter.tourism.common.config.MyException;
import cn.gxhunter.tourism.common.entity.SysUser;
import cn.gxhunter.tourism.common.entity.UserDTO;
import cn.gxhunter.tourism.common.util.CommonUtil;
import cn.gxhunter.tourism.system.service.SysUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Api(description = "用户controller")
@RestController
@RequestMapping("/sysUser")
public class SysUserController {

    @Autowired
    private SysUserService sysUserService;

    /**
     * @Description 分页获取用户列表
     * @Author      BinXiang
     * @Date        2020-02-14 16:43
     * @param userName  用户名
     * @param name      名称
     * @param pageNo    当前页
     * @param pageSize  每页记录数
     * @return: java.util.Map<java.lang.String,java.lang.Object>
     **/
    @ApiOperation("分页获取用户列表")
    @GetMapping("/list")
    public Map<String,Object> list(String userName,
                                   String name,
                                   @RequestParam(defaultValue = "1") Integer pageNo,
                                   @RequestParam(defaultValue = "10") Integer pageSize) {
        //用户列表
        List<SysUser> list = sysUserService.list(userName, name, pageNo, pageSize);
        //记录总数
        int total = sysUserService.count(userName, name);
        return CommonUtil.getResult(list, total);
    }

    /**
     * @Description 添加用户
     * @Author      BinXiang
     * @Date        2020-02-14 16:43
     * @param sysUser   用户信息
     * @return: int     1:成功 0:失败
     **/
    @ApiOperation("添加用户")
    @PostMapping("/add")
    public int add(@RequestBody SysUser sysUser, HttpServletRequest request) {
        //Integer editerId = Integer.valueOf(((UserDTO)request.getUserPrincipal()).getId());
        //sysUser.setEditerId(editerId);
        //sysUser.setCreaterId(editerId);

        //判断用户是否已存在
        List<String> userNames = new ArrayList<>();
        userNames.add(sysUser.getUserName());
        List<SysUser> sysUsers = sysUserService.selectByUserNames(userNames);
        if (!CollectionUtils.isEmpty(sysUsers)){
            throw new MyException(403, "用户已存在!");
        }
        return sysUserService.insertSelective(sysUser);
    }

    /**
     * @Description 批量添加用户
     * @Author BinXiang
     * @Date 2020/4/21 18:53
     * @param sysUsers
     * @return: int
     **/
    @ApiOperation("批量添加用户")
    @PostMapping("/batchInsert")
    public int batchInsert(@RequestBody List<SysUser> sysUsers, HttpServletRequest request) {
        Integer editerId = Integer.valueOf(((UserDTO)request.getUserPrincipal()).getId());
        List<String> userNames = new ArrayList<>();

        for (SysUser user : sysUsers){
            user.setEditerId(editerId);
            user.setCreaterId(editerId);
            //密码编码
            String encodePassword = new BCryptPasswordEncoder().encode(user.getPassword());
            //设置密码
            user.setPassword(encodePassword);

            userNames.add(user.getUserName());
        }
        //判断用户是否已存在
        List<SysUser> users = sysUserService.selectByUserNames(userNames);
        if (!CollectionUtils.isEmpty(sysUsers)){
            throw new MyException(403, "用户已存在!");
        }
        return sysUserService.batchInsert(sysUsers);
    }

    /**
     * @Description 修改用户信息
     * @Author      BinXiang
     * @Date        2020-02-14 16:44
     * @param sysUser   用户信息
     * @return: int     1:成功 0:失败
     **/
    @ApiOperation("修改用户信息")
    @PostMapping("/update")
    public int update(@RequestBody SysUser sysUser, HttpServletRequest request) {
        Integer editerId = Integer.valueOf(((UserDTO)request.getUserPrincipal()).getId());
        sysUser.setEditerId(editerId);
        sysUser.setEditTime(null);

        return sysUserService.updateByPrimaryKeySelective(sysUser);
    }

    /**
     * @Description 根据id查找用户
     * @Author      BinXiang
     * @Date        2020-02-14 16:45
     * @param id    用户id
     * @return: cn.gxhunter.ams.entity.SysUser
     **/
    @ApiOperation("根据id查找用户")
    @GetMapping("/get/{id}")
    public SysUser get(@PathVariable Integer id) {
        return sysUserService.selectByPrimaryKey(id);
    }

    /**
     * @Description 根据用户id删除用户
     * @Author      BinXiang
     * @Date        2020-02-14 16:47
     * @param id    用户id
     * @return: int 1:成功 0:失败
     **/
    @ApiOperation("根据用户id删除用户")
    @GetMapping("/delete/{id}")
    public int delete(@PathVariable Integer id, HttpServletRequest request) {
        Integer editerId = Integer.valueOf(((UserDTO)request.getUserPrincipal()).getId());
        SysUser sysUser = new SysUser();
        sysUser.setId(id);
        sysUser.setIsDeleted(true);
        sysUser.setEditerId(editerId);
        return sysUserService.updateByPrimaryKeySelective(sysUser);
    }

    /**
     * @Description 根据用户名获取用户信息
     * @Author BinXiang
     * @Date 2020/4/29 10:00
     * @param username
     * @return: cn.gxhunter.ams.entity.SysUser
     **/
    @ApiOperation("根据用户名获取用户信息")
    @GetMapping("/get/username")
    public SysUser getByUsername(String username){
        return sysUserService.selectByName(username);
    }
}
