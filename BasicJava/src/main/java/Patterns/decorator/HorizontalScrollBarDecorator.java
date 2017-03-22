package Patterns.decorator;

/**
 * 实实在在的装饰者实现类(ConcreteDecorator)
 * <p>
 * Created by yantinggeng on 2015/12/15.
 */
public class HorizontalScrollBarDecorator extends WindowDecorator {

    public HorizontalScrollBarDecorator(Window decoratedWindow) {
        super(decoratedWindow);
    }

    public void draw() {
        drawHorizontalScrollBar();
        decoratedWindow.draw();
    }

    private void drawHorizontalScrollBar() {
        // draw the horizontal scrollbar
    }

    public String getDesc() {
        return decoratedWindow.getDesc() + ", including horizontal scrollbars";
    }
}
