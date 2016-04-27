package order;

import java.util.*;

import static javafx.scene.input.KeyCode.T;

/**
 * Created by yantinggeng on 2016/3/28.
 */
public class OrderTest {
    //test the order
    public static void main(String[] args) {
        Map<String, String> paramsMap = new HashMap<>();
        paramsMap.put("sss", "ss");
        paramsMap.put("bss", "ss");
        paramsMap.put("aa", "ss");
        paramsMap.put("at", "ss");
        paramsMap.put("vb", "ss");
        paramsMap.put("vn", "ss");
        paramsMap.put("fr", "ss");
        Map<String, String> params = getParams(paramsMap);
    }

    private static Map<String, String> getParams(Map<String, String> paramsMap) {
        List<Map.Entry<String, String>> infoIds = new ArrayList<>(paramsMap.entrySet());
        Collections.sort(infoIds, new Comparator<Map.Entry<String, String>>() {
            @Override
            public int compare(Map.Entry<String, String> o1, Map.Entry<String, String> o2) {
                return o1.getKey().compareTo(o2.getKey());
            }
        });
        Map<String, String> pa = new HashMap<>();
        for (Map.Entry<String, String> infoId : infoIds) {
            pa.put(infoId.getKey(), infoId.getValue());
        }
        return pa;
    }


}
