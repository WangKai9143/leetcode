package str;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by Administrator on 2020/5/3.
 */
public class LeetCode819 {

    public static void main(String[] args) {
        String[] banned = {};
        System.out.println(mostCommonWord("Bob", banned));
    }

    public static String mostCommonWord(String paragraph, String[] banned) {
        if (paragraph == null){
            return null;
        }

        paragraph += ".";// 防止最后一个单子遍历不上
        Map<String,Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        String maxKey = "";
        int maxLen = 0;
        for (Character ch:paragraph.toCharArray()) {
            if (Character.isLetter(ch)){
                sb.append(Character.toLowerCase(ch));
            }else if (sb.length()>0){
                String finString = sb.toString().toLowerCase();
                boolean isIncluding = false;
                for (String ban:banned) {
                    if (finString.equals(ban)){
                        isIncluding = true;
                        break;
                    }
                }
                if (!isIncluding){
                    Integer count = map.get(finString);
                    if (count == null) {
                        count = 1;
                    }else {
                        count = count+1;
                    }
                    map.put(finString, count);
                    if (count>maxLen){
                        maxKey = finString;
                        maxLen = count;
                    }
                }
                sb = new StringBuilder();
            }
        }
        return maxKey;
    }
}
