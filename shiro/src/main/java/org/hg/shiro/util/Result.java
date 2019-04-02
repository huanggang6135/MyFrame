package org.hg.shiro.util;

import lombok.Getter;
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
public class Result<T> implements Serializable {
    public static final int SUCCESS_CODE = 200;
    public static final int FAILURE_CODE = 500;

    private int code = SUCCESS_CODE;
    private String message;
    private T result;

    public Result setFailureMessage(String message){
        this.code = FAILURE_CODE;
        this.message = message;
        return this;
    }
}
