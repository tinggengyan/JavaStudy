package dagger1;

import dagger.Module;
import dagger.Provides;

import javax.inject.Singleton;

/**
 * Created by yantinggeng on 2015/11/24.
 */


@Module(
        injects = CoffeeApp.class,
        includes = PumpModule.class
)
class DripCoffeeModule {

    @Provides
    @Singleton
    Heater provideHeater() {
        return new ElectricHeater();
    }

}
