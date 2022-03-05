package slidingWindow;

import java.util.ArrayList;
import java.util.List;

// 找到字符串中所有字母异位词

/*输入: s = "cbaebabacd", p = "abc"
        输出: [0,6]
        解释:
        起始索引等于 0 的子串是 "cba", 它是 "abc" 的异位词。
        起始索引等于 6 的子串是 "bac", 它是 "abc" 的异位词。
         示例 2:

        输入: s = "abab", p = "ab"
        输出: [0,1,2]
        解释:
        起始索引等于 0 的子串是 "ab", 它是 "ab" 的异位词。
        起始索引等于 1 的子串是 "ba", 它是 "ab" 的异位词。
        起始索引等于 2 的子串是 "ab", 它是 "ab" 的异位词。*/

public class FindAnagrams438 {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if (s == null || p == null || s.isEmpty() || p.isEmpty()) {
            return result;
        }
        char[] sArray = s.toCharArray();
        char[] pArray = p.toCharArray();
        int l = 0;
        int hash[] = new int[26];
        for (int i = 0; i < p.length(); i++) {
            hash[pArray[i]]++;
        }
        int len = pArray.length;
        for (int r =0; r < sArray.length; r++) {
            // 如果匹配，则计数器减1
            if (hash[sArray[r]] > 0) {
                len--;
            }
            // 更新窗口的字符匹配情况
            hash[sArray[r]]--;
            // 找到解之后开始优化
            while (len == 0) {
                if (r - l + 1 == p.length()) {
                    result.add(l);
                }
                // 移动窗口左区间
                hash[sArray[l]]++;
                // 只有大于0的元素才是需要匹配的元素，才需要更新匹配计数器
                if (hash[sArray[l]]>0) {
                    len++;
                }
                l++;
            }
        }
        return result;
    }
}
