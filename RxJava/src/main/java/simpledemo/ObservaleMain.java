package simpledemo;

import rx.Observable;
import rx.Subscriber;
import rx.functions.Action0;
import rx.functions.Action1;
import rx.functions.Func1;

/**
 * 基础理解
 * <p/>
 * Created by yantinggeng on 2015/10/19.
 */
public class ObservaleMain {

    public static void main(String[] args) {
        ObservaleMain test = new ObservaleMain();
//        test.setSubscriber();
//        test.simpleConcat();
        test.flatMapVersion();
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


    private void simpleConcat() {

        final String cacheCache = "no cache";
        final String versionCache = "7.4.0";
        final String httpCache = "new data is coming";

        final boolean hasCache = false;
        final boolean versionSame = false;
        final boolean hasNewData = true;


        final Observable<String> cache = Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {
                System.out.println("读取缓存内容");
                if (hasCache) {
                    System.out.println("有缓存，即将显示页面");
                    subscriber.onCompleted();
                } else {
                    System.out.println("没有缓存");
                    subscriber.onCompleted();
                }
            }
        });

        final Observable<String> version = Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {
                System.out.println("检查版本号");
                if (!versionSame) {
                    System.out.println("版本号不一样，需要联网检查");
                    subscriber.onCompleted();
                } else {
                    System.out.println("版本号一样，不需要继续执行了，就这么着了吧。。。");
                }
            }
        });

        final Observable<String> httpData = Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {
                if (hasNewData) {
                    System.out.println("获取到最新的数据了，存储，更新界面");
                    subscriber.onNext(httpCache);
                } else {
                    subscriber.onCompleted();
                }
            }
        });


        Observable.concat(cache, version, httpData).first().subscribe(new Action1<String>() {
            @Override
            public void call(String s) {
                System.out.println("最后执行的是:" + s);
            }
        }, new Action1<Throwable>() {
            @Override
            public void call(Throwable throwable) {

            }
        }, new Action0() {
            @Override
            public void call() {
                System.out.println("跑完流程");
            }
        });

    }


    private void flatMapVersion() {
        final String cacheCache = "no cache";
        final String versionCache = "7.4.0";
        final String httpCache = "new data is coming";

        final boolean hasCache = false;
        final boolean versionSame = false;
        final boolean hasNewData = true;


        final Observable<String> cache = Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {
                System.out.println("读取缓存内容");
                if (hasCache) {
                    System.out.println("有缓存，即将显示页面");
                    subscriber.onNext("Has cache");
                } else {
                    System.out.println("没有缓存");
                    subscriber.onNext("No cache");
                }
            }
        });

        Observable<String> stringObservable = cache.flatMap(new Func1<String, Observable<String>>() {
            @Override
            public Observable<String> call(final String s) {
                System.out.println("Func1:" + s);
                //根据缓存的有无，构造下一个事件源
                if (s != null) {
                    //TODO 有缓存，接下来进行version的比对
                    return Observable.create(new Observable.OnSubscribe<String>() {
                        @Override
                        public void call(Subscriber<? super String> subscriber) {
                            //TODO 比对version
                            subscriber.onNext(s);
                        }
                    });
                } else {
                    return Observable.create(new Observable.OnSubscribe<String>() {
                        @Override
                        public void call(Subscriber<? super String> subscriber) {
                            //TODO 直接获取全部的内容，存储，更新界面
                            subscriber.onNext(s);
                        }
                    });
                }
            }
        });

        stringObservable.subscribe(new Action1<String>() {
            @Override
            public void call(String s) {
                System.out.println("Next :" + s);
            }
        });

    }


}
