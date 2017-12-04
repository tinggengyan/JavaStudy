package string;


import java.net.URI;
import java.net.URISyntaxException;
import java.util.Map;

public class UriTest {

    public static void main(String[] args) {
        String psw = "aaaaaaaaaaaaaaa1";
        System.out.println(verifyPsw(psw));
    }

    private static boolean verifyPsw(String psw) {
        String regex = "^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{8,16}$";
        return psw.matches(regex);
    }

}
