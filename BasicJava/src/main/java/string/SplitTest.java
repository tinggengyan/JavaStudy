package string;

import java.util.*;

/**
 * Created by Steve on 2017/2/17.
 */
public class SplitTest {
    public static void main(String[] args) {
//        String str = "a,b,c,,,,,,,,d";
//        String str2 = "a,b,c,,,,,,,,";
//        String[] ary = str.split(",");
//        String[] ary2 = str2.split(",");
//        //预期大于 3，结果是 3
//        System.out.println(ary.length);
//        System.out.println(ary2.length);

        ArrayList<? super Fruits> list = new ArrayList<>();
        list.add(new Apple());
        list.add(new Fruits());

        List<String> a = new ArrayList<String>();
        a.add("1");
        a.add("2");


//
//        Iterator<String> iterator = a.iterator();
//        while (iterator.hasNext()){
//            String next = iterator.next();
//            if (next.equals("2")){
//                iterator.remove();
//            }
//        }
//
//        for (String s : a) {
//            System.out.println(s);
//        }


        HashMap<String, String> data = new HashMap<>();
        data.put("a", "steve");
        data.put("b", "yan");
        Set<Map.Entry<String, String>> entries = data.entrySet();
        for (Map.Entry<String, String> entry : entries) {
            String key = entry.getKey();
            String value = entry.getValue();
            System.out.println("key:" + key + "   value:" + value);
        }

        int code = 1;
        switch (code) {
            case 1:
                break;
            default:
                break;
        }


        Apple apple = new Apple();
        apple.setName("apple");



    }
}
