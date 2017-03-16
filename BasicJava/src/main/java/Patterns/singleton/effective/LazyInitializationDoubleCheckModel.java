package Patterns.singleton.effective;

/**
 * 实例域可以采用这种双重检查锁机制
 * <p>
 * Created by Steve on 2017/3/16.
 */
public class LazyInitializationDoubleCheckModel {

    // 对于基本数据类型可以删除这个  volatile
    private volatile LazyInitializationDoubleCheckModel field;

    LazyInitializationDoubleCheckModel getField() {
        // 这个临时变量能提高性能，保证 filed 只被读取一次
        LazyInitializationDoubleCheckModel result = field;
        if (result == null) { // First check (no locking)
            synchronized (this) {
                result = field;
                if (result == null) // Second check (with locking)
                    field = result = new LazyInitializationDoubleCheckModel();
            }
        }
        return result;
    }
}
