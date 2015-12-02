package number;

/**
 * 测试java中数字运算的过程中，数字类型的转换
 *
 * Created by yantinggeng on 2015/12/2.
 */
public class NumberMain {

    //被除数为浮点数的结果
    public static void main(String[] args) {
        int delta = 2;
        float total = 10 * 1.2f;
        float result = (total - delta) / total;
        System.out.println(result);

    }
}
