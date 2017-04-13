package iiterface;

/**
 * Created by steveyan on 4/13/17.
 */
@FunctionalInterface
public interface Defaulable {

    static void staticMethod() {
        System.out.println("static Method");
    }

    void requiredMethod();

    default void notRequiredMethod() {
        System.out.println("default method");
    }

}
