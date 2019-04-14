package org.hg.shiro.rest;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.hg.shiro.dto.Resource;
import org.hg.shiro.service.ResourceService;
import org.hg.shiro.service.RoleService;
import org.hg.shiro.service.UserService;
import org.hg.shiro.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author hg
 * @Date 2019/4/3 13:58
 * @Version 1.0
 **/
@RestController
@RequestMapping("/admin")
@Api(value = "/admin", description = "管理员资源操作")
public class ResourceController {
    @Autowired
    private ResourceService resourceService;
    @Autowired
    private RoleService roleService;
    @Autowired
    private UserService userService;
    @RequestMapping(value = "/addResource", method = RequestMethod.POST)
    @ApiOperation(value="添加资源")
    public Result addResource(String key, String name, String note){
        Result<String> result = new Result<>();
        if(resourceService.findByKey(key) != null){
            return result.failMessage("资源key已存在");
        }
        Resource resource = resourceService.add(key, name, note);
        if(resource == null){
            return result.failMessage("添加资源失败");
        }
        return result;
    }
    @RequestMapping(value = "/findResourceById", method = RequestMethod.GET)
    @ApiOperation(value="查找资源")
    public Resource findResourceById(String id){
        return resourceService.findById(id);
    }
    @RequestMapping(value = "/deleteResourceById", method = RequestMethod.GET)
    @ApiOperation(value="删除资源")
    public Resource deleteResourceById(String id){
        return resourceService.findById(id);
    }
}
