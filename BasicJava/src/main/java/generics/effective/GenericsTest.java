package generics.effective;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by SteveYan on 2017/4/13.
 */
public class GenericsTest {
    public static void main(String[] args) {
        List<String> strings = new ArrayList<>();
        unsafeAdd(strings, "hello");
        String s = strings.get(0);


        List<?> list = strings;


    }

    public static void unsafeAdd(List list, Object o) {
        list.add(o);
    }


    public static void safeAdd(List<Object> list, Object o) {
        list.add(o);
    }

    public static void except() {

        Class<String> c = String.class;
        Class<Integer> integerClass = int.class;
        Class<String[]> stringArrayClass = String[].class;


        // 由于泛型信息可以在运行时被擦除,存在两种例外
        // 第一种：在类文字中必须使用原生态类型
        // List<String>.class; 非法的处理方式
        // List<?>.class

        // 第二种：由于运行时会擦除泛型信息，所以在参数化类型上使用 instanceof 操作符非法的。用无限制通配符类型代替原生类型，对行为不产生影响。显得多余。


        List<String> stringList = new ArrayList<>();
        // inlegitimate
//        if (stringList instanceof  List<String>){
//        }

    }

}
