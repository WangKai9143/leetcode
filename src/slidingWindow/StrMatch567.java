package slidingWindow;

import org.junit.jupiter.api.Test;

/**
 * Created by Administrator on 2020/4/1.
 */
public class StrMatch567 {

    /*    示例 1：

        输入：s1 = "ab" s2 = "eidbaooo"
        输出：true
        解释：s2 包含 s1 的排列之一 ("ba").
        示例 2：

        输入：s1= "ab" s2 = "eidboaoo"
        输出：false*/
    public static boolean checkInclusion(String s1, String s2) {
        if (s1 == null || s2 == null || s1.isEmpty() || s2.isEmpty()) {
            return false;
        }
        char[] s2Arr = s1.toCharArray();
        char[] s1Arr = s2.toCharArray();
        int[] need = new int[256];
        for (int i = 0; i < s2Arr.length; i++) {
            need[s2Arr[i]]++;
        }
        int l = 0;
        int count = 0;
        for (int r = 0; r < s1Arr.length; r++) {
            // 匹配ok
            if (need[s1Arr[r]] > 0) {
                count++;
            }
            // 窗口要匹配的字符个数减1
            need[s1Arr[r]]--;
            while (r - l > s2Arr.length - 1) {
                if (count == s2Arr.length) {
                    return true;
                }
                need[s1Arr[l]]++;
                // 如果左窗口的第一个字符匹配,恢复之前的计数，即使有重复的元素，恢复的计数也是之前减去的（因为只会遍历该元素重复的出现次数）。
                if (need[s1Arr[l]] > 0) {
                    count--;
                }
                l++;
            }
        }
        return false;
    }

    @Test
    void testCheckInclusion() {
        System.out.println(checkInclusion("bbb", "bbaab"));
    }
}
