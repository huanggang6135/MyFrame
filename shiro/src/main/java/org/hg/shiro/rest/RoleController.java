package org.hg.shiro.rest;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.hg.shiro.dto.Role;
import org.hg.shiro.dto.User;
import org.hg.shiro.service.ResourceService;
import org.hg.shiro.service.RoleService;
import org.hg.shiro.service.UserService;
import org.hg.shiro.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Transient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author hg
 * @Date 2019/4/3 14:49
 * @Version 1.0
 **/
@RestController
@RequestMapping("/admin")
@Api(value = "/admin", description = "管理员角色操作")
public class RoleController {
    @Autowired
    private ResourceService resourceService;
    @Autowired
    private RoleService roleService;
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/addRole", method = RequestMethod.POST)
    @ApiOperation(value = "添加角色")
    public Result addRole(String key, String name, String note) {
        Result<String> result = new Result<>();
        if (roleService.findByKey(key) != null) {
            return result.failMessage("key已存在");
        }
        Role role = roleService.add(key, name, note);
        if (role == null) {
            return result.failMessage("添加失败");
        }
        return result;
    }
    @Transient
    @RequestMapping(value = "/grantRole", method = RequestMethod.POST)
    @ApiOperation(value = "给用户赋予角色")
    public Result grantRole(String userId, String... roles) {
        Result<String> result = new Result<>();
        User userById = userService.findUserById(userId);
        if(userById == null || !roleService.grantRole(userId, roles)){
            return result.failMessage("操作失败");
        }
        return result;
    }
    @Transient
    @RequestMapping(value = "/deleteRole", method = RequestMethod.POST)
    @ApiOperation(value = "删除角色")
    public String deleteRole(String roleId){
        Result<Object> result = new Result<>();
        try{
            Role role = roleService.findById(roleId);
            if(role!=null){
                roleService.deleteById(roleId);
            }
        } catch (Exception e){
            result.failMessage("删除失败");
        }
        return result.toJsonString();
    }
}
