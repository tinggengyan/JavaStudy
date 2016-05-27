package deeplinkapk;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/**
 * Created by yantinggeng on 2016/5/20.
 */
public class DeepLinkMain {
    public static void main(String[] args) {

//        String syntheticApk = WriteComment2APK.getSyntheticApk("http://m.lvmama.com/tuan/product-277959?losc=082900");
//        System.out.println(syntheticApk);

//        String comment = DeepLinkUtil.getCommentFromApk();
//        System.out.println(comment);


        String comment="http://m.lvmama.com/tuan/product-277959?losc=082900";
        byte[] byteComment = comment.getBytes();
        System.out.println(new String(short2Stream((short) byteComment.length)));
    }

    private static byte[] short2Stream(short data) {
        ByteBuffer buffer = ByteBuffer.allocate(2);
        buffer.order(ByteOrder.LITTLE_ENDIAN);
        buffer.putShort(data);
        buffer.flip();
        return buffer.array();
    }
}
