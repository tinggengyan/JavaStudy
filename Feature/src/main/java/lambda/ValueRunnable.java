package lambda;

/**
 * Created by steveyan on 4/12/17.
 */
@FunctionalInterface
public interface ValueRunnable {

    public static void main(String[] args) {
        v((b, c) -> {
            return b + c;
        });
    }

    static void v(ValueRunnable runnable) {
        System.out.println(runnable.hasReturnValue("c", "b"));
    }

    String hasReturnValue(String c, String b);

}
