package Patterns.singleton.effective;

import java.io.*;

/**
 * 一个枚举就可以实现单例,即使在多线程和序列化的前提下
 * <p>
 * 无偿提供序列化机制，绝对防止多次实例化
 * Created by Steve on 2017/3/13.
 */

public class EnumSingle {
    public static void main(String[] args) throws Exception {
        //Write Obj to file
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("tempFile"));
        oos.writeObject(SingleTon.INSTANCE);
        //Read Obj from file
        File file = new File("tempFile");
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
        SingleTon newInstance = (SingleTon) ois.readObject();
        //判断是否是同一个对象，在此处返回的是 true
        System.out.println(newInstance == SingleTon.INSTANCE);
    }

    public enum SingleTon {
        INSTANCE
    }
}
