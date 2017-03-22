package Patterns.decorator;

/**
 * 待被包装的具体的构建类(ConcreteComponent)
 * Created by yantinggeng on 2015/12/15.
 */
public class SimpleWindow implements Window {
    @Override
    public void draw() {
        System.out.println("simple draw window");
    }

    @Override
    public String getDesc() {
        return "simple window";
    }
}
