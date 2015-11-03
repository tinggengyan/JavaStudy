package simpledemo;

import rx.Observable;
import rx.Observer;
import rx.Subscriber;
import rx.functions.Action0;
import rx.functions.Action1;

/**
 * �������
 * <p/>
 * Created by yantinggeng on 2015/10/19.
 */
public class ObservaleMain {

    public static void main(String[] args) {
        ObservaleMain test = new ObservaleMain();
        test.setSubscriber();
    }

    //1.�����Ĺ۲���
    Observer<String> observer = new Observer<String>() {
        @Override
        public void onCompleted() {
            System.out.println("onCompleted");
        }

        @Override
        public void onError(Throwable e) {
        }

        @Override
        public void onNext(String s) {
            System.out.println("s = [" + s + "]");
        }
    };

    //2.�۲��ߵķ�װ,�÷�ͬ��
    Subscriber<String> subscriber = new Subscriber<String>() {
        //�¼���δ����֮ǰ������
        @Override
        public void onStart() {
            super.onStart();
            System.out.println("onStart");
        }

        @Override
        public void onCompleted() {
            System.out.println("onCompleted");
        }

        @Override
        public void onError(Throwable e) {
        }

        @Override
        public void onNext(String s) {
            System.out.println("s = [" + s + "]");
        }
    };

    //1.�����ı��۲���
    Observable observable = Observable.create(new Observable.OnSubscribe<String>() {
        @Override
        public void call(Subscriber<? super String> subscriber) {
            subscriber.onNext("Hello");
            subscriber.onNext("Hi");
            subscriber.onNext("Aloha");
            subscriber.onCompleted();
        }
    });

    //2.���۲��ߣ��¼����δ���
    Observable observable2 = Observable.just("1", "2", "3");

    //3.��������֮�����ε���
    String[] words = {"Hello", "Hi", "Aloha"};
    Observable observable3 = Observable.from(words);


    //Action   ���Զ����ݶ��崴���� Subscriber
    //Action0 �������޲εķ���
    Action0 onCompletedAction = new Action0() {
        @Override
        public void call() {
            System.out.println("onCompletedAction");
        }
    };

    //Action1��������һ�������ķ���
    Action1<String> onNextAction = new Action1<String>() {
        @Override
        public void call(String o) {
            System.out.println("onNextAction");
        }
    };

    Action1<Throwable> onErrorAction = new Action1<Throwable>() {
        @Override
        public void call(Throwable o) {
            System.out.println("onErrorAction");
        }
    };


    private void setSubscriber() {
        //����Ķ���
//        observable.subscribe(observer);
//        observable2.subscribe(subscriber);
//        observable3.subscribe(subscriber);
        //�Զ�������
//        observable.subscribe(onNextAction);
//        observable.subscribe(onNextAction,onErrorAction);
//        observable.subscribe(onNextAction,onErrorAction,onCompletedAction);

    }


}
