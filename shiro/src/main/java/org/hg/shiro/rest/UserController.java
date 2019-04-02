package org.hg.shiro.rest;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.Synchronized;
import org.hg.shiro.dto.User;
import org.hg.shiro.service.UserService;
import org.hg.shiro.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author hg
 * @Date 2019/3/26 11:49
 * @Version 1.0
 **/
@RestController
@RequestMapping(value = "/api/user")
@Api(value = "/api/user", description = "用户信息接口")
public class UserController {
    @Autowired
    UserService userService;
    @RequestMapping(value = "addUser", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ApiOperation(value = "添加用户")
    public Result addUser(String username, String password) {
        Result<Object> result = new Result<>();
        if(userService.findByName(username) != null){
            return result.setFailureMessage("用户名已存在");
        }
        User user = userService.addUser(username, password);
        if (null == user) {
            return result.setFailureMessage("添加用户失败");
        }
        return result;
    }

    @RequestMapping(value = "findUserById", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    @ApiOperation(value = "查找用户")
    public User findUserById(String id) {
        return userService.findUserById(id);
    }

    @RequestMapping(value="findUserByName", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    @ApiOperation(value="通过用户名查找用户")
    public User findUserByName(String name){
        return userService.findByName(name);
    }
    @Synchronized
    @RequestMapping(value="deleteById", method = RequestMethod.POST)
    public Result<Object> deleteById(String id){
        Result<Object> result = new Result<>();
        User user = userService.findUserById(id);
        if(null != user){
            userService.deleteUser(user);
        }
        result.setMessage("删除成功");
        return result;
    }
    @RequestMapping(value="deleteByName", method = RequestMethod.POST)
    public Result<Object> deleteByName(String Name){
        Result<Object> result = new Result<>();
        User user = userService.findByName(Name);
        if(null != user){
            userService.deleteUser(user);
        }
        result.setMessage("删除成功");
        return result;
    }
}
