package simpledemo;

import rx.Observable;
import rx.Observer;
import rx.Subscriber;
import rx.functions.Action0;
import rx.functions.Action1;

/**
 * 基础理解
 * <p/>
 * Created by yantinggeng on 2015/10/19.
 */
public class ObservaleMain {

    public static void main(String[] args) {
        ObservaleMain test = new ObservaleMain();
        test.setSubscriber();
    }

    //1.基础的观察者
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

    //2.观察者的封装,用法同上
    Subscriber<String> subscriber = new Subscriber<String>() {
        //事件还未发送之前被调用
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

    //1.基本的被观察者
    Observable observable = Observable.create(new Observable.OnSubscribe<String>() {
        @Override
        public void call(Subscriber<? super String> subscriber) {
            subscriber.onNext("Hello");
            subscriber.onNext("Hi");
            subscriber.onNext("Aloha");
            subscriber.onCompleted();
        }
    });

    //2.被观察者，事件依次处理
    Observable observable2 = Observable.just("1", "2", "3");

    //3.将数组拆封之后，依次调用
    String[] words = {"Hello", "Hi", "Aloha"};
    Observable observable3 = Observable.from(words);


    //Action   会自动根据定义创建出 Subscriber
    //Action0 代表了无参的方法
    Action0 onCompletedAction = new Action0() {
        @Override
        public void call() {
            System.out.println("onCompletedAction");
        }
    };

    //Action1代表了有一个参数的方法
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
        //常规的订阅
//        observable.subscribe(observer);
//        observable2.subscribe(subscriber);
//        observable3.subscribe(subscriber);
        //自动创建的
//        observable.subscribe(onNextAction);
//        observable.subscribe(onNextAction,onErrorAction);
//        observable.subscribe(onNextAction,onErrorAction,onCompletedAction);

    }


}
