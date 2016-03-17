package newjava;

/**
 * Created by yantinggeng on 2016/3/17.
 */
public class IterfaceTest {


    public static void main(String[] args) {

        NewInterfaceIPL interfaceIPL=new NewInterfaceIPL();
        interfaceIPL.say();

    }

    static class NewInterfaceIPL implements NewInterface {
//        @Override
//        public void say() {
//            System.out.println("from ipl");
//        }
    }

}
