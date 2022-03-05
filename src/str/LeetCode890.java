package str;

import javax.swing.text.html.parser.Entity;
import java.util.*;

/**
 * Created by Administrator on 2020/5/1.
 */
public class LeetCode890 {
    public static void main(String[] args) {
        String[] words = {"abc","deq","mee","aqq","dkd","ccc"};
        String pattern = "abb";
        List<String> result = findAndReplacePattern(words,pattern);
        System.out.println(result);
    }
    public static List<String> findAndReplacePattern(String[] words, String pattern) {
        if (words == null || words.length == 0 || pattern == null){
            return null;
        }
        List<String> result = new ArrayList<>();
        Map<Character,Character> mapwp = new HashMap<>();
        Map<Character,Character> mappw = new HashMap<>();
        int len = pattern.length();

        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            mapwp.clear();
            mappw.clear();
            // 记录映射关系
            boolean flag = true;
            for (int j = 0; j < len; j++) {
                Character pch = pattern.charAt(j);
                Character wch = word.charAt(j);
                if (!mappw.containsKey(pch)){
                   mappw.put(pch,wch);
                }
                if (!mapwp.containsKey(wch)){
                    mapwp.put(wch,pch);
                }
                // 映射关系都不能重复
                if (mapwp.get(wch) != pch || mappw.get(pch) != wch) {
                    flag = false;
                }
            }
            if (flag) {
                result.add(word);
            }
        }
        return result;
    }
}
