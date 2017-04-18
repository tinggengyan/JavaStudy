package stream;

import java.util.Arrays;
import java.util.Collection;

/**
 * 把函数式编程带到java中,Stream API可以极大提供Java程序员的生产力，让程序员写出高效率、干净、简洁的代码。
 *
 * Created by steveyan on 4/18/17.
 */
public class StreamTest {

    public static void main(String[] args) {
        final Collection<Task> tasks = Arrays.asList(
            new Task(Status.OPEN, 5),
            new Task(Status.OPEN, 13),
            new Task(Status.CLOSED, 8)
        );

        // 统计状态为open 的分数
        final long totalPointsOfOpenTasks =
            tasks
                .stream()
                .filter(t -> t.getStatus() == Status.OPEN)
                .mapToInt(Task::getPoints)
                .sum();

        System.out.println("Total points: " + totalPointsOfOpenTasks);


    }

    private enum Status {
        OPEN, CLOSED
    }

    private static final class Task {

        private final Status status;
        private final Integer points;

        Task(final Status status, final Integer points) {
            this.status = status;
            this.points = points;
        }

        public Integer getPoints() {
            return points;
        }

        public Status getStatus() {
            return status;
        }

        @Override
        public String toString() {
            return String.format("[%s, %d]", status, points);
        }
    }

}
