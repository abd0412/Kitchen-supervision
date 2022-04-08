package cn.gxhunter.tourism.system.controller;


import cn.gxhunter.tourism.common.entity.SysRole;
import cn.gxhunter.tourism.common.entity.UserDTO;
import cn.gxhunter.tourism.common.util.CommonUtil;
import cn.gxhunter.tourism.system.service.SysRoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Api(description = "角色controller")
@RestController
@RequestMapping(value = "/sysRole")
public class SysRoleController {

    @Autowired
    private SysRoleService sysRoleService;


    /**
     * @Description 分页获取角色列表
     * @Author      BinXiang
     * @Date        2020-02-14 17:05
     * @param roleName      角色名称
     * @param pageNo    当前页
     * @param pageSize  每页记录数
     * @return: java.util.Map<java.lang.String,java.lang.Object>
     **/
    @ApiOperation("分页获取角色列表")
    @GetMapping(value = "/list")
    public Map<String, Object> list(String roleName,
                                    @RequestParam(defaultValue = "1") Integer pageNo,
                                    @RequestParam(defaultValue = "10") Integer pageSize){
        //获取list数据
        List<SysRole> list = sysRoleService.list(roleName,pageNo,pageSize);
        //获取数据总数
        int total = sysRoleService.count(roleName);

        return CommonUtil.getResult(list, total);
    }

    /**
     * @Description 添加角色
     * @Author      BinXiang
     * @Date        2020-02-14 17:27
     * @param sysRole   角色信息
     * @return: int     1:成功 0:失败
     **/
    @ApiOperation("添加角色")
    @PostMapping(value = "/add")
    public int add(@RequestBody SysRole sysRole, HttpServletRequest request) {
        Integer editerId = Integer.valueOf(((UserDTO)request.getUserPrincipal()).getId());
        sysRole.setEditerId(editerId);
        sysRole.setCreaterId(editerId);
        return sysRoleService.insertSelective(sysRole);
    }

    /**
     * @Description 根据id查找角色
     * @Author      BinXiang
     * @Date        2020-02-14 17:27
     * @param id    角色id
     * @return: cn.gxhunter.ams.entity.SysRole
     **/
    @ApiOperation("根据id查找角色")
    @GetMapping(value = "/get/{id}")
    public SysRole get(@PathVariable Integer id) {
        return sysRoleService.selectByPrimaryKey(id);
    }

    /**
     * @Description 根据id删除角色
     * @Author      BinXiang
     * @Date        2020-02-14 17:28
     * @param id    角色id
     * @return: int 1:成功 0:失败
     **/
    @ApiOperation("根据id删除角色")
    @GetMapping(value = "/delete/{id}")
    public int delete(@PathVariable Integer id, HttpServletRequest request) {
        Integer editerId = Integer.valueOf(((UserDTO)request.getUserPrincipal()).getId());
        SysRole sysRole = new SysRole();
        sysRole.setId(id);
        sysRole.setIsDeleted(true);
        sysRole.setEditerId(editerId);
        return sysRoleService.updateByPrimaryKeySelective(sysRole);
    }

    /**
     * @Description 修改角色信息
     * @Author      BinXiang
     * @Date        2020-02-14 17:28
     * @param sysRole   角色信息
     * @return: int     1:成功 0:失败
     **/
    @ApiOperation("修改角色信息")
    @PostMapping(value = "/update")
    public int update(@RequestBody SysRole sysRole, HttpServletRequest request) {
        Integer editerId = Integer.valueOf(((UserDTO)request.getUserPrincipal()).getId());
        sysRole.setEditerId(editerId);
        sysRole.setEditTime(null);
        return sysRoleService.updateByPrimaryKeySelective(sysRole);
    }
}
