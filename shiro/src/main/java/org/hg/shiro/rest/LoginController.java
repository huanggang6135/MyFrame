package org.hg.shiro.rest;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.hg.shiro.util.MyException;
import org.hg.shiro.util.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author hg
 * @Date 2019/4/3 18:59
 * @Version 1.0
 **/
@RestController
@RequestMapping
@Api(description = "登录登出")
public class LoginController {
    @GetMapping("/toLogin")
    public Result toLogin(){
        return new Result().code(Result.OUT_TIME_CODE).message("请登录");
    }
    @ApiOperation("登录")
    @GetMapping("/login")
    public String login(String username, String password){
        Result<Object> result = new Result<>();
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        try{
            subject.login(token);
        } catch (Exception e){
            throw new MyException(Result.FAILURE_CODE, "登录失败");
        }
        return result.toJsonString();
    }
    @GetMapping("/unauthorized")
    public Result unauthorized(){
        return new Result().code(Result.UN_AUTHOR_CODE).message("未授权");
    }
    @GetMapping("/")
    public Result index(){
        return new Result().successMessage("主页");
    }
}
