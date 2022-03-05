package other;

import java.util.Stack;

/**
 * Created by Administrator on 2020/3/8.
 */
public class Brackets {
    public static void main(String[] args) {
        String s = ")()())";
        System.out.println(longestValidParentheses(s));
    }

    public static int longestValidParentheses(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int maxLen = 0;
        char[] chs = s.toCharArray();
        for (int i = 0; i < chs.length; i++) {
            for (int j = i + 2; j <= chs.length; j += 2) {
                if (valid(chs, i, j)) {
                    maxLen = Math.max(maxLen, (j - i));
                }
            }
        }
        return maxLen;
    }

    public static boolean valid(char[] chs, int start, int end) {
        Stack<Character> stack = new Stack<>();
        for (int i = start; i < end; i++) {
            if (!stack.isEmpty() && chs[i] == ')') {
                stack.pop();
            } else if (chs[i] == '(') {
                // 重新计数括号
                stack.push(chs[i]);
            } else {
                return false;
            }
        }
        return stack.isEmpty();
    }
}
