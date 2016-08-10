package Patterns.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * create a handler to define actions before obj do somthing and after it
 * <p>
 * Created by yantinggeng on 2016/8/10.
 */
public class ProxyHandler implements InvocationHandler {

    private Object proxied;

    public ProxyHandler(Object proxied) {
        this.proxied = proxied;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //can do something before call the target
        System.out.println("调用之前");
        Object invoke = method.invoke(proxied, args);
        //can do something after call the method
        System.out.println("调用之后");
        return invoke;
    }

}
