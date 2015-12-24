package dagger1;

import dagger.Lazy;

import javax.inject.Inject;

/**
 * Created by yantinggeng on 2015/11/23.
 */
public class CoffeeMaker {
    // 当类中含有@Inject注释的成员变量， 却没有@Inject注释的构造函数时，
    // Dagger将使用类的默认构造函数。
    // 若类中缺少@Inject注释， 该类是不能由Dagger创建的。
    @Inject
    Lazy<Heater> heater; //懒加载
    @Inject
    Pump pump;

    public void brew() {
        heater.get().on();
        pump.pump();
        System.out.println(" [_]P coffee! [_]P ");
        heater.get().off();
    }
}
