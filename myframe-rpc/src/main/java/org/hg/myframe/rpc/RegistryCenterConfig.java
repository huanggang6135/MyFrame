package org.hg.myframe.rpc;

/**
 * @Author huanggang6135@gmail.com
 * @Date 2019/4/28 10:36
 * @Desc
 * @Version 1.0
 **/
public class RegistryCenterConfig {
    public static final String CONNECTING_STR="127.0.0.1";
    public static final int SESSION_TIMEOUT = 4000;
    public static final String NAMESPACE = "/rpcNode";
    public static final byte[] DEFAULT_VALUE = "0".getBytes();
}
