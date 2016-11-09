package processor;

/**
 * Created by yantinggeng on 2016/11/8.
 */

@RuntimeAnnotation(name = "age")
public class ProcessorTest {

    public static void main(String[] args) {

        try {

            Class cls = Class.forName("processor.ProcessorTest");


            RuntimeAnnotation annotation = (RuntimeAnnotation) cls.getAnnotation(RuntimeAnnotation.class);

            System.out.println(annotation.name());


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
