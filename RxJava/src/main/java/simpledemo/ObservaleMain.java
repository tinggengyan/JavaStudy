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
        test.simpleOnCompleteAndOnError();
    }

    //最基本的使用方式
    private void simpleObserver() {

        //创建订阅者,Observer 即观察者，它决定事件触发的时候将有怎样的行为。
        Subscriber<String> observer = new Subscriber<String>() {

            @Override
            public void onStart() {
                super.onStart();
                //还未发送消息之前调用
            }

            @Override
            public void onCompleted() {
                //执行结束
            }

            @Override
            public void onError(Throwable e) {
                //执行有错误
            }

            @Override
            public void onNext(String s) {
                //传递消息到下一步
                System.out.println(s);
            }
        };

        //创建Observable
        Observable observable = Observable.create(new Observable.OnSubscribe<String>() {
            //事件的触发规则
            @Override
            public void call(Subscriber<? super String> subscriber) {
                subscriber.onNext("he1");
                subscriber.onNext("he2");
                subscriber.onNext("he3");
                subscriber.onCompleted();
            }
        });
        observable.subscribe(observer);
    }


    // 快捷创建事件队列: just:将传入的参数依次发送出来
    private void simpleJust() {
        String[] words = {"1", "2", "3"};
        Subscriber subscriber = new Subscriber<String>() {

            @Override
            public void onStart() {
                super.onStart();
            }

            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(String s) {
                System.out.println("simple just :" + s);
            }
        };

        Observable.just(words).subscribe(subscriber);
    }

    // 快捷创建事件队列: from:将传入的数组或 Iterable 拆分成具体对象后，依次发送出来。
    private void simpleFrom() {
        Action1 action1 = new Action1() {
            @Override
            public void call(Object o) {
                System.out.println(o.toString());
            }
        };
        String[] words = {"Hello", "Hi", "Aloha"};
        Observable observable = Observable.from(words);
        observable.subscribe(action1);
    }


    //简单的使用action这个接口
    private void simpleAction() {
        //简单的使用Action1这个接口，来变现单个参数的观察者参数
        //所有只含有一个参数的回调都可以用这个简单的接口
        Action1 onNextAction = new Action1() {
            @Override
            public void call(Object o) {
                System.out.println("next:" + o.toString());
            }
        };

        Action1 onErrorAction = new Action1() {
            @Override
            public void call(Object o) {
                System.out.println("error:" + o.toString());
            }
        };
        //对于无参的回调，则可以用Action0这个接口简单的实现
        Action0 onCompletedAction = new Action0() {
            @Override
            public void call() {
                System.out.println("Complete");
            }
        };
        String[] words = {"Hello", "Hi", "Aloha"};
        Observable observable = Observable.from(words);
        observable.subscribe(onNextAction);
        observable.subscribe(onNextAction, onErrorAction);
        observable.subscribe(onNextAction, onErrorAction, onCompletedAction);
    }


    private void setSubscriber() {
    }


    //测试doOnNext()
    private void simpledoOnNext() {
        String[] strings = {"a", "b"};
        Observable observable = Observable.from(strings).doOnNext(new Action1() {
            @Override
            public void call(Object o) {
                System.out.println(o.toString() + "即将进入订阅者");
            }
        });
        observable.subscribe(new Action1() {
            @Override
            public void call(Object o) {
                System.out.println(o.toString());
            }
        });
    }


    private void simpleStart() {
        Observable observable = Observable.just("2", "aa");
        observable.startWith(Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {
                subscriber.onNext("Hello");
                subscriber.onCompleted();
            }
        })).subscribe(new Action1() {
            @Override
            public void call(Object o) {
                System.out.println("value:" + o.toString());
            }
        }, new Action1<Throwable>() {
            @Override
            public void call(Throwable throwable) {

            }
        }, new Action0() {
            @Override
            public void call() {
                System.out.println("Complete");
            }
        });
    }

    //doOnComplete and doOnError
    private void simpleOnCompleteAndOnError(){
        Observable.just("a","b").doOnCompleted(new Action0() {
            @Override
            public void call() {
                System.out.println("doOnCompleted");
            }
        }).doOnError(new Action1<Throwable>() {
            @Override
            public void call(Throwable throwable) {
                System.out.println("doOnError");
            }
        }).subscribe(new Observer<String>() {
            @Override
            public void onCompleted() {
                System.out.println("onCompleted");
            }

            @Override
            public void onError(Throwable e) {
                System.out.println("onError");
            }

            @Override
            public void onNext(String s) {
                System.out.println("onNext");
            }
        });
    }

}
