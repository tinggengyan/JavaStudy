package number;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 测试是否为手机号
 * <p/>
 * Created by yantinggeng on 2016/1/25.
 */
public class PhoneNumber {
    public static void main(String[] args) {
        System.out.println(isPhone("12345678901"));
    }

    //判断是否为手机号码
    public static boolean isPhone(String strPhone) {
        if (strPhone == null) {
            return false;
        }
        String strPattern = "^((?:13\\d|14[\\d]|15[\\d]|17[\\d]|18[\\d])-?\\d{5}(\\d{3}|\\*{3}))$";
        Pattern p = Pattern.compile(strPattern);
        Matcher m = p.matcher(strPhone);
        return m.matches();
    }
}
