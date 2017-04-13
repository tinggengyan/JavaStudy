package iiterface;

/**
 * Created by steveyan on 4/13/17.
 */
public class DefaulableTest {

    public static void main(String[] args) {
        DefaultableImpl im = new DefaultableImpl();
        im.requiredMethod();

        im.notRequiredMethod();

        Defaulable.staticMethod();

        Defaulable defaulable = DefaulableFactory.create(DefaultableImpl::new);
        defaulable.requiredMethod();


    }
}
