package operator;

import rx.Observable;
import rx.functions.Action1;
import rx.functions.Func1;

/**
 * Created by yantinggeng on 2015/10/29.
 */
public class ObserMainClass {
    public static void main(String[] args) {

        //1. map,map() ��һ��һ��ת��
        Observable observable = Observable.just("111", "222");
        Action1 action1 = new Action1() {
            @Override
            public void call(Object o) {
                System.out.println(o.toString());
            }
        };
        //�м�㴦��ת��,����ת������ֵ������observer�Ϳ��Դ����ķ���ֵ��
        Func1 func = new Func1() {
            @Override
            public Object call(Object o) {
                return "Func:" + o;
            }
        };
        observable.map(func).subscribe(action1);

        //2. flatMap,һ�Զ��ת��,�˴���demo��student��course���齫����ֳ�һ��������ֱ�ִ��
        final Course[] courses = {new Course(1, "A"), new Course(2, "B"), new Course(3, "C")};
        Course[] courses2 = {new Course(4, "D"), new Course(5, "E"), new Course(6, "F")};
        Student[] students = {new Student(1, courses), new Student(2, courses2)};

        Observable.from(students)
                .flatMap(new Func1<Student, Observable<Course>>() {
                    @Override
                    public Observable<Course> call(Student student) {
                        if (student.getId() == 1)
                            return Observable.from(student.getCourses());
                        else
                            return null;
                    }
                }).subscribe(new Action1<Course>() {
            @Override
            public void call(Course course) {
                System.out.println(course.getCname());
            }
        });

    }
}
