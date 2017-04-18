package optional;

import java.util.Optional;

/**
 * 对于空指针的判断加固了
 *
 *
 * Created by steveyan on 4/18/17.
 */
public class OptionalTest {

    public static void main(String[] args) {
        // 新建一个optional 对象
        Optional<String> fullName = Optional.ofNullable(null);
        // 判断是否为空
        System.out.println("Full Name is set? " + fullName.isPresent());
        // 如果为空就按照 orElseGet 取值
        System.out.println("Full Name: " + fullName.orElseGet(() -> "[none]"));
        // 不为空就应用 map 的方法，否则应用else 方法
        System.out.println(fullName.map(s -> "Hey " + s + "!").orElse("Hey Stranger!"));
    }
}
