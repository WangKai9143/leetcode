package slidingWindow;

import java.util.HashSet;
import java.util.Set;

// 最长不重复子串
/*
示例 1:

        输入: s = "abcabcbb"
        输出: 3
        解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
        示例 2:

        输入: s = "bbbbb"
        输出: 1
        解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
*/

public class LengthOfLongestSubstring3 {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.isEmpty()){
            return 0;
        }
        int left = 0;
        int right = 0;
        Set<Character> set = new HashSet<>();
        char[] arr = s.toCharArray();
        int minLen = -1;
        while (left < arr.length && right < arr.length) {
            if (!set.contains(arr[right])) {
                set.add(arr[right]);
                minLen = Math.max(minLen, right - left + 1);
                right++;
            } else {
                set.remove(arr[left++]);
            }
        }
        return minLen;

    }
}
