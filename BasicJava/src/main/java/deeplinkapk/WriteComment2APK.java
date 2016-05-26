package deeplinkapk;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.zip.ZipFile;

import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

/**
 * source from http://pingguohe.net/2016/03/21/Dynimac-write-infomation-into-apk.html
 * <p>
 * 这个部分是在服务器端执行的
 * <p>
 * Created by yantinggeng on 2016/5/20.
 */
public class WriteComment2APK {

    private static HashMap<String, String> fileCache = new HashMap<>();

    public static String getSyntheticApk(String comment) {
        if (fileCache.containsKey(comment)) {
            return fileCache.get(comment);
        }
        try {
            File file = copyFile();
            writeApk(file, comment);
            //update the cache
            fileCache.put(comment, file.getAbsolutePath());
            return file.getAbsolutePath();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }


    /**
     * 将源文件复制到一个指定的位置
     *
     * @return 返回目标文件
     * @throws IOException
     */
    public static synchronized File copyFile() throws IOException {
        String originApk = "E:\\workspace\\work\\lvmama_android_7.6.1\\app\\ANDROID_DEFAULT_7.6.1.apk";
        File originFile = new File(originApk);
        long timeMillis = System.currentTimeMillis();
        String dest = "E:\\test\\" + timeMillis;
        Path path = Paths.get(dest);
        Path directories = Files.createDirectories(path);
        File destinationFile = new File(directories.toString() + "\\" + originFile.getName());
        Files.copy(originFile.toPath(), destinationFile.toPath(), REPLACE_EXISTING);
        return destinationFile;
    }


    /**
     * 向APK中写入指定内容
     *
     * @param file    待写入的文件
     * @param comment 待写入的内容
     */
    public static void writeApk(File file, String comment) {
        ZipFile zipFile = null;
        ByteArrayOutputStream outputStream = null;
        RandomAccessFile accessFile = null;
        try {
            zipFile = new ZipFile(file);
            String zipComment = zipFile.getComment();
            if (zipComment != null) {
                return;
            }

            // comment to the bytes
            byte[] byteComment = comment.getBytes();
            outputStream = new ByteArrayOutputStream();
            // write the comment content data
            outputStream.write(byteComment);
            // write the comment's length
            outputStream.write(short2Stream((short) byteComment.length));

            byte[] data = outputStream.toByteArray();

            accessFile = new RandomAccessFile(file, "rw");

            accessFile.seek(file.length() - 2);
            //the all comment struct's length
            accessFile.write(short2Stream((short) data.length));
            // write the comment struct
            System.out.println("string data:"+new String(data));
            accessFile.write(data);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (zipFile != null) {
                    zipFile.close();
                }
                if (outputStream != null) {
                    outputStream.close();
                }
                if (accessFile != null) {
                    accessFile.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


    /**
     * 字节数组转换成short（小端序）
     */
    private static byte[] short2Stream(short data) {
        ByteBuffer buffer = ByteBuffer.allocate(2);
        buffer.order(ByteOrder.LITTLE_ENDIAN);
        buffer.putShort(data);
        buffer.flip();
        return buffer.array();
    }
}
