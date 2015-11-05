package Thread;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * Callable��Future������������˼�ģ�һ�����������һ���õ������
 * Callable�ӿ�������Runnable�������־Ϳ��Կ������ˣ�����Runnable���᷵�ؽ���������޷��׳����ؽ�����쳣��
 * ��Callable���ܸ�ǿ��һЩ�� ���߳�ִ�к󣬿��Է���ֵ���������ֵ���Ա�Future�õ���
 * Ҳ����˵��Future�����õ��첽ִ������ķ���ֵ
 * <p/>
 * Created by yantinggeng on 2015/11/5.
 */
public class CallableMain {

    public static void main(String[] args) {

        //������Runnable����������������ݣ������Ƿ��������,������з���ֵInteger��
        Callable<Integer> callable = new Callable<Integer>() {
            public Integer call() throws Exception {
                return new Random().nextInt(100);
            }
        };

        //����ȡ��Callable�ķ���ֵ
        FutureTask<Integer> future = new FutureTask<Integer>(callable);
        new Thread(future).start();

        try {
            // TODO do anything
            System.out.println(future.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }


    }

}
