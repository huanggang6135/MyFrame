import java.lang.reflect.Proxy;

/**
 * @Author hg
 * @Date 2019/3/31 14:00
 * @Version 1.0
 **/
public class DynamicProxyTest {
    public static void main(String[] args) {
        IUserService target  = new UserServiceImpl();
        MyInvocationHandler handler = new MyInvocationHandler(target);
        IUserService proxyInstance = (IUserService) Proxy.newProxyInstance(DynamicProxyTest.class.getClassLoader(), target.getClass().getInterfaces(), handler);
        proxyInstance.add("str ");
    }
}
