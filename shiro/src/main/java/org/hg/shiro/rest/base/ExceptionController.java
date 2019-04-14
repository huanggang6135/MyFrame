package org.hg.shiro.rest.base;

import org.hg.shiro.util.MyException;
import org.hg.shiro.util.Result;
import org.hg.shiro.util.myconst.ConstString;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author huanggang6135@gmail.com
 * @Date 2019/4/14 10:57
 * @Desc
 * @Version 1.0
 **/
@RestController
@RequestMapping("/exception")
public class ExceptionController {
    @RequestMapping(value = "/{type}")
    public Result exceptions(@PathVariable("type") String type){
        if(ConstString.ERROR.equals(type)){
            throw new MyException(Result.ERROR_CODE, type);
        } else if(ConstString.IO_ERROR.equals(type)){
            throw new MyException(Result.IO_ERROR_CODE, type);
        }
        Result<String> result = new Result<>();
        result.setCode(Result.EXCEPTION_CODE);
        return  result;
    }
}
