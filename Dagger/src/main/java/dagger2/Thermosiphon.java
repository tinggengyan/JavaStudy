package dagger2;

import javax.inject.Inject;

/**
 * Created by yantinggeng on 2015/12/24.
 */
public class Thermosiphon implements Pump {

    private final Heater heater;

    /**
     * 使用@Inject这个注解，表示dagger应该使用这个构造函数来生成一个实例
     * 当需要一个实例的时候，dagger将会获取必要的参数来生成这个对象
     */
    @Inject
    public Thermosiphon(Heater heater) {
        this.heater = heater;
    }

    @Override
    public void pump() {
        if (heater.isHot()) {
            System.out.println("=> => pumping => =>");
        }
    }
}
