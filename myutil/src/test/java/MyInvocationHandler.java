import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @Author hg
 * @Date 2019/3/31 13:50
 * @Version 1.0
 **/
public class MyInvocationHandler implements InvocationHandler {
    Object target;

    public MyInvocationHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("准备--------------------");
        Object invoke = method.invoke(target, args);
        System.out.println("完成--------------------");
        return invoke;
    }
}
