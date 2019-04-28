package org.hg.shiro.rest;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.hg.shiro.dto.Resource;
import org.hg.shiro.service.ResourceService;
import org.hg.shiro.service.RoleService;
import org.hg.shiro.service.UserService;
import org.hg.shiro.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

/**
 * @Author hg
 * @Date 2019/4/3 13:58
 * @Version 1.0
 **/
@RestController
@RequestMapping("/admin/resource")
@Api("管理员资源操作")
public class ResourceController {
    @Autowired
    private ResourceService resourceService;
    @Autowired
    private RoleService roleService;
    @Autowired
    private UserService userService;
    @PostMapping(value = "/")
    @ApiOperation(value="添加资源")
    public String addResource(@RequestBody Resource resource){
        Result<String> result = new Result<>();
        if(resourceService.findByKey(resource.getKey()) != null){
            return result.failMessage("资源key已存在").toJsonString();
        }
        Resource resource1 = resourceService.add(resource.getKey(), resource.getName(),resource.getNote());
        if(resource1 == null){
            return result.failMessage("添加资源失败").toJsonString();
        }
        return result.toJsonString();
    }
    @GetMapping("/{id}")
    @ApiOperation(value="查找资源")
    public String findResourceById(@PathVariable String id){
        Resource resource = resourceService.findById(id);
        return new Result<>().result(resource).toJsonString();
    }
    @GetMapping("/page")
    @ApiOperation("分页查询")
    public Result page(@RequestParam(required=false, defaultValue="0") int start,
                       @RequestParam(required = false, defaultValue = "10") int length,
                       @RequestParam(required = false) String find){
        Page page = resourceService.find(start, length, find);
        return new Result<>().result(page);
    }
    @DeleteMapping("/{id}")
    @ApiOperation("删除资源")
    public String deleteResourceById(@PathVariable String id){
        resourceService.delete(id);
        return new Result<String>().toJsonString();
    }
}
