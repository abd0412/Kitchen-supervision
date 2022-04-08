package cn.gxhunter.tourism.system.controller;


import cn.gxhunter.tourism.common.entity.SysRoleModuleAuthority;
import cn.gxhunter.tourism.common.entity.UserDTO;
import cn.gxhunter.tourism.system.service.SysRoleModuleAuthorityService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Api(description = "角色模块权限controller")
@RestController
@RequestMapping(value = "/sysRoleModule")
public class SysRoleModuleAuthorityController {

    @Autowired
    private SysRoleModuleAuthorityService sysRoleModuleAuthorityService;

    /**
     * @Description 更新用户模块权限
     * @Author BinXiang
     * @Date 2020/4/14 17:09
     * @param sysRoleModuleAuthorityList
     * @return: int
     **/
    @ApiOperation("更新用户模块权限")
    @PostMapping(value = "/update")
    public int update(@RequestBody List<SysRoleModuleAuthority> sysRoleModuleAuthorityList, HttpServletRequest request){
        Integer editerId = Integer.valueOf(((UserDTO)request.getUserPrincipal()).getId());
        return sysRoleModuleAuthorityService.updateSysRoleModule(sysRoleModuleAuthorityList, editerId);
    }
    /**
     * @Description 根据角色id获取角色模块列表
     * @Author      BinXiang
     * @Date        2020-02-14 17:56
     * @param roleId    角色id
     * @return: java.util.List<cn.gxhunter.ams.entity.SysRoleModuleAuthority>
     **/
    @ApiOperation("根据角色id获取角色模块列表")
    @GetMapping("/list/{roleId}")
    public List<SysRoleModuleAuthority> listSysRoleModuleByRoleId(@PathVariable Integer roleId){
        //角色模块列表
        List<SysRoleModuleAuthority> list = sysRoleModuleAuthorityService.listSysRoleModuleByRoleId(roleId);
        return list;
    }

}
