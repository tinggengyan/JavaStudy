package date;

import java.time.Clock;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;

/**
 * Created by steveyan on 4/25/17.
 */
public class DateTest {

    public static void main(String[] args) {

        final Clock clock = Clock.systemUTC();
        System.out.println("当前系统时间:" + clock.millis());
        System.out.println("当前时间:" + clock.instant());

        LocalDate localDate = LocalDate.now();
        System.out.println("当前日期:" + localDate);

        final LocalDate dateFromClock = LocalDate.now(clock);
        System.out.println("当前日期:" + dateFromClock);

        final LocalTime time = LocalTime.now();
        final LocalTime timeFromClock = LocalTime.now(clock);

        System.out.println("时间:" + time);
        System.out.println("时间:" + timeFromClock);

        // 时间 和 日期结合的类
        final LocalDateTime datetime = LocalDateTime.now();
        final LocalDateTime datetimeFromClock = LocalDateTime.now(clock);

        System.out.println("时间和日期:" + datetime);
        System.out.println("时间和日期:" + datetimeFromClock);

        // 计算两个事件之间的差异
        // Get duration between two dates
        final LocalDateTime from = LocalDateTime.of(2016, Month.SEPTEMBER, 21, 0, 0, 0);
        final LocalDateTime to = LocalDateTime.now();

        final Duration duration = Duration.between(from, to);
        System.out.println("Duration in days: " + duration.toDays());
        System.out.println("Duration in hours: " + duration.toHours());

    }
}
