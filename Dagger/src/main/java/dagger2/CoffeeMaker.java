package dagger2;

import javax.inject.Inject;

/**
 * Created by yantinggeng on 2015/12/24.
 */
public class CoffeeMaker {
    /**
     * 假如存在注解需要注入对象，但是没有对应的注解的构造函数，
     * dagger会对那些需要被注入的属性进行注入，但是并不是创建新的实例。
     * 也可以用注解添加一个无参的构造函数来通知dagger创建新的实例。
     * dagger还支持对方法的注解，尽管属性或者构造函数更加典型。
     * 对于那些没用注解的类，是不能被dagger正确的构造的。
     */

    @Inject
    Heater heater;
    @Inject
    Pump pump;

    public void brew() {
        heater.on();
        pump.pump();
        System.out.println(" [_]P coffee! [_]P ");
        heater.off();
    }
}
