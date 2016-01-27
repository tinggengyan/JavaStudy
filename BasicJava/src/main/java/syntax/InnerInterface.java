package syntax;

/**
 * 内部声明一个接口
 * <p/>
 * Created by yantinggeng on 2016/1/27.
 */
public class InnerInterface {

    public static void main(String[] args) {
        new InnerInterface.IFace() {
            @Override
            public void say() {
            }
        };
    }

    static interface IFace {
        void say();
    }
}
