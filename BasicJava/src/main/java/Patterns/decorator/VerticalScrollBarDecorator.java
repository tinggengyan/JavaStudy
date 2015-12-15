package Patterns.decorator;

/**
 * Created by yantinggeng on 2015/12/15.
 */
public class VerticalScrollBarDecorator extends WindowDecorator {


    public VerticalScrollBarDecorator(Window decoratedWindow) {
        super(decoratedWindow);
    }

    @Override
    public void draw() {
        drawVerticalScrollBar();
        decoratedWindow.draw();
    }

    private void drawVerticalScrollBar() {
        System.out.println("draw the vertical scrollbar");
    }

    @Override
    public String getDesc() {
        return decoratedWindow.getDesc() + ", including vertical scrollbars";
    }
}
