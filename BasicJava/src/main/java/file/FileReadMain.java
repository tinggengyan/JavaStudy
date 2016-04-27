package file;

import java.io.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * Created by Steve on 2016/3/13.
 */
public class FileReadMain {
    public static void main(String[] args) {
        try {
//            readfile("F:\\迅雷下载\\data");
            outPut();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static boolean readfile(String filepath) throws IOException {
        try {
            File file = new File(filepath);
            if (!file.isDirectory()) {
                System.out.println("文件");
                System.out.println("path=" + file.getPath());
                System.out.println("absolutepath=" + file.getAbsolutePath());
                System.out.println("name=" + file.getName());
            } else if (file.isDirectory()) {
                System.out.println("文件夹");
                String[] fileList = file.list();
                for (int i = 0; i < fileList.length; i++) {
                    File readfile = new File(filepath + "\\" + fileList[i]);
                    if (!readfile.isDirectory()) {
                        System.out.println("path=" + readfile.getPath());
                        System.out.println("absolutepath=" + readfile.getAbsolutePath());
                        System.out.println("name=" + readfile.getName());
                    } else if (readfile.isDirectory()) {
                        readfile(filepath + "\\" + fileList[i]);
                    }
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("readfile()   Exception:" + e.getMessage());
        }
        return true;
    }


    static void outPut() {

        HashMap<Integer, Integer> datas = new HashMap<>();
        for (int i = 0; i < 100; i++) {
            datas.put(i, 100 + i);
        }
        try {
            File writename = new File("F:\\微博数据\\如家\\output20160405.txt"); // 相对路径，如果没有则要建立一个新的output。txt文件
            writename.createNewFile(); // 创建新文件
            BufferedWriter out = new BufferedWriter(new FileWriter(writename));

            Set<Map.Entry<Integer, Integer>> entries = datas.entrySet();
            for (Map.Entry<Integer, Integer> entry : entries) {
                out.write(entry.getKey());
                out.write("\t");
                out.write(entry.getValue());
            }
            out.write("\r\n"); // \r\n即为换行
            out.flush(); // 把缓存区内容压入文件
            out.close(); // 最后记得关闭文件
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
