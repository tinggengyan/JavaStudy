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

    //�������ʹ�÷�ʽ
    private void simpleObserver() {

        //����������,Observer ���۲��ߣ��������¼�������ʱ������������Ϊ��
        Subscriber<String> observer = new Subscriber<String>() {

            @Override
            public void onStart() {
                super.onStart();
                //��δ������Ϣ֮ǰ����
            }

            @Override
            public void onCompleted() {
                //ִ�н���
            }

            @Override
            public void onError(Throwable e) {
                //ִ���д���
            }

            @Override
            public void onNext(String s) {
                //������Ϣ����һ��
                System.out.println(s);
            }
        };

        //����Observable
        Observable observable = Observable.create(new Observable.OnSubscribe<String>() {
            //�¼��Ĵ�������
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


    // ��ݴ����¼�����: just:������Ĳ������η��ͳ���
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

    // ��ݴ����¼�����: from:������������ Iterable ��ֳɾ����������η��ͳ�����
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


    //�򵥵�ʹ��action����ӿ�
    private void simpleAction() {
        //�򵥵�ʹ��Action1����ӿڣ������ֵ��������Ĺ۲��߲���
        //����ֻ����һ�������Ļص�������������򵥵Ľӿ�
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
        //�����޲εĻص����������Action0����ӿڼ򵥵�ʵ��
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


}
