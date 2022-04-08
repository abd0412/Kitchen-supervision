package cn.gxhunter.tourism.system.controller;


import cn.gxhunter.tourism.common.entity.SysUserRole;
import cn.gxhunter.tourism.common.entity.UserDTO;
import cn.gxhunter.tourism.system.service.SysUserRoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Api(description = "用户角色controller")
@RestController
@RequestMapping(value = "/sysUserRole")
public class SysUserRoleController {

    @Autowired
    private SysUserRoleService sysUserRoleService;

    /**
     * @Description 更新用户角色
     * @Author BinXiang
     * @Date 2020/5/18 10:00
     * @param sysUserId   用户id
     * @param sysRoleIds  角色ids
     * @param request
     * @return: int
     **/
    @ApiOperation("更新用户角色")
    @PostMapping("/update")
    public int updateSysUserRole(Integer sysUserId, @RequestBody List<Integer> sysRoleIds, HttpServletRequest request){
        Integer editerId = Integer.valueOf(((UserDTO)request.getUserPrincipal()).getId());
        return sysUserRoleService.updateSysUserRole(sysUserId, sysRoleIds, editerId);
    }

    /**
     * @Description 根据用户id获取用户角色列表
     * @Author      BinXiang
     * @Date        2020-02-14 18:04
     * @param userId    用户id
     * @return: java.util.List<cn.gxhunter.ams.entity.SysUserRole>
     **/
    @ApiOperation("根据用户id获取用户角色列表")
    @GetMapping(value = "/list/{userId}")
    public List<SysUserRole> listSysUserRoleByUserId(@PathVariable Integer userId){
        //用户角色列表
        List<SysUserRole> list = sysUserRoleService.listSysUserRoleByUserId(userId);
        return list;
    }

}
