package Patterns.decorator;

/**
 * 装饰者的抽象类
 * <p/>
 * Created by yantinggeng on 2015/12/15.
 */
abstract class WindowDecorator implements Window {

    // the Window being decorated
    protected Window decoratedWindow;

    public WindowDecorator(Window decoratedWindow) {
        this.decoratedWindow = decoratedWindow;
    }


}
