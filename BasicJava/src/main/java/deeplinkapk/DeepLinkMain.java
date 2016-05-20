package deeplinkapk;

import java.io.File;

import static deeplinkapk.WriteComment2APK.writeApk;

/**
 * Created by yantinggeng on 2016/5/20.
 */
public class DeepLinkMain {
    public static void main(String[] args) {
        File file = new File("E:\\workspace\\AndroidStudio\\Study\\app\\app-release.apk");
        writeApk(file, "test comment");
    }
}
