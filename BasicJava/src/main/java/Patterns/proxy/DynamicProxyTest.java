package Patterns.proxy;

import sun.misc.ProxyGenerator;

import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Proxy;

/**
 * Created by yantinggeng on 2016/8/10.
 */
public class DynamicProxyTest {

    public static void main(String[] args) {
        RealSubject realSubject = new RealSubject();
        Subject proxySubject = (Subject) Proxy.newProxyInstance(Subject.class.getClassLoader(), new Class[]{Subject.class}, new ProxyHandler(realSubject));
        proxySubject.doSomething();
        createProxyClassFile();
    }

    public static void createProxyClassFile() {
        String name = "ProxySubject";
        byte[] data = ProxyGenerator.generateProxyClass(name, new Class[]{Subject.class});
        try {
            FileOutputStream out = new FileOutputStream(name + ".class");
            out.write(data);
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
