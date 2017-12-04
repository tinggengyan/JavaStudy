import javafx.beans.binding.ObjectExpression;

import java.util.ArrayList;

public class JavaTest {

    public static void main(String[] args) {
        method(1,null,null,null);

    }


    private static void method(int a ,Object... args){
        System.out.println(args.length);

    }


}
