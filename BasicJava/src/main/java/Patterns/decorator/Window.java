package Patterns.decorator;

/**
 * 装饰者和普通的类都需要实现的统一的接口(Component)
 * <p/>
 * Created by yantinggeng on 2015/12/15.
 */
public interface Window {

    void draw();

    String getDesc();

}
