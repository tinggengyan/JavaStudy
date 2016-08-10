package simpledemo;

import rx.Observable;
import rx.Observer;
import rx.Subscriber;
import rx.functions.*;
import rx.observables.GroupedObservable;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * 基础理解
 * <p>
 * Created by yantinggeng on 2015/10/19.
 */
public class ObservaleMain {

    public static void main(String[] args) {
        ObservaleMain test = new ObservaleMain();
//        test.simpleOnCompleteAndOnError();
//        test.simpleTimer();
//        test.simpleScan();
//        test.simpleGroupBy();
//        test.simpleBuffer();
//        test.simpleWindow();
//        test.simpleCast();
//        test.simpleMerge();
//        test.simpleZip();
//        test.simpleJoin();
//        test.simpleCombineLatest();
//        test.simpleStartWith();
//        test.simpleDefer();
//        test.simpleConcat();
        test.simpleConcat2();
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
    private void simpleOnCompleteAndOnError() {
        Observable.just("a", "b").doOnCompleted(new Action0() {
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


    //simple timer
    private void simpleTimer() {
        Observable.just(1).timer(3, TimeUnit.SECONDS).subscribe(new Subscriber<Long>() {
            @Override
            public void onCompleted() {
                System.out.println("Timer Complte");
            }

            @Override
            public void onError(Throwable e) {
            }

            @Override
            public void onNext(Long aLong) {
                System.out.println("Next:" + aLong);
            }
        });
    }

    //simple scan
    private void simpleScan() {
        String[] words = {"第一个", "第二个", "第三个"};
        Observable.from(words).scan(new Func2<String, String, String>() {
            @Override
            public String call(String s, String s2) {
                return s2;
            }
        }).subscribe(new Action1<String>() {
            @Override
            public void call(String s) {
                System.out.println(s);
            }
        });
    }


    //simple group by
    private void simpleGroupBy() {
        String[] words = {"长度大于2", "1", "1", "有三个", "长度大于2", "1"};
        Observable<GroupedObservable<Integer, String>> groupedObservableObservable = Observable.from(words).groupBy(new Func1<String, Integer>() {
            @Override
            public Integer call(String s) {
                if (s.length() > 2) {
                    return 1;
                } else {
                    return 2;
                }
            }
        });
        Observable.concat(groupedObservableObservable).subscribe(new Action1<String>() {
            @Override
            public void call(String s) {
                System.out.println(s);
            }
        });
    }

    //simple buffer
    private void simpleBuffer() {
        String[] words = {"第一个", "第二个", "第三个"};
        Observable.from(words).buffer(2).subscribe(new Action1<List<String>>() {
            @Override
            public void call(List<String> strings) {
                for (String string : strings) {
                    System.out.print(string);
                }
                System.out.println();
            }
        });
    }

    //simple windows
    private void simpleWindow() {
        String[] words = {"第一个", "第二个", "第三个"};
        Observable.from(words).window(2).subscribe(new Action1<Observable<String>>() {
            @Override
            public void call(Observable<String> stringObservable) {
                stringObservable.subscribe(new Action1<String>() {
                    @Override
                    public void call(String s) {
                        System.out.println(stringObservable.toString());
                        System.out.println(s);
                    }
                });
            }
        });
    }

    //simple cast
    private void simpleCast() {
        Integer[] numbers = {1, 2, 3, 4};
        Observable.from(numbers).cast(Integer.class).subscribe(new Action1<Integer>() {
            @Override
            public void call(Integer s) {
                System.out.println(s);
            }
        });
    }

    //simple merge
    private void simpleMerge() {
        String[] numbers = {"1", "2", "3", "4"};
        String[] words = {"第一个", "第二个", "第三个"};
        Observable<String> integerObservable = Observable.from(numbers);
        Observable<String> stringObservable = Observable.from(words);
        Observable<String> mergeWith = Observable.merge(integerObservable, stringObservable);
        mergeWith.subscribe(new Action1<String>() {
            @Override
            public void call(String s) {
                System.out.println(s);
            }
        });
        integerObservable.sample(500, TimeUnit.MICROSECONDS).subscribe(new Action1<String>() {
            @Override
            public void call(String s) {
                System.out.println(s);
            }
        });
    }


    //simple zip
    private void simpleZip() {
        String[] words = {"第一个", "第二个", "第三个"};
        String[] numbers = {"1", "2", "3", "4"};
        Observable<String> stringObservable = Observable.from(words);
        Observable<String> integerObservable = Observable.from(numbers);
        Observable.zip(stringObservable, integerObservable, new Func2<String, String, String>() {
            @Override
            public String call(String s, String s2) {
                return s + ":" + s2;
            }
        }).subscribe(new Action1<String>() {
            @Override
            public void call(String s) {
                System.out.println(s);
            }
        });
    }


    //simple join
    private void simpleJoin() {
        String[] words = {"第一个", "第二个", "第三个"};
        String[] numbers = {"1", "2", "3", "4"};
        Observable<String> stringObservable = Observable.from(words);
        Observable<String> integerObservable = Observable.from(numbers);
        stringObservable.join(integerObservable, new Func1<String, Observable<String>>() {
            @Override
            public Observable<String> call(String s) {
                return Observable.just(s + "left:");
            }
        }, new Func1<String, Observable<Object>>() {
            @Override
            public Observable<Object> call(String s) {
                return Observable.just(s + "right:");
            }
        }, new Func2<String, String, String>() {
            @Override
            public String call(String s, String s2) {
                return s + s2;
            }
        }).subscribe(new Action1<String>() {
            @Override
            public void call(String s) {
                System.out.println(s);
            }
        });

    }

    //simple combineLatest
    private void simpleCombineLatest() {
        String[] words = {"第一个", "第二个", "第三个"};
        String[] numbers = {"1", "2", "3", "4"};
        Observable<String> stringObservable = Observable.from(words);
        Observable<String> integerObservable = Observable.from(numbers);
        Observable.combineLatest(stringObservable, integerObservable, new Func2<String, String, String>() {
            @Override
            public String call(String s, String s2) {
                return s + "+" + s2;
            }
        }).subscribe(new Action1<String>() {
            @Override
            public void call(String s) {
                System.out.println(s);
            }
        });
    }

    //simple switch
    private void simpleStartWith() {
        String[] words = {"第一个", "第二个", "第三个"};
        Observable<String> stringObservable = Observable.from(words);
        stringObservable.startWith("StartWith").subscribe(new Action1<String>() {
            @Override
            public void call(String s) {
                System.out.println(s);
            }
        });
    }


    //simple defer
    private void simpleDefer() {
        Observable<Object> deferObserverable = Observable.defer(new Func0<Observable<Object>>() {
            @Override
            public Observable<Object> call() {
                System.out.println("done");
                return Observable.just("Hello");
            }
        });
        deferObserverable.subscribe(new Action1<Object>() {
            @Override
            public void call(Object o) {

            }
        });
    }


    //使用concat和first做缓存,依次检查memory、disk和network中是否存在数据，任何一步一旦发现数据后面的操作都不执行。
    private void simpleConcat() {
        Observable<String> memory = Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {
                System.out.println("here is memory");
                String memoryCache = "memory cache";
                if (memoryCache != null) {
                    //调用next表示传递到subscriber那
                    subscriber.onNext(memoryCache);
                } else {
                    //调用complete表示不做处理，处理下个
                    subscriber.onCompleted();
                    System.out.println("memory over");
                }
            }
        });
        Observable<String> disk = Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {
                System.out.println("here is disk");
                String cachePref = "disk cache";
                if (cachePref != null) {
                    subscriber.onNext(cachePref);
                } else {
                    subscriber.onCompleted();
                }
            }
        });

        Observable<String> network = Observable.just("network");
        //依次检查memory、disk、network
        Observable.concat(memory, disk, network)
                .first()
                .subscribe(new Subscriber<String>() {
                    @Override
                    public void onCompleted() {
                        System.out.println("Subscriber is onCompleted");
                    }

                    @Override
                    public void onError(Throwable e) {
                    }

                    @Override
                    public void onNext(String s) {
                        System.out.println("you have choose the " + s);
                    }
                });
    }


    //按照顺序，发射源数据，直到前一个结束了，才发射后一个。
    private void simpleConcat2() {
        Observable<String> a = Observable.just("A");
        Observable<String> b = Observable.just("B");
        Observable<String> c = Observable.just("C");
        Observable.concat(a, b, c).subscribe(new Action1<String>() {
            @Override
            public void call(String s) {
                System.out.println(s);
            }
        });
    }


    //emit without error
    private void simpleCatch() {
        Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {
            }
        }).filter(new Func1<String, Boolean>() {
            @Override
            public Boolean call(String s) {
                return null;
            }
        }).subscribe(new Observer<String>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(String s) {

            }
        });
    }

}
