package org.hg.myframe.rpc;

import lombok.extern.slf4j.Slf4j;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author huanggang6135@gmail.com
 * @Date 2019/4/28 10:54
 * @Desc
 * @Version 1.0
 **/
@Slf4j
public class RpcServer {
    private IRegistryCenter registryCenter;
    private String addressService;
    private static final Map<String, Object> HANDLER_MAPPING = new HashMap<>();

    private static final ExecutorService EXECUTOR_SERVICE = Executors.newCachedThreadPool();

    public void publisher(){
        int port = Integer.parseInt(addressService.split(":")[1]);
        try (ServerSocket serverSocket = new ServerSocket(port)){
            HANDLER_MAPPING.keySet().forEach(interfaceName -> {
                registryCenter.register(interfaceName, addressService);
                log.info("注册服务成功：[serviceName:{}, address:{}]", interfaceName, addressService);
            });
            while (true){
                Socket accept = serverSocket.accept();
                EXECUTOR_SERVICE.execute(new ProcessorHandler(accept, HANDLER_MAPPING));
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    public void bind(Object... services){
        for (Object service : services) {
            RpcAnnotation annotation = service.getClass().getAnnotation(RpcAnnotation.class);
            if(annotation == null){
                continue;
            }
            String serviceName = annotation.value().getName();
            HANDLER_MAPPING.put(serviceName, service);
        }
    }
    public RpcServer(IRegistryCenter registryCenter, String addressService){
        this.registryCenter = registryCenter;
        this.addressService = addressService;
    }
}
