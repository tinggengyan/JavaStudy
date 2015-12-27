package number;

/**
 * 百分比时间转换
 * <p/>
 * <p/>
 * Created by Steve on 2015/12/27.
 */
public class TimeNumberConvert {

    public static void main(String[] args) {
        getTime("9.99");
    }


    private static void getTime(String time) {
        String[] split = time.split("\\.");
        int hour = 0;
        int minute = 0;
        hour = Integer.valueOf(split[0]);
        if (split.length > 1) {
            String left = split[1];
            if (left.length() > 1) {
                left = left.substring(0, 2);
            } else {
                left = left + "0";
            }
            minute = Integer.valueOf(left) * 60 / 100;
        }
        System.out.println("H:" + hour + "M:" + minute);
    }


}
