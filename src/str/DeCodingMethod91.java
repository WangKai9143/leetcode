package str;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Administrator on 2020/5/6.
 */
public class DeCodingMethod91 {
    public static void main(String[] args) {
        System.out.println(numDecodings("226"));
    }

    public static int numDecodings(String s) {
        if (s == null ){
            return -1;
        }
        List<String> result = new LinkedList<>();
        getAllDecoding(0,result,s,"");
        return result.size();
    }

    private static void getAllDecoding(int start, List<String> result,String s,String tmp) {
        if (start >= s.length()){
            result.add(tmp);
            return;
        }
        if (start+1<=s.length()){
            String one = s.substring(start,start+1);
            if (Integer.valueOf(one) != 0) {
                char oneCh = (char) ('A' + Integer.valueOf(one) - 1);
                getAllDecoding(start+1,result,s,tmp+oneCh);
            }
        }
        if (start+2<=s.length()) {
            String two = s.substring(start, start + 2);
            if (Integer.valueOf(two) <= 26 && Integer.valueOf(two)>=10) {
                char twoCh = (char) ('A' + Integer.valueOf(two)-1);
                getAllDecoding(start + 2, result, s, tmp + twoCh);
            }
        }
    }
}
