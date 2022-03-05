package other;

import java.util.Arrays;

/**
 * Created by Administrator on 2020/3/17.
 */

/*942. 增减字符串匹配
        给定只含 "I"（增大）或 "D"（减小）的字符串 S ，令 N = S.length。

        返回 [0, 1, ..., N] 的任意排列 A 使得对于所有 i = 0, ..., N-1，都有：

        如果 S[i] == "I"，那么 A[i] < A[i+1]
        如果 S[i] == "D"，那么 A[i] > A[i+1]


        示例 1：

        输出："IDID"
        输出：[0,4,1,3,2]
        示例 2：

        输出："III"
        输出：[0,1,2,3]
        示例 3：

        输出："DDI"
        输出：[3,2,0,1]


        提示：

        1 <= S.length <= 10000
        S 只包含字符 "I" 或 "D"。*/
public class IncreaseAndDecreaseStringMatch {
    // 遇见D就整一个没用过的最大值，遇见I没用过的最小值
    public int[] diStringMatch(String S) {
        if (S == null || S.isEmpty()) {
            return new int[0];
        }
        int len = S.length();
        int[] result = new int[len + 1];
        int min = 0;
        int max = len;
        for (int i = 0; i < len; i++) {
            if (S.charAt(i) == 'D') {
                result[i] = max--;
            } else if (S.charAt(i) == 'I') {
                result[i] = min++;
            }
        }
        result[len] = min;
        return result;
    }
}
