package org.hg.shiro.rest;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.NonNull;
import org.hg.shiro.service.UserService;
import org.hg.shiro.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author hg
 * @Date 2019/3/26 11:49
 * @Version 1.0
 **/
@RestController
@RequestMapping("/rest/user")
@Api(value = "/rest/user", description = "用户信息接口")
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping(value = "addUser", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ApiOperation(value = "添加用户")
    @ResponseBody
    public Result addUser(@NonNull String password) {
        Result<Object> result = new Result<>();
        return userService.addUser(password, result);
    }
}
