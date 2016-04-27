package heyidata;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InterruptedIOException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by yantinggeng on 2016/4/27.
 */
public class HeYiData {

    static int reward = 0;
    static ArrayList<Integer> times = new ArrayList<>();
    static HashMap<Integer, Integer> result = new HashMap<>();

    static void init() {
        // 4/5 00:00
        int first = 1459785600;
        //一天144个10分钟
        for (int i = 0; i < 144; i++) {
            first += 600;
            times.add(first);
        }
    }

    public static void main(String[] args) {
        init();
        try {
            read();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void read() throws Exception {
        BufferedReader br = new BufferedReader(new FileReader("E:\\迅雷下载\\weibo_freshdata.2016-04-05"));
        String data = br.readLine();//一次读入一行，直到读入null为文件结束
        String[] split;
        String content = "";
        Integer time = 0;
        while (data != null) {
            split = data.split("\t");
            if (split[3].equals("1")) {
                time = Integer.valueOf(split[17]);
                content = split[22];
            }
            if (split[3].equals("0")) {
                time = Integer.valueOf(split[17]);
                content = split[9];
                for (String s : split) {
                    System.out.println(s);
                }
                break;
            }
            if (content.contains("key")) {
                for (int i = times.size() - 1; i >= 0; i--) {
                    if (time > times.get(i) - 600 && time <= times.get(i)) {
                        if (result.containsKey(times.get(i))) {
                            Integer integer = result.get(times.get(i));
                            result.put(times.get(i), ++integer);
                        } else {
                            result.put(times.get(i), 1);
                        }
                    }
                }
            }
            data = br.readLine(); //接着读下一行
        }
    }


    static void deal() {
    }


}
