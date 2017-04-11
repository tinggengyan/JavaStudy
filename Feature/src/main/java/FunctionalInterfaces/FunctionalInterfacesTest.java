package FunctionalInterfaces;

/**
 * 为了更好的支持 lambda 表达式，才有了这个函数式接口
 *
 * Created by steveyan on 4/11/17.
 */
public class FunctionalInterfacesTest {

    public static void main(String[] args) {

        MyRunnable myRunnable = () -> {
            System.out.println("only one method");
        };
        myRunnable.onlyOneMethod();

    }
}
