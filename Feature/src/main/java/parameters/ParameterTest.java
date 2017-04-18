package parameters;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

/**
 * 通过新版的javac的–parameters选项,使得方法参数的名字能保留在Java字节码中
 *
 * 目前还未成功办成
 *
 * Created by steveyan on 4/13/17.
 */
public class ParameterTest {

    public static void main(String[] args) {
        try {
            //for (Method method : ParameterTest.class.getMethods()) {
            //    for (Parameter parameter : method.getParameters()) {
            //        System.out.println("method:" + method.getName() + "   parameter:" + parameter.getName());
            //    }
            //}

            Method method = ParameterTest.class.getMethod("main", String[].class);
            for (Parameter parameter : method.getParameters()) {
                System.out.println(parameter.getName());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
