package simpledemo;

import rx.Observable;
import rx.Subscriber;
import rx.functions.Action0;
import rx.functions.Action1;
import rx.functions.Func1;

/**
 * Created by yantinggeng on 2015/12/31.
 */
public class BizDemo {
    public static void main(String[] args) {
        BizDemo demo=new BizDemo();
        demo.simpleConcat2();
    }



    ////////////////////////////////////////////
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

    //////////////////////////////////////
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

    private void simpleConcat2() {

        final String cacheCache = "no cache";
        final String versionCache = "7.4.0";
        final String httpCache = "new data is coming";
        final String refreshUI = "Refresh UI";

        final boolean hasCache = false;
        final boolean versionSame = false;
        final boolean hasNewData = true;


        final Observable<String> cacheObservable = Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {
                System.out.println("读取缓存");
                if (hasCache) {
                    subscriber.onNext("有缓存");
                } else {
                    subscriber.onNext("无缓存");
                }
            }
        });
        final Observable<String> ccccc = cacheObservable.flatMap(new Func1<String, Observable<String>>() {
            @Override
            public Observable<String> call(final String s) {
                if (s.equals("有缓存")) {
                    return Observable.create(new Observable.OnSubscribe<String>() {
                        @Override
                        public void call(Subscriber<? super String> subscriber) {
                            subscriber.onNext(s);//refresh
                            subscriber.onCompleted();//version
                        }
                    });
                } else {
                    return Observable.create(new Observable.OnSubscribe<String>() {
                        @Override
                        public void call(Subscriber<? super String> subscriber) {
                            subscriber.onCompleted();//
                        }
                    });
                }
            }
        });

        final Observable<String> versionObservable = Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {
                System.out.println("对比缓存");
                if (versionSame) {

                }
            }
        });

        final Observable<String> httpObservable = Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {

            }

        });


        httpObservable.startWith(versionObservable).startWith(ccccc).subscribe(new Action1<String>() {
            @Override
            public void call(String s) {

            }
        });


    }
}
