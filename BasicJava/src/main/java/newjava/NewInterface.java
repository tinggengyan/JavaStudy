package newjava;

/**
 * Created by yantinggeng on 2016/3/17.
 */
public interface NewInterface {
    default void say() {
        System.out.println("This from interface");
    }

    static void ss() {

    }
}
