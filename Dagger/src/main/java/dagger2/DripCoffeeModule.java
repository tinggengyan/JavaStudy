package dagger2;

import dagger.Module;
import dagger.Provides;

/**
 * Created by yantinggeng on 2015/12/24.
 */

@Module
public class DripCoffeeModule {

    @Provides
    Heater provideHeater() {
        return new ElectricHeater();
    }

    @Provides
    Pump providePump(Thermosiphon pump) {
        return pump;
    }

}
