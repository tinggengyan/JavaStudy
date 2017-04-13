package iiterface;

import java.util.function.Supplier;

/**
 * Created by steveyan on 4/13/17.
 */
public interface DefaulableFactory {

    static <T> T create(Supplier<T> supplier) {
        return supplier.get();
    }

}
