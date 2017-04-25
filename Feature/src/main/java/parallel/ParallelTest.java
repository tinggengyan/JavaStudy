package parallel;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by steveyan on 4/25/17.
 */
public class ParallelTest {

    public static void main(String[] args) {
        long[] arrayOfLong = new long[20000];

        Arrays.parallelSetAll(arrayOfLong, index -> ThreadLocalRandom.current().nextInt(100000));
        Arrays.stream(arrayOfLong).limit(10).forEach(i -> System.out.println(i));
        System.out.println();

        Arrays.parallelSort(arrayOfLong);
        Arrays.stream(arrayOfLong).limit(10).forEach(i -> System.out.println(i));
        System.out.println();

        Arrays.stream(arrayOfLong).limit(10).forEach(i -> System.out.println(i));
    }
}
