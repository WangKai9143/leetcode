package mianshi;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class validIp {

    public static void main(String[] args) {
        List<String> result = getValidIp("101023");
        System.out.println(result);
    }

    static List<String> getValidIp(String str) {
        if (str == null || str.isEmpty()) {
            return Collections.EMPTY_LIST;
        }
        List<String> validIps = new ArrayList<>();
        List<String> tmpIp = new ArrayList<>();
        getValidIp(str, 4, validIps, tmpIp);
        return validIps;
    }

    private static void getValidIp(String str, int level, List<String> validIps, List<String> tmpIp) {
        if (level == 0) {
            if (str.length()>0){
                return;
            }
            StringBuilder stringBuilder = new StringBuilder();
            for (String ipParam : tmpIp) {
                if (isValid(ipParam)) {
                    stringBuilder.append(ipParam);
                    stringBuilder.append(".");
                } else {
                    return;
                }
            }
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            validIps.add(stringBuilder.toString());
        }
        // 遍历所有打断点的位置
        for (int i = 1; i < 4; i++) {
            // 这块要判断str字符串的大小，另外这块要先判断ip字段的有效性
            if (str.length() >= i && isValid(str.substring(0, i))) {
                tmpIp.add(str.substring(0, i));
                // 注意层次这块是level-1;不是--;
                getValidIp(str.substring(i), level-1, validIps, tmpIp);
                tmpIp.remove(str.substring(0, i));
            }
        }
    }

    static boolean isValid(String s) {
        if (s.length()> 1 && s.charAt(0) == '0') return false;
        return Integer.valueOf(s) >= 0 && Integer.valueOf(s) <= 255;
    }
}
