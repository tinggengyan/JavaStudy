package deeplinkapk;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/**
 * Created by yantinggeng on 2016/5/20.
 */
public class DeepLinkUtil {

    public static String getCommentFromApk() {
        String path = "E:\\test\\1464253910072\\ANDROID_DEFAULT_7.6.1.apk";
        File file = new File(path);
        return readApk(file);
    }

    private static String readApk(File file) {
        byte[] bytes;
        try {
            RandomAccessFile accessFile = new RandomAccessFile(file, "r");
            long index = accessFile.length();

            bytes = new byte[2];
            index = index - bytes.length;
            accessFile.seek(index);
            accessFile.readFully(bytes);
            //comment内容的长度
            int contentLength = stream2Short(bytes, 0);
            //存储comment的内容
            bytes = new byte[contentLength];
            index = index - bytes.length;
            accessFile.seek(index);
            accessFile.readFully(bytes);

            return new String(bytes, "utf-8");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * short转换成字节数组（小端序）
     */
    private static short stream2Short(byte[] stream, int offset) {
        ByteBuffer buffer = ByteBuffer.allocate(2);
        buffer.order(ByteOrder.LITTLE_ENDIAN);
        buffer.put(stream[offset]);
        buffer.put(stream[offset + 1]);
        return buffer.getShort(0);
    }
}
