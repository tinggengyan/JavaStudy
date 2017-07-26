package deeplinkapk;

import java.io.File;

public class UtilMain {
    public static void main(String[] args) {
        String comment="sssss";
        String pathname = "C:\\Users\\SteveYan\\Desktop\\ANDROID_CPS_7.10.0.apk";
        File file = new File(pathname);
        WriteComment2APK.writeApk(file,comment);
    }
}
