import dagger.ObjectGraph;

import javax.inject.Inject;

/**
 * Created by yantinggeng on 2015/11/24.
 */
public class CoffeeApp implements Runnable {
    @Inject
    CoffeeMaker coffeeMaker;

    @Override
    public void run() {
        coffeeMaker.brew();
    }

    public static void main(String[] args) {
        ObjectGraph objectGraph = ObjectGraph.create(new DripCoffeeModule());
        CoffeeApp coffeeApp = objectGraph.get(CoffeeApp.class);
        coffeeApp.run();
    }

}
