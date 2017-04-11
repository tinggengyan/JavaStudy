package lambda;

import java.util.Arrays;

/**
 * Created by steveyan on 4/11/17.
 */
public class LambdaTest {

    public static void main(String[] args) {
        // 1. 严格的方式
        Arrays.asList("a", "b", "c").forEach((e) -> {
            System.out.println(e);
        });

        // 2. 对于有一个参数,一个命令的时候，可以省略小括号和大括号
        Arrays.asList("a", "b", "c").forEach(e -> System.out.println(e));

        // 3. 还有一种方式，用双引号,这种方式需要待看
        Arrays.asList("a", "b", "c").forEach(System.out::println);

        // 引用局部变量
        String separator = "separator";
        Arrays.asList("a", "b", "c").forEach(e -> System.out.println(e + separator));


    }
}
