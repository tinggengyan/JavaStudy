package FunctionalInterfaces;

/**
 * 如果一个接口定义个唯一一个抽象方法，那么这个接口就成为函数式接口。
 *
 * 通过在接口里面添加一个抽象方法，这些方法可以直接从接口中运行。
 *
 * 在接口中添加了 @FunctionalInterface 的接口，只允许有一个抽象方法，否则编译器也会报错。
 *
 *
 * Created by steveyan on 4/11/17.
 */
@FunctionalInterface
public interface MyRunnable {

    void onlyOneMethod();

    default void method() {
        System.out.println("默认方法不受影响");
    }

}
