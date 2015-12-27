package dagger2;

import dagger.Component;

/**
 * Created by yantinggeng on 2015/12/24.
 */


@Component(modules = DripCoffeeModule.class)
interface CoffeeShop {
    CoffeeMaker maker();
}
