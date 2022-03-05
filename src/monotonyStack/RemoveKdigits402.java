package monotonyStack;

import java.util.Deque;
import java.util.LinkedList;

public class RemoveKdigits402 {

    // https://leetcode-cn.com/problems/remove-k-digits/solution/yi-diao-kwei-shu-zi-by-leetcode-solution/
    public String removeKdigits(String num, int k) {
        Deque<Character> deque = new LinkedList<Character>();
        int length = num.length();
        for (int i = 0; i < length; ++i) {
            char digit = num.charAt(i);
            while (!deque.isEmpty() && k > 0 && deque.peek() > digit) {
                deque.pop();
                k--;
            }
            deque.push(digit);
        }
        // k个数没删完，需要从尾部继续删除
        for (int i = 0; i < k; ++i) {
            deque.pollFirst();
        }
        StringBuilder ret = new StringBuilder();
        boolean leadingZero = true;
        // 如果前缀为0,则舍弃
        while (!deque.isEmpty()) {
            char digit = deque.pollLast();
            if (leadingZero && digit == '0') {
                continue;
            }
            leadingZero = false;
            ret.append(digit);
        }
        return ret.length() == 0 ? "0" : ret.toString();
    }
}
