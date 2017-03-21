package generics;

/**
 * https://itimetraveler.github.io/2016/12/27/%E3%80%90Java%E3%80%91%E6%B3%9B%E5%9E%8B%E4%B8%AD%20extends%20%E5%92%8C%20super%20%E7%9A%84%E5%8C%BA%E5%88%AB%EF%BC%9F/
 * <p>
 * <p>
 * Created by Steve on 2017/3/21.
 */
public class GenericsTest {

    public static void main(String[] args) {

        // 1. error,虽然meat 和beef存在继承关系，但对于plate来说，没有继承关系，
        Plate<Meat> p = null;
        // p = new Plate<Beef>(new Beef());
        Meat meat = p.getItem();

        // 对于以上的问题，才会有上限 和下限，<? extends T>和<? super T>一说

        // 2. error
        Plate<? extends Meat> p1 = null;
        // p1 = new Plate<>(new Beef());

        Meat m = p1.getItem();


        // 3. yes
        Plate<? super Meat> p2 = null;
        p2 = new Plate<>(new Beef());
        // error
        // Meat m2=p2.getItem();
        // get 方法只能被 最基本的object接收
        Object item = p2.getItem();

    }


    /**
     * 泛型方法 ，public 后的尖括号表示了这个是个泛型方法
     *
     * @param tClass 用来创建泛型对象
     * @param <T>    声明一个泛型 T
     * @return 返回泛型对象
     */
    public <T> T getObject(Class<T> tClass) throws Exception {
        T t = tClass.newInstance();
        return t;
    }


}
