package dagger1;

import javax.inject.Inject;

/**
 * Created by yantinggeng on 2015/11/23.
 */
class Thermosiphon implements Pump {

    private final Heater heater;


    // Dagger将使用 @Inject 注释的构造函数 创建类对象。
    // 当请求构建新的类对象时， Dagger 将自动获取相应的参数， 并调用构造函数。
    @Inject
    Thermosiphon(Heater heater) {
        this.heater = heater;
    }

    @Override
    public void pump() {

        if (heater.isHot()) {
            System.out.println("=> => pumping => =>");
        }
    }
}
