package org.hg.myframe.rpc;

import lombok.extern.slf4j.Slf4j;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.zookeeper.CreateMode;

/**
 * @Author huanggang6135@gmail.com
 * @Date 2019/4/28 10:30
 * @Desc
 * @Version 1.0
 **/
@Slf4j
public class IRegistryCenterImpl implements IRegistryCenter {
    private CuratorFramework curatorFramework;

    {
        curatorFramework = CuratorFrameworkFactory.builder()
                .connectString(RegistryCenterConfig.CONNECTING_STR)
                .sessionTimeoutMs(RegistryCenterConfig.SESSION_TIMEOUT)
                .retryPolicy(new ExponentialBackoffRetry(1000, 10))
                .build();
        curatorFramework.start();
    }

    @Override
    public void register(String serviceName, String serviceAddress) {
        String serviceNodePath = RegistryCenterConfig.NAMESPACE + "/" + serviceName;
        try {
            if(curatorFramework.checkExists().forPath(serviceNodePath) == null){
                curatorFramework.create().creatingParentsIfNeeded().withMode(CreateMode.EPHEMERAL);
            }
            String addressPath = serviceNodePath + "/" + serviceAddress;
            String rsNode = curatorFramework.create().creatingParentsIfNeeded()
                    .withMode(CreateMode.EPHEMERAL)
                    .forPath(addressPath, RegistryCenterConfig.DEFAULT_VALUE);
            log.info("服务注册成功：{}", rsNode);
        } catch (Exception e){
            throw new RuntimeException("注册服务异常：", e);
        }
    }
}
