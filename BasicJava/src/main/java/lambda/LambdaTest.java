package lambda;

/**
 * Created by yantinggeng on 2016/2/22.
 */
public class LambdaTest {
    public static void main(String[] args) {
//        lambda();
        lambdaReturnValue();
    }


    void get(IPerson person) {
        person.walk("Steve");
    }

    // has no args
    private static void simple() {
        LambdaTest test = new LambdaTest();
        test.get(new IPerson() {
            @Override
            public void walk(String s) {
                System.out.println(s + "walking!");
            }
        });
    }

    // have args
    private static void lambda() {
        LambdaTest test = new LambdaTest();
        test.get(s -> System.out.println(s + " is walking "));
    }


    private static void lambdaReturnValue() {
        LambdaTest test = new LambdaTest();
        test.getAnimalName(name -> name + "55");
    }

    private void getAnimalName(IAnimal animal) {
        System.out.println(animal.getName("Dog"));
    }


}






