package org.hg.shiro.aspect;

import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.UnauthenticatedException;
import org.apache.shiro.authz.UnauthorizedException;
import org.hg.shiro.util.MyException;
import org.hg.shiro.util.Result;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.naming.AuthenticationException;

/**
 * @Author huanggang6135@gmail.com
 * @Date 2019/4/13 17:00
 * @Desc
 * @Version 1.0
 **/
@RestControllerAdvice("org.hg.shiro.rest")
public class BaseControllerAdvice {
    /**
     * 登录验证异常
     * @return
     */
    @ExceptionHandler({UnauthenticatedException.class, AuthenticationException.class})
    public String authenticationException(){
        Result<String> result = new Result<>();
        result.setCode(Result.OUT_TIME_CODE);
        result.setMessage("会话超时，请重新登录");
        return result.toJsonString();
    }
    @ExceptionHandler({UnauthorizedException.class, AuthorizationException.class})
    public Result authorizationException(){
        Result<Object> result = new Result<>();
        result.setCode(Result.UN_AUTHOR_CODE);
        result.setMessage("权限错误");
        return result;
    }
    @ExceptionHandler(MyException.class)
    public String myException(MyException e){
        Result<Object> result = new Result<>();
        result.setCode(e.getCode());
        result.setMessage(e.getMsg());
        return result.toJsonString();
    }
    @ExceptionHandler
    public Result exception(Exception e){
        Result<Object> result = new Result<>();
        result.setCode(Result.EXCEPTION_CODE);
        result.setMessage(e.getMessage());
        return result;
    }

}
