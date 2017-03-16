package Patterns.singleton.effective;

/**
 * 对于静态域而言是最佳选择
 * <p>
 * <p>
 * Created by Steve on 2017/3/16.
 */
public class LazyInitializationModel {
    // 私有静态类
    private static class FieldHolder {
        static final LazyInitializationModel field = new LazyInitializationModel();
    }

    // 只有在方法被调用时，VM 才会加载 FieldHolder 类
    public static LazyInitializationModel getField() {
        return FieldHolder.field;
    }
}
