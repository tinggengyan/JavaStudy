import dagger.Module;
import dagger.Provides;

import java.util.TreeMap;

/**
 * Created by yantinggeng on 2015/11/24.
 */

@Module(
        complete = false,
        library = true
)
class PumpModule {
    @Provides
    Pump providePump(Thermosiphon pump) {
        return pump;
    }
}
