package Patterns.proxy;

/**
 * Created by yantinggeng on 2016/8/10.
 */
public class RealSubject implements Subject {
    @Override
    public void doSomething() {
        System.out.println("RealSubject do something");
    }
}
