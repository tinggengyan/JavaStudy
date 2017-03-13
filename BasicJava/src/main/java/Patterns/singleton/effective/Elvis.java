package Patterns.singleton.effective;

import java.io.*;

/**
 * Created by Steve on 2017/3/13.
 */
public class Elvis implements Serializable {
    private static final Elvis instance = new Elvis();

    private Elvis() {
    }

    public static Elvis getInstance() {
        return instance;
    }


    public static void main(String[] args) throws Exception {
        //Write Obj to file
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("tempFile"));
        oos.writeObject(Elvis.getInstance());
        //Read Obj from file
        File file = new File("tempFile");
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
        Elvis newInstance = (Elvis) ois.readObject();
        //判断是否是同一个对象,在此处返回的是 false
        //如果需要返回true，需要将每个实例域都用transient标记，并提供readResolve方法
        System.out.println(newInstance == Elvis.getInstance());

    }
}
