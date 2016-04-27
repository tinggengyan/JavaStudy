package heyidata;

import db.DBHelper;

import java.io.*;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;


/**
 * Created by yantinggeng on 2016/4/27.
 */
public class HeYiData {

    static double startTime = 0;
    static double endTime = 0;

    static ArrayList<Integer> allTimes = new ArrayList<Integer>();
    static HashMap<Integer, Integer> result = new HashMap<Integer, Integer>();
    static ArrayList<String> allData = new ArrayList<String>();

    // init the all time
    static void init() {
        // 4/5 00:00
        int first = 1459785600;
        // 一天144个10分钟
        for (int i = 0; i < 144; i++) {
            first += 600;
            allTimes.add(first);
        }
    }

    public static void main(String[] args) {
        startTime = System.currentTimeMillis();
        System.out.println("系统启动！");
        init();
        try {
            read();
        } catch (Exception e) {
            e.printStackTrace();
        }
        deal();
        outPut();
        endTime = System.currentTimeMillis();
        System.out.println("总共耗时：" + (endTime - startTime) / 60000.0 + "分钟");
    }

    // read into the memory
    static void read() throws Exception {
        double s = System.currentTimeMillis();
        BufferedReader br = new BufferedReader(new FileReader(
                "F:\\微博数据\\如家\\weibo_freshdata.2016-04-05"));
        String line = br.readLine();// 一次读入一行，直到读入null为文件结束
        while (line != null) {
            allData.add(line);
            line = br.readLine(); // 接着读下一行
        }
        double e = System.currentTimeMillis();
        System.out.println("读取耗时：" + (e - s) / 60000.0 + "分钟");
    }

    static void deal() {
        double s = System.currentTimeMillis();
        String[] split;
        String content = "";
        Integer time = 0;
        for (String line : allData) {
            split = line.split("\t");
            if (split[3].equals("1")) {
                time = Integer.valueOf(split[17]);
                content = split[22];
            }
            if (split[3].equals("0")) {
                time = Integer.valueOf(split[17]);
                content = split[9];
            }
            if (hasKey(content)) {
                for (int i = allTimes.size() - 1; i >= 0; i--) {
                    if (time > allTimes.get(i) - 600 && time <= allTimes.get(i)) {
                        if (result.containsKey(allTimes.get(i))) {
                            int integer = result.get(allTimes.get(i));
                            ++integer;
                            result.put(allTimes.get(i), integer);
                        } else {
                            result.put(allTimes.get(i), 1);
                        }
                    }
                }
            }
        }
        double e = System.currentTimeMillis();
        System.out.println("处理耗时：" + (e - s) / 60000.0 + "分钟");
    }

    static boolean hasKey(String content) {
        return content.contains("如家") || content.contains("和颐")
                || content.contains("女生遇袭") || content.contains("酒店遇袭");
    }

    static void outPut() {
        double s=System.currentTimeMillis();
        String outPrintSql = "INSERT INTO rujia VALUES(?,?);";
        DBHelper dbHelper = new DBHelper();// 创建DBHelper对象
        PreparedStatement pst = dbHelper.getPst(outPrintSql);
        final int batchSize = 1000;
        int count = 0;
        try {
            Set<Map.Entry<Integer, Integer>> entries = result.entrySet();
            for (Map.Entry<Integer, Integer> entry : entries) {
                int key = entry.getKey().intValue();
                int value = entry.getValue().intValue();
                pst.setInt(1, key);
                pst.setInt(2, value);
                pst.addBatch();
                if (++count % batchSize == 0) {
                    pst.executeBatch();
                }
            }
            pst.executeBatch();
        } catch (Exception e) {
            e.printStackTrace();
        }
        double e = System.currentTimeMillis();
        System.out.println("输出耗时：" + (e - s) / 60000.0 + "分钟");
    }
}
