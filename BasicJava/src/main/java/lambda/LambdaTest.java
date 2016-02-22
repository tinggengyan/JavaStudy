package lambda;

/**
 * Created by yantinggeng on 2016/2/22.
 */
public class LambdaTest {

    interface IPerson {
        void walk(String name);
    }

    public static void main(String[] args) {
        lambda();
    }

    void get(IPerson person) {
        person.walk("Steve");
    }

    private static void simple() {
        LambdaTest test = new LambdaTest();
        test.get(new IPerson() {
            @Override
            public void walk(String s) {
                System.out.println(s + "walking!");
            }
        });
    }

    private static void lambda() {
        LambdaTest test = new LambdaTest();
        test.get((s) -> System.out.println(s + " is walking "));
    }


}






