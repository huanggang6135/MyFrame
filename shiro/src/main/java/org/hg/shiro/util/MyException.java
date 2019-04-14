package org.hg.shiro.util;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @Author huanggang6135@gmail.com
 * @Date 2019/4/14 11:03
 * @Desc
 * @Version 1.0
 **/
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class MyException extends RuntimeException {
    private static final long serialVersionUID = 2931203585906989933L;
    private int code;
    private String msg;
}
