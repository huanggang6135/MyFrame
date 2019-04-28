package org.hg.myframe.rpc;

/**
 * @Author huanggang6135@gmail.com
 * @Date 2019/4/28 10:30
 * @Version 1.0
 **/
public interface IRegistryCenter {
    void register(String serviceName, String serviceAddress);
}
