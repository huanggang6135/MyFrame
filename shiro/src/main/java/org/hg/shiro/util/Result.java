package org.hg.shiro.util;

import com.alibaba.fastjson.JSON;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * @Author hg
 * @Date 2019/3/26 11:55
 * @Version 1.0
 **/
@Setter
@Getter
@ToString
@NoArgsConstructor
public class Result<T> implements Serializable {
    /** 操作成功 **/
    public static final int SUCCESS_CODE = 200;
    /** 操作失败 **/
    public static final int FAILURE_CODE = 500;
    /** 登录超时 **/
    public static final int OUT_TIME_CODE = 600;
    /** 权限错误 **/
    public static final int UN_AUTHOR_CODE = 601;
    /** 处理异常 **/
    public static final int EXCEPTION_CODE = 700;
    /** 处理错误 **/
    public static final int ERROR_CODE = 701;
    /** IO错误 **/
    public static final int IO_ERROR_CODE = 702;

    private int code = SUCCESS_CODE;
    private String message;
    private T result;

    public Result success(){
        this.code = SUCCESS_CODE;
        return this;
    }
    public Result fail(){
        this.code = FAILURE_CODE;
        return this;
    }
    public Result code(int code){
        this.code = code;
        return this;
    }
    public Result message(String message){
        this.message = message;
        return this;
    }
    public Result result(T result){
        this.result = result;
        return this;
    }
    public Result failMessage(String message){
        this.code = FAILURE_CODE;
        this.message = message;
        return this;
    }
    public Result successMessage(String message){
        this.code = SUCCESS_CODE;
        this.message = message;
        return this;
    }
    public String toJsonString(){
        return JSON.toJSONString(this);
    }
}
