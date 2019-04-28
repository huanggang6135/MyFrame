package org.hg.myframe.rpc;

import lombok.extern.slf4j.Slf4j;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.Socket;
import java.util.Map;

/**
 * @Author huanggang6135@gmail.com
 * @Date 2019/4/28 11:03
 * @Desc
 * @Version 1.0
 **/
@Slf4j
public class ProcessorHandler implements Runnable {
    private Socket socket;
    private Map<String, Object> handlerMapping;

    public ProcessorHandler(Socket socket, Map<String, Object> handlerMapping) {
        this.socket = socket;
        this.handlerMapping = handlerMapping;
    }

    @Override
    public void run() {
        try (
                ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream())
        ){
            RpcRequest request = (RpcRequest)objectInputStream.readObject();
            Object o = invoke(request);
            objectOutputStream.writeObject(o);
            objectOutputStream.flush();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    private Object invoke(RpcRequest request) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        log.info("服务端开始调用");
        Object[] paramters = request.getParamters();
        Class[] classes = new Class[paramters.length];
        for (int i = 0; i < paramters.length; i++) {
            classes[i] = paramters[i].getClass();
        }
        Object service = handlerMapping.get(request.getClassName());
        Method method = service.getClass().getMethod(request.getMethodName(), classes);
        return method.invoke(service, paramters);
    }
}
