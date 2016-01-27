package operator;

import rx.Observable;
import rx.Subscriber;
import rx.functions.Action1;
import rx.functions.Func1;

/**
 * Created by Steve on 2016/1/14.
 */
public class SimpleConcatFirstClass {

    public static void main(String[] args) {


        SimpleConcatFirstClass test = new SimpleConcatFirstClass();
        test.simple();
    }


    private void simple() {


        Observable memory = Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {
                subscriber.onNext("memory");
                subscriber.onCompleted();
            }
        });

        Observable disk = Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {
                subscriber.onNext("disk");
                subscriber.onCompleted();

            }
        });
        Observable network = Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {
                subscriber.onNext("network");
                subscriber.onCompleted();

            }
        });


        Observable.concat(memory, disk, network).first(new Func1<String, Boolean>() {
            @Override
            public Boolean call(String o) {
                return isUpdate(o);
            }
        }).subscribe(new Action1() {
            @Override
            public void call(Object o) {
                System.out.println("last is " + o);
            }
        });


    }

    //check the version
    private boolean isUpdate(String s) {
        return s.equals("memory");
    }


}
