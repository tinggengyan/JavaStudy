package Patterns.decorator;

/**
 * Created by yantinggeng on 2015/12/15.
 */
public class decoratortest {
    public static void main(String[] args) {
        // create a decorated Window with horizontal and vertical scrollbars
        Window decoratedWindow = new HorizontalScrollBarDecorator(new VerticalScrollBarDecorator(new SimpleWindow()));
        // print the Window's description
        System.out.println(decoratedWindow.getDesc());
    }
}
